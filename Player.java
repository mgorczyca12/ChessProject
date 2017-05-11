public class Player
{
	char color;

	public Player(char side)
	{
		this.color = side;
	}

	public void intializeBoard(ChessBoard b)
	{
		for(int i = 0; i < b.getBoard()[0].length; i++)
		{
			b.getSpot(1,i).setPiece(new Pawn(this.color, b.getSpot(1,i).getSpotColumn(), b.getSpot(1,i).getSpotRow(), "Pawn"));
		}

		b.getSpot(0,0).setPiece(new Rook(this.color, b.getSpot(0,0).getSpotColumn(), b.getSpot(0,0).getSpotRow(), "Rook"));
		b.getSpot(0,1).setPiece(new Knight(this.color, b.getSpot(0,1).getSpotColumn(), b.getSpot(0,1).getSpotRow(), "Knight"));
		b.getSpot(0,2).setPiece(new Bishop(this.color, b.getSpot(0,2).getSpotColumn(), b.getSpot(0,2).getSpotRow(), "Bishop"));
		b.getSpot(0,3).setPiece(new Queen(this.color, b.getSpot(0,3).getSpotColumn(), b.getSpot(0,3).getSpotRow(), "Queen"));
		b.getSpot(0,4).setPiece(new King(this.color, b.getSpot(0,4).getSpotColumn(), b.getSpot(0,4).getSpotRow(), "King"));
		b.getSpot(0,5).setPiece(new Bishop(this.color, b.getSpot(0,5).getSpotColumn(), b.getSpot(0,5).getSpotRow(), "Bishop"));
		b.getSpot(0,6).setPiece(new Kinght(this.color, b.getSpot(0,6).getSpotColumn(), b.getSpot(0,6).getSpotRow(), "Knight"));
		b.getSpot(0,7).setPiece(new Rook(this.color, b.getSpot(0,7).getSpotColumn(), b.getSpot(0,7).getSpotRow(), "Rook"));

	}
}