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
        Collections.swap(sol.getOrden(), a, b);
    }

    /**
     * @param current ultima solucion evaluada
     * @return ArrayList<Solution> lista de soluciones vecinas
     */
    public ArrayList<Solution> vecinos(Solution actual)
    {
        ArrayList<Solution> vecinos = new ArrayList<Solution>();
        vecinos.add(actual);

        for (int i = 0; i < actual.getOrden().size(); i++) {
            for (int j = i + 1; j < actual.getOrden().size(); j++) {
                Solution vecino = new Solution(actual);
                this.swap(vecino, i, j);
                vecinos.add(vecino);
            }
        }

        return vecinos;
    }
}
