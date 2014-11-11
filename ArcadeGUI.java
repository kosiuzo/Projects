import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

public class ArcadeGUI extends JPanel {

    public static JLabel ticTacLabel, blackJackLabel;
    public static ImageIcon ticTacToeImage = new ImageIcon("Images/tictactoe.png");
    public static ImageIcon blackJackImage = new ImageIcon("Images/blackjack.png");


    public ArcadeGUI () {
    MListener listener = new MListener();
    ticTacLabel=new JLabel(ticTacToeImage);
    blackJackLabel = new JLabel(blackJackImage);
    ticTacLabel.addMouseListener(listener);
    blackJackLabel.addMouseListener(listener);
    ticTacLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    blackJackLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    add(ticTacLabel);
    add(blackJackLabel);
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


    }

 	public static class MListener implements MouseListener
 	{

	public void mouseClicked(MouseEvent event)
	{
		Object source = event.getSource();
		if(source == ticTacLabel)
		{
			TicTacToePanel panel = new TicTacToePanel();
			ArcadeFrame.frame.setContentPane(panel);
			ArcadeFrame.frame.validate();
			ArcadeFrame.frame.repaint();
			System.out.println("You have been sent to the TicTacToe panel");

		}
		else if(source == blackJackLabel)
		{
			BlackJackPanel panel = new BlackJackPanel();
			ArcadeFrame.frame.setContentPane(panel);
			ArcadeFrame.frame.validate();
			ArcadeFrame.frame.repaint();
			System.out.println("You have been sent to the black jack panel");
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
