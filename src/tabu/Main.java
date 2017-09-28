package src.tabu;

import static java.lang.System.out;

public class Main
{
    public static void main(final String[] arguments)
    {
        Integer[] order = new Integer[30];
        for (Integer i = 0; i < 30; ++i) {
            order[i] = i;
        }

        Solution testSol = new Solution(order);
        final Main main = new Main();
        out.println(testSol.getCount());
        testSol.increaseCount();
        out.println(testSol.getCount());
        out.println(testSol.getProductOrder()[20]);
    }
}
