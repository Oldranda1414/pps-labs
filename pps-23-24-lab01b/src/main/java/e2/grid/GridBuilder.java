package e2.grid;

import e2.numberStrategy.NumberStrategy;

public interface GridBuilder {
    
    /**
     * @param SIZE
     * @param N_MINES
     * @param strategy
     * @return builds a grid with the specified parameters
     */
    public Grid build(final int SIZE, final int N_MINES, final NumberStrategy STRATEGY);
}
