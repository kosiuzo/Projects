import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;

public class ArcadeGUI extends JPanel {

    public static JLabel ticTacLabel, blackJackLabel, titleLabel;
    public static ImageIcon ticTacToeImage = new ImageIcon("Images/tttbutton.png");
    public static ImageIcon blackJackImage = new ImageIcon("Images/bjbutton.png");
    public static ImageIcon title = new ImageIcon("Images/titlelabel.png");
    
    public ArcadeGUI () {
    
	
	MListhiener listener = new MListhiener();  
	titleLabel = new JLabel(title);
	ticTacLabel = new JLabel(ticTacToeImage);
	blackJackLabel = new JLabel(blackJackImage);
	ticTacLabel.addMouseListener(listener);
	blackJackLabel.addMouseListener(listener);
	ticTacLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	blackJackLabel.setAlignmentX(Component.CENTER_ALIGNMENT);   
	titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	add(titleLabel);
	add(ticTacLabel);
	add(blackJackLabel);
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	setBackground(Color.BLACK);
    
    }

 	public static class MListhiener implements MouseListener
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
			howManyCardsPanel panel = new howManyCardsPanel();
			ArcadeFrame.frame.setContentPane(panel);
			ArcadeFrame.frame.validate();
			ArcadeFrame.frame.repaint();
			System.out.println("You have been sent to the how many cards panel");
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
