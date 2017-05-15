import java.util.*;

public class King extends Piece{

	public King(char side, int row, int col, String name)
	{
		super(side, row, col, name);
	}

	public List<coordinate> possibleMoves(ChessBoard B)
	{
		ArrayList<coordinate> moves = new ArrayList<>();

		Spot f = B.getSpot(super.getRow()+1, super.getCol());
		Spot b = B.getSpot(super.getRow()-1, super.getCol());

		Spot r = B.getSpot(super.getRow(), super.getCol()+1);
		Spot l = B.getSpot(super.getRow(), super.getCol()-1);

		if(f.checkAvailability() == true || f.getPiece() != null || f.getPiece().getSide() != super.getSide())
		{
			moves.add(new coordinate(f.getSpotRow(), f.getSpotCol()));
		}
		if(b.checkAvailability() == true || b.getPiece() != null || b.getPiece().getSide() != super.getSide())
		{
			moves.add(new coordinate(b.getSpotRow(), b.getSpotCol()));
		}



		if(l.checkAvailability() == true || l.getPiece() != null || l.getPiece().getSide() != super.getSide())
		{
			moves.add(new coordinate(l.getSpotRow(), l.getSpotCol()));
		}
		if(r.checkAvailability() == true || r.getPiece() != null || r.getPiece().getSide() != super.getSide())
		{
			moves.add(new coordinate(r.getSpotRow(), r.getSpotCol()));
		}

		return moves;
	}

}