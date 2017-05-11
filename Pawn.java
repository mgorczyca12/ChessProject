import java.util.*;

public class Pawn extends Piece
{

	public Pawn(char side, int row, int col, String name)
	{
		super(side, row, col, name);
	}

	//finds any and all possible moves a pawn can make, weather thats to move up or attack another piece
	public List<coordinate> possibleMoves(ChessBoard b)
	{
		ArrayList<coordinate> moves = new ArrayList<>();

		Spot r = b.getSpot(super.getRow()+1, super.getCol()+1); //up: 1, left: 1
		Spot c = b.getSpot(super.getRow(), super.getCol()+1); //up: 1
		Spot l = b.getSpot(super.getRow()+1, super.getCol()-1); // up: 1, right: 1

		//if pawn is black
		if(side == 'b')
		{
			if(r.checkAvailability() == false &&  r.getPiece() != null || r.getPiece().getSide() == 'w')
			{
				moves.add(new coordinate(super.getRow()+1, super.getCol()+1));
			}

			if(c.checkAvailability() == true && b.getTurn() == 1)
			{
				moves.add(new coordinate(super.getRow(), super.getCol()+2));
			}
			else if(c.checkAvailability() == true)
			{
				moves.add(new coordinate(super.getRow(), super.getCol()+1));
			}

			if(l.checkAvailability() == false && r.getPiece().getSide() == 'w')
			{
				moves.add(new coordinate(super.getRow()+1, super.getCol()-1));
			}

		}

		//if pawn is white
		else if(side == 'w')
		{
			if(r.checkAvailability() == false &&  r.getPiece() != null || r.getPiece().getSide() == 'b')
			{
				moves.add(new coordinate(super.getRow()+1, super.getCol()+1));
			}

			if(c.checkAvailability() == true && b.getTurn() == 1)
			{
				moves.add(new coordinate(super.getRow(), super.getCol()+2));
			}
			else if(c.checkAvailability() == true)
			{
				moves.add(new coordinate(super.getRow(), super.getCol()+1));
			}

			if(l.checkAvailability() == false && r.getPiece().getSide() == 'b')
			{
				moves.add(new coordinate(super.getRow()+1, super.getCol()-1));
			}

		}

		return moves;
	}

}
