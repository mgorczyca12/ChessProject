class GirafficalChessBoard extends JPanel{

	ChessBoard bord;
	SpotAction[][] acts = new SpotAction[8][8];
	GirafficalChessBoard(){
		bord = new ChessBoard();
		setLayout(new GridLayout());
		for (int i = 0; i < 8; ++i)
			for (int j = 0; j < 8; ++j)
				acts[i][j] = new SpotAction(i,j,bord);
	}


}
class SpotAction extends AbstractAction{
	int x,y;
	Spot sp;
	public SpotAction(int x, int y, ChessBoard b){
		this.x = x;
		this.y = y;
		sp = b.getSpot(x,y);
	}
	public void actionPerformed(){
		return sp;
	}

}
