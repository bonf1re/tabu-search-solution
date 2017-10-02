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
    public Solution search(TabuProblem problem, ArrayList<Coordinates> order) 
    { 
        Solution current = problem.initial(order); 
        Solution best = current; 
        
        Integer currentIteration = 0; 
        
        while (!problem.stop(best, currentIteration)) { 
            out.println("=================================");
            out.println("Iteración Nro " + currentIteration);
            out.println("Mejor solución actual:");
            out.println("Distancia: " + problem.getDistance(best));
            best.printOrder();
            out.println("Ultima solución evaluada:");
            out.println("Distancia: " + problem.getDistance(current));
            current.printOrder();

            ArrayList<Solution> candidates = this.tUtils.getNeighbors(current);
            Solution newSol = problem.findBestNeighbor(candidates, this.tList); 

            out.println("Mejor solución vecina posible:");
            out.println("Distancia: " + problem.getDistance(newSol));
            newSol.printOrder();

            current = newSol; 
            this.tList.update(current); 

            if (problem.isBetter(current, best)) { 
                best = current; 
                out.println("Nueva mejor solución encontrada");
            } else { 
                best.increaseCount(); 
                out.println("Se mantiene mejor solución");
            } 

            out.println("Mejor solución actual:");
            out.println("Distancia: " + problem.getDistance(best));
            best.printOrder();
            out.println("Contador: " + best.getCount());
            
            currentIteration++;
        } 

        return best;
    }
}
