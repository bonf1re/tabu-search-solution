package src.tabu;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TabuProblem
{
    private Integer[][] map = new Integer[60][30];

    /**
     * Constructor para el objeto TabuProblem
     */
    public TabuProblem(Integer[][] map)
    {
        this.map = map;
    }

    /**
     * @param order arreglo de productos por atender
     * @return Solution solucion inicial por la que se iniciara la busqueda
     */
    public Solution inicial(ArrayList<Coordinates> orden)
    {
        Collections.shuffle(orden);
        return new Solution(orden);
    }

    /**
     * @param first coordenadas del lugar de origen
     * @param second coordenadas del lugar de destino
     * @return double distancia del primero punto al segundo
     */
    private Double euclidean(Coordinates first, Coordinates second)
    {
        return Math.sqrt(Math.pow(first.getX() - second.getX(), 2) + Math.pow(first.getY() - second.getY(), 2));
    }

    /**
     * @param solution solucion a validar
     * @return double distancia total a ser recorrida para la solucion dada
     */
    public Double distancia(Solution solucion)
    {
        Double distancia = 0.0;
        Coordinates origen = new Coordinates();
        origen.setX(0);
        origen.setY(0);

        distancia += this.euclidean(origen, solucion.getOrden().get(0));
        distancia += this.euclidean(solucion.getOrden().get(solucion.getOrden().size() - 1), origen);

        for(int i = 0; i < solucion.getOrden().size() - 1; i++) {
            Double paso = this.euclidean(solucion.getOrden().get(i), solucion.getOrden().get(i+1));
            distancia += paso;    
        }

        return distancia;
    }

    /**
     * @param s1 primera solucion
     * @param s2 segunda solucion
     * @return boolean validando si la sol1 es mas optima que la sol2
     */
    public boolean esMejor(Solution s1, Solution s2)
    {
        return (this.distancia(s1) < this.distancia(s2)) ? true : false;
    }

    /**
     * @param candidates vecinos candidatos a nueva solucion
     * @param tList lista tabu
     * @return Solution mejor solucion vecina que no se encuentra en la tList
     */
    public Solution mejorVecino(ArrayList<Solution> candidatos, TabuList listaT)
    {
        Collections.sort(candidatos, (Solution s1, Solution s2) 
                -> this.distancia(s1).compareTo(this.distancia(s2)));

        for (int i = 0; i < candidatos.size(); i++) {
            boolean encontrada = false;

            for (int j = 0; j < listaT.getSoluciones().size(); j++) {
                if (candidatos.get(i).stringFormatOrden().equals(listaT.getSoluciones().get(j).stringFormatOrden())) {
                    encontrada = true;
                    break;
                }
            }

            if (encontrada == false) {
                return candidatos.get(i);
            }
        }

        return candidatos.get(0);
    }

    /**
     * @param best mejor solucion encontrada al finalizar la iteracion
     * @param iterations cantidad de iteraciones hasta el momento
     * @return boolean validando si se cumple la condicion de parada
     */
    public boolean parada(Solution mejor, Integer iteraciones) 
    {
        return (iteraciones >= 100000 || mejor.getCount() == 5000) ? true : false;
    }
}
