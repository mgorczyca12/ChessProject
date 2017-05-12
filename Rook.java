import java.util.*;

public class Rook extends Piece{

	public Rook(char side, int row, int col, String name)
	{
		super(side, row, col, name);
	}

	public List<coordinate> possibleMoves(ChessBoard b)
	{
		ArrayList<coordinate> moves = new ArrayList<>();

		int up = 1;
		int down = 1;
		int left = 1;
		int right = 1;

		//up
		while(b.getSpot(super.getRow(),super.getCol()+up).checkAvailability() == true || b.getSpot(super.getRow(),super.getCol()+up).getPiece().getSide() != this.side)
		{
			moves.add(new coordinate(super.getRow(),super.getCol()+up));
			up++;
		}

		while(b.getSpot(super.getRow(),super.getCol()-down).checkAvailability() == true || b.getSpot(super.getRow(),super.getCol()-down).getPiece().getSide() != this.side)
		{
			moves.add(new coordinate(super.getRow(),super.getCol()+up));
			down++;
		}

		while(b.getSpot(super.getRow()-left,super.getCol()).checkAvailability() == true || b.getSpot(super.getRow()+left,super.getCol()-down).getPiece().getSide() != this.side)
		{
			moves.add(new coordinate(super.getRow(),super.getCol()+up));
			left++;
		}

		while(b.getSpot(super.getRow(),super.getCol()-down).checkAvailability() == true || b.getSpot(super.getRow(),super.getCol()-down).getPiece().getSide() != this.side)
		{
			moves.add(new coordinate(super.getRow(),super.getCol()+up));
			down++;
		}

		return moves;

	}

}