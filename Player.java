public class Player
{
	char color;

	public Player(char side)
	{
		this.color = side;
	}

	public void initializeBoard(ChessBoard b)
	{
		for(int i = 0; i < b.getBoard()[0].length; i++)
		{
			b.getSpot(1,i).setPiece(new Pawn(this.color, "Pawn", b, b.getSpot(1,i)));
		}

		b.getSpot(0,0).setPiece(new Rook(this.color, "Rook", b, b.getSpot(0,0)));
		b.getSpot(0,1).setPiece(new Knight(this.color, "Knight", b, b.getSpot(0,1)));
		b.getSpot(0,2).setPiece(new Bishop(this.color,  "Bishop", b, b.getSpot(0,2)));
		b.getSpot(0,3).setPiece(new Queen(this.color,  "Queen", b, b.getSpot(0,3)));
		b.getSpot(0,4).setPiece(new King(this.color, "King", b, b.getSpot(0,4)));
		b.getSpot(0,5).setPiece(new Bishop(this.color, "Bishop", b, b.getSpot(0,5)));
		b.getSpot(0,6).setPiece(new Knight(this.color, "Knight", b, b.getSpot(0,6)));
		b.getSpot(0,7).setPiece(new Rook(this.color, "Rook", b, b.getSpot(0,7)));

	}
}