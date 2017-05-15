import java.util.*;
public class King extends Piece{
	public King(char side, String name, ChessBoard b, Spot sp){
		super(side, name, b, sp);
	
	}
	public List<Coordinate> fullMoves(){
		ArrayList<Coordinate> moves = new ArrayList<>();
		moves.add(new Coordinate(getRow()-1,getCol()-1));
		moves.add(new Coordinate(getRow()-1,getCol()));
		moves.add(new Coordinate(getRow()-1,getCol()+1));
		moves.add(new Coordinate(getRow(),getCol()-1));
		moves.add(new Coordinate(getRow(),getCol()+1));
		moves.add(new Coordinate(getRow()+1,getCol()-1));
		moves.add(new Coordinate(getRow()+1,getCol()));
		moves.add(new Coordinate(getRow()+1,getCol()+1));

		//trims invalid moves
		for (int i = moves.size()-1; i >= 0; --i)
			if ((moves.get(i).getRow() < 0 || moves.get(i).getRow() > 7) || (moves.get(i).getCol() < 0 || moves.get(i).getCol() > 7))
				moves.remove(i);
		for(int i = moves.size() -1; i >= 0; --i)
			if (!isAvailable(moves.get(i).getRow(), moves.get(i).getCol()))
				moves.remove(i);
		return moves;
	}
	public List<Coordinate> possibleMoves(){
		ArrayList<Coordinate> moves = new ArrayList<>(fullMoves());

		ArrayList<Coordinate> kingMoves = new ArrayList<>();
		//trims enemy non-king moves
		////gets the moves
		ArrayList<Coordinate> enemyMoves = new ArrayList<>();
		for (Spot[] sps : b.getBoard())
			for(Spot sp : sps)
				if (sp.getPiece() != null && sp.getPiece().getSide() !=  getSide() && !sp.getPiece().toString().equals("King"))
					enemyMoves.addAll(sp.getPiece().possibleMoves());
				else if(sp.getPiece() != null && sp.getPiece().getSide() !=  getSide() && sp.getPiece().toString().equals("King"))
					kingMoves.addAll(((King)sp.getPiece()).fullMoves());
		////removes them
		ListIterator<Coordinate> iter = enemyMoves.listIterator();
		while(iter.hasNext())
			moves.remove(iter.next());

		//takes care of kingmoves
		for (Spot[] sps : b.getBoard())
			for (Spot sp : sps)
				if (sp.getPiece() != null && sp.getPiece().getSide() == getSide() && !sp.getPiece().toString().equals("King"))
					kingMoves.remove(sp.getPiece().possibleMoves());
		iter = kingMoves.listIterator();
		while (iter.hasNext())
			moves.remove(iter.next());



		return moves;
	}
	/* vestigial code
	public boolean checkChecks(){
		ArrayList<Coordinate> enemyMoves = new ArrayList<>();
		Coordinate thisCoord = new Coordinate(getRow(),getCol());
		for (Spot[] sps: b.getBoard())
			for(Spot sp: sps)
				if (sp.getPiece() != null && sp.getPiece().getSide() != getSide())
					enemyMoves.addAll(sp.getPiece().possibleMoves());
		if (enemyMoves.contains(thisCoord))
			return true;
		return false;

	}*/
}