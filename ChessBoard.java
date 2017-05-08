public class ChessBoard
{
	Spot[][] board;

	public ChessBoard()
	{
		this.board = new Spot[8][8];

		//sets all board spots as having an x and a y
		for(int row = 0; row <= board.length - 1; row++)
		{
			for(int col = 0; row <= board[0].length - 1; col++)
			{
				this.board[row][col] = new Spot(row,col);
			}
		}
	}

	public void flipBoard()
	{
		//only goes through half of the rows since it would flip the array twice over if it went through them all
		for(int row = 0; row < (this.board.length / 2); row++)
		{
			Spot[] temp = this.board[row];//makes temporary save of current row
			this.board[row] = this.board[this.board.length - row - 1];//take the last row and replace it with the current row
			this.board[this.board.length - row - 1] = temp;//take saved current row and set it as the last row
		}
	}

	public Spot getSpot(int x, int y)
	{
		return this.board[x][y];
	}

	public void move(Spot currentSpot, Spot targetSpot)
	{
		targetSpot.setPiece(currentSpot.getPiece());
		currentSpot.killPiece();
	}

	public void move(int currentX, int currentY, int targetX, int targetY)
	{
		this.board[targetX][targetY].setPiece(this.board[currentX][currentY].getPiece());
		this.board[targetX][targetY].killPiece();
	}

}
