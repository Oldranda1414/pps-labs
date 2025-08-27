package e1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e1.logics.Logics;
import e1.logics.LogicsImpl;
import e1.utils.Pair;

public class LogicsTest {

    private Logics logics;
    private final int SIZE = 5;
    private final int KNIGHT_ROW = 4;
    private final int KNIGHT_COL = 2;
    private final int PAWN_ROW = 2;
    private final int PAWN_COL = 2;
    private final Pair<Integer, Integer> KNIGHT = new Pair<Integer,Integer>(KNIGHT_ROW, KNIGHT_COL);
    private final Pair<Integer, Integer> PAWN = new Pair<Integer,Integer>(PAWN_ROW, PAWN_COL);
    private final int WRONG_ROW = 0;
    private final int WRONG_COL = 0;
    
    @BeforeEach
    void beforeEach(){
        logics = new LogicsImpl(SIZE, PAWN, KNIGHT);
    }

    @Test
    void checkKnightPosition(){
        assertTrue(logics.hasKnight(KNIGHT_ROW, KNIGHT_COL));
    }

    @Test
    void checkPawnPosition(){
        assertTrue(logics.hasPawn(PAWN_ROW, PAWN_COL));
    }

    @Test
    void checkWrongKnightPosition(){
        assertFalse(logics.hasKnight(WRONG_ROW, WRONG_COL));
    }

    @Test
    void checkWrongPawnPosition(){
        assertFalse(logics.hasKnight(WRONG_ROW, WRONG_COL));
    }

    @Test
    void testPossibleKnightMoves(){
        ArrayList<Pair<Integer, Integer>> list = possibleKnightMoves();
        for(Pair<Integer, Integer> position : list){
            logics.hit(position.getX(), position.getY());
            assertTrue(logics.hasKnight(position.getX(), position.getY()));
            this.beforeEach();
        }
    }

    @Test
    void hitPawn(){
        final int FIRST_MOVE_ROW = 3;
        final int FIRST_MOVE_COL = 0;
        logics.hit(FIRST_MOVE_ROW, FIRST_MOVE_COL);
        assertTrue(logics.hit(PAWN_ROW, PAWN_COL));    
    }

    @Test
    void testImpossibleMove(){
        Pair<Integer, Integer> move = impossibleMove();
        logics.hit(move.getX(), move.getY());
        assertTrue(logics.hasKnight(KNIGHT_ROW, KNIGHT_COL));
    }

    private ArrayList<Pair<Integer, Integer>> possibleKnightMoves(){
        ArrayList<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if(isMovePossible(row, col)){
                    list.add(new Pair<>(row, col));
                }
            }
        }
        return list;
    }

    private Pair<Integer, Integer> impossibleMove(){
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if(!isMovePossible(row, col)){
                    return new Pair<>(row, col);
                }
            }
        }
        return new Pair<>(null, null);
    }

    private boolean isMovePossible(int row, int col){
        int x = row-this.KNIGHT.getX();
        int y = col-this.KNIGHT.getY();
        if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
            return true;
        }
        return false;
    }
}
