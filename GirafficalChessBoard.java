import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class GirafficalChessBoard extends JPanel implements Runnable{

	javax.swing.Timer t;
	JPanel thing;
	ChessBoard bord;
	SpotAction[][] acts = new SpotAction[8][8];
	Player w;
	Player b;
	Vector<Spot> activeSpots = new Vector<>();
	ChessButton[][] buttons = new ChessButton[8][8];
	java.util.List<Coordinate> availableMoves = new ArrayList<>();
	char currentColor = 'w';
	final Object[] promotables = {"Queen","Kinght","Rook","Bishop"};


	class Pair{
		String name;
		char color;
		Pair(char c, String n){
			color = c;
			name = n;
		}
		public boolean equals(Object o){
			Pair p = (Pair) o;
			return p.color == color && p.name.equals(name);
		}
		public int hashCode() {
			int i = 0;
			for (char c : name.toCharArray())
				i+= (int)c;
			i += (int) color;
			return i;
		}
		public String toString(){
			return color + " " + name;
		}
	}

	HashMap<Pair, ImageIcon> pics = new HashMap<Pair, ImageIcon>(){
		{	
			try {
				put(new Pair('w',"King"), new ImageIcon(ImageIO.read(getClass().getResource("img//w_k.png"))));
				put(new Pair('w',"Queen"), new ImageIcon(ImageIO.read(getClass().getResource("img//w_q.png"))));
				put(new Pair('w',"Rook"), new ImageIcon(ImageIO.read(getClass().getResource("img//w_r.png"))));
				put(new Pair('w',"Knight"), new ImageIcon(ImageIO.read(getClass().getResource("img//w_kn.png"))));
				put(new Pair('w',"Bishop"), new ImageIcon(ImageIO.read(getClass().getResource("img//w_b.png"))));
				put(new Pair('w',"Pawn"), new ImageIcon(ImageIO.read(getClass().getResource("img//w_p.png"))));
				put(new Pair('b',"King"), new ImageIcon(ImageIO.read(getClass().getResource("img//b_k.png"))));
				put(new Pair('b',"Queen"), new ImageIcon(ImageIO.read(getClass().getResource("img//b_q.png"))));
				put(new Pair('b',"Rook"), new ImageIcon(ImageIO.read(getClass().getResource("img//b_r.png"))));
				put(new Pair('b',"Knight"), new ImageIcon(ImageIO.read(getClass().getResource("img//b_kn.png"))));
				put(new Pair('b',"Bishop"), new ImageIcon(ImageIO.read(getClass().getResource("img//b_b.png"))));
				put(new Pair('b',"Pawn"), new ImageIcon(ImageIO.read(getClass().getResource("img//b_p.png"))));
			}
			catch (Exception e){

			}
		}
	};
	ImageIcon Blank;
	Image Blnk;
	Image Token;

	public GirafficalChessBoard(){
		thing = this;
		//reads some images
		try {
			Blnk = ImageIO.read(getClass().getResource("img//blank.png"));
			Blank = new ImageIcon(Blnk);
			Token = ImageIO.read(getClass().getResource("img//token.png"));
		}
		catch (Exception e){}
		
		//initializes the board
		bord = new ChessBoard();
		//players used only for initialization
		w = new Player('w');
		b = new Player('b');
		b.initializeBoard(bord);
		bord.flipBoard();
		w.initializeBoard(bord);
		bord.flipBoard();


		//populates the buttons and action listeners
		setLayout(new GridLayout(8,8));
		for (int i = 0; i < 8; ++i)
			for (int j = 0; j < 8; ++j){
				acts[i][j] = new SpotAction(i,j,bord);
				ChessButton temp = new ChessButton(acts[i][j]);
				
				buttons[i][j] = temp;
				this.add(temp);
			}

	}
	public void run(){
		//different events that could happen
		ActionListener refreshAction = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				refresh();
			}
		};
		ActionListener checkAction = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (activeSpots.size() == 2){
					//move the things
					bord.move(activeSpots.get(0),activeSpots.get(1));
					winChecker();

					//promotion
					String promoted = "";
					if (activeSpots.get(1).getPiece().toString().equals("Pawn") && (activeSpots.get(1).getRow() == 7 || activeSpots.get(1).getRow() == 0))
						promoted = (String)JOptionPane.showInputDialog(thing,"Promote to:","Promotion",JOptionPane.PLAIN_MESSAGE, null, promotables,"Queen");
					switch(promoted){
						case ("Queen"):
							activeSpots.get(1).setPiece(new Queen(currentColor,promoted,bord,activeSpots.get(1)));
							break;
						case ("Knight"):
							activeSpots.get(1).setPiece(new Knight(currentColor,promoted,bord,activeSpots.get(1)));
							break;
						case ("Rook"):
							activeSpots.get(1).setPiece(new Rook(currentColor,promoted,bord,activeSpots.get(1)));
							break;
						case ("Bishop"):
							activeSpots.get(1).setPiece(new Bishop(currentColor,promoted,bord,activeSpots.get(1)));
							break;
					}

					//clear the queue (not actually a queue in this case)
					activeSpots.remove(0);
					activeSpots.remove(0);

					//switches turns
					if (currentColor == 'w')
						currentColor = 'b';
					else
						currentColor = 'w';
				}

			}
		};
		ActionListener moveChecker = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//if one piece is selected, display possible moves
				if (activeSpots.size() == 1){
					displayMoveTokens();
				}

			}
		};


		t = new javax.swing.Timer(5, refreshAction);


		t.addActionListener(checkAction);
		t.addActionListener(moveChecker);
		t.start();

	}
	public void winChecker(){
		Piece wKing = null;
		Piece bKing = null;
		for (int i = 0; i < 8; ++i)
			for (int j = 0; j < 8; ++j){
				Spot temp = bord.getSpot(i,j);
				if (!temp.isOpen() && temp.getPiece().toString() == "King"){
					if (temp.getPiece().getSide() == 'w')
						wKing = temp.getPiece();
					else
						bKing = temp.getPiece();
				}
			}
		if (wKing == null)
			endGame("Black");
		else if (bKing == null)
			endGame("White");

	}
	public void endGame(String side){
		JOptionPane.showMessageDialog(thing,side+" Won!");
		System.exit(0);
	}
	

	public void refresh(){
		for (int i = 0; i < 8; ++i)
			for (int j = 0; j < 8; ++j){
				buttons[i][j].setIcon(Blank);
				//buttons[i][j].setImg(Blnk);
				if (bord.getSpot(i,j).getPiece() != null){
					Pair p = new Pair(bord.getSpot(i,j).getPiece().getSide(),bord.getSpot(i,j).getPiece().toString());
					//System.out.println(pics.getOrDefault(p,Blank));
					buttons[i][j].setIcon(pics.getOrDefault(p,Blank));
				}
			}
	}
	public void displayMoveTokens(){
		for (Coordinate c : availableMoves){
			try{
				buttons[c.getRow()][c.getCol()].setImg(Token);
				buttons[c.getRow()][c.getCol()].repaint();
			}
			catch (Exception e){
				System.out.println(e);
			}
		}
	}
	public void clearMoveTokens(){
		for (int i = 0; i < 8; ++i)
			for (int j = 0; j < 8; ++j){
				buttons[i][j].setImg(Blnk);
				this.repaint();
			}
	}

	public static void main(String[] args){
		JFrame f = new JFrame();
		f.add(new GirafficalChessBoard());
		f.setSize(700,700);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Chess Game");
		f.setVisible(true);

	}
	public void clearAvailable(){
		while(availableMoves.size() != 0)
			availableMoves.remove(0);
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
			if(activeSpots.size() == 1 && activeSpots.get(0).getRow() == x && activeSpots.get(0).getCol() == y){
				activeSpots.remove(0);
				clearMoveTokens();
				clearAvailable();
			}
			//selects piece
			else if (activeSpots.size() == 0 && sp.getPiece()!=null && sp.getPiece().possibleMoves().size() != 0 && currentColor == sp.getPiece().getSide()){
				availableMoves.addAll(sp.getPiece().possibleMoves());
				activeSpots.add(sp);
			}
			//selects second piece
			if (activeSpots.size() == 1 && availableMoves.contains(new Coordinate(x,y)) && (sp.getPiece() == null || currentColor != sp.getPiece().getSide())){
				clearAvailable();
				activeSpots.add(sp);
				clearMoveTokens();
			}

		}
	}
	class ChessButton extends JButton {
	
		Image img;
		public void setImg(Image i){
			img = i;
		}
		public void removeImage(){
			img = Blnk;
		}
		public ChessButton(Action a){
			super(a);
		}
		public void paintComponent(Graphics g){
		super.paintComponent(g);
			g.drawImage(img,getWidth()/2-30,getHeight()/2-30,null);

		}
	}

}
