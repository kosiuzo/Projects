import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArcadeFrame {
	public static JMenuItem quit, gs,about,mm,htop;
	public static JMenuBar menu;
	public static JMenu game, help;
	public static JFrame frame;
	public Scanner inputStream;
	private final static String newline = "\n";
  
    

    public ArcadeFrame () {
	frame = new JFrame("Arcade");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setPreferredSize(new Dimension(600,700));
	frame.setResizable(false);
	
	
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
	htop = new JMenuItem("How to Play");
	htop.setMnemonic(KeyEvent.VK_T);
	htop.addActionListener(listener);
	gs = new JMenuItem("Get Started");
	gs.setMnemonic(KeyEvent.VK_G);
	gs.addActionListener(listener);
	about = new JMenuItem("About");
	about.setMnemonic(KeyEvent.VK_A);
	about.addActionListener(listener);
	game.add(mm);
	game.add(quit);
	help.add(htop);
	help.add(gs);
	help.add(about);

	//set up main menu pane
	ArcadeGUI MMPanel = new ArcadeGUI();

	frame.setContentPane(MMPanel);

	frame.validate();
	frame.pack();
	frame.setVisible(true);
    }
    
    //Listener for menu bar
    public class menuLister implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		
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
	    else if(source == htop)
	    {
	    	String fileName = "manual.txt";
	    	JTextArea info2 = new JTextArea(100,100);
			JScrollPane scrollPane = new JScrollPane(info2);
			scrollPane.setVerticalScrollBarPolicy(
	                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			info2.setEditable(false);
			try{
				
				inputStream = new Scanner(new File(fileName));
				}
				catch(FileNotFoundException e)
				{
					System.out.println("Error opening the file "+ fileName );
				}
				String display = new String("");
				JFrame leaderFrame = new JFrame("Manual");
				JPanel leaderPanel = new JPanel();
				leaderPanel.setLayout(new BoxLayout(leaderPanel,BoxLayout.Y_AXIS ));
				leaderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				leaderFrame.setPreferredSize(new Dimension(600,700));
				leaderFrame.setBackground(Color.black);
				while(inputStream.hasNextLine())
				{
					display = inputStream.nextLine();
					info2.append(display+newline);
					System.out.println(display);
				}
				leaderPanel.add(scrollPane);
				leaderFrame.setContentPane(leaderPanel);
				leaderFrame.validate();
				leaderFrame.pack();
				leaderFrame.setVisible(true);
	    }
	}
    }



}
