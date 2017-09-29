package src.tabu;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class TabuProblem
{
    /**
     * @param order arreglo de productos por atender
     * @return Solution solucion inicial por la que se iniciara la busqueda
     */
    public Solution initial(Integer[] order)
    {
        Collections.shuffle(Arrays.asList(order));
        return new Solution(order);
    }

    /**
     * @param solution solucion a validar
     * @return Integer distancia total a ser recorrida para la solucion dada
     */
    private Integer getDistance(Solution solution)
    {
        return 0;
    }

    /**
     * @param s1 primera solucion
     * @param s2 segunda solucion
     * @return boolean validando si la sol1 es mas optima que la sol2
     */
    public boolean isBetter(Solution s1, Solution s2)
    {
        return (this.getDistance(s1) <= this.getDistance(s2)) ? false : true;
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
            if (!tList.getSolutions().contains(candidates.get(i))) {
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
        return (iterations >= 1000 || best.getCount() == 10) ? true : false;
    }
}
