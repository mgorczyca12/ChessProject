import java.util.*;

public class Rook extends Piece{

	public Rook(char side, String name, ChessBoard b, Spot sp)
	{
		super(side, name, b, sp);
	}

	public List<Coordinate> possibleMoves()
	{
		
		ArrayList<Coordinate> moves = new ArrayList<>();
		moves.addAll(checkHorizontal(1));
		moves.addAll(checkHorizontal(-1));
		moves.addAll(checkVertical(1));
		moves.addAll(checkVertical(-1));


		return moves;

	}

}