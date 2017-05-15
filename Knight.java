import java.util.*;
public class Knight extends Piece{

	public Knight(char side, String name, ChessBoard b, Spot sp)
	{
		super(side, name, b, sp);
	}

	//finds any and all possible moves a pawn can make, weather thats to move up or attack another piece
	public List<Coordinate> possibleMoves()
	{
		ArrayList<Coordinate> moves = new ArrayList<>();
		//two up, adjacent horizontally
		if (getCol() > 1){
			if (getRow() < 7 && isAvailable(getRow()+1,getCol()-2))
				moves.add(new Coordinate(getRow()+1, getCol()-2));
			if (getRow() > 0 && isAvailable(getRow()-1,getCol()-2))
				moves.add(new Coordinate(getRow()-1, getCol()-2));
		}
		//two down, adjacent horizontally
		if (getCol() < 6){
			if (getRow() < 7 && isAvailable(getRow()+1,getCol()+2))
				moves.add(new Coordinate(getRow()+1, getCol()+2));
			if (getRow() > 0 && isAvailable(getRow()-1,getCol()+2))
				moves.add(new Coordinate(getRow()-1, getCol()+2));
		}
		//two right, adjacent vertically
		if (getRow() < 6) {
			if (getCol() < 7 && isAvailable(getRow()+2,getCol()+1))
				moves.add(new Coordinate(getRow()+2, getCol()+1));
			if (getCol() > 0 && isAvailable(getRow()+2,getCol()-1))
				moves.add(new Coordinate(getRow()+2, getCol()-1));
		}
		//two left, adjacent vertically
		if (getRow() > 1){
			if (getCol() < 7 && isAvailable(getRow()-2,getCol()+1))
				moves.add(new Coordinate(getRow()-2, getCol()+1));
			if (getCol() > 0 && isAvailable(getRow()-2,getCol()-1))
				moves.add(new Coordinate(getRow()-2, getCol()-1));
		}

		return moves;


	}

}