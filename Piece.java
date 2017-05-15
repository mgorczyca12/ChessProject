import java.util.*;

public abstract class Piece
{


	final char side;
	protected int Column;
	protected int Row;
	protected final String name;

	public Piece(char side, int row, int col, String name)
	{
		this.side = side;
		this.Column = col;
        this.Row = row;
       	this.name = name;
	}

	public abstract List<coordinate> possibleMoves(ChessBoard b);

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

	//public abstract String showPossibleMoves();

	public int getRow()
	{
		return Row;
	}

	public int getCol()
	{
		return Column;
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
		String l = Row + " " + Column;
		return l;
	}

	public char getSide()
	{
		return side;
	}

}