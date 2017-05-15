import java.util.*;

public class Bishop extends Piece{

	public Bishop(char side, int row, int col, String name)
	{
		super(side, row, col, name);
	}

	public List<coordinate> possibleMoves(ChessBoard b)
	{
		int i = 1;
		ArrayList<coordinate> moves = new ArrayList<>();

		while(b.getSpot(super.getRow() + i, super.getCol() + i).checkAvailability() != false || b.getSpot(super.getRow() + i, super.getCol() + i).getPiece() != null
		|| b.getSpot(super.getRow() + i, super.getCol() + i).getPiece().getSide() != super.getSide() || i > 8)
		{
			if(b.getSpot(super.getRow() + i, super.getCol() + i).getPiece().getRow() >= 0 && b.getSpot(super.getRow() + i, super.getCol() + i).getPiece().getCol() >= 0)
			{
				moves.add(new coordinate(super.getRow() + i, super.getCol() + i));
			}
			i++;
		}

		i = 1;

		while(b.getSpot(super.getRow() - i, super.getCol() - i).checkAvailability() != false || b.getSpot(super.getRow() - i, super.getCol() - i).getPiece() != null
		|| b.getSpot(super.getRow() - i, super.getCol() - i).getPiece().getSide() != super.getSide() || i > 8)
		{
			if(b.getSpot(super.getRow() - i, super.getCol() - i).getPiece().getRow() >= 0 && b.getSpot(super.getRow() - i, super.getCol() - i).getPiece().getCol() >= 0)
			{
				moves.add(new coordinate(super.getRow() - i, super.getCol() - i));
			}
			i++;
		}

		i = 1;

		while(b.getSpot(super.getRow() + i, super.getCol() - i).checkAvailability() != false || b.getSpot(super.getRow() + i, super.getCol() - i).getPiece() != null
		|| b.getSpot(super.getRow() + i, super.getCol() - i).getPiece().getSide() != super.getSide() || i > 8)
		{
			if(b.getSpot(super.getRow() + i, super.getCol() - i).getPiece().getRow() >= 0 && b.getSpot(super.getRow() + i, super.getCol() - i).getPiece().getCol() >= 0)
			{
				moves.add(new coordinate(super.getRow() + i, super.getCol() - i));
			}
			i++;
		}

		while(b.getSpot(super.getRow() - i, super.getCol() + i).checkAvailability() != false || b.getSpot(super.getRow() - i, super.getCol() + i).getPiece() != null
		|| b.getSpot(super.getRow() - i, super.getCol() + i).getPiece().getSide() != super.getSide() || i > 8)
		{
			if(b.getSpot(super.getRow() - i, super.getCol() + i).getPiece().getRow() >= 0 && b.getSpot(super.getRow() - i, super.getCol() + i).getPiece().getCol() >= 0)
			{
				moves.add(new coordinate(super.getRow() - i, super.getCol() + i));
			}
			i++;
		}

		return moves;

	}

}
