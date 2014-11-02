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

public class ArcadeGUI extends JPanel {

    public JLabel ttt;
    public JLabel bljk;
    
    public ArcadeGUI () {
	
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	//BufferedImage tttImg = ImageIO.read(new File("tttImg.png");
	//ttt = new JButton(new ImageIcon(tttImg));

	//BufferedImage bljkImg = ImageIO.read(new File("bljkImg.png");
	//bljk = new JButton(new ImageIcon(bljkImg));

    }
    
    static class tttAL implements ActionListener {
	public void actionPerformed(.....)
    }

}