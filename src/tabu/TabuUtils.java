package src.tabu;

import java.util.ArrayList;

public class TabuUtils
{
    /**
     * @param sol solucion en la cual se realizara la modificacion
     * @param a indice del elemento pivote
     * @param b indice del elemento a ser cambiado
     */
    private void swap(Solution sol, int a, int b)
    {
        Integer temp = sol.getProductOrder()[a];
        sol.getProductOrder()[a] = sol.getProductOrder()[b];
        sol.getProductOrder()[b] = temp;
    }

    /**
     * @param current ultima solucion evaluada
     * @return ArrayList<Solution> lista de soluciones vecinas
     */
    public ArrayList<Solution> getNeighbors(Solution current)
    {
        ArrayList<Solution> neighbors = new ArrayList<Solution>();
        neighbors.add(current);

        for (int i = 0; i < current.getProductOrder().length; i++) {
            for (int j = i + 1; j < current.getProductOrder().length; j++) {
                Solution neighbor = current;
                this.swap(neighbor, i, j);
                neighbors.add(neighbor);
            }
        }

        return neighbors;
    }
}
