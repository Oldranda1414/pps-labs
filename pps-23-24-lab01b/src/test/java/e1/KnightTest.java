package e1;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e1.chess.Knight;
import e1.chess.Piece;
import e1.utils.Pair;

public class KnightTest {

    private Piece knight;
    private final Pair<Integer, Integer> initialPosition = new Pair<Integer,Integer>(0,0);
    
    @BeforeEach
    void beforeEach(){
       knight = new Knight(initialPosition); 
    }

    @Test
    void correctPositionTest(){
        assertEquals(initialPosition, knight.getPosition());
    }

    @Test
    void correctMovementTest(){
        final Pair<Integer, Integer> newPosition = new Pair<>(2,1);
        assertAll(
            () -> assertTrue(knight.move(newPosition)),
            () -> assertEquals(newPosition, knight.getPosition())
        );
    }

    @Test
    void wrongMovementTest(){
        final Pair<Integer, Integer> wrongPosition = new Pair<>(1,1);
        assertAll(
            () -> assertFalse(knight.move(wrongPosition)),
            () -> assertEquals(initialPosition, knight.getPosition())
        );
    }
}
