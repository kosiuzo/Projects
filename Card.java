import java.util.*;
import javax.swing.*;
import java.awt.*;
public class Card {
private static Stack<JLabel> deck = new Stack<JLabel>();

public Stack<JLabel> makeDeck()
{
	for(int i = 0; i<53; i++)
	{
		ImageIcon image = new ImageIcon("class-card/"+i);
		JLabel label = new JLabel(image);
		deck.push(label);
	}
	return deck;
}



}