public abstract class Piece
{

	protected final char side;
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

	public abstract int[][] possibleMoves();

	public abstract String showPossibleMoves();

	public int getRow()
	{
		return Row;
	}

	public int getCol()
	{
		return Column;
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
		String l = x + " " + y;
		return l;
	}

	public char getSide()
	{
		return side;
	}

}}