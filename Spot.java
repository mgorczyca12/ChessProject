public class Spot{

    public Piece currentPiece;
	int x, y;

    public Spot(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

	public int getRow()
	{
		return x;
	}

	public int getCol()
	{
		return y;
	}

    public void setPiece(Piece chessPiece)
    {
        this.currentPiece = chessPiece;
    }

    public Piece getPiece()
	{
	     return currentPiece;
    }

	public void killPiece()
	{
		this.currentPiece = null;
	}

    public boolean isOpen()
    {
        return currentPiece == null;
    }

	public char getPieceSide()
	{
		return this.getPiece().getSide();
	}

    public String toString()
    {   
		return String.format("%9s,(%d,%d)%c;",(isOpen() ? "null" : currentPiece), x, y,(getPiece() != null ? getPieceSide() : '0'));
	}

}
