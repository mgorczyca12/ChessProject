import java.util.*;
public class ChessBoard
{
	Spot[][] board;

	public int turn = 1;

	public ChessBoard()
	{
		this.board = new Spot[8][8];

		//sets all board spots as having an x and a y
		for(int row = 0; row <= board.length - 1; row++)
		{
			for(int col = 0; col <= board[0].length - 1; col++)
			{
				this.board[row][col] = new Spot(row,col);
			}
		}
	}

	public Spot[][] getBoard()
	{
		return this.board;
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

		if (targetSpot.getPiece() == null)
		{
			targetSpot.setPiece(currentSpot.getPiece());
			targetSpot.getPiece().setSpot(targetSpot);
			currentSpot.killPiece();
			targetSpot.getPiece().moved();
		}
		else if(currentSpot.getPiece().getSide() != targetSpot.getPiece().getSide())
		{

			targetSpot.killPiece();
			targetSpot.setPiece(currentSpot.getPiece());
			targetSpot.getPiece().setSpot(targetSpot);
			currentSpot.killPiece();
			targetSpot.getPiece().moved();
		}

	}

	public static void main(String[] args){
		Player w = new Player('w');
		Player bl = new Player('b');
		ChessBoard b = new ChessBoard();
		bl.initializeBoard(b);
		b.flipBoard();
		w.initializeBoard(b);
		b.flipBoard();
		int x1 = 0, x2 = 0;
		int y1 = 0, y2 = 0;
		List<Coordinate> co;
		Scanner s = new Scanner(System.in);
		while (true){
			System.out.println(b);
			x1 = s.nextInt();
			y1 = s.nextInt();
			co = b.getSpot(x1,y1).getPiece().possibleMoves();
			System.out.println(co);
			x2 = s.nextInt();
			y2 = s.nextInt();
			b.move(b.getSpot(x1,y1),b.getSpot(x2,y2));

		}

	}

	public int getTurn()
	{
		return turn;
	}

	public void nextTurn()
	{
		turn++;
	}
	public String toString(){
		String str = "";
		for (Spot[] sps : board){
			for (Spot sp : sps)
				str += sp;
			str += "\n";
		}
		return str;
	}

}
