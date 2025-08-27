package e2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e2.cell.Cell;
import e2.cell.CellImpl;
import e2.numberStrategy.NumberStrategyImpl;
import e2.numberStrategy.NumberStrategy;

public class NumberStrategyTest {

    private NumberStrategy strategy;
    private final int SIZE = 7;
    private Cell[][] cells;

    @BeforeEach
    void beforeEach(){
        strategy = new NumberStrategyImpl();
        initMines();
    }
    
    @Test
    void numberOfAdiacentMinesTest(){
        for(int x = 0; x < SIZE; x++){
            for(int y = 0; y < SIZE; y++){
                var adiacentNumber = strategy.calculateNumber(cells, x, y);
                assertEquals(countAdiacentMines(x, y), adiacentNumber);
            }
        }
    }


    private int countAdiacentMines(int X, int Y){
        int counter = 0;

        final int[] ADIACENT_X = {X, X - 1, X + 1};
        final int[] ADIACENT_Y = {Y, Y - 1, Y + 1};

        for(var x : ADIACENT_X){
            for(var y : ADIACENT_Y){
                if((x != X || y != Y) && isValidPosition(x, y)){
                    Cell currentCell = cells[x][y];
                    if(currentCell.isMine()) counter++;
                }
            }
        }
        return counter;
    }

    private boolean isValidPosition(final int X, final int Y){

        if(X < SIZE && X >= 0 && Y < SIZE && Y >= 0){
            return true;
        }
        return false;
    }

    private void initMines(){
        cells = new Cell[SIZE][SIZE];
        for(int x = 0; x < SIZE; x++){
            for(int y = 0; y < SIZE; y++){
                cells[x][y] = new CellImpl();
                if(x == y){
                    cells[x][y].setIsMine(true);
                }
            }
        }
    }
}
