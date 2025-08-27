package e1.logics;

import e1.chess.Board;
import e1.chess.BoardImpl;
import e1.utils.Pair;
import e1.utils.RandomPairGenerator;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawnPosition;
	private final Pair<Integer,Integer> knightPosition;
	private final Board board;
	private final RandomPairGenerator random; 
	 
    public LogicsImpl(int size){
		this.random = new RandomPairGenerator(size);
        this.pawnPosition = this.randomEmptyPosition();
        this.knightPosition = this.randomEmptyPosition();
		this.board = new BoardImpl(this.knightPosition, this.pawnPosition, new Pair<>(size, size));
    }

	public LogicsImpl(int size, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition){
		this.random = new RandomPairGenerator(size);
        this.pawnPosition = pawnPosition;
        this.knightPosition = knightPosition;
		this.board = new BoardImpl(this.knightPosition, this.pawnPosition, new Pair<>(size, size));
	}
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = this.random.nextPair();
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawnPosition!=null && this.pawnPosition.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		final Pair<Integer, Integer> movement = new Pair<>(row, col);
		this.board.movePiece(movement);
		final Pair<Integer, Integer> piecePosition = this.board.getPiecePosition();
		final Pair<Integer, Integer> pawnPosition = this.board.getTargetPosition();
		return piecePosition.equals(pawnPosition);
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.board.hasPiece(new Pair<Integer,Integer>(row, col));	
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.board.hasTarget(new Pair<Integer,Integer>(row, col));	
	}
}
