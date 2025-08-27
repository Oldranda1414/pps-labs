package e1.chess;

import e1.utils.Pair;

public interface Board {

    /**
     * @param position
     * @return whether the piece is in position
     */
    public boolean hasPiece(Pair<Integer, Integer> position);

    /**
     * @param position
     * @return whether the target is in position
     */
    public boolean hasTarget(Pair<Integer, Integer> position);

    /**
     * attempt to move the piece, if possible
     * @param newPosition the position to move the piece to
     * @return true if the movement is executed, false otherwise
     */
    public boolean movePiece(Pair<Integer, Integer> newPosition);

    /**
     * get the piece position
     * @return the piece position
     */
    public Pair<Integer, Integer> getPiecePosition();

    /**
     * get the target position
     * @return the target position
     */
    public Pair<Integer, Integer> getTargetPosition();

} 