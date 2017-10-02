package src.tabu;

import static java.lang.System.out;

public class Coordinates
{
    private Integer X;
    private Integer Y;

    public Integer getX()
    {
        return this.X;
    }

    public Integer getY()
    {
        return this.Y;
    }

    public void setX(Integer x)
    {
        this.X = x;
    }

    public void setY(Integer y)
    {
        this.Y = y;
    }

    public String stringFormat()
    {
        return this.getX() + ", " + this.getY();
    }
}
