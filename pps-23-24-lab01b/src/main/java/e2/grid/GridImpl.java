package e2.grid;

import java.util.Optional;

import e2.cell.Cell;
import e2.revealStrategy.RevealStrategy;
import e2.revealStrategy.RevealStrategyImpl;

public class GridImpl implements Grid{
    
    private Cell[][] cells;
    private RevealStrategy strategy = new RevealStrategyImpl();
    
    public GridImpl(Cell[][] cells){
        this.cells = cells;
    }
    
    @Override
    public Optional<Integer> getNumberOnCell(final int X, final int Y) {
        checkIfOutOfBounds(X, Y);
        return this.cells[X][Y].getNumber();
    }

    @Override
    public boolean hitCell(int X, int Y) {
        checkIfOutOfBounds(X, Y);
        boolean isMine = this.cells[X][Y].isMine();
        if(!isMine){
            this.strategy.revealCell(cells, X, Y);
        } 
        return isMine;
    }

    @Override
    public boolean hasMine(int X, int Y) {
        checkIfOutOfBounds(X, Y);
        return this.cells[X][Y].isMine();
    }

    @Override
    public boolean isVisible(int X, int Y) {
        checkIfOutOfBounds(X, Y);
        return this.cells[X][Y].isVisible();
    }

    @Override
    public void setFlag(boolean bool, int X, int Y) {
        checkIfOutOfBounds(X, Y);
        this.cells[X][Y].setFlag(bool);
    }

    @Override
    public boolean isFlagged(int X, int Y) {
        checkIfOutOfBounds(X, Y);
        return this.cells[X][Y].isFlagged();
    }

    @Override
    public boolean isGameWon() {
        for(var array: cells){
            for(var cell: array){
                if(!cell.isMine() && !cell.isVisible()){
                    return false;
                }
            }
        }
        return true;
    }

    private void checkIfOutOfBounds(final int X, final int Y){
        if(X >= this.cells.length || Y >= this.cells[0].length){
            throw new IndexOutOfBoundsException();
        }
    }

}
