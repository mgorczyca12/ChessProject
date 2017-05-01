public class Spot{

    private boolean isAvailable;
    public Piece currentPiece;
	int x, y;

    public Spot(int x, int y)
    {
        this.isAvailable = true;
        this.currentPiece = null;
        this.x = x;
        this.y = y;
    }

    public void setPiece(Piece chessPiece)
    {
        this.currentPiece = chessPiece;
        this.isAvailable = false;
    }

	public void killPiece()
	{
		this.currentPiece = null;
		this.isAvailable = true;
	}

    public boolean checkAvailability()
    {
        if(this.isAvailable == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String toString()
    {
		String str = "\nCurrent Piece: " + currentPiece.toString();
		str += "Current Peice at " + this.x + ":" + this.y;

		return str;
	}

}
