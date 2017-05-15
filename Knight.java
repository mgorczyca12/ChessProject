import java.util.*;

public class Knight extends Piece{

	public Knight(char side, int row, int col, String name)
	{
		super(side, row, col, name);
	}

	//finds any and all possible moves a pawn can make, weather thats to move up or attack another piece
	public List<coordinate> possibleMoves(ChessBoard b)
	{
		ArrayList<coordinate> moves = new ArrayList<>();


		//spots infront of piece
		Spot r1 = b.getSpot(super.getRow()+2, super.getCol()+1);
		Spot r2 = b.getSpot(super.getRow()+1, super.getCol()+2);

		Spot l1 = b.getSpot(super.getRow()+2, super.getCol()-1);
		Spot l2 = b.getSpot(super.getRow()+1, super.getCol()-2);

		//spots behind piece
		Spot br1 = b.getSpot(super.getRow()+2, super.getCol()+1);
		Spot br2 = b.getSpot(super.getRow()+1, super.getCol()+2);

		Spot bl1 = b.getSpot(super.getRow()+2, super.getCol()+1);
		Spot bl2 = b.getSpot(super.getRow()+1, super.getCol()+2);



		if(r1.checkAvailability() == true || r1.getPiece() != null || r1.getPiece().getSide() != super.getSide())
		{
			moves.add(new coordinate(r1.getSpotRow(), r1.getSpotCol()));
		}
		if(r2.checkAvailability() == true || r2.getPiece() != null || r2.getPiece().getSide() != super.getSide())
		{
			moves.add(new coordinate(r2.getSpotRow(), r2.getSpotCol()));
		}



		if(l1.checkAvailability() == true || l1.getPiece() != null || l1.getPiece().getSide() != super.getSide())
		{
			moves.add(new coordinate(l1.getSpotRow(), l1.getSpotCol()));
		}
		if(l2.checkAvailability() == true || l2.getPiece() != null || l2.getPiece().getSide() != super.getSide())
		{
			moves.add(new coordinate(l2.getSpotRow(), l2.getSpotCol()));
		}



		if(br1.checkAvailability() == true || br1.getPiece() != null || br1.getPiece().getSide() != super.getSide())
		{
			moves.add(new coordinate(br1.getSpotRow(), br1.getSpotCol()));
		}
		if(br2.checkAvailability() == true || br2.getPiece() != null || br2.getPiece().getSide() != super.getSide())
		{
			moves.add(new coordinate(br2.getSpotRow(), br2.getSpotCol()));
		}



		if(bl1.checkAvailability() == true || bl1.getPiece() != null || bl1.getPiece().getSide() != super.getSide())
		{
			moves.add(new coordinate(bl1.getSpotRow(), bl1.getSpotCol()));
		}
		if(bl2.checkAvailability() == true || bl2.getPiece() != null || bl2.getPiece().getSide() != super.getSide())
		{
			moves.add(new coordinate(bl2.getSpotRow(), bl2.getSpotCol()));
		}

		return moves;


	}

}