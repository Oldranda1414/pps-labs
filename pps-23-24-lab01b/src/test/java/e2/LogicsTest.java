package e2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import e2.logics.Logics;
import e2.logics.LogicsImpl;
import e2.utils.Pair;

public class LogicsTest extends DefaultGrid{
    
    private Logics logics;
    private final int SIZE = 9;
    private final int N_MINES = 4;

    @Test
    void hitAndHasMineTest(){
        logics = new LogicsImpl(SIZE, N_MINES);
        int hitCounter = 0;
        int minesCounter = 0;
        for(int x = 0; x < SIZE; x++){
            for(int y = 0; y < SIZE; y++){
                if(logics.hit(new Pair<>(x,y)))hitCounter++;
                if(logics.hasMine(new Pair<>(x,y)))minesCounter++;
            }
        }
        assertEquals(N_MINES, hitCounter); 
        assertEquals(N_MINES, minesCounter); 
    }

    @Test
    void numberCellTextTest(){
        defaultInit();
        firstCell.setNumber(ADIACENT_MINES);
        assertEquals(Integer.toString(ADIACENT_MINES), logics.getCellText(new Pair<Integer,Integer>(CELL_X, CELL_Y)).get());
    }

    @Test
    void emptyCellTextTest(){
        defaultInit();
        assertAll(
            () -> assertFalse(logics.getCellText(new Pair<Integer,Integer>(CELL_X, CELL_Y)).isPresent()),
            () -> assertFalse(logics.getCellText(new Pair<Integer,Integer>(SECOND_CELL_X, SECOND_CELL_Y)).isPresent())
        );
    }

    @Test
    void isVisibleTest(){
        defaultInit();
        firstCell.setNumber(ADIACENT_MINES);
        logics.hit(new Pair<Integer,Integer>(CELL_X, CELL_Y));
        assertAll(
            () -> assertTrue(logics.isVisible(new Pair<Integer,Integer>(CELL_X, CELL_Y))),
            () -> assertFalse(logics.isVisible(new Pair<Integer,Integer>(SECOND_CELL_X, SECOND_CELL_Y)))
        );
    }
    
    @Test
    void cellFlagTest(){
        defaultInit();
        logics.switchFlag(new Pair<Integer,Integer>(CELL_X, CELL_Y));
        assertAll(
            () -> assertTrue(logics.isFlagged(new Pair<Integer,Integer>(CELL_X, CELL_Y))),
            () -> assertFalse(logics.isFlagged(new Pair<Integer,Integer>(SECOND_CELL_X, SECOND_CELL_Y)))
        );
        logics.switchFlag(new Pair<Integer,Integer>(CELL_X, CELL_Y));
        assertFalse(logics.isFlagged(new Pair<Integer,Integer>(CELL_X, CELL_Y)));
    }

    @Test
    void isGameWonTest(){
        defaultInit();
        assertFalse(logics.isGameWon());
        logics.hit(new Pair<Integer,Integer>(CELL_X, CELL_Y));
        logics.hit(new Pair<Integer,Integer>(SECOND_CELL_X, SECOND_CELL_Y));
        logics.hit(new Pair<Integer,Integer>(THIRD_CELL_X, THIRD_CELL_Y));
        assertTrue(logics.isGameWon());
    }
    
    private void defaultInit(){
        setup();
        logics = new LogicsImpl(grid);
    }
}
