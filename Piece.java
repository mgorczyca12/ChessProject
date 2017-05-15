import java.util.*;

public abstract class Piece
{


	final char side;
	protected final String name;
	protected ChessBoard b;
	protected Spot sp;
	protected int moves = 0;

	public Piece(char side, String name, ChessBoard b, Spot sp)
	{
		this.side = side;
       	this.name = name;
       	this.b = b;
       	this.sp = sp;
	}

	public abstract List<Coordinate> possibleMoves();
	public void setSpot(Spot sp){
		this.sp = sp;
	}
	public Object clone()
	{
		try
		{
			return super.clone();
		}

		catch (Exception e)
		{
			return null;
		}
	}
	//PRECOND spot(i,j) is a valid spot
	public boolean isAvailable(int i, int j){
		 return b.getSpot(i,j).isOpen() || b.getSpot(i,j).getPiece().getSide() != this.side;
	}
	public boolean isEnemy(int i, int j){
		return isAvailable(i,j) && !b.getSpot(i,j).isOpen();

	}
	public List<Coordinate> checkHorizontal(int dir){
		ArrayList<Coordinate> moves = new ArrayList<>();
		for (int i = getCol(); (i != -1 && i != 8); i+=dir){
			if (getCol() != i && isAvailable(getRow(),i))
				moves.add(new Coordinate(getRow(),i));
			if (i != getCol() && b.getSpot(getRow(),i).getPiece() != null)
				break;
		}
		return moves;

	}
	public List<Coordinate> checkVertical(int dir){
		ArrayList<Coordinate> moves = new ArrayList<>();
		for (int i = getRow(); (i != -1 && i != 8); i+=dir){
			if (getRow() != i && isAvailable(i,getCol()))
				moves.add(new Coordinate(i,getCol()));
			if (i != getRow() && b.getSpot(i,getCol()).getPiece() != null)
				break;
		}
		return moves;
	}
	public List<Coordinate> checkDiagonal(int vDir, int hDir){
		ArrayList<Coordinate> moves = new ArrayList<>();
		for (int i = getRow(), j = getCol(); (i != -1 && i != 8) && (j != -1 && j != 8); i+=vDir, j += hDir){
			if (getCol() != j && getRow() != i && isAvailable(i,j))
				moves.add(new Coordinate(i,j));
			if ((i != getRow() && j != getCol()) && b.getSpot(i,j).getPiece() != null)
				break;
		}
		return moves;

	}
	
	//public abstract String showPossibleMoves();

	public int getRow()
	{
		return sp.getRow();
	}

	public int getCol()
	{
		return sp.getCol();
	}

	public void setRow(int y)
	{
		this.Row = y;
	}

	public void setCol(int x)
	{
		this.Column = x;
	}

	public String toString()
	{
		return name;
	}

	public char getSide()
	{
		return side;
	}

	public int getMoves(){return moves;}
	public void moved(){++moves;}

}