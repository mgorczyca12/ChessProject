import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ChessGame extends JFrame implements Runnable{

	MouseListener menuListener;
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

		mainPanel.add(new JComponent(){
			{this.setBounds(100,100,100,100);}
			public void paintComponent(Graphics g){
				g.setColor(new Color(120,244,12));
				g.fillRect(0,0,100,100);
			}}, 1);

		mainPanel.remove(mainPanel.getComponents()[0]);

	}
    public static void main(String []args)
    {
        SwingUtilities.invokeLater(new ChessGame());
    }
}
class Menu extends JPanel {
	java.util.List<JButton> buttons = new ArrayList<>();
	public void add(JButton b){
		buttons.add(b);
		this.add(b);
	}
	public Menu(){
		super();
		this.setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
	}
}
