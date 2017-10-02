package src.tabu;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    private ArrayList<Coordinates> order = new ArrayList<Coordinates>();
    private int count;

    /**
     * Constructor para el objeto Solution
     */
    public Solution(ArrayList<Coordinates> order)
    {
        this.order = order;
        this.count = 0;
    }

    public Solution(Solution sol)
    {
        ArrayList<Coordinates> order = new ArrayList<Coordinates>(sol.getOrder().size());

        for (int i = 0; i < sol.getOrder().size(); i++) {
            order.add(sol.getOrder().get(i));
        }
        
        this.order = order;
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

    public ArrayList<Coordinates> getOrder()
    {
        return this.order;
    }

    public void increaseCount()
    {
        this.count++;
    }

    public String stringFormatOrder()
    {
        String order = "";

        for (int i = 0; i < 50; i++) {
            order = order + "[" + this.order.get(i).stringFormat() + "], ";
        }

        return order;
    }

    public void printOrder()
    {
        out.println(this.stringFormatOrder());
    }
}
