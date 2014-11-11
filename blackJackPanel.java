import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class blackJackPanel extends JPanel 
{
public JButton split, stand, hit, history, playAgain;
public static JPanel buttonPanel, computerPanel, userPanel;
public static JLabel winnerTitle, whoWon, playerTurn;
public static int compHand, userHand, splitHand, shoeValue, wins, losses;
public static Card gameDeck;
public SingleCard firstCardUser,secondCardUser, firstCardComp, secondCardComp;
public ImageIcon hide = new ImageIcon("classic-cards/b1fv.png");
public JLabel hideCard = new JLabel(hide);


public blackJackPanel()
{
	//Setting button Panel
	buttonPanel = new JPanel();
	
	
	//Setting background of panel
	setBackground(Color.BLACK);
	
	//Setting all the beginning values to zero
	wins=losses=compHand=userHand=splitHand=0;
	
	//Setting the turn
	playerTurn = new JLabel("User");
	
	//Setting Layout of the game
	setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	
	//Making the deck
	gameDeck = new Card();
	gameDeck.makeShoe(shoeValue);
	//gameDeck.make1DeckArray();
	//gameDeck.shuffleDeckArray();
	//gameDeck.makeDeckStack();
	
	
	//Setting the font to use for the panel
	Font font = new Font("FixedSys", Font.PLAIN, 30);
	
	//Creating listener for button
	ButtonListener listener = new ButtonListener();
	
	//Setting all the button to use in the Panel
	split = new JButton("Split");
	split.setFont(font);
	split.addActionListener(listener);
	stand = new JButton("Stand");
	stand.setFont(font);
	stand.addActionListener(listener);
	hit = new JButton("Hit");
	hit.setFont(font);
	hit.addActionListener(listener);
	history = new JButton("History");
	history.setFont(font);
	history.addActionListener(listener);
	playAgain = new JButton("Play Again");
	playAgain.setFont(font);
	playAgain.addActionListener(listener);
	
	buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
	//buttonPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
	buttonPanel.add(split);
	buttonPanel.add(stand);
	buttonPanel.add(hit);
	buttonPanel.add(history);
	buttonPanel.add(playAgain);
	//add(buttonPanel);
	
	//Making the panel for the computer
	computerPanel = new JPanel();
	computerPanel.setLayout(new BoxLayout(computerPanel, BoxLayout.X_AXIS));
	firstCardComp = gameDeck.getNextCard();
	compHand += firstCardComp.value;
	computerPanel.add(firstCardComp);
	secondCardComp = gameDeck.getNextCard();
	compHand += secondCardComp.value;
	computerPanel.add(secondCardComp);
	secondCardComp.setVisible(false);
	computerPanel.add(hideCard);
	
	add(computerPanel);
	
	//Making the panel for the user
	userPanel = new JPanel();
	userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.X_AXIS));
	firstCardUser = gameDeck.getNextCard();
	userHand += firstCardUser.value;
	userPanel.add(firstCardUser);
	secondCardUser = gameDeck.getNextCard();
	userHand += secondCardUser.value;
	userPanel.add(secondCardUser);
	add(userPanel);
	
	//Making title of who wins the game
	Font font2 = new Font("FixedSys", Font.PLAIN, 30);
	winnerTitle = new JLabel("");
	winnerTitle.setFont(font2);
	add(winnerTitle);
	
	//Adding button Panel
	add(buttonPanel);
	
	//Printing out value of the hands
	System.out.println("Users Hand "+ userHand);
	System.out.println("Computers Hand "+ compHand);
	


}

