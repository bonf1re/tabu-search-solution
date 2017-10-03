package src.tabu;

import static java.lang.System.out;
import java.util.ArrayList;

public class TabuSearch 
{
    private TabuList listaT;
    private TabuUtils tUtils;

    /**
     * Constructor para el objeto TabuSearch
     */
    public TabuSearch()
    {
        this.listaT = new TabuList();
        this.tUtils = new TabuUtils();
    }

    /**
     * @param problem instancia de objeto TabuProblem
     * @param order arreglo de productos por atender
     * @return Solution mejor solucion para el objeto problem 
     */ 
    public Solution buscar(TabuProblem problema, ArrayList<Coordinates> orden) 
    { 
        Solution actual = problema.inicial(orden); 
        Solution mejor = actual; 
        
        Integer iteracion = 0; 
        
        while (!problema.parada(mejor, iteracion)) { 
            out.println("=================================");
            out.println("Iteración Nro " + iteracion);
            out.println("Mejor solución actual:");
            out.println("Distancia: " + problema.distancia(mejor));
            mejor.imprimirOrden();
            out.println("Ultima solución evaluada:");
            out.println("Distancia: " + problema.distancia(actual));
            actual.imprimirOrden();

            ArrayList<Solution> candidatos = this.tUtils.vecinos(actual);
            Solution nuevaSol = problema.mejorVecino(candidatos, this.listaT); 

            out.println("Mejor solución vecina posible:");
            out.println("Distancia: " + problema.distancia(nuevaSol));
            nuevaSol.imprimirOrden();

            actual = nuevaSol; 
            this.listaT.actualizar(actual); 

            if (problema.esMejor(actual, mejor)) { 
                mejor = actual; 
                out.println("Nueva mejor solución encontrada");
            } else { 
                mejor.aumentarCount(); 
                out.println("Se mantiene mejor solución");
            } 

            out.println("Mejor solución actual:");
            out.println("Distancia: " + problema.distancia(mejor));
            mejor.imprimirOrden();
            out.println("Contador: " + mejor.getCount());
            
            iteracion++;
        } 

        return mejor;
    }
}
