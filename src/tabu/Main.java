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

        TabuProblem tProblem = new TabuProblem();
        TabuSearch tSearch = new TabuSearch();
        Solution best = tSearch.search(tProblem, order);
        out.println(best.getProductOrder().length);
    }
}
