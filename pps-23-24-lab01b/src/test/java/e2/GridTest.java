package e2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GridTest extends DefaultGrid{

    private final int OUT_OF_BOUNDS = 5;

    @BeforeEach
    void beforeEach(){
        setup();
    }
    
    @Test
    void getNumberOnCellTest(){
        firstCell.setNumber(ADIACENT_MINES);
        assertEquals(ADIACENT_MINES, grid.getNumberOnCell(CELL_X, CELL_Y).get());
    }

    @Test
    void hitTest(){
        assertAll(
            () -> assertFalse(grid.hitCell(CELL_X, CELL_Y)),
            () -> assertTrue(grid.hitCell(MINE_X, MINE_Y))
        );
    }

    @Test 
    void hasMineTest(){
        assertAll(
            () -> assertFalse(grid.hitCell(CELL_X, CELL_Y)),
            () -> assertTrue(grid.hitCell(MINE_X, MINE_Y))
        );
    }

    @Test
    void isVisibleTest(){
        firstCell.setNumber(ADIACENT_MINES);
        grid.hitCell(CELL_X, CELL_Y);
        assertAll(
            () -> assertTrue(grid.isVisible(CELL_X, CELL_Y)),
            () -> assertFalse(grid.isVisible(SECOND_CELL_X, SECOND_CELL_Y))
        );
    }

    @Test
    void setFlagTest(){
        grid.setFlag(true, CELL_X, CELL_Y);
        assertAll(
            () -> assertTrue(grid.isFlagged(CELL_X, CELL_Y)),
            () -> assertFalse(grid.isFlagged(SECOND_CELL_X, SECOND_CELL_Y))
        );
    }

    @Test
    void isGameWonTest(){
        assertFalse(grid.isGameWon());
        grid.hitCell(CELL_X, CELL_Y);
        grid.hitCell(SECOND_CELL_X, SECOND_CELL_Y);
        grid.hitCell(THIRD_CELL_X, THIRD_CELL_Y);
        assertTrue(grid.isGameWon());
    }

    @Test
    void outOfBoundsTest(){
        assertAll(
            () -> assertThrows(IndexOutOfBoundsException.class, () -> grid.getNumberOnCell(OUT_OF_BOUNDS, OUT_OF_BOUNDS)),
            () -> assertThrows(IndexOutOfBoundsException.class, () -> grid.hitCell(OUT_OF_BOUNDS, OUT_OF_BOUNDS)),
            () -> assertThrows(IndexOutOfBoundsException.class, () -> grid.hasMine(OUT_OF_BOUNDS, OUT_OF_BOUNDS)),
            () -> assertThrows(IndexOutOfBoundsException.class, () -> grid.isVisible(OUT_OF_BOUNDS, OUT_OF_BOUNDS)),
            () -> assertThrows(IndexOutOfBoundsException.class, () -> grid.setFlag(false, OUT_OF_BOUNDS, OUT_OF_BOUNDS)),
            () -> assertThrows(IndexOutOfBoundsException.class, () -> grid.isFlagged(OUT_OF_BOUNDS, OUT_OF_BOUNDS))
        );
    }
}
