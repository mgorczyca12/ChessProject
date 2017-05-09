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

		this.setSize(700,700);
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
				//to be implemented

			}
		};
		String kek = "topKek";
		creditsAction = new AbstractAction("Credits"){
			public void actionPerformed(ActionEvent a){

				//mainPanel.setLayer(c,20);
				//System.out.println(mainPanel.getComponentCountInLayer(20));
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
		mainPanel.add(menu);
		mainPanel.setLayer(menu,0);
		Credits c = new Credits();
		c.setBounds(0,0,300,300);
		mainPanel.add(c);
		mainPanel.setLayer(c,2);

	}
    public static void main(String []args)
    {
        SwingUtilities.invokeLater(new ChessGame());
    }
}
class Menu extends JPanel {
	GridBagConstraints gbc;
	java.util.List<JButton> buttons = new ArrayList<>();
	public void add(JButton b){
		buttons.add(b);
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
class Credits extends JPanel {
	GridBagConstraints gbc;
	public Credits(){
		super();
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
	}
			public void paintComponent(Graphics g)
			{
				g.setColor(new Color(100,200,0));
				g.fillRect(0,0,100,100);
			}

}

