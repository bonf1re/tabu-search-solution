package src.tabu;

import java.util.ArrayList;
import java.util.Collections;

public class TabuUtils
{
    /**
     * @param sol solucion en la cual se realizara la modificacion
     * @param a indice del primer elemento a ser cambiado
     * @param b indice del segundo elemento a ser cambiado
     */
    private void swap(Solution sol, int a, int b)
    {
        Collections.swap(sol.getOrder(), a, b);
    }

    /**
     * @param current ultima solucion evaluada
     * @return ArrayList<Solution> lista de soluciones vecinas
     */
    public ArrayList<Solution> getNeighbors(Solution current)
    {
        ArrayList<Solution> neighbors = new ArrayList<Solution>();
        neighbors.add(current);

        for (int i = 0; i < current.getOrder().size(); i++) {
            for (int j = i + 1; j < current.getOrder().size(); j++) {
                Solution neighbor = new Solution(current);
                this.swap(neighbor, i, j);
                neighbors.add(neighbor);
            }
        }

        return neighbors;
    }
}
