package e2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e2.grid.Grid;
import e2.grid.GridBuilder;
import e2.grid.GridBuilderImpl;
import e2.numberStrategy.NumberStrategyImpl;
import e2.numberStrategy.NumberStrategy;

public class GridBuilderTest {
    
    private GridBuilder builder;
    private Grid grid;
    private final int SIZE = 7;
    private final int N_MINES = 10;
    private final NumberStrategy STRATEGY = new NumberStrategyImpl();

    @BeforeEach
    void beforeEach(){
        builder = new GridBuilderImpl();
        grid = builder.build(SIZE, N_MINES, STRATEGY);
    }

    @Test
    void initTest(){
        int minesCounter = 0;
        for(int x = 0; x < SIZE; x++){
            for(int y = 0; y < SIZE; y++){
                if(grid.hasMine(x, y)){
                    minesCounter++;
                }
            }
        }
       assertEquals(N_MINES, minesCounter); 
    }

}
