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

	public abstract List<List<Integer>>[] possibleMoves();

	public abstract String showPossibleMoves();

	public int getRow()
	{
		return Row;
	}

	public int getCol()
	{
		return Column;
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