package e2;

import e2.cell.Cell;
import e2.cell.CellImpl;
import e2.grid.Grid;
import e2.grid.GridImpl;

public class DefaultGrid {
    
    protected final int SIZE = 2;
    protected final int CELL_X = 0;
    protected final int CELL_Y = 0;
    protected Cell[][] cells;
    protected Grid grid;
    protected Cell firstCell;
    protected final int ADIACENT_MINES = 3;
    protected final int MINE_X = 1;
    protected final int MINE_Y = 1;
    protected Cell mine;
    protected final int SECOND_CELL_X = 0;
    protected final int SECOND_CELL_Y = 1;
    protected final int THIRD_CELL_X = 1;
    protected final int THIRD_CELL_Y = 0;
    
    public void setup(){
        firstCell = new CellImpl();
        var secondCell = new CellImpl();
        var thirdCell = new CellImpl();
        mine = new CellImpl();
        mine.setIsMine(true);
        cells = new Cell[SIZE][SIZE];
        cells[CELL_X][CELL_Y] = firstCell;
        cells[MINE_X][MINE_Y] = mine;
        cells[SECOND_CELL_X][SECOND_CELL_Y] = secondCell;
        cells[THIRD_CELL_X][THIRD_CELL_Y] = thirdCell;
        grid = new GridImpl(cells);
    }
}
