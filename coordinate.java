public class Coordinate
{
	int row,col;

	public Coordinate(int x, int y)
	{
		this.row = x;
		this.col = y;
	}

	public int getRow()
	{
		return row;
	}

	public int getCol()
	{
		return col;
	}
	public boolean equals(Object o){
		Coordinate c = (Coordinate) o;
		return (c.getRow() == getRow()) && (c.getCol() == getCol());

	}
	public String toString(){
		return String.format("(%d,%d)",row,col);
	}

}