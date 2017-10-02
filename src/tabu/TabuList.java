package src.tabu;

import java.util.*;

public class TabuList
{
    private ArrayList<Solution> solutions;

    /**
     * Constructor para el objeto TabuList
     */
    public TabuList()
    {
        this.solutions = new ArrayList<Solution>();
    }

    private void addSolution(Solution s)
    {
        this.solutions.add(s);
    }

    public ArrayList<Solution> getSolutions()
    {
        return this.solutions;
    }

    public void update(Solution current)
    {
        for (int i = 0; i < this.solutions.size(); i++) {
            if (this.solutions.get(i).getCount() == 1) {
                this.solutions.remove(i);
                i--;
            } else {
                this.solutions.get(i).setCount(this.solutions.get(i).getCount() - 1);
            }
        }

        Solution tabuSol = new Solution(current);
        tabuSol.setCount(1000);
        this.addSolution(tabuSol);
    }
}
