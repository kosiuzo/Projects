import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.imageio.ImageIO;

import java.net.URL;

import javax.swing.BoxLayout;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

import java.io.File;
import java.io.IOException;
import java.awt.Graphics;

public class howManyCardsPanel extends JPanel
{
	public JLabel num1 = new JLabel(1+"");
	public JLabel num2 = new JLabel(2+"");
	public JLabel num3 = new JLabel(3+"");
	public JLabel num4 = new JLabel(4+"");
	public JLabel num5 = new JLabel(5+"");
	public JLabel num6 = new JLabel(6+"");
	public JLabel num7 = new JLabel(7+"");
	public JLabel num8 = new JLabel(8+"");
	public JLabel title = new JLabel("      HOW MANY DECKS DO YOU WANT TO USE?      ");
	public howManyCardsPanel()
    {
	    setBackground(Color.GREEN);
	    title.setAlignmentX(Component.CENTER_ALIGNMENT);
		Font font = new Font("FixedSys", Font.PLAIN, 30);
		Font font2 = new Font("FixedSys", Font.PLAIN, 15);
		title.setFont(font2);
		MListener listener = new MListener();
		num1.setFont(font);
		num1.addMouseListener(listener);
		num2.setFont(font);
		num2.addMouseListener(listener);
		num3.setFont(font);
		num3.addMouseListener(listener);
		num4.setFont(font);
		num4.addMouseListener(listener);
		num5.setFont(font);
		num5.addMouseListener(listener);
		num6.setFont(font);
		num6.addMouseListener(listener);
		num7.setFont(font);
		num7.addMouseListener(listener);
		num8.setFont(font);
		num8.addMouseListener(listener);
		add(title);
		add(num1);
		add(num2);
		add(num3);
		add(num4);
		add(num5);
		add(num6);
		add(num7);
		add(num8);
		
	
	}
	public class MListener implements MouseListener
 	{
	
	public void mouseClicked(MouseEvent event)
	{
		Object source = event.getSource();
		if(source == num1)
		{
			blackJackPanel.shoeValue = 1;
			blackJackPanel panel = new blackJackPanel();
			ArcadeFrame.frame.setContentPane(panel);
			ArcadeFrame.frame.validate();
			ArcadeFrame.frame.repaint();
			System.out.println("You have been sent to the black jack panel");
		}
		else if(source == num2)
		{
			blackJackPanel.shoeValue = 2;
			blackJackPanel panel = new blackJackPanel();
			ArcadeFrame.frame.setContentPane(panel);
			ArcadeFrame.frame.validate();
			ArcadeFrame.frame.repaint();
			System.out.println("You have been sent to the black jack panel");
		}
		else if(source == num3)
		{
			blackJackPanel.shoeValue = 3;
			blackJackPanel panel = new blackJackPanel();
			ArcadeFrame.frame.setContentPane(panel);
			ArcadeFrame.frame.validate();
			ArcadeFrame.frame.repaint();
			System.out.println("You have been sent to the black jack panel");
		}
		else if(source == num4)
		{
			blackJackPanel.shoeValue = 4;
			blackJackPanel panel = new blackJackPanel();
			ArcadeFrame.frame.setContentPane(panel);
			ArcadeFrame.frame.validate();
			ArcadeFrame.frame.repaint();
			System.out.println("You have been sent to the black jack panel");
		}
		else if(source == num5)
		{
			blackJackPanel.shoeValue = 5;
			blackJackPanel panel = new blackJackPanel();
			ArcadeFrame.frame.setContentPane(panel);
			ArcadeFrame.frame.validate();
			ArcadeFrame.frame.repaint();
			System.out.println("You have been sent to the black jack panel");
		}
		else if(source == num6)
		{
			blackJackPanel.shoeValue = 6;
			blackJackPanel panel = new blackJackPanel();
			ArcadeFrame.frame.setContentPane(panel);
			ArcadeFrame.frame.validate();
			ArcadeFrame.frame.repaint();
			System.out.println("You have been sent to the black jack panel");
		}
		else if(source == num7)
		{
			blackJackPanel.shoeValue = 7;
			blackJackPanel panel = new blackJackPanel();
			ArcadeFrame.frame.setContentPane(panel);
			ArcadeFrame.frame.validate();
			ArcadeFrame.frame.repaint();
			System.out.println("You have been sent to the black jack panel");
		}
		else if(source == num8)
		{
			blackJackPanel.shoeValue = 8;
			blackJackPanel panel = new blackJackPanel();
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
