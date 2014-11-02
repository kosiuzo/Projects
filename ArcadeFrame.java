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
    
    public ArcadeFrame () {
	JFrame frame = new JFrame("Arcade");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JMenuBar menu = new JMenuBar();
	frame.setJMenuBar(menu);
	JMenu game = new JMenu("Game");
	game.setMnemonic(KeyEvent.VK_G);
	JMenu help = new JMenu("Help");
	help.setMnemonic(KeyEvent.VK_H);
	menu.add(game);
	menu.add(help);
	JMenuItem mm = new JMenuItem("Main Menu");
	mm.addActionListener(new mmAL());
	mm.setMnemonic(KeyEvent.VK_M);
	JMenuItem quit = new JMenuItem("Quit");
	quit.setMnemonic(KeyEvent.VK_Q);
	quit.addActionListener(new quitAL());
	JMenuItem gs = new JMenuItem("Get Started");
	gs.setMnemonic(KeyEvent.VK_G);
	gs.addActionListener(new gsAL());
	JMenuItem about = new JMenuItem("About");
	about.setMnemonic(KeyEvent.VK_A);
	about.addActionListener(new aboutAL());
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

    static class mmAL implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    
	}
    }

   static class quitAL implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    System.exit(0);
	}
   }
    
    static class gsAL implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    
	}
    }
    
    static class aboutAL implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    
	}
    }
    
}