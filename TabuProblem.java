package tabu;

import java.util.Arrays;
import java.util.Collections;

public class TabuProblem
{
    /**
     * @return solucion inicial por la que se iniciara la busqueda
     */
    public Solution initial(Integer[] order)
    {
        Solution firstSolution = new 
        return Collections.shuffle(Arrays.asList(order));
    }

    /**
     * @param s1 primera solucion
     * @param s2 segunda solucion
     * @return boolean validando si la sol1 es mas optima que la sol2
     */
    public boolean isBetter(Solution sol1, Solution s2);

    /**
     * @param candidates colleccion de candidatos a solucion
     * @return Collection<Solution> coleccion ordenada de soluciones en orden de optimizacion
     */
    public Collection<Solution> findBestNeighbor(Collection<Solution> candidates);

    /**
     * @param current solucion escogida actualmente
     * @return colleccion de vecinos de la solucion actual
     */
    public Collection<Solution> neighborhood(Solution current);

    /**
     * @param best mejor solucion encontrada al finalizar la iteracion
     * @param currentIteration cantidad de iteraciones hasta el momento
     * @return boolean validando si se cumple la condicion de parada
     */
    public boolean stop(Solution best, Integer currentIteration) 
    {
        (currentIteration >= 1000 || best.count() == 10)
            ? return true
            : return false;
    }


    /**
     * @param current solucion actual
     * @param best mejor solucion almacenada hasta el momento
     */
    public void update(Solution current, Solution best);
}
