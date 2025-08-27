package e2.revealStrategy;

import e2.cell.Cell;
import e2.utils.AdiacentStrategy;
import e2.utils.AdiacentStrategyImpl;
import e2.utils.Pair;

public class RevealStrategyImpl implements RevealStrategy{

    @Override
    public void revealCell(Cell[][] cells, int X, int Y) {
        var cell = cells[X][Y];
        if(!cell.isVisible()){
            cell.setVisible(true);
            if(!cell.getNumber().isPresent()){
                recurrentRevealCell(cells, X, Y);
            }
        }
    }
    
    private void recurrentRevealCell(Cell[][] cells, int X, int Y){
        AdiacentStrategy strategy = new AdiacentStrategyImpl();

        var list = strategy.getAdiacentPositions(new Pair<Integer,Integer>(X, Y));

        for(var pos: list){
            if(isValidPosition(pos.getX(), pos.getY(), cells.length, cells[0].length)){
                revealCell(cells, pos.getX(), pos.getY());
            }
        }
        
    }

    private boolean isValidPosition(final int X, final int Y, int SIZE_X, int SIZE_Y){

        if(X < SIZE_X && X >= 0 && Y < SIZE_Y && Y >= 0){
            return true;
        }
        return false;
    }
}
