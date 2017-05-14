public class Knight extends Piece{

	public Kinght(char side, int row, int col, String name)
	{
		super(side, row, col, name);
	}

	//finds any and all possible moves a pawn can make, weather thats to move up or attack another piece
	public List<coordinate> possibleMoves(ChessBoard b)
	{
		ArrayList<coordinate> moves = new ArrayList<>();


		//spots infront of piece
		Spot r1 = b.getSpot(super.getRow()+2, super.getCol()+1);
		Spot r2 = b.getSpot(super.getRow()+1, super.getCol()+2);

		Spot l1 = b.getSpot(super.getRow()+2, super.getCol()-1);
		Spot l2 = b.getSpot(super.getRow()+1, super.getCol()-2);

		//spots behind piece
		Spot br1 = b.getSpot(super.getRow()+2, super.getCol()+1);
		Spot br2 = b.getSpot(super.getRow()+1, super.getCol()+2);

		Spot bl1 = b.getSpot(super.getRow()+2, super.getCol()+1);
		Spot bl2 = b.getSpot(super.getRow()+1, super.getCol()+2);



		if(r1.checkAvailability() == true || r1.getPiece() != null || r1.getSide() != super.getSide())
		{
			moves.add(new coordinate(r1.getRow(), r1.getCol()));
		}
		if(r2.checkAvailability() == true || r2.getPiece() != null || r2.getSide() != super.getSide())
		{
			moves.add(new coordinate(r2.getRow(), r2.getCol()));
		}



		if(l1.checkAvailability() == true || l1.getPiece() != null || l1.getSide() != super.getSide())
		{
			moves.add(new coordinate(l1.getRow(), l1.getCol()));
		}
		if(l2.checkAvailability() == true || l2.getPiece() != null || l2.getSide() != super.getSide())
		{
			moves.add(new coordinate(l2.getRow(), l2.getCol()));
		}



		if(br1.checkAvailability() == true || br1.getPiece() != null || br1.getSide() != super.getSide())
		{
			moves.add(new coordinate(br1.getRow(), br1.getCol()));
		}
		if(br2.checkAvailability() == true || br2.getPiece() != null || br2.getSide() != super.getSide())
		{
			moves.add(new coordinate(br2.getRow(), br2.getCol()));
		}



		if(br1.checkAvailability() == true || bl1.getPiece() != null || bl1.getSide() != super.getSide())
		{
			moves.add(new coordinate(bl1.getRow(), bl1.getCol()));
		}
		if(br1.checkAvailability() == true || bl2.getPiece() != null || bl2.getSide() != super.getSide())
		{
			moves.add(new coordinate(bl2.getRow(), bl1.getCol()));
		}

		return moves;


	}

}