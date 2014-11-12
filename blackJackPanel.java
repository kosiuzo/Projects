import javax.swing.*;

import java.util.Scanner;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class blackJackPanel extends JPanel 
{

public JButton split, stand, hit, history, playAgain;
public static JPanel buttonPanel, computerPanel, userPanel;
    public static JLabel gameTitle, dHand, pHand, winnerTitle, whoWon, playerTurn;
public static int compHand, userHand, splitHand, shoeValue, wins, losses, games;
public static Shoe gameDeck;
public SingleCard firstCardUser,secondCardUser, firstCardComp, secondCardComp;
public ImageIcon hide = new ImageIcon("classic-cards/b1fv.png");
public ImageIcon title = new ImageIcon("Images/bjTitle.png");
public ImageIcon dH = new ImageIcon("Images/dHand.png");
    public ImageIcon pH = new ImageIcon("Images/pHand.png");
    public JLabel hideCard = new JLabel(hide);
public String userStr,compStr, userCards, compCards;
public GameLogging log = new GameLogging();
public Scanner inputStream;
private final static String newline = "\n";


public blackJackPanel()
{
	//logging information
	log.eraseFile("gameplay.txt");
	log.openFile("gameplay.txt");
	compStr=userStr=userCards=compCards="";
	
	//Setting button Panel
	buttonPanel = new JPanel();
	buttonPanel.setBackground(Color.GREEN);
	
	//Setting background of panel
	setBackground(Color.GREEN);
	
	//Setting all the beginning values to zero
	games=wins=losses=compHand=userHand=splitHand=0;
	
	//Setting the turn
	playerTurn = new JLabel("User");
	
	//Setting Layout of the game
	setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	
	//Making the deck
	gameDeck = new Shoe();
	gameDeck.makeShoe(shoeValue);
	
	
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
	
	//Adding title to top of panel
	gameTitle = new JLabel(title);
	gameTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
	add(gameTitle);
	
	dHand = new JLabel(dH);
	dHand.setAlignmentX(Component.CENTER_ALIGNMENT);
	add(dHand);
	
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
	
	pHand = new JLabel(pH);
	pHand.setAlignmentX(Component.CENTER_ALIGNMENT);
	add(pHand);
	
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
	
	//Printing out value of the hands and names of Card
	userStr = new String("First: "+ firstCardUser.name + "\tSecond: " + secondCardUser.name);
	compStr = new String("First: "+ firstCardComp.name + "\tSecond: " + secondCardComp.name);
	System.out.println("User's Hand: \t\t" + userStr);
	System.out.println("Computer's Hand: \t" + compStr);
	System.out.println("Users Hand "+ userHand);
	System.out.println("Computers Hand "+ compHand);
	
	//Variables for logging
	userCards+= "User Cards: " +  firstCardUser.name + ", " + secondCardUser.name;
	compCards+= "Computer Cards: " +  firstCardComp.name + ", " + secondCardComp.name;
	


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
				userCards += ", " + temp.name;
				userPanel.add(space);
				userPanel.add(secondCardUser);
				SingleCard temp2 = gameDeck.getNextCard();
				userPanel.add(temp2);
				splitHand +=temp2.value;
				userCards += ", " + temp2.name;
				userPanel.validate();
				userPanel.repaint();
				validate();
				repaint();
				if(userHand<compHand && splitHand<compHand)
				{
					winnerTitle.setText("YOU LOST BOTH HANDS");
					System.out.println("Users Hand "+ userHand);
					System.out.println("Computers Hand "+ compHand);
					losses++;
					games++;
					String logger = new String("Game " + games + "\n" + userCards + "\n" + compCards + "\n" + winnerTitle.getText()+"\n");
					log.record(logger);
					log.saveFile();
				}
				else if(userHand>compHand && splitHand>compHand)
				{
					winnerTitle.setText("YOU WON BOTH HANDS");
					System.out.println("Users Hand "+ userHand);
					System.out.println("Computers Hand "+ compHand);
					wins++;
					games++;
					String logger = new String("Game " + games + "\n" + userCards + "\n" + compCards + "\n" + winnerTitle.getText()+"\n");
					log.record(logger);
					log.saveFile();
				}
				else if(userHand>compHand)
				{
					winnerTitle.setText("YOUR FIRST HAND WON");
					System.out.println("Users Hand "+ userHand);
					System.out.println("Computers Hand "+ compHand);
					wins++;
					games++;
					String logger = new String("Game " + games + "\n" + userCards + "\n" + compCards + "\n" + winnerTitle.getText()+"\n");
					log.record(logger);
					log.saveFile();
				}
				else if(splitHand>compHand)
				{
					winnerTitle.setText("YOUR SECOND HAND WON");
					System.out.println("Users Hand "+ userHand);
					System.out.println("Computers Hand "+ compHand);
					wins++;
					games++;
					String logger = new String("Game " + games + "\n" + userCards + "\n" + compCards + "\n" + winnerTitle.getText()+"\n");
					log.record(logger);
					log.saveFile();
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
				compCards += ", " + temp.name;
				computerPanel.add(temp);
				validate();
				repaint();
				System.out.println("Users Hand "+ userHand);
				System.out.println("Computers Hand "+ compHand);
			}
			if(compHand == 21)
			{
				winnerTitle.setText("DEALER WINS");
				System.out.println("Users Hand "+ userHand);
				System.out.println("Computers Hand "+ compHand);
				losses++;
				games++;
				String logger = new String("Game " + games + "\n" + userCards + "\n" + compCards + "\n" + winnerTitle.getText()+"\n");
				log.record(logger);
				log.saveFile();
			}
			if(compHand>21)
			{
				winnerTitle.setText("YOU WON");
				System.out.println("Users Hand "+ userHand);
				System.out.println("Computers Hand "+ compHand);
				wins++;
				games++;
				String logger = new String("Game " + games + "\n" + userCards + "\n" + compCards + "\n" + winnerTitle.getText()+"\n");
				log.record(logger);
				log.saveFile();
				System.out.println(logger);
			}
			if(compHand<21 && compHand>userHand)
			{
				winnerTitle.setText("DEALER WINS");
				System.out.println("Users Hand "+ userHand);
				System.out.println("Computers Hand "+ compHand);
				losses++;
				games++;
				String logger = new String("Game " + games + "\n" + userCards + "\n" + compCards + "\n" + winnerTitle.getText()+"\n");
				log.record(logger);
				log.saveFile();
				System.out.println(logger);
			}
			if(compHand<21 && compHand<userHand)
			{
				winnerTitle.setText("You WINS");
				System.out.println("Users Hand "+ userHand);
				System.out.println("Computers Hand "+ compHand);
				losses++;
				games++;
				String logger = new String("Game " + games + "\n" + userCards + "\n" + compCards + "\n" + winnerTitle.getText()+"\n");
				log.record(logger);
				log.saveFile();
				System.out.println(logger);
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
				userCards += ", " + temp.name;
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
					System.out.println("Users Hand "+ userHand);
					System.out.println("Computers Hand "+ compHand);
					losses ++;
					games++;
					String logger = new String("Game " + games + "\n" + userCards + "\n" + compCards + "\n" + winnerTitle.getText()+"\n");
					log.record(logger);
					log.saveFile();
					System.out.println(logger);
				}
				if(userHand == 21)
				{
					
					winnerTitle.setText("YOU WON");
					hideCard.setVisible(false);
					secondCardComp.setVisible(true);
					System.out.println("Users Hand "+ userHand);
					System.out.println("Computers Hand "+ compHand);
					wins++;
					games++;
					String logger = new String("Game " + games + "\n" + userCards + "\n" + compCards + " \n" + winnerTitle.getText()+"\n");
					log.record(logger);
					log.saveFile();
					System.out.println(logger);
				}
				
				
			}
		}
		else if(source == history)
		{
			String fileName = "gameplay.txt";
			Font font = new Font("FixedSys", Font.PLAIN, 15);
			JTextArea info2 = new JTextArea(100,100);
			JScrollPane scrollPane = new JScrollPane(info2);
			scrollPane.setVerticalScrollBarPolicy(
	                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			info2.setEditable(false);
			System.out.println("History Button was pressed");
			try{
			
			inputStream = new Scanner(new File(fileName));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Error opening the file "+ fileName );
			}
			String display = new String("");
			JFrame leaderFrame = new JFrame("GamePlay History");
			JPanel leaderPanel = new JPanel();
			leaderPanel.setLayout(new BoxLayout(leaderPanel,BoxLayout.Y_AXIS ));
			leaderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			leaderFrame.setPreferredSize(new Dimension(600,700));
			leaderFrame.setBackground(Color.black);
			while(inputStream.hasNextLine())
			{
				display = inputStream.nextLine();
				info2.append(display+newline);
			}
			String leaderBoard = "Your Wins: " + wins + " \n " + "Your Losses: " + losses;
			JLabel info1 = new JLabel(leaderBoard);
			info1.setFont(font);
			//info2.setFont(font);
			leaderPanel.add(info1);
			leaderPanel.add(scrollPane);
			leaderFrame.setContentPane(leaderPanel);
			leaderFrame.validate();
			leaderFrame.pack();
			leaderFrame.setVisible(true);
			
			
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
	//Logging file
	log.openFile("gameplay.txt");
	
	//Setting winnerTitle to original state
	winnerTitle.setText("");
	
	//Making the deck
	gameDeck = new Shoe();
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
	userPanel.validate();
	userPanel.repaint();
	computerPanel.validate();
	computerPanel.repaint();
		
	//Reseting the panel
	validate();
	repaint();
	
	//Printing out value of the hands and names of Card
	userStr = new String("First: "+ firstCardUser.name + "\tSecond: " + secondCardUser.name);
	compStr = new String("First: "+ firstCardComp.name + "\tSecond: " + secondCardComp.name);
	System.out.println("User's Hand: \t\t" + userStr);
	System.out.println("Computer's Hand: \t" + compStr);
	System.out.println("Users Hand "+ userHand);
	System.out.println("Computers Hand "+ compHand);
		
		
}



}