public class ButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent event)
	{
		
		Object source = event.getSource();
		if(source == split)
		{
			JLabel space = new JLabel(TicTacToePanel.horizontal);
			System.out.println("Split Button was pressed");
			if(firstCardUser.value == secondCardUser.value)
			{
				userHand -=firstCardUser.value;
				splitHand +=secondCardUser.value;
				userPanel.remove(secondCardUser);
				SingleCard temp = gameDeck.getNextCard();
				userPanel.add(temp);
				userHand +=temp.value;
				userPanel.add(space);
				userPanel.add(secondCardUser);
				SingleCard temp2 = gameDeck.getNextCard();
				userPanel.add(temp2);
				splitHand +=temp2.value;
				userPanel.validate();
				userPanel.repaint();
				validate();
				repaint();
				if(userHand<compHand && splitHand<compHand)
				{
					winnerTitle.setText("YOU LOSE BOTH HANDS");
					losses++;
				}
				else if(userHand>compHand && splitHand>compHand)
				{
					winnerTitle.setText("YOU WON BOTH HANDS");
					wins++;
				}
				else if(userHand>compHand)
				{
					winnerTitle.setText("YOUR FIRST HAND WON");
					wins++;
				}
				else if(splitHand>compHand)
				{
					winnerTitle.setText("YOUR SECOND HAND WON");
					wins++;
				}
				hideCard.setVisible(false);
				secondCardComp.setVisible(true);
				
			}
		}
		else if(source == stand)
		{
			System.out.println("Stand Button was pressed");
			hideCard.setVisible(false);
			secondCardComp.setVisible(true);
			while(compHand<17)
			{
				SingleCard temp = gameDeck.getNextCard();
				compHand +=temp.value;
				computerPanel.add(temp);
				validate();
				repaint();
				System.out.println("Computers Hand "+ compHand);
			}
			if(compHand == 21)
			{
				winnerTitle.setText("DEALER WINS");
				losses++;
			}
			if(compHand>21)
			{
				winnerTitle.setText("YOU WON");
				wins++;
			}
			if(compHand<21 && compHand>userHand)
			{
				winnerTitle.setText("DEALER WINS");
				losses++;
			}
			
		}
		else if(source == hit)
		{
			//Remove the ablity to split if you hit.
			System.out.println("Hit Button was pressed");
			if(playerTurn.getText() == "User")
			{
				if(userHand<21)
				{
				SingleCard temp = gameDeck.getNextCard();
				userHand += temp.value;
				userPanel.add(temp);
				validate();
				repaint();
				System.out.println("Users Hand "+ userHand);
				}
				if(userHand>21)
				{
					winnerTitle.setText("DEALER WINS");
					hideCard.setVisible(false);
					secondCardComp.setVisible(true);
					losses ++;
				}
				if(userHand == 21)
				{
					winnerTitle.setText("YOU WON");
					hideCard.setVisible(false);
					secondCardComp.setVisible(true);
					wins++;
				}
				
				
			}
		}
		else if(source == history)
		{
			System.out.println("History Button was pressed");
			String leaderBoard = "Your Wins: " + wins + "\n" + "Your Losses: " + losses;
			JOptionPane.showMessageDialog(null, leaderBoard, "LeaderBoard", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(source == playAgain)
		{
			System.out.println("PlayAgain Button was pressed");
			reset();
		}
		
	}
}// The end of the listener 

public void reset()
{
	
	//Setting winnerTitle to original state
	winnerTitle.setText("");
	
	//Making the deck
	gameDeck = new Card();
	gameDeck.makeShoe(shoeValue);
		
	//Setting all the beginning values to zero
	compHand=userHand=splitHand=0;
	
	//Resetting the turn
	playerTurn.setText("User");
	
	//Making the panel for the computer
	computerPanel.removeAll();
	SingleCard firstCardComp = gameDeck.getNextCard();
	compHand += firstCardComp.value;
	computerPanel.add(firstCardComp);
	SingleCard secondCardComp = gameDeck.getNextCard();
	compHand += secondCardComp.value;
	computerPanel.add(secondCardComp);
	secondCardComp.setVisible(false);
	computerPanel.add(hideCard);
	hideCard.setVisible(true);
	
		
	//Making the panel for the user
	userPanel.removeAll();
	firstCardUser = gameDeck.getNextCard();
	userHand += firstCardUser.value;
	userPanel.add(firstCardUser);
	secondCardUser = gameDeck.getNextCard();
	userHand += secondCardUser.value;
	userPanel.add(secondCardUser);
		
	//Reseting the panel
	validate();
	repaint();
		
		
}

}