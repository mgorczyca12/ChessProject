import java.util.*;

public class Pawn extends Piece
{

	public Pawn(char side, String name, ChessBoard b, Spot sp)
	{
		super(side, name, b, sp);
	}

	//finds any and all possible moves a pawn can make, weather thats to move up or attack another piece
	public List<Coordinate> possibleMoves()
	{

		int dir = 0;
		ArrayList<Coordinate> moves = new ArrayList<>();
		if (side == 'w')
			dir = -1;
		if (side == 'b')
			dir = 1;
		//front
		if(getRow() > 0 && b.getSpot(getRow()+dir,getCol()).isOpen())
			moves.add(new Coordinate(getRow()+dir,getCol()));

		//diagonals
		if(getCol() < 7 && isEnemy(getRow()+dir,getCol()+1))
			moves.add(new Coordinate(getRow()+dir,getCol()+1));
		if(getCol() > 0 && isEnemy(getRow()+dir,getCol()-1))
			moves.add(new Coordinate(getRow()+dir,getCol()-1));

		//initial two
		if (getMoves() == 0)
			moves.add(new Coordinate(getRow()+2*dir, getCol()));

		return moves;
	}

}
