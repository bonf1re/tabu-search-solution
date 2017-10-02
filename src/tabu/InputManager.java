package src.tabu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class InputManager
{
    public Integer[][] loadMatrix(String mapFile) throws FileNotFoundException, IOException
    {
        Integer[][] matrix = new Integer[60][30];
        BufferedReader mapR = new BufferedReader(new FileReader(mapFile));
            
        for (int y = 0; y < 30; y++) {
            String line = mapR.readLine();
            for (int x = 0; x < 60; x++) {
                matrix[x][y] = Character.getNumericValue(line.charAt(x));
            }
        }

        mapR.close();

        return matrix;
    }

    public ArrayList<Coordinates> loadOrder(String orderFile) throws FileNotFoundException, IOException
    {
        ArrayList<Coordinates> order = new ArrayList<Coordinates>();
        BufferedReader orderR = new BufferedReader(new FileReader(orderFile));

        for (int i = 0; i < 50; i++) {
            String line = orderR.readLine();
            line = line.replace("[", "");
            line = line.replace("]", "");
            String[] words = line.split(",");
            Coordinates newCoord = new Coordinates();
            newCoord.setY(Integer.parseInt(words[0]));
            newCoord.setX(Integer.parseInt(words[1]));
            order.add(newCoord);
        }

        return order;
    }
}
