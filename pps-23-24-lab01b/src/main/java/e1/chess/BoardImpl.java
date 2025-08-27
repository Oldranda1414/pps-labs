package e1.chess;

import e1.utils.Pair;

public class BoardImpl implements Board{

    private Piece piece;
    private Pair<Integer, Integer> target; 
    private Pair<Integer, Integer> dimensions; 

    public BoardImpl(Pair<Integer, Integer> piecePosition, Pair<Integer, Integer> targetPosition, Pair<Integer, Integer> dimensions){
        this.dimensions = dimensions;

        final int pieceX = piecePosition.getX();
        final int pieceY = piecePosition.getY();
        final int targetX = targetPosition.getX();
        final int targetY = targetPosition.getY();

        if(pieceX < 0 || pieceX >= this.dimensions.getX() || pieceY < 0 || pieceY >= this.dimensions.getY()){
            throw new IndexOutOfBoundsException("piece is out of bounds");
        }

        if(targetX < 0 || targetX >= this.dimensions.getX() || targetY < 0 || targetY >= this.dimensions.getY()){
            throw new IndexOutOfBoundsException("target is out of bounds");
        }

        this.piece = new Knight(piecePosition);
        this.target = targetPosition;
    }

    @Override
    public boolean hasPiece(Pair<Integer, Integer> position) {
        return this.piece.getPosition().equals(position);
    }

    @Override
    public boolean hasTarget(Pair<Integer, Integer> position) {
       return this.target.equals(position); 
    }

    @Override
    public boolean movePiece(Pair<Integer, Integer> newPosition) {
        final int newX = newPosition.getX();
        final int newY = newPosition.getY();
        if(newX < 0 || newX >= this.dimensions.getX() || newY < 0 || newY >= this.dimensions.getY()){
            throw new IndexOutOfBoundsException("newPosition is out of bounds");
        }
        return this.piece.move(newPosition);
    }

    @Override
    public Pair<Integer, Integer> getPiecePosition() {
        return this.piece.getPosition();
    }

    @Override
    public Pair<Integer, Integer> getTargetPosition() {
        return this.target;
    }
    
}
