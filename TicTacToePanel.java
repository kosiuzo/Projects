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
import java.awt.Font;
public class TicTacToePanel extends JPanel 
{
	//public JLabel label = new JLabel("TicTacToe Panel add customization as you would like ");
	public static JLabel playerTurn, gameTitle, player1, player2;
	public static JLabel[][] gameArray = new JLabel[5][5];
	public static ImageIcon icon = new ImageIcon("Images/java.png");
	public static ImageIcon xIcon = new ImageIcon("Images/X.png");
	public static ImageIcon oIcon = new ImageIcon("Images/O.png");
	public static ImageIcon open = new ImageIcon("Images/open.png");
	public static boolean computer;
	public static CutThroatComputerPlayer comp;
	private static JPanel gameBoard, innerBoard1, innerBoard2, innerBoard3, innerBoard4, innerBoard5;
	//private JLabel test;
	public TicTacToePanel()
	{
		Font font = new Font("Jokerman", Font.PLAIN, 35);
		player1 = new JLabel("Player 1");
		player1.setFont(font);
		player1.setAlignmentX(Component.LEFT_ALIGNMENT);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		makeBoard();
		//Adding all the panels 
		add(player1);
		gameBoard.add(innerBoard1);
		gameBoard.add(innerBoard2);
		gameBoard.add(innerBoard3);
		gameBoard.add(innerBoard4);
		gameBoard.add(innerBoard5);
		add(gameBoard);
		comp = new CutThroatComputerPlayer();
		computer = true;
	}

	public static class MListener implements MouseListener
 	{
	
