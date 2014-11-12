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
import java.io.PrintWriter;
import java.io.*;
import java.io.Writer;
public class SingleCard extends JLabel {
public int value;
public String name;
public SingleCard(Icon image)
{
	super(image);
}

public int getValue()
{
	return this.value;
}

public String getName()
{
	return this.name;
}

}
