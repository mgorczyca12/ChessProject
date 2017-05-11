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
		creditsAction = new AbstractAction("Credits"){
			public void actionPerformed(ActionEvent a){
				Credits c = new Credits();
				c.setBounds(0,0,700,700);
				mainPanel.add(c,2);
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
		mainPanel.add(menu,1);

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
class Credits extends JComponent {
	public Credits(){
		super();
		this.add(new JComponent(){public void paintComponent(Graphics g){g.setColor(new Color(100,200,0));g.fillRect(100,100,100,100);}});
	}
}

