package src.tabu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.System.out;

public class Main
{
    public static void main(final String[] arguments)
    {
        InputManager inputM = new InputManager();
        Integer[][] mapa = new Integer[60][30];

        try {
            mapa = inputM.cargarMatriz("map.txt");
        } catch (IOException ex) {
            out.println("Error con el archivo map.txt!");
        }

        out.println("==================");
        out.println("MAPA DEL DEPOSITO:");

        for (int i = 0; i < 30; i++) {
            out.println(Arrays.toString(mapa[i]));
        }
        
        ArrayList<Coordinates> orden = new ArrayList<Coordinates>();

        try {
            orden = inputM.cargarOrden(arguments[0]);
        } catch (IOException ex) {
            out.println("Error con el archivo de orden!");
        }

        out.println("==================");
        out.println("ORDEN A ATENDER:");

        for (int i = 0; i < 50; i++) {
            out.println(orden.get(i).stringFormat());
        }

        TabuProblem problema = new TabuProblem(mapa);
        TabuSearch busqueda = new TabuSearch();
        Solution mejor = busqueda.buscar(problema, orden);
        out.println("==================");
        out.println("SOLUCIÓN FINAL:"); 
        mejor.imprimirOrden();

        try {
            PrintWriter output = new PrintWriter("output/" + arguments[0], "UTF-8");
            output.println("Archivo: " + arguments[0]);
            output.println("Distancia: " + problema.distancia(mejor));
            output.close();
        } catch (IOException e) {
            out.println("Error al imprimir resultados!");
        }
    }
}
