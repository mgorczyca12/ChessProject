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

		while(b.getSpot(super.getRow() + i, super.getCol()).checkAvailability() != false || b.getSpot(super.getRow() + i, super.getCol()).getPiece() != null
		|| b.getSpot(super.getRow() + i, super.getCol()).getPiece().getSide() != super.getSide() || i > 8)
		{
			if(b.getSpot(super.getRow() + i, super.getCol()).getPiece().getRow()+i >= 0)
			{
				moves.add(new coordinate(super.getRow() + i, super.getCol()));
			}
			i++;
		}

		i = 1;

		while(b.getSpot(super.getRow() - i, super.getCol()).checkAvailability() != false || b.getSpot(super.getRow() - i, super.getCol()).getPiece() != null
		|| b.getSpot(super.getRow() - i, super.getCol()).getPiece().getSide() != super.getSide() || i > 8)
		{
			if(b.getSpot(super.getRow() - i, super.getCol()).getPiece().getRow() >= 0)
			{
				moves.add(new coordinate(super.getRow() - i, super.getCol()));
			}
			i++;
		}

		i = 1;

		while(b.getSpot(super.getRow(), super.getCol() + i).checkAvailability() != false || b.getSpot(super.getRow(), super.getCol() + i).getPiece() != null
		|| b.getSpot(super.getRow(), super.getCol() + i).getPiece().getSide() != super.getSide() || i > 8)
		{
			if(b.getSpot(super.getRow(), super.getCol() + i).getPiece().getCol() >= 0)
			{
				moves.add(new coordinate(super.getRow(), super.getCol() + i));
			}
			i++;
		}

		i = 1;

		while(b.getSpot(super.getRow(), super.getCol() - i).checkAvailability() != false || b.getSpot(super.getRow(), super.getCol() - i).getPiece() != null
		|| b.getSpot(super.getRow(), super.getCol() - i).getPiece().getSide() != super.getSide() || i > 8)
		{
			if(b.getSpot(super.getRow(), super.getCol() - i).getPiece().getCol() >= 0)
			{
				moves.add(new coordinate(super.getRow(), super.getCol() - i));
			}
			i++;
		}


		return moves;

	}

}