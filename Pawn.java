public class Pawn extends Piece
{

	public Pawn(String side, int row, int col, String name)
	{
		super(side, row, col, name);
	}

	public int[][] possibleMoves(Board b)
	{
		ArrayList<Integer> moveX = new ArrayList<Integer>();
		ArrayList<Integer> moveY = new ArrayList<Integer>();
		

		if(ChessBoard.getBoard()[super.getRow()+1][super.getCol()+1].isAvailable()) //find way to get get pawn and identify were it is on the board and how to move it
		{
			moveX.add()
		}
		
		return array;
	}

	public String showPossibleMoves()
	{

	}

}
