package src.tabu;

public class Solution
{
    Integer[] productOrder = new Integer[30];
    private int count;

    /**
     * Constructor para el objeto Solution
     */
    public Solution(Integer[] order)
    {
        this.productOrder = order;
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

    public Integer[] getProductOrder()
    {
        return this.productOrder;
    }

    public void increaseCount()
    {
        this.count++;
    }
}
