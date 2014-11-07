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

public class ArcadeFrame {
	public static JMenuItem quit, gs,about,mm;
	public static JMenuBar menu;
	public static JMenu game, help;
	public static JFrame frame;
    
    public ArcadeFrame () {
	frame = new JFrame("Arcade");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	menuLister listener = new menuLister();

	 menu = new JMenuBar();
	frame.setJMenuBar(menu);
	 game = new JMenu("Game");
	game.setMnemonic(KeyEvent.VK_G);
	 help = new JMenu("Help");
	help.setMnemonic(KeyEvent.VK_H);
	menu.add(game);
	menu.add(help);
	mm = new JMenuItem("Main Menu");
	mm.addActionListener(listener);
	mm.setMnemonic(KeyEvent.VK_M);
	quit = new JMenuItem("Quit");
	quit.setMnemonic(KeyEvent.VK_Q);
	quit.addActionListener(listener);
	gs = new JMenuItem("Get Started");
	gs.setMnemonic(KeyEvent.VK_G);
	gs.addActionListener(listener);
	about = new JMenuItem("About");
	about.setMnemonic(KeyEvent.VK_A);
	about.addActionListener(listener);
	game.add(mm);
	game.add(quit);
	help.add(gs);
	help.add(about);
	
	//set up main menu pane
	ArcadeGUI MMPanel = new ArcadeGUI();
	
	frame.setContentPane(MMPanel);

	frame.validate();
	frame.pack();
	frame.setVisible(true);
    }

    public static class menuLister implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		//Object source = e.getSource();
		Object source = event.getSource();
	    if(source == quit)
	    	System.exit(0);
	    else if(source == mm)
	    {
	    	ArcadeGUI MMPanel = new ArcadeGUI();
	    	frame.setContentPane(MMPanel);
			frame.validate();
			frame.repaint();
			System.out.println("Reset back to Main Menu");
	    }
	    else if(source == about)
	    {
	    	JOptionPane.showMessageDialog(null, "Version: 1.00\nAuthor: Kosi Uzodinma and Kyler Collins" +
				 "\nCreated with JSWING and Awt", "About Options", JOptionPane.INFORMATION_MESSAGE);
	    }
	    else if(source == gs)
	    {
	    	JOptionPane.showMessageDialog(null, "To start pick one of choices to play the game of your choice" + 
					"\n\nMENUBAR OPTIONS\nMainMenu: Takes you back to the main menu to choose a selection to play \nQuit: Exits the program" +
					 "\nGetStarted: Tells you information on how to use the program\n" + 
					 "About Options: tells you about the program", "Getting Started", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
    }

   
    
}