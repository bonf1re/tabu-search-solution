package src.tabu;

import java.util.*;

public class TabuList
{
    private ArrayList<Solution> soluciones;

    /**
     * Constructor para el objeto TabuList
     */
    public TabuList()
    {
        this.soluciones = new ArrayList<Solution>();
    }

    private void addSolution(Solution s)
    {
        this.soluciones.add(s);
    }

    public ArrayList<Solution> getSoluciones()
    {
        return this.soluciones;
    }

    public void actualizar(Solution actual)
    {
        for (int i = 0; i < this.soluciones.size(); i++) {
            if (this.soluciones.get(i).getCount() == 1) {
                this.soluciones.remove(i);
                i--;
            } else {
                this.soluciones.get(i).setCount(this.soluciones.get(i).getCount() - 1);
            }
        }

        Solution tabuSol = new Solution(actual);
        tabuSol.setCount(10);
        this.addSolution(tabuSol);
    }
}
