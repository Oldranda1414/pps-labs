package e2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e2.cell.Cell;
import e2.cell.CellImpl;

public class CellTest {
    
    private Cell cell;
    private final int ADIACENT_MINES = 3;

    @BeforeEach
    void beforeEach(){
        cell = new CellImpl();
    }

    @Test
    void initTest(){
        assertAll(
            () -> assertFalse(cell.isFlagged()),
            () -> assertFalse(cell.getNumber().isPresent()),
            () -> assertFalse(cell.isMine())
        );
    }

    @Test
    void flagTest(){
        cell.setFlag(true);
        assertTrue(cell.isFlagged());
    }

    @Test 
    void adiacentMinesTest(){
        cell.setNumber(ADIACENT_MINES);
        assertEquals(ADIACENT_MINES, cell.getNumber().get());
    }

    @Test
    void visibleTest(){
        assertFalse(cell.isVisible());
        cell.setVisible(true);
        assertTrue(cell.isVisible());
    }

    @Test
    void isMineTest(){
        assertFalse(cell.isMine());
        cell.setIsMine(true);
        assertTrue(cell.isMine());
    }
}
