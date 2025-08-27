package e2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e2.cell.Cell;
import e2.cell.CellImpl;
import e2.revealStrategy.RevealStrategy;
import e2.revealStrategy.RevealStrategyImpl;

public class RevealStrategyTest {

    private RevealStrategy strategy;
    private final int SIZE = 3;
    private final int NUMBER = 1;
    private Cell[][] cells;

    @BeforeEach
    void beforeEach(){
        strategy = new RevealStrategyImpl();
        initCells();
    }

    @Test
    void revealTest(){
        final int REVEAL_CELL_X = 0;
        final int REVEAL_CELL_Y = 1;
        final int CHECK_CELL_X = 0;
        final int CHECK_CELL_Y = 2;

        strategy.revealCell(cells, REVEAL_CELL_X, REVEAL_CELL_Y);

        assertTrue(cells[CHECK_CELL_X][CHECK_CELL_Y].isVisible());
    }

    private void initCells(){
        cells = new Cell[SIZE][SIZE];
        for(int x = 0; x < SIZE; x++){
            for(int y = 0; y < SIZE; y++){
                var cell = new CellImpl();
                if(x == y){
                    cell.setNumber(NUMBER);
                }
                cells[x][y] = cell;
            }
        }
    }
}
