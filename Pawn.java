public class Pawn extends Piece
{

	public Pawn(String side, int row, int col, String name)
	{
		super(side, row, col, name);
	}

	public int[][] possibleMoves(Board b)
	{
		int i = 0;
		int[][] array = new int[28][2];

		if([Row+1][Col+1].isAvailable) //find way to get get pawn and identify were it is on the board and how to move it
		{
			i++;
		}

		return array;

	}

	public String showPossibleMoves()
	{

	}

}
