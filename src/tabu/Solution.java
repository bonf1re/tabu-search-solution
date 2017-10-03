package src.tabu;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    private ArrayList<Coordinates> orden = new ArrayList<Coordinates>();
    private int count;

    /**
     * Constructor para el objeto Solution
     */
    public Solution(ArrayList<Coordinates> orden)
    {
        this.orden = orden;
        this.count = 0;
    }

    public Solution(Solution sol)
    {
        ArrayList<Coordinates> orden = new ArrayList<Coordinates>(sol.getOrden().size());

        for (int i = 0; i < sol.getOrden().size(); i++) {
            orden.add(sol.getOrden().get(i));
        }
        
        this.orden = orden;
        this.count = 0;
    }

    public int getCount()
    {
        return this.count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }

    public ArrayList<Coordinates> getOrden()
    {
        return this.orden;
    }

    public void aumentarCount()
    {
        this.count++;
    }

    public String stringFormatOrden()
    {
        String orden = "";

        for (int i = 0; i < 50; i++) {
            orden = orden + "[" + this.orden.get(i).stringFormat() + "], ";
        }

        return orden;
    }

    public void imprimirOrden()
    {
        out.println(this.stringFormatOrden());
    }
}
