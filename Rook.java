import java.util.*;

public class Rook extends Piece{



	public Rook(char side, int row, int col, String name)
	{
		super(side, row, col, name);
	}

	public List<coordinate> possibleMoves(ChessBoard b)
	{
		int i = 1;
		ArrayList<coordinate> moves = new ArrayList<>();

		while(b.getSpot(super.getRow + i, super.getCol).checkAvailability() != false || b.getSpot(super.getRow + i, super.getCol).)
		{
			if(b.getSpot(super.getRow + i, super.getCol).getRow() >= 0)
			{

			}
		}


		return moves;

	}

}