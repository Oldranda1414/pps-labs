package e2.logics;

import e2.utils.Pair;

import java.util.Optional;

import e2.grid.Grid;
import e2.grid.GridBuilderImpl;
import e2.numberStrategy.NumberStrategyImpl;

public class LogicsImpl implements Logics {

    private Grid grid;

    public LogicsImpl(final int SIZE, final int N_MINES) {
        this.grid = new GridBuilderImpl().build(SIZE, N_MINES, new NumberStrategyImpl());
    }

    public LogicsImpl(Grid grid){
        this.grid = grid;
    }

    @Override
    public boolean hit(Pair<Integer, Integer> position) {
        return this.grid.hitCell(position.getX(), position.getY());
    }

    @Override
    public boolean hasMine(Pair<Integer, Integer> position) {
        return this.grid.hasMine(position.getX(), position.getY());
    }

    @Override
    public Optional<String> getCellText(Pair<Integer, Integer> position) {
        var optional = this.grid.getNumberOnCell(position.getX(), position.getY());
        if(optional.isPresent()){
            return Optional.of(Integer.toString(optional.get()));
        }
        return Optional.empty();
    }

	@Override
	public boolean isVisible(Pair<Integer, Integer> position) {
        return this.grid.isVisible(position.getX(), position.getY());
	}

    @Override
    public void switchFlag(Pair<Integer, Integer> position) {
        boolean bool = !this.grid.isFlagged(position.getX(), position.getY());
        this.grid.setFlag(bool, position.getX(), position.getY());
    }

    @Override
    public boolean isFlagged(Pair<Integer, Integer> position) {
        return this.grid.isFlagged(position.getX(), position.getY());
    }

    @Override
    public boolean isGameWon() {
        return this.grid.isGameWon();
    }

}
