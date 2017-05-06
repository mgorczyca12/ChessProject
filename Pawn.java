public class Pawn extends Piece
{

	public Pawn(char side, int row, int col, String name)
	{
		super(side, row, col, name);
	}

	public int[][] possibleMoves(Board b)
	{
		ArrayList<Integer> moveX = new ArrayList<Integer>();



		if(ChessBoard.getBoard()[super.getRow()+1][super.getCol()+1].getPeiceSide() == 'w' && side == 'b')
		{
			moveX.add()


		}

		return array;
	}

	public String showPossibleMoves()
	{

	}

}
