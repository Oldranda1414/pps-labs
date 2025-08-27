package e2.numberStrategy;

import e2.cell.Cell;
import e2.utils.AdiacentStrategy;
import e2.utils.AdiacentStrategyImpl;
import e2.utils.Pair;

public class NumberStrategyImpl implements NumberStrategy{


    @Override
    public int calculateNumber(Cell[][] cells, int X, int Y) {
        return countAdiacentMines(cells, X, Y);
    }

    private int countAdiacentMines(Cell[][] cells, int X, int Y){
        int counter = 0;

        AdiacentStrategy strategy = new AdiacentStrategyImpl();
        var list = strategy.getAdiacentPositions(new Pair<Integer,Integer>(X, Y));

        for(var pos: list){
            if(isValidPosition(pos.getX(), pos.getY(), cells.length, cells[0].length)){
                Cell currentCell = cells[pos.getX()][pos.getY()];
                if(currentCell.isMine()) counter++;
            }
        }
        return counter;
    }

    private boolean isValidPosition(final int X, final int Y, int SIZE_X, int SIZE_Y){

        if(X < SIZE_X && X >= 0 && Y < SIZE_Y && Y >= 0){
            return true;
        }
        return false;
    }
    
}
