package e2.logics;

import java.util.Optional;

import e2.utils.Pair;

public interface Logics {
    
    /**
     * sets the cell to visible, and checks if the cell was a mine
     * @param position
     * @return whether the position contains a mine
     */
    public boolean hit(Pair<Integer, Integer> position);

    /**
     * @param position
     * @return true if the cell at position is a mine, false otherwise
     */
    public boolean hasMine(Pair<Integer, Integer> position);

    /**
     * @param position
     * @return number on the cell at position, null if cell has no number
     */
    public Optional<String> getCellText(Pair<Integer, Integer> position);

    /**
     * @param position
     * @return true if the cell at position is visible, false otherwise
     */
    public boolean isVisible(Pair<Integer, Integer> position);

    /**
     * switches the value of the flag of the cell at position
     * @param position
     */
    public void switchFlag(Pair<Integer, Integer> position);

    /**
     * @param position
     * @return true if the cell a tposition is flagged, false otherwise
     */
    public boolean isFlagged(Pair<Integer, Integer> position);

    /**
     * @return true if the game has been won, false otherwise
     */
    public boolean isGameWon();
}