	public void mouseClicked(MouseEvent event)
	{
		Object source = event.getSource();
		if(source == gameArray[0][0])
		{
			if( (gameArray[0][0].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			gameArray[0][0].setIcon(xIcon);
			gameArray[0][0].repaint();

			playerTurn.setText("Player 2");
			//control = true;
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
			}
			if(checkCat())
			{
				System.out.println("It was a cat");
			}
			if(computer)
			{
				System.out.println("Testing");
				if(comp.win(oIcon)!=0)
				{
					comp.insertO(comp.win(oIcon));
				}
				else if(comp.block(xIcon)!=0)
				{
					comp.insertO(comp.block(xIcon));
				}
				else if(comp.fork(oIcon) !=0)
				{
				comp.insertO(comp.fork(oIcon));
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				comp.insertO(comp.blockOpponentFork(xIcon));
				}
				else if(comp.center() !=0)
				{
				comp.insertO(comp.center());
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				comp.insertO(comp.oppositeCorner(xIcon));
				}
				else if(comp.emptyCorner() !=0)
										{
				comp.insertO(comp.emptyCorner());
				}
				else if(comp.emptySide() !=0)
										{
				comp.insertO(comp.emptySide());
				}
			}
			}
			else if( (gameArray[0][0].getIcon() == open) && (playerTurn.getText().equals("Player 2") && !computer ))
			{
				gameArray[0][0].setIcon(oIcon);
				gameArray[0][0].repaint();
				playerTurn.setText("Player 1");
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				}
				if(checkCat())
				{
				System.out.println("It was a cat");
				}
				
			}

		}	
		else if(source == gameArray[0][2])
		{
			if( (gameArray[0][2].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			gameArray[0][2].setIcon(xIcon);
			gameArray[0][2].repaint();
			playerTurn.setText("Player 2");
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
			}
			if(checkCat())
			{
				System.out.println("It was a cat");
			}
			if(computer)
			{
				System.out.println("Testing");
				if(comp.win(oIcon)!=0)
				{
					comp.insertO(comp.win(oIcon));
				}
				else if(comp.block(xIcon)!=0)
				{
					comp.insertO(comp.block(xIcon));
				}
				else if(comp.fork(oIcon) !=0)
				{
				comp.insertO(comp.fork(oIcon));
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				comp.insertO(comp.blockOpponentFork(xIcon));
				}
				else if(comp.center() !=0)
				{
				comp.insertO(comp.center());
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				comp.insertO(comp.oppositeCorner(xIcon));
				}
				else if(comp.emptyCorner() !=0)
										{
				comp.insertO(comp.emptyCorner());
				}
				else if(comp.emptySide() !=0)
										{
				comp.insertO(comp.emptySide());
				}
			}
			}
			else if( (gameArray[0][2].getIcon() == open) && (playerTurn.getText().equals("Player 2") ))
			{
				gameArray[0][2].setIcon(oIcon);
				gameArray[0][2].repaint();
				playerTurn.setText("Player 1");
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				}
				if(checkCat())
				{
				System.out.println("It was a cat");
				}
			}
		}
		else if(source == gameArray[0][4])
		{
			if( (gameArray[0][4].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			gameArray[0][4].setIcon(xIcon);
			gameArray[0][4].repaint();
			//control = true;
			playerTurn.setText("Player 2");
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
			}
			if(checkCat())
			{
				System.out.println("It was a cat");
			}
			if(computer)
			{
				System.out.println("Testing");
				if(comp.win(oIcon)!=0)
				{
					comp.insertO(comp.win(oIcon));
				}
				else if(comp.block(xIcon)!=0)
				{
					comp.insertO(comp.block(xIcon));
				}
				else if(comp.fork(oIcon) !=0)
				{
				comp.insertO(comp.fork(oIcon));
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				comp.insertO(comp.blockOpponentFork(xIcon));
				}
				else if(comp.center() !=0)
				{
				comp.insertO(comp.center());
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				comp.insertO(comp.oppositeCorner(xIcon));
				}
				else if(comp.emptyCorner() !=0)
										{
				comp.insertO(comp.emptyCorner());
				}
				else if(comp.emptySide() !=0)
										{
				comp.insertO(comp.emptySide());
				}
			}
			}
			else if( (gameArray[0][4].getIcon() == open) && (playerTurn.getText().equals("Player 2") ))
			{
				gameArray[0][4].setIcon(oIcon);
				gameArray[0][4].repaint();
				playerTurn.setText("Player 1");
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				}
				if(checkCat())
				{
				System.out.println("It was a cat");
				}
			}
		}
		else if(source == gameArray[2][0])
		{
			if( (gameArray[2][0].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			gameArray[2][0].setIcon(xIcon);
			gameArray[2][0].repaint();
			playerTurn.setText("Player 2");
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
			}
			if(checkCat())
			{
				System.out.println("It was a cat");
			}
			if(computer)
			{
				System.out.println("Testing");
				if(comp.win(oIcon)!=0)
				{
					comp.insertO(comp.win(oIcon));
				}
				else if(comp.block(xIcon)!=0)
				{
					comp.insertO(comp.block(xIcon));
				}
				else if(comp.fork(oIcon) !=0)
				{
				comp.insertO(comp.fork(oIcon));
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				comp.insertO(comp.blockOpponentFork(xIcon));
				}
				else if(comp.center() !=0)
				{
				comp.insertO(comp.center());
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				comp.insertO(comp.oppositeCorner(xIcon));
				}
				else if(comp.emptyCorner() !=0)
										{
				comp.insertO(comp.emptyCorner());
				}
				else if(comp.emptySide() !=0)
										{
				comp.insertO(comp.emptySide());
				}
			}
			}
			else if( (gameArray[2][0].getIcon() == open) && (playerTurn.getText().equals("Player 2") ))
			{
				gameArray[2][0].setIcon(oIcon);
				gameArray[2][0].repaint();
				playerTurn.setText("Player 1");
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				}
				if(checkCat())
				{
				System.out.println("It was a cat");
				}
			}
		}
		else if(source == gameArray[2][2])
		{
			if( (gameArray[2][2].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			gameArray[2][2].setIcon(xIcon);
			gameArray[2][2].repaint();
			playerTurn.setText("Player 2");
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
			}
			if(checkCat())
			{
				System.out.println("It was a cat");
			}
			if(computer)
			{
				System.out.println("Testing");
				if(comp.win(oIcon)!=0)
				{
					comp.insertO(comp.win(oIcon));
				}
				else if(comp.block(xIcon)!=0)
				{
					comp.insertO(comp.block(xIcon));
				}
				else if(comp.fork(oIcon) !=0)
				{
				comp.insertO(comp.fork(oIcon));
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				comp.insertO(comp.blockOpponentFork(xIcon));
				}
				else if(comp.center() !=0)
				{
				comp.insertO(comp.center());
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				comp.insertO(comp.oppositeCorner(xIcon));
				}
				else if(comp.emptyCorner() !=0)
										{
				comp.insertO(comp.emptyCorner());
				}
				else if(comp.emptySide() !=0)
										{
				comp.insertO(comp.emptySide());
				}
			}
			}
			else if( (gameArray[2][2].getIcon() == open) && (playerTurn.getText().equals("Player 2") ))
			{
				gameArray[2][2].setIcon(oIcon);
				gameArray[2][2].repaint();
				playerTurn.setText("Player 1");
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				}
				if(checkCat())
				{
				System.out.println("It was a cat");
				}
				// if(computer)
				// {
				// System.out.println("Testing");
				// int space = comp.firstAvailableSpace();
				// comp.insertO(space);
				// }
			}
		}
		else if(source == gameArray[2][4])
		{
			if( (gameArray[2][4].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			gameArray[2][4].setIcon(xIcon);
			gameArray[2][4].repaint();
			playerTurn.setText("Player 2");
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
			}
			if(checkCat())
			{
				System.out.println("It was a cat");
			}
			if(computer)
			{
				System.out.println("Testing");
				if(comp.win(oIcon)!=0)
				{
					comp.insertO(comp.win(oIcon));
				}
				else if(comp.block(xIcon)!=0)
				{
					comp.insertO(comp.block(xIcon));
				}
				else if(comp.fork(oIcon) !=0)
				{
				comp.insertO(comp.fork(oIcon));
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				comp.insertO(comp.blockOpponentFork(xIcon));
				}
				else if(comp.center() !=0)
				{
				comp.insertO(comp.center());
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				comp.insertO(comp.oppositeCorner(xIcon));
				}
				else if(comp.emptyCorner() !=0)
										{
				comp.insertO(comp.emptyCorner());
				}
				else if(comp.emptySide() !=0)
										{
				comp.insertO(comp.emptySide());
				}
			}
			}
			else if( (gameArray[2][4].getIcon() == open) && (playerTurn.getText().equals("Player 2") ))
			{
				gameArray[2][4].setIcon(oIcon);
				gameArray[2][4].repaint();
				playerTurn.setText("Player 1");
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				}
				if(checkCat())
				{
				System.out.println("It was a cat");
				}
			}
		}
		else if(source == gameArray[4][0])
		{
			if( (gameArray[4][0].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			gameArray[4][0].setIcon(xIcon);
			gameArray[4][0].repaint();
			playerTurn.setText("Player 2");
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
			}
			if(checkCat())
			{
				System.out.println("It was a cat");
			}
			if(computer)
			{
				System.out.println("Testing");
				if(comp.win(oIcon)!=0)
				{
					comp.insertO(comp.win(oIcon));
				}
				else if(comp.block(xIcon)!=0)
				{
					comp.insertO(comp.block(xIcon));
				}
				else if(comp.fork(oIcon) !=0)
				{
				comp.insertO(comp.fork(oIcon));
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				comp.insertO(comp.blockOpponentFork(xIcon));
				}
				else if(comp.center() !=0)
				{
				comp.insertO(comp.center());
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				comp.insertO(comp.oppositeCorner(xIcon));
				}
				else if(comp.emptyCorner() !=0)
										{
				comp.insertO(comp.emptyCorner());
				}
				else if(comp.emptySide() !=0)
										{
				comp.insertO(comp.emptySide());
				}
			}
			}
			else if( (gameArray[4][0].getIcon() == open) && (playerTurn.getText().equals("Player 2") ))
			{
				gameArray[4][0].setIcon(oIcon);
				gameArray[4][0].repaint();
				playerTurn.setText("Player 1");
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				}
				if(checkCat())
				{
				System.out.println("It was a cat");
				}
			}
		}
		else if(source == gameArray[4][2])
		{
			if( (gameArray[4][2].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			gameArray[4][2].setIcon(xIcon);
			gameArray[4][2].repaint();
			playerTurn.setText("Player 2");
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
			}
			if(checkCat())
			{
				System.out.println("It was a cat");
			}
			if(computer)
			{
				System.out.println("Testing");
				if(comp.win(oIcon)!=0)
				{
					comp.insertO(comp.win(oIcon));
				}
				else if(comp.block(xIcon)!=0)
				{
					comp.insertO(comp.block(xIcon));
				}
				else if(comp.fork(oIcon) !=0)
				{
				comp.insertO(comp.fork(oIcon));
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				comp.insertO(comp.blockOpponentFork(xIcon));
				}
				else if(comp.center() !=0)
				{
				comp.insertO(comp.center());
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				comp.insertO(comp.oppositeCorner(xIcon));
				}
				else if(comp.emptyCorner() !=0)
										{
				comp.insertO(comp.emptyCorner());
				}
				else if(comp.emptySide() !=0)
										{
				comp.insertO(comp.emptySide());
				}
			}
			}
			else if( (gameArray[4][2].getIcon() == open) && (playerTurn.getText().equals("Player 2") ))
			{
				gameArray[4][2].setIcon(oIcon);
				gameArray[4][2].repaint();
				playerTurn.setText("Player 1");
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				}
				if(checkCat())
				{
				System.out.println("It was a cat");
				}
			}
		}
		else if(source == gameArray[4][4])
		{
			if( (gameArray[4][4].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			gameArray[4][4].setIcon(xIcon);
			gameArray[4][4].repaint();
			playerTurn.setText("Player 2");
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
			}
			if(checkCat())
			{
				System.out.println("It was a cat");
			}
			if(computer)
			{
				System.out.println("Testing");
				if(comp.win(oIcon)!=0)
				{
					comp.insertO(comp.win(oIcon));
				}
				else if(comp.block(xIcon)!=0)
				{
					comp.insertO(comp.block(xIcon));
				}
				else if(comp.fork(oIcon) !=0)
				{
				comp.insertO(comp.fork(oIcon));
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				comp.insertO(comp.blockOpponentFork(xIcon));
				}
				else if(comp.center() !=0)
				{
				comp.insertO(comp.center());
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				comp.insertO(comp.oppositeCorner(xIcon));
				}
				else if(comp.emptyCorner() !=0)
										{
				comp.insertO(comp.emptyCorner());
				}
				else if(comp.emptySide() !=0)
										{
				comp.insertO(comp.emptySide());
				}
			}
			}
			else if( (gameArray[4][4].getIcon() == open) && (playerTurn.getText().equals("Player 2") ))
			{
				gameArray[4][4].setIcon(oIcon);
				gameArray[4][4].repaint();
				playerTurn.setText("Player 1");
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				}
				if(checkCat())
				{
				System.out.println("It was a cat");
				}
			}
		}

	 
  	}

  	public void mouseEntered(MouseEvent event)
  	{

  	}

  	public void mouseExited(MouseEvent event)
  	{

  	}

  	public void mouseReleased(MouseEvent event)
  	{

  	}

  	public void mousePressed(MouseEvent event)
  	{

  	}

  }

  public static void makeBoard()
  {
  	playerTurn = new JLabel("Player 1");
  	//Creating listener for Labels
  	MListener listener = new MListener();
  	//Setting Layouts, Dimension, Preference
	gameBoard = new JPanel();
	gameBoard.setLayout(new BoxLayout(gameBoard, BoxLayout.Y_AXIS));
	gameBoard.setAlignmentX(Component.CENTER_ALIGNMENT);
	gameBoard.setPreferredSize(new Dimension(500,500));
	innerBoard1 = new JPanel();
	innerBoard1.setLayout(new BoxLayout(innerBoard1, BoxLayout.X_AXIS));
	innerBoard1.setPreferredSize(new Dimension(100,100));
	innerBoard2 = new JPanel();
	innerBoard2.setLayout(new BoxLayout(innerBoard2, BoxLayout.X_AXIS));
	innerBoard2.setPreferredSize(new Dimension(100,100));
	innerBoard3 = new JPanel();
	innerBoard3.setLayout(new BoxLayout(innerBoard3, BoxLayout.X_AXIS));
	innerBoard3.setPreferredSize(new Dimension(100,100));
	innerBoard4 = new JPanel();
	innerBoard4.setLayout(new BoxLayout(innerBoard4, BoxLayout.X_AXIS));
	innerBoard4.setPreferredSize(new Dimension(100,100));
	innerBoard5 = new JPanel();
	innerBoard5.setLayout(new BoxLayout(innerBoard5, BoxLayout.X_AXIS));
	innerBoard5.setPreferredSize(new Dimension(100,100));



	gameArray = new JLabel[5][5];
	//Puts all the empty spaces to open lock sign
	for (int i=0; i< gameArray.length;i+=2 )
	{
		for (int j = 0; j < gameArray[0].length; j+=2)
		{
			
			gameArray[i][j] = new JLabel(open);
			
		}
		
	}
	//Put the bars in every other line
	for (int i=1; i< gameArray.length;i+=2 )
	{
		for (int j = 0; j < gameArray[0].length; j++)
		{
			
			gameArray[i][j] = new JLabel(icon);
			
		}
		
	}
	//Skips two lines because the lines only go in the middle
	for (int i=0; i< gameArray.length;i+=2 )
	{
		for (int j = 1; j < gameArray[0].length; j+=2)
		{
			
			gameArray[i][j] = new JLabel(icon);
			
		}
		
	}
	//Puts all the elements in
	for (int i=0; i< gameArray.length;i++ )
	{
		for (int j = 0; j < gameArray[0].length; j++)
		{
			gameArray[i][j].addMouseListener(listener);
			
		}
		
	}
	//Puts the labels in the panels individually
	for (int i = 0; i<gameArray.length; i++)
	{
		for (int j = 0; j<gameArray[0].length; j++)
		{
			if(i ==0)
			{
				innerBoard1.add(gameArray[i][j]);
			}
			else if(i==1)
			{
				innerBoard2.add(gameArray[i][j]);
			}
			else if(i==2)
			{
				innerBoard3.add(gameArray[i][j]);
			}
			else if(i==3)
			{
				innerBoard4.add(gameArray[i][j]);
			}
			else if(i==4)
			{
				innerBoard5.add(gameArray[i][j]);
			}

		}
	}
	
	
	
  }

  public static void reset()
  {
  	//Puts all the empty spaces to open lock sign
	for (int i=0; i< gameArray.length;i+=2 )
	{
		for (int j = 0; j < gameArray[0].length; j+=2)
		{
			
			gameArray[i][j].setIcon(open);
			gameArray[i][j].repaint();
			
		}
		
	}
	//Put the bars in every other line
	for (int i=1; i< gameArray.length;i+=2 )
	{
		for (int j = 0; j < gameArray[0].length; j++)
		{
			
			gameArray[i][j].setIcon(icon);
			gameArray[i][j].repaint();
			
		}
		
	}
	//Skips two lines because the lines only go in the middle
	for (int i=0; i< gameArray.length;i+=2 )
	{
		for (int j = 1; j < gameArray[0].length; j+=2)
		{
			
			gameArray[i][j].setIcon(icon);
			gameArray[i][j].repaint();
		}
		
	}
	
	
  }
  	//Checks to see if either player won
	public static boolean checkWin(ImageIcon symbol)
	{
		if ((gameArray[0][0].getIcon() == symbol) && (gameArray[0][0].getIcon() == gameArray[0][2].getIcon()) && (gameArray[0][2].getIcon() == gameArray[0][4].getIcon()))
			return true;
		else if ((gameArray[2][0].getIcon() == symbol) && (gameArray[2][0].getIcon() == gameArray[2][2].getIcon()) && (gameArray[2][2].getIcon() == gameArray[2][4].getIcon()))
			return true;
		else if ((gameArray[4][0].getIcon() == symbol) && (gameArray[4][0].getIcon() == gameArray[4][2].getIcon()) && (gameArray[4][2].getIcon() == gameArray[4][4].getIcon()))
			return true;
		else if ((gameArray[0][0].getIcon() == symbol) && (gameArray[0][0].getIcon() == gameArray[2][0].getIcon()) && (gameArray[2][0].getIcon() == gameArray[4][0].getIcon()))
			return true;
		else if ((gameArray[0][2].getIcon() == symbol) && (gameArray[0][2].getIcon() == gameArray[2][2].getIcon()) && (gameArray[2][2].getIcon() == gameArray[4][2].getIcon()))
			return true;
		else if ((gameArray[0][4].getIcon() == symbol) && (gameArray[0][4].getIcon() == gameArray[2][4].getIcon()) && (gameArray[2][4].getIcon() == gameArray[4][4].getIcon()))
			return true;
		else if ((gameArray[0][0].getIcon() == symbol) && (gameArray[0][0].getIcon() == gameArray[2][2].getIcon()) && (gameArray[2][2].getIcon() == gameArray[4][4].getIcon()))
			return true;
		else if ((gameArray[0][4].getIcon() == symbol) && (gameArray[0][4].getIcon() == gameArray[2][2].getIcon()) && (gameArray[2][2].getIcon() == gameArray[4][0].getIcon()))
			return true;
		else
			return false;
		
	}

	//checks if it is a tie 
	public static boolean checkCat()
	{
		for (int i =0; i< gameArray.length;i+=2 )
		{
			for (int j =0; j< gameArray[0].length; j+=2)
			{
				if (gameArray[i][j].getIcon() == open)
					return false;
			}
		}
		
		return true;
	}


}