package e1.chess;

import e1.utils.Pair;

public class Knight implements Piece {

    private Pair<Integer, Integer> position;

    public Knight(Pair<Integer, Integer> position){
       this.position = position;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public boolean move(Pair<Integer, Integer> newPosition) {
		// Below a compact way to express allowed moves for the knight
        final int startingX = this.position.getX();
        final int startingY = this.position.getY();
        final int targetX = newPosition.getX();
        final int targetY = newPosition.getY();
		int x = targetX - startingX;
		int y = targetY - startingY;
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
			this.position = new Pair<>(targetX, targetY);
			return true;
		}
		return false;
    }
    
}
