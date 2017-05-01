public abstract class Piece{

	protected final String color;
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



}
