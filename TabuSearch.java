package tabu;

public class TabuSearch 
{
    private TabuList tList;

    /**
     * Constructor para el objeto TabuSearch
     * @param tList lista tabu para guardar soluciones visitadas
     */
    public TabuSearch(TabuList tList)
    {
        this.tabuList = tList;
    }

    /**
     * @param problem instancia de objeto TabuProblem
     * @return Solution mejor solucion para el objeto problem 
     */ 
    public Solution search(TabuProblem problem, order) 
    { 
        Solution current = problem.initial(order); 
        Solution best = current; 
        
        Integer currentIteration = 0; 
        
        while (!problem.stop(best, currentIteration)) { 
            Solution newSolution = problem.findBestPossibleNeighbor(current, this.tList); 
            this.tList.update(current); 
            current = newSolution; 

            if (problem.isBetter(current, best)) { 
                best = current; 
            } else { 
                best.increaseCount(); 
            } 
            
            currentIteration++;
        } 

        return best;
    }
}
