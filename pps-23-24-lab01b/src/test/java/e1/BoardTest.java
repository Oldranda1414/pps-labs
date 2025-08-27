package e1;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e1.chess.Board;
import e1.chess.BoardImpl;
import e1.utils.Pair;

public class BoardTest {

    private Board board;
    private Pair<Integer, Integer> piecePosition = new Pair<>(8,8);
    private Pair<Integer, Integer> target = new Pair<>(3,3);
    private Pair<Integer, Integer> dimensions = new Pair<>(9,9);
    
    @BeforeEach
    void beforeEach(){
        board = new BoardImpl(piecePosition, target, dimensions);
    }

    @Test
    void hasTest(){
        assertAll(
            () -> assertTrue(board.hasPiece(piecePosition)),
            () -> assertTrue(board.hasTarget(target)),
            () -> assertFalse(board.hasPiece(target)),
            () -> assertFalse(board.hasTarget(piecePosition))
        );
    }

    @Test
    void getPositionTest(){
        assertAll(
            () -> assertEquals(board.getPiecePosition(), piecePosition),
            () -> assertEquals(board.getTargetPosition(), target)
        );
    }

    @Test
    void movePieceTest(){
        final Pair<Integer, Integer> firstMove = new Pair<>(7,6);
        final Pair<Integer, Integer> wrongMove = new Pair<>(1,1);
        assertAll(
            () -> assertFalse(board.movePiece(wrongMove)),
            () -> assertTrue(board.movePiece(firstMove))
        );
    }

    @Test
    void outOfBoundsMoveTest(){
        final Pair<Integer, Integer> outOfBoundsMove = new Pair<>(9,10);
        assertThrows(IndexOutOfBoundsException.class, () -> board.movePiece(outOfBoundsMove));
    }

    @Test
    void outOfBoundsInit(){
        final Pair<Integer, Integer> overBoundsPosition = new Pair<>(10,10);
        final Pair<Integer, Integer> underBoundsPosition = new Pair<>(-1, -1);
        assertAll(
            () -> assertThrows(IndexOutOfBoundsException.class, () -> new BoardImpl(piecePosition, overBoundsPosition, dimensions)),
            () -> assertThrows(IndexOutOfBoundsException.class, () -> new BoardImpl(piecePosition, underBoundsPosition, dimensions)),
            () -> assertThrows(IndexOutOfBoundsException.class, () -> new BoardImpl(overBoundsPosition, target, dimensions)),
            () -> assertThrows(IndexOutOfBoundsException.class, () -> new BoardImpl(underBoundsPosition, target, dimensions))
        );
    }
}
