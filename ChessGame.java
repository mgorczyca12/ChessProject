import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.beans.*;

public class ChessGame extends JFrame implements Runnable{

	Action startAction;
	Action creditsAction;
	Action exitAction;
	JLayeredPane mainPanel;

	public ChessGame(){super();}

	public void run(){

		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Chess Game");
		this.setLayout(null);

		mainPanel = new JLayeredPane();
		mainPanel.setBounds(0,0,700,700);
		mainPanel.setLayout(null);

		this.add(mainPanel);
		this.setVisible(true);

		Menu menu = new Menu();
		menu.setBounds(0,0,700,700);

		startAction = new AbstractAction("Start"){
			public void actionPerformed(ActionEvent a){
				GirafficalChessBoard b = new GirafficalChessBoard();
				b.setBounds(0,0,700,700);
				mainPanel.add(b,JLayeredPane.MODAL_LAYER + 30);
				mainPanel.setLayer(b,30);
				b.run();
			}
		};
		creditsAction = new AbstractAction("Information/How to play"){
			public void actionPerformed(ActionEvent a){
				Credits c = new Credits();
				c.setBounds(0,0,700,700);
				mainPanel.add(c,JLayeredPane.MODAL_LAYER + 20);
				mainPanel.setLayer(c,20);
			}

		};
		exitAction = new AbstractAction("Quit"){
			public void actionPerformed(ActionEvent a){
				System.exit(0);
			}
		};

		JButton play = new JButton(startAction);
		JButton credits = new JButton(creditsAction);
		JButton quit = new JButton(exitAction);
		menu.add(play);
		menu.add(credits);
		menu.add(quit);
		mainPanel.add(menu, JLayeredPane.MODAL_LAYER + 10);
		mainPanel.setLayer(menu,0);

	}
    public static void main(String []args)
    {
        SwingUtilities.invokeLater(new ChessGame());
    }
}
class Menu extends JPanel {
	GridBagConstraints gbc;
	public void add(JButton b){
		super.add(b, gbc);
	}
	public Menu(){
		super();
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

	}
}

class Credits extends JPanel implements ActionListener {
	GridBagConstraints gbc;
	public Credits(){
		super();
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JButton b = new JButton("Exit");
		this.addMouseListener(null);
		b.addActionListener(this);
		this.add(b,gbc);
		//this.getParent().getComponentInLayer(0)[0].getComponents()[0].get

	}
	public void paintComponent(Graphics g)
	{
		g.setColor(new Color(100,200,0));
		g.setFont(new Font("TimesRoman", Font.BOLD, 24));
		g.drawString("Made By:",200,50);
		g.drawString("George Li",200,70);
		g.drawString("Michal Gorczyca",200,90);
		g.drawString("Rules",200,110);
		g.drawString("Follows international chess rules except:",200,130);
		g.drawString("No En Passant.",200,150);
		g.drawString("No Castling.",200,170);
		g.drawString("Click to move things.",200,190);
	}
	public void actionPerformed(ActionEvent a){
		JComponent parent = (JComponent) this.getParent();
		parent.remove(this);
		parent.paint(parent.getGraphics());

	}

}

