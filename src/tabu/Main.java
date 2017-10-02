package src.tabu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.System.out;

public class Main
{
    public static void main(final String[] arguments)
    {
        InputManager inputM = new InputManager();
        Integer[][] map = new Integer[60][30];

        try {
            map = inputM.loadMatrix("map.txt");
        } catch (IOException ex) {
            out.println("Error con el archivo map.txt!");
        }

        out.println("==================");
        out.println("MAPA DEL DEPOSITO:");

        for (int i = 0; i < 30; i++) {
            out.println(Arrays.toString(map[i]));
        }
        
        ArrayList<Coordinates> order = new ArrayList<Coordinates>();

        try {
            order = inputM.loadOrder("order.txt");
        } catch (IOException ex) {
            out.println("Error con el archivo order.txt!");
        }

        out.println("==================");
        out.println("ORDEN A ATENDER:");

        for (int i = 0; i < 50; i++) {
            out.println(order.get(i).stringFormat());
        }

        TabuProblem tProblem = new TabuProblem(map);
        TabuSearch tSearch = new TabuSearch();
        Solution best = tSearch.search(tProblem, order);
        out.println("==================");
        out.println("SOLUCIÓN FINAL:"); 
        best.printOrder();
    }
}
