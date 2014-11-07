import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.awt.*;
public class TicTacToePanel extends JPanel 
{
	public JLabel label = new JLabel("TicTacToe Panel add customization as you would like ");
	public static JLabel[] gameArray = new JLabel[9];
	public TicTacToePanel()
{
	MListener listener = new MListener();
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	add(label);
	gameArray = new JLabel[9];
	for(int i = 0; i<gameArray.length; i++)
	{
		gameArray[i] = new JLabel(i+"");
		gameArray[i].addMouseListener(listener);
		gameArray[i].setAlignmentX(Component.CENTER_ALIGNMENT);
		add(gameArray[i]);
	}
}

	public static class MListener implements MouseListener
 	{
	
	public void mouseClicked(MouseEvent event)
	{
		Object source = event.getSource();
		if(source == gameArray[0])
		{
			TicTacToePanel panel = new TicTacToePanel();
			ArcadeFrame.frame.setContentPane(panel);
			ArcadeFrame.frame.validate();
			ArcadeFrame.frame.repaint();
			System.out.println("Testing");

		}	
		else if(source == gameArray[1])
		{
			BlackJackPanel panel = new BlackJackPanel();
			ArcadeFrame.frame.setContentPane(panel);
			ArcadeFrame.frame.validate();
			ArcadeFrame.frame.repaint();
			System.out.println("Testine2");
		}
	 
  	}

  	public void mouseEntered(MouseEvent event)
  	{

  	}

  	public void mouseExited(MouseEvent event)
  	{

  	}

  	public void mouseReleased(MouseEvent event)
  	{

  	}

  	public void mousePressed(MouseEvent event)
  	{

  	}

  }



}