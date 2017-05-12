import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class GirafficalChessBoard extends JPanel implements Runnable{

	javax.swing.Timer t;
	ChessBoard bord;
	SpotAction[][] acts = new SpotAction[8][8];

	public GirafficalChessBoard(){
		bord = new ChessBoard();
		setLayout(new GridLayout(8,8));
		for (int i = 0; i < 8; ++i)
			for (int j = 0; j < 8; ++j){
				acts[i][j] = new SpotAction(i,j,bord);
				this.add(new JButton(acts[i][j]));
			}
	}
	public void run(){

	}

	public static void main(String[] args){
		JFrame f = new JFrame();
		f.add(new GirafficalChessBoard());
		f.setSize(700,700);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Chess Game");
		f.setVisible(true);

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
	public void actionPerformed(ActionEvent e){
		System.out.println(String.format("(%s,%s)",x,y));
	}

}
