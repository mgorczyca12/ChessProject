import java.util.*;

public class Bishop extends Piece{

	public Bishop(char side, String name, ChessBoard b, Spot sp)
	{
		super(side, name, b, sp);
	}

	public List<Coordinate> possibleMoves()
	{
		ArrayList<Coordinate> moves = new ArrayList<>();
		moves.addAll(checkDiagonal(1,1));
		moves.addAll(checkDiagonal(-1,1));
		moves.addAll(checkDiagonal(1,-1));
		moves.addAll(checkDiagonal(-1,-1));


		return moves;

	}

}
