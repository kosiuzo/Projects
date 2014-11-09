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
public class TicTacToePlayer
{
	private String name;
	private PrintWriter out = null;
	public TicTacToePlayer()
	{
		name = "";
	}
	//sets the name
	public TicTacToePlayer(String inputName)
	{
		name = inputName;
	}

	public void openFile(String fileName)
	{
		try
		{
			out = new PrintWriter(new FileWriter(fileName));
		}
		catch (IndexOutOfBoundsException e) {
        System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());                      
    	} 
    	catch (IOException e) {
        System.err.println("Caught IOException: " +  e.getMessage());                        
    	}
    	catch(Exception e){
    		System.err.println("Caught Exception: " + e.getMessage());
    	}
	}

	//Writes to the gamelog
	public void record(String input)
	{
		out.println(input);
	}

	public void closeFile()
	{
		System.out.println("gameplay log was closed and save successfully ");
		out.close();
	}

	//returns a name
	public String getName()
	{
		return name;
	}
	
	//sets the name
	public void setName(String inputName)
	{
		name = inputName;
	}
	
	//returns a name
	public void displayName()
	{
		System.out.println(name);
	}
	
	//checks if the spot entered is available or not and probably the most important method
	public boolean checkAvailable(int space)
	{
		JLabel[][] tempArray = TicTacToePanel.gameArray;
		switch(space)
		{
		
		case 1: if(tempArray[4][0].getIcon() == TicTacToePanel.open)
			return true;
			else
			return false;
		case 2: if(tempArray[4][2].getIcon() == TicTacToePanel.open)
			return true;
			else
			return false;
		case 3: if(tempArray[4][4].getIcon() == TicTacToePanel.open)
			return true;
			else
			return false;
		case 4: if(tempArray[2][0].getIcon() == TicTacToePanel.open)
			return true;
			else
			return false;
		case 5: if(tempArray[2][2].getIcon() == TicTacToePanel.open)
			return true;
			else
			return false;
		case 6: if(tempArray[2][4].getIcon() == TicTacToePanel.open)
			return true;
			else
			return false;
		case 7: if(tempArray[0][0].getIcon() == TicTacToePanel.open)
			return true;
			else
			return false;
		case 8: if(tempArray[0][2].getIcon() == TicTacToePanel.open)
			return true;
			else
			return false;
		case 9: if(tempArray[0][4].getIcon() == TicTacToePanel.open)
			return true;
			else
			return false;
		default: 
			System.out.println("You have to enter 1-9");
			return false;
		}
		
	}
	
	//inserts the X into the space that is entered in
	public void insertX(int choice)
	{
		JLabel tempArray[][] = TicTacToePanel.gameArray;
		if(checkAvailable(choice))
		{
			switch(choice)
			{
			
			case 1: tempArray[4][0].setIcon(TicTacToePanel.xIcon);
					tempArray[4][0].repaint();
					TicTacToePanel.playerTurn.setText("Player 2");
					break;
			case 2: tempArray[4][2].setIcon(TicTacToePanel.xIcon);
					tempArray[4][2].repaint();
					TicTacToePanel.playerTurn.setText("Player 2");
					break;
			case 3: tempArray[4][4].setIcon(TicTacToePanel.xIcon);
					tempArray[4][4].repaint();
					TicTacToePanel.playerTurn.setText("Player 2");
					break;
			case 4: tempArray[2][0].setIcon(TicTacToePanel.xIcon);
					tempArray[2][0].repaint();
					TicTacToePanel.playerTurn.setText("Player 2");
					break;
			case 5:	tempArray[2][2].setIcon(TicTacToePanel.xIcon);
					tempArray[2][2].repaint();
					TicTacToePanel.playerTurn.setText("Player 2");
					break;
			case 6: tempArray[2][4].setIcon(TicTacToePanel.xIcon);
					tempArray[2][4].repaint();
					TicTacToePanel.playerTurn.setText("Player 2");
					break;
			case 7:	tempArray[0][0].setIcon(TicTacToePanel.xIcon);
					tempArray[0][0].repaint();
					TicTacToePanel.playerTurn.setText("Player 2");
					break;
			case 8: tempArray[0][2].setIcon(TicTacToePanel.xIcon);
					tempArray[0][2].repaint();
					TicTacToePanel.playerTurn.setText("Player 2");
					break;
			case 9: tempArray[0][4].setIcon(TicTacToePanel.xIcon);
					tempArray[0][4].repaint();
					TicTacToePanel.playerTurn.setText("Player 2");
					break;
			
		}
		
	}
		else
			System.out.println("That space is taken choose another one");
	}
	
	//inserts O in the space that is entered
	public void insertO(int choice)
	{
		JLabel tempArray[][] = TicTacToePanel.gameArray;
		if(checkAvailable(choice))
		{
			switch(choice)
			{
			
			case 1: tempArray[4][0].setIcon(TicTacToePanel.oIcon);
					tempArray[4][0].repaint();
					TicTacToePanel.playerTurn.setText("Player 1");
					break;
			case 2: tempArray[4][2].setIcon(TicTacToePanel.oIcon);
					tempArray[4][2].repaint();
					TicTacToePanel.playerTurn.setText("Player 1");
					break;
			case 3: tempArray[4][4].setIcon(TicTacToePanel.oIcon);
					tempArray[4][4].repaint();
					TicTacToePanel.playerTurn.setText("Player 1");
					break;
			case 4: tempArray[2][0].setIcon(TicTacToePanel.oIcon);
					tempArray[2][0].repaint();
					TicTacToePanel.playerTurn.setText("Player 1");
					break;
			case 5:	tempArray[2][2].setIcon(TicTacToePanel.oIcon);
					tempArray[2][2].repaint();
					TicTacToePanel.playerTurn.setText("Player 1");
					break;
			case 6: tempArray[2][4].setIcon(TicTacToePanel.oIcon);
					tempArray[2][4].repaint();
					TicTacToePanel.playerTurn.setText("Player 1");
					break;
			case 7:	tempArray[0][0].setIcon(TicTacToePanel.oIcon);
					tempArray[0][0].repaint();
					TicTacToePanel.playerTurn.setText("Player 1");
					break;
			case 8: tempArray[0][2].setIcon(TicTacToePanel.oIcon);
					tempArray[0][2].repaint();
					TicTacToePanel.playerTurn.setText("Player 1");
					break;
			case 9: tempArray[0][4].setIcon(TicTacToePanel.oIcon);
					tempArray[0][4].repaint();
					TicTacToePanel.playerTurn.setText("Player 1");
					break;
			
		}
		
	}
		else
			System.out.println("That space is taken choose another one");
	}

	public void reverseSpace(int space)
	{
		JLabel tempArray[][] = TicTacToePanel.gameArray;
		switch(space)
			{
			
			case 1: tempArray[4][0].setIcon(TicTacToePanel.open);
					tempArray[4][0].repaint();
					break;
			case 2: tempArray[4][2].setIcon(TicTacToePanel.open);
					tempArray[4][2].repaint();
					break;
			case 3: tempArray[4][4].setIcon(TicTacToePanel.open);
					tempArray[4][4].repaint();
					break;
			case 4: tempArray[2][0].setIcon(TicTacToePanel.open);
					tempArray[2][0].repaint();
					break;
			case 5:	tempArray[2][2].setIcon(TicTacToePanel.open);
					tempArray[2][2].repaint();
					break;
			case 6: tempArray[2][4].setIcon(TicTacToePanel.open);
					tempArray[2][4].repaint();
					break;
			case 7:	tempArray[0][0].setIcon(TicTacToePanel.open);
					tempArray[0][0].repaint();
					break;
			case 8: tempArray[0][2].setIcon(TicTacToePanel.open);
					tempArray[0][2].repaint();
					break;
			case 9: tempArray[0][4].setIcon(TicTacToePanel.open);
					tempArray[0][4].repaint();
					break;
			
		}

	}
}