import javax.swing.JPanel;
import javax.swing.*;
public class blackJackPanel extends JPanel 
{

public JLabel label = new JLabel("Black Jack Panel add customization as you would like ");

public blackJackPanel()
{

	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	add(label);
}

}