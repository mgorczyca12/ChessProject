public class Queen extends Piece{

	public Queen(char side, int row, int col, String name)
	{
		super(side, row, col, name);
	}

	public List<coordinate> possibleMoves(ChessBoard b)
	{
		int i = 1;
		ArrayList<coordinate> moves = new ArrayList<>();

		while(b.getSpot(super.getRow + i, super.getCol).checkAvailability() != false || b.getSpot(super.getRow + i, super.getCol).getSide() != super.getSide() || i > 8)
		{
			if(b.getSpot(super.getRow + i, super.getCol).getRow() >= 0)
			{
				moves.add(new coordinate(super.getRow + i, super.getCol));
			}
			i++;
		}

		i = 1;

		while(b.getSpot(super.getRow - i, super.getCol).checkAvailability() != false || b.getSpot(super.getRow - i, super.getCol).getSide() != super.getSide() || i > 8)
		{
			if(b.getSpot(super.getRow - i, super.getCol).getRow() >= 0)
			{
				moves.add(new coordinate(super.getRow - i, super.getCol));
			}
			i++;
		}

		i = 1;

		while(b.getSpot(super.getRow, super.getCol + i).checkAvailability() != false || b.getSpot(super.getRow, super.getCol + i).getSide() != super.getSide() || i > 8)
		{
			if(b.getSpot(super.getRow, super.getCol + i).getRow() >= 0)
			{
				moves.add(new coordinate(super.getRow, super.getCol + i));
			}
			i++;
		}

		i = 1;

		while(b.getSpot(super.getRow, super.getCol - i).checkAvailability() != false || b.getSpot(super.getRow, super.getCol - i).getSide() != super.getSide() || i > 8)
		{
			if(b.getSpot(super.getRow, super.getCol - i).getRow() >= 0)
			{
				moves.add(new coordinate(super.getRow, super.getCol - i));
			}
			i++;

		}

		while(b.getSpot(super.getRow + i, super.getCol + i).checkAvailability() != false || b.getSpot(super.getRow + i, super.getCol + i).getSide() != super.getSide() || i > 8)
		{
			if(b.getSpot(super.getRow + i, super.getCol + i).getRow() >= 0)
			{
				moves.add(new coordinate(super.getRow + i, super.getCol + i));
			}
			i++;
		}

		i = 1;

		while(b.getSpot(super.getRow - i, super.getCol - i).checkAvailability() != false || b.getSpot(super.getRow - i, super.getCol - i).getSide() != super.getSide() || i > 8)
		{
			if(b.getSpot(super.getRow - i, super.getCol - i).getRow() >= 0)
			{
				moves.add(new coordinate(super.getRow - i, super.getCol - i));
			}
			i++;
		}

		i = 1;

		while(b.getSpot(super.getRow - i, super.getCol + i).checkAvailability() != false || b.getSpot(super.getRow - i, super.getCol + i).getSide() != super.getSide() || i > 8)
		{
			if(b.getSpot(super.getRow - i, super.getCol + i).getRow() >= 0)
			{
				moves.add(new coordinate(super.getRow - i, super.getCol + i));
			}
			i++;
		}

		i = 1;

		while(b.getSpot(super.getRow + i, super.getCol - i).checkAvailability() != false || b.getSpot(super.getRow + i, super.getCol - i).getSide() != super.getSide() || i > 8)
		{
			if(b.getSpot(super.getRow + i, super.getCol - i).getRow() >= 0)
			{
				moves.add(new coordinate(super.getRow + i, super.getCol - i));
			}
			i++;
		}

		return moves;

	}

}