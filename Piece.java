public abstract class Piece{

	protected final char color;
	protected int Column;
	protected int Row;
	protected final String name;

	public Piece(String side, int row, int col, String name)
	{
		this.color = side;
		this.Column = col;
        	this.Row = row;
       		this.name = name;
	}

	public String getColor()
	{
		return color;
	}

	public abstract int[][] possibleMoves();

	public abstract String showPossibleMoves();

	public String toString()
	{
		String str = this.color + " " + this.name;

		return str;
	}

	public char getSide()
	{
		return color;
	}

	public int getRow()
	{
		return Row;
	}

	public int getCol()
	{
		return Column;
	}

}

public class move
{
	int x;
	int y;

	public move(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public String toString()
	{
		System.out.println(x + " " + y);
	}
}
