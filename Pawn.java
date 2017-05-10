import java.util.*;

public class Pawn extends Piece
{

	public Pawn(char side, int row, int col, String name)
	{
		super(side, row, col, name);
	}

	public List<List<Integer>>[] possibleMoves(ChessBoard b)
	{
		List<List<Integer>> nutralArray = new ArrayList<List<Integer>>();
		List<List<Integer>> attackArray = new ArrayList<List<Integer>>();

		List<List<Integer>>[] array = new List<List<Integer>>[2];

		Spot r = b.getBoard()[super.getRow()+1][super.getCol()+1];
		Spot c = b.getBoard()[super.getRow()][super.getCol()+1];
		Spot l = b.getBoard()[super.getRow()+1][super.getCol()-1];

		if(side == 'b')
		{
			if(r.checkAvaliability() == false &&  !r.getPiece() == null || r.getPeice().getSide() == 'w')
			{
				attackArray.get(0).add(super.getRow()+1, super.getCol()+1);
			}

			if(c.checkAvailability() == true && b.getTurn == 1)
			{
				nutralArray.get(0).add(super.getRow(), super.getCol()+2);
			}
			else if(c.checkAvailability() == true)
			{
				nutralArray.get(0).add(super.getRow(), super.getCol()+1);
			}

			if(l.checkAvaliability() == false && r.getPeice().getSide == 'w')
			{
				attackArray.get(0).add(super.getRow()+1, super.getCol()-1);
			}

		}

		else if(side == 'w')
		{
			if(r.checkAvaliability() == false &&  !r.getPiece() == null || r.getPeice().getSide() == 'b')
			{
				attackArray.get(0).add(super.getRow()+1, super.getCol()+1);
			}

			if(c.checkAvailability() == true && b.getTurn == 1)
			{
				nutralArray.get(0).add(super.getRow(), super.getCol()+2);
			}
			else if(c.checkAvailability() == true)
			{
				nutralArray.get(0).add(super.getRow(), super.getCol()+1);
			}

			if(l.checkAvaliability() == false && r.getPeice().getSide == 'b')
			{
				attackArray.get(0).add(super.getRow()+1, super.getCol()-1);
			}
		}

		array[0] = nutralArray;
		array[1] = attackArray;

		return array;
	}

	public String showPossibleMoves()
	{

	}

}
