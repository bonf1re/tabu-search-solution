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
    public Solution initial(ArrayList<Coordinates> order)
    {
        Collections.shuffle(order);
        return new Solution(order);
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
    public Double getDistance(Solution solution)
    {
        Double distance = 0.0;

        for(int i = 0; i < solution.getOrder().size() - 1; i++) {
            Double move = this.euclidean(solution.getOrder().get(i), solution.getOrder().get(i+1));
            distance += move;    
        }

        return distance;
    }

    /**
     * @param s1 primera solucion
     * @param s2 segunda solucion
     * @return boolean validando si la sol1 es mas optima que la sol2
     */
    public boolean isBetter(Solution s1, Solution s2)
    {
        return (this.getDistance(s1) < this.getDistance(s2)) ? true : false;
    }

    /**
     * @param candidates vecinos candidatos a nueva solucion
     * @param tList lista tabu
     * @return Solution mejor solucion vecina que no se encuentra en la tList
     */
    public Solution findBestNeighbor(ArrayList<Solution> candidates, TabuList tList)
    {
        Collections.sort(candidates, (Solution s1, Solution s2) 
                -> this.getDistance(s1).compareTo(this.getDistance(s2)));

        for (int i = 0; i < candidates.size(); i++) {
            boolean found = false;

            for (int j = 0; j < tList.getSolutions().size(); j++) {
                if (candidates.get(i).stringFormatOrder().equals(tList.getSolutions().get(j).stringFormatOrder())) {
                    out.println("SOLUCION EN TABU");
                    found = true;
                    break;
                }
            }

            if (found == false) {
                out.println("Solución no se encuentra en la lista tabu");
                return candidates.get(i);
            }
        }

        return candidates.get(0);
    }

    /**
     * @param best mejor solucion encontrada al finalizar la iteracion
     * @param iterations cantidad de iteraciones hasta el momento
     * @return boolean validando si se cumple la condicion de parada
     */
    public boolean stop(Solution best, Integer iterations) 
    {
        return (iterations >= 100000 || best.getCount() == 5000) ? true : false;
    }
}
