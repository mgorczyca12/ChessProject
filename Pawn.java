public class Pawn extends Piece
{

	public Pawn(String side, int row, int col, String color)
	{
		super(side, row, col, color);
	}

	public int[][] possibleMoves(Board b)
	{
		int i = 0;
		int[][] array = new int[28][2];

		if(b[Row][Col+1].isAvailable)
		{
			i++;

		}



	}

	public String showPossibleMoves()
	{

	}

}