package src.tabu;

import static java.lang.System.out;
import java.util.ArrayList;

public class TabuSearch 
{
    private TabuList tList;
    private TabuUtils tUtils;

    /**
     * Constructor para el objeto TabuSearch
     */
    public TabuSearch()
    {
        this.tList = new TabuList();
        this.tUtils = new TabuUtils();
    }

    /**
     * @param problem instancia de objeto TabuProblem
     * @param order arreglo de productos por atender
     * @return Solution mejor solucion para el objeto problem 
     */ 
    public Solution search(TabuProblem problem, Integer[] order) 
    { 
        Solution current = problem.initial(order); 
        Solution best = current; 
        
        Integer currentIteration = 0; 
        
        while (!problem.stop(best, currentIteration)) { 
            ArrayList<Solution> candidates = this.tUtils.getNeighbors(current);
            out.println(candidates.size());
            Solution newSol = problem.findBestNeighbor(candidates, this.tList); 
            out.println(newSol.getProductOrder()[20]);
            //this.tList.update(current); 
            current = newSol; 

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
