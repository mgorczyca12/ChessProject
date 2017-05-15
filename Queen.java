import java.util.*;
public class Queen extends Piece{

	public Queen(char side, String name, ChessBoard b, Spot sp)
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
		moves.addAll(checkHorizontal(1));
		moves.addAll(checkHorizontal(-1));
		moves.addAll(checkVertical(1));
		moves.addAll(checkVertical(-1));


		return moves;

	}

}