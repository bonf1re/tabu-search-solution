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

    public void addSolution(Solution s)
    {
        this.solutions.add(s);
    }

    public ArrayList<Solution> getSolutions()
    {
        return this.solutions;
    }
}
