import java.util.*;

public class Rook extends Piece{

	public Rook(char side, int row, int col, String name)
	{
		super(side, row, col, name);
	}

	public List<coordinate> possibleMoves(ChessBoard b)
	{
		ArrayList<coordinate> moves = new ArrayList<>();



		while(b.getSpot(super.getRow() + v, super.getCol().getRow() >= 0 && b.getSpot(super.getRow() + v, super.getCol().getCol() >= 0)


		return moves;

	}

}