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
import java.util.*;
public class TicTacToePanel extends JPanel 
{
	//public JLabel label = new JLabel("TicTacToe Panel add customization as you would like ");
	public static Stack<Integer> undoStack;
	public static int player1Wins,player2Wins,compWins;
	public static JLabel playerTurn, gameTitle, player1, player2, p1WinLabel, p2WinLabel,errorMessage, whoWon;
	public static JButton playAgain, undo;
	public static JLabel[][] gameArray = new JLabel[5][5];
	public static ImageIcon vertical = new ImageIcon("Images/vertical.png");
	public static ImageIcon horizontal = new ImageIcon("Images/horizontal.png");
	public static ImageIcon xIcon = new ImageIcon("Images/X.png");
	public static ImageIcon oIcon = new ImageIcon("Images/O.png");
	public static ImageIcon open = new ImageIcon("Images/open.png");
	public static boolean computer;
	public static CutThroatComputerPlayer comp;
	public static TicTacToePlayer controlReverse = new TicTacToePlayer();
	private static JPanel gameBoard, innerBoard1, innerBoard2, innerBoard3, innerBoard4, innerBoard5, titlePanel, player2Panel,gameTitlePanel, player1Panel;
	//private JLabel test;
	public TicTacToePanel()
	{
		whoWon = new JLabel("");
		undoStack = new Stack<Integer>();
		player1Wins=0;
		player2Wins=0;
		compWins=0;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(300,400));
		titlePanel.setLayout(new BoxLayout(titlePanel,BoxLayout.X_AXIS));
		Font font = new Font("Jokerman", Font.PLAIN, 35);
		
		//Error Message to display
		errorMessage = new JLabel("Choose another Space");
		errorMessage.setFont(font);
		errorMessage.setVisible(false);

		//Setting Player 1
		player1 = new JLabel("Player 1");
		p1WinLabel = new JLabel(player1Wins + ""+ " Wins");
		p1WinLabel.setFont(font);
		player1.setFont(font);
		player1Panel = new JPanel();
		//player1Panel.setPreferredSize(new Dimension(50,50));
		player1Panel.setLayout(new BoxLayout(player1Panel, BoxLayout.Y_AXIS));
		player1Panel.add(player1);
		player1Panel.add(p1WinLabel);
		player1Panel.setBackground(Color.RED);

		//Setting play again
		playAgain = new JButton("Play Again");
		playAgain.setVisible(false);
		playAgain.setFont(font);
		playAgain.addActionListener(new BListener());
		
		//Setting Game Title
		gameTitle = new JLabel("");
		gameTitle.setFont(font);
		gameTitlePanel = new JPanel();
		gameTitlePanel.setPreferredSize(new Dimension(50,50));
		gameTitlePanel.add(gameTitle);
		
		//Setting Player 2
		player2 = new JLabel("Player 2");
		p2WinLabel = new JLabel(player2Wins + "" + " Wins");
		p2WinLabel.setFont(font);
		player2.setFont(font);
		player2.addMouseListener(new MListener());
		player2Panel = new JPanel();
		player2Panel.setLayout(new BoxLayout(player2Panel, BoxLayout.Y_AXIS));
		player2Panel.add(player2);
		player2Panel.add(p2WinLabel);

		//Setting up undo button
		undo = new JButton("UNDO");
		undo.setFont(font);
		undo.addActionListener(new BListener());
		undo.setMnemonic(KeyEvent.VK_U);


		//Adding to the titlePanel
		titlePanel.add(player1Panel);
		//titlePanel.add(Box.createRigidArea(new Dimension(0,15)));
		titlePanel.add(gameTitlePanel);
		titlePanel.add(playAgain);
		titlePanel.add(Box.createRigidArea(new Dimension(0,15)));
		titlePanel.add(player2Panel);
		
		//Making the board and adding all panels associated with it
		makeBoard();
		//Adding all the panels 
		add(titlePanel);
		add(Box.createRigidArea(new Dimension(0,15)));
		add(gameTitle);
		gameBoard.add(innerBoard1);
		gameBoard.add(innerBoard2);
		gameBoard.add(innerBoard3);
		gameBoard.add(innerBoard4);
		gameBoard.add(innerBoard5);
		add(gameBoard);
		add(errorMessage);
		add(undo);
		comp = new CutThroatComputerPlayer();
		
	}

	public static class BListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object source = event.getSource();
			if(source == playAgain)
				reset();
			else if(source == undo)
			{
				if(!undoStack.isEmpty())
				{
					if(gameTitle.getText().equals("DRAW"))
					{
						gameTitle.setText("");

					}
					if(playAgain.isVisible())
					{
						playAgain.setVisible(false);
						gameTitle.setText("");
						if(whoWon.getText().equals("Player 1"))
						{
							player1Wins--;
							p1WinLabel.setText(player1Wins + ""+ " Wins");
						}
						else if(whoWon.getText().equals("Player 2"))
						{
							player2Wins--;
							p2WinLabel.setText(player2Wins + ""+ " Wins");
						}
						else if(whoWon.getText().equals("Computer"))
						{
							compWins--;
							p2WinLabel.setText(compWins + ""+ " Wins");
						}
					}
					System.out.println("Undo Stack Number"+undoStack.peek());
					int space = undoStack.pop();
					controlReverse.reverseSpace(space);
					if(TicTacToePanel.playerTurn.getText().equals("Player 1"))
					{
					if(TicTacToePanel.player2.getText().equals("Computer"))
					{
						System.out.println("Testing");
						System.out.println("Undo Stack Number"+undoStack.peek());
						controlReverse.reverseSpace(undoStack.pop());
						TicTacToePanel.playerTurn.setText("Player 1");
						player2Panel.setBackground(Color.white);
						player1Panel.setBackground(Color.RED);
					}
					if(TicTacToePanel.player2.getText().equals("Player 2"))
					{
					TicTacToePanel.playerTurn.setText("Player 2");
					player1Panel.setBackground(Color.white);
					player2Panel.setBackground(Color.RED);
					}
					}
					else if(TicTacToePanel.playerTurn.getText().equals("Player 2"))
					{
					TicTacToePanel.playerTurn.setText("Player 1");
					player2Panel.setBackground(Color.white);
					player1Panel.setBackground(Color.RED);
					}

				}
			}
		}
	}
	public static class MListener implements MouseListener
 	{
	
	public void mouseClicked(MouseEvent event)
	{
		Object source = event.getSource();
		if(source == player2)
		{
			if(player2.getText().equals("Player 2"))
			{
				player2.setText("Computer");
				p2WinLabel.setText(compWins + "" + " Wins");
				computer = true;
			}
			else if(player2.getText().equals("Computer"))
			{
				player2.setText("Player 2");
				p2WinLabel.setText(player2Wins + "" + " Wins");
				computer = false;
			}
		}
		if(source == gameArray[0][0])
		{
			if(gameArray[0][0].getIcon() == xIcon || gameArray[0][0].getIcon() == oIcon )
			{
				errorMessage.setVisible(true);
			}
			if( (gameArray[0][0].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			gameArray[0][0].setIcon(xIcon);
			gameArray[0][0].repaint();
			errorMessage.setVisible(false);
			undoStack.push(7);
			playerTurn.setText("Player 2");
			player2Panel.setBackground(Color.RED);
			player1Panel.setBackground(Color.white);
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
				player1Wins++;
				p1WinLabel.setText(player1Wins + ""+ " Wins");
				playAgain.setVisible(true);
				gameTitle.setText("Player 1 Wins");
				whoWon.setText("Player 1");

				
			}
			else if(checkCat())
			{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
			}
			if(computer)
			{
				if(comp.win(oIcon)!=0)
				{
					undoStack.push(comp.win(oIcon));
					comp.insertO(comp.win(oIcon));
					player1Panel.setBackground(Color.RED);
					player2Panel.setBackground(Color.white);
				}
				else if(comp.block(xIcon)!=0)
				{
					undoStack.push(comp.block(xIcon));
					comp.insertO(comp.block(xIcon));
					player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.fork(oIcon) !=0)
				{
				undoStack.push(comp.fork(oIcon));
				comp.insertO(comp.fork(oIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				undoStack.push(comp.blockOpponentFork(xIcon));
				comp.insertO(comp.blockOpponentFork(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.center() !=0)
				{
				undoStack.push(comp.center());
				comp.insertO(comp.center());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				undoStack.push(comp.oppositeCorner(xIcon));
				comp.insertO(comp.oppositeCorner(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptyCorner() !=0)
										{
				undoStack.push(comp.emptyCorner());
				comp.insertO(comp.emptyCorner());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptySide() !=0)
										{
				undoStack.push(comp.emptySide());
				comp.insertO(comp.emptySide());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				if(checkWin(oIcon))
				{
					System.out.println("Computer Won");
					gameTitle.setText("Computer Wins");
					whoWon.setText("Computer");
					compWins++;
					p2WinLabel.setText(compWins + "" + " Wins");
					playAgain.setVisible(true);
				}
				else if(checkCat())
				{
					gameTitle.setText("DRAW");
				}
			}
			}
			else if( (gameArray[0][0].getIcon() == open) && (playerTurn.getText().equals("Player 2") && !computer ))
			{
				gameArray[0][0].setIcon(oIcon);
				gameArray[0][0].repaint();
				errorMessage.setVisible(false);
				undoStack.push(7);
				playerTurn.setText("Player 1");
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				player2Wins++;
				p2WinLabel.setText(player2Wins + ""+ " Wins");
				playAgain.setVisible(true);
				gameTitle.setText("Player 2 Wins");
				whoWon.setText("Player 2")
				;
				}
				else if(checkCat())
				{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
				}
				
			}

		}	
		else if(source == gameArray[0][2])
		{
			if(gameArray[0][2].getIcon() == xIcon || gameArray[0][2].getIcon() == oIcon )
			{
				errorMessage.setVisible(true);
			}
			if( (gameArray[0][2].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			errorMessage.setVisible(false);
			gameArray[0][2].setIcon(xIcon);
			gameArray[0][2].repaint();
			undoStack.push(8);
			playerTurn.setText("Player 2");
			player2Panel.setBackground(Color.RED);
			player1Panel.setBackground(Color.white);
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
				player1Wins++;
				p1WinLabel.setText(player1Wins + ""+ " Wins");
				playAgain.setVisible(true);
				gameTitle.setText("Player 1 Wins");
				whoWon.setText("Player 1");
				
			}
			else if(checkCat())
			{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
			}
			if(computer)
			{
				if(comp.win(oIcon)!=0)
				{
					undoStack.push(comp.win(oIcon));
					comp.insertO(comp.win(oIcon));
					player1Panel.setBackground(Color.RED);
					player2Panel.setBackground(Color.white);
				}
				else if(comp.block(xIcon)!=0)
				{
					undoStack.push(comp.block(xIcon));
					comp.insertO(comp.block(xIcon));
					player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.fork(oIcon) !=0)
				{
				undoStack.push(comp.fork(oIcon));
				comp.insertO(comp.fork(oIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				undoStack.push(comp.blockOpponentFork(xIcon));
				comp.insertO(comp.blockOpponentFork(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.center() !=0)
				{
				undoStack.push(comp.center());
				comp.insertO(comp.center());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				undoStack.push(comp.oppositeCorner(xIcon));
				comp.insertO(comp.oppositeCorner(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptyCorner() !=0)
										{
				undoStack.push(comp.emptyCorner());
				comp.insertO(comp.emptyCorner());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptySide() !=0)
										{
				undoStack.push(comp.emptySide());
				comp.insertO(comp.emptySide());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				if(checkWin(oIcon))
				{
					System.out.println("Computer Won");
					gameTitle.setText("Computer Wins");
					whoWon.setText("Computer");
					compWins++;
					p2WinLabel.setText(compWins + "" + " Wins");
					playAgain.setVisible(true);
				}
				else if(checkCat())
				{
					gameTitle.setText("DRAW");
				}
			}
			}
			else if( (gameArray[0][2].getIcon() == open) && (playerTurn.getText().equals("Player 2") ))
			{
				gameArray[0][2].setIcon(oIcon);
				gameArray[0][2].repaint();
				undoStack.push(8);
				errorMessage.setVisible(false);
				playerTurn.setText("Player 1");
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				player2Wins++;
				p2WinLabel.setText(player2Wins + ""+ " Wins");
				playAgain.setVisible(true);
				
				gameTitle.setText("Player 2 Wins");
				whoWon.setText("Player 2")
				;
				}
				else if(checkCat())
				{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
				}
			}
		}
		else if(source == gameArray[0][4])
		{
			if(gameArray[0][4].getIcon() == xIcon || gameArray[0][4].getIcon() == oIcon )
			{
				errorMessage.setVisible(true);
			}
			if( (gameArray[0][4].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			gameArray[0][4].setIcon(xIcon);
			gameArray[0][4].repaint();
			undoStack.push(9);
			errorMessage.setVisible(false);
			//control = true;
			playerTurn.setText("Player 2");
			player2Panel.setBackground(Color.RED);
			player1Panel.setBackground(Color.white);
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
				player1Wins++;
				p1WinLabel.setText(player1Wins + ""+ " Wins");
				playAgain.setVisible(true);
				gameTitle.setText("Player 1 Wins");
				whoWon.setText("Player 1");
			}
			else if(checkCat())
			{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
			}
			if(computer)
			{
				if(comp.win(oIcon)!=0)
				{
					undoStack.push(comp.win(oIcon));
					comp.insertO(comp.win(oIcon));
					player1Panel.setBackground(Color.RED);
					player2Panel.setBackground(Color.white);
				}
				else if(comp.block(xIcon)!=0)
				{
					undoStack.push(comp.block(xIcon));
					comp.insertO(comp.block(xIcon));
					player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.fork(oIcon) !=0)
				{
				undoStack.push(comp.fork(oIcon));
				comp.insertO(comp.fork(oIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				undoStack.push(comp.blockOpponentFork(xIcon));
				comp.insertO(comp.blockOpponentFork(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.center() !=0)
				{
				undoStack.push(comp.center());
				comp.insertO(comp.center());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				undoStack.push(comp.oppositeCorner(xIcon));
				comp.insertO(comp.oppositeCorner(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptyCorner() !=0)
										{
				undoStack.push(comp.emptyCorner());
				comp.insertO(comp.emptyCorner());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptySide() !=0)
										{
				undoStack.push(comp.emptySide());
				comp.insertO(comp.emptySide());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				if(checkWin(oIcon))
				{
					System.out.println("Computer Won");
					gameTitle.setText("Computer Wins");
					whoWon.setText("Computer");
					compWins++;
					p2WinLabel.setText(compWins + "" + " Wins");
					playAgain.setVisible(true);
				}
				else if(checkCat())
				{
					gameTitle.setText("DRAW");
				}
			}
			}
			else if( (gameArray[0][4].getIcon() == open) && (playerTurn.getText().equals("Player 2") ))
			{
				gameArray[0][4].setIcon(oIcon);
				gameArray[0][4].repaint();
				undoStack.push(9);
				errorMessage.setVisible(false);
				playerTurn.setText("Player 1");
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				player2Wins++;
				p2WinLabel.setText(player2Wins + ""+ " Wins");
				playAgain.setVisible(true);
				
				gameTitle.setText("Player 2 Wins");
				whoWon.setText("Player 2")
				;
				}
				else if(checkCat())
				{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
				}
			}
		}
		else if(source == gameArray[2][0])
		{
			if(gameArray[2][0].getIcon() == xIcon || gameArray[2][0].getIcon() == oIcon )
			{
				errorMessage.setVisible(true);
			}
			if( (gameArray[2][0].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			gameArray[2][0].setIcon(xIcon);
			gameArray[2][0].repaint();
			undoStack.push(4);
			errorMessage.setVisible(false);
			playerTurn.setText("Player 2");
			player2Panel.setBackground(Color.RED);
			player1Panel.setBackground(Color.white);
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
				player1Wins++;
				p1WinLabel.setText(player1Wins + ""+ " Wins");
				playAgain.setVisible(true);
				gameTitle.setText("Player 1 Wins");
				whoWon.setText("Player 1");
			}
			else if(checkCat())
			{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
			}
			if(computer)
			{
				if(comp.win(oIcon)!=0)
				{
					undoStack.push(comp.win(oIcon));
					comp.insertO(comp.win(oIcon));
					player1Panel.setBackground(Color.RED);
					player2Panel.setBackground(Color.white);
				}
				else if(comp.block(xIcon)!=0)
				{
					undoStack.push(comp.block(xIcon));
					comp.insertO(comp.block(xIcon));
					player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.fork(oIcon) !=0)
				{
				undoStack.push(comp.fork(oIcon));
				comp.insertO(comp.fork(oIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				undoStack.push(comp.blockOpponentFork(xIcon));
				comp.insertO(comp.blockOpponentFork(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.center() !=0)
				{
				undoStack.push(comp.center());
				comp.insertO(comp.center());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				undoStack.push(comp.oppositeCorner(xIcon));
				comp.insertO(comp.oppositeCorner(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptyCorner() !=0)
										{
				undoStack.push(comp.emptyCorner());
				comp.insertO(comp.emptyCorner());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptySide() !=0)
										{
				undoStack.push(comp.emptySide());
				comp.insertO(comp.emptySide());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				if(checkWin(oIcon))
				{
					System.out.println("Computer Won");
					gameTitle.setText("Computer Wins");
					whoWon.setText("Computer");
					compWins++;
					p2WinLabel.setText(compWins + "" + " Wins");
					playAgain.setVisible(true);
				}
				else if(checkCat())
				{
					gameTitle.setText("DRAW");
				}
			}
			}
			else if( (gameArray[2][0].getIcon() == open) && (playerTurn.getText().equals("Player 2") ))
			{
				gameArray[2][0].setIcon(oIcon);
				gameArray[2][0].repaint();
				undoStack.push(4);
				errorMessage.setVisible(false);
				playerTurn.setText("Player 1");
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				player2Wins++;
				p2WinLabel.setText(player2Wins + ""+ " Wins");
				playAgain.setVisible(true);
				
				gameTitle.setText("Player 2 Wins");
				whoWon.setText("Player 2")
				;
				}
				else if(checkCat())
				{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
				}
			}
		}
		else if(source == gameArray[2][2])
		{
			if(gameArray[2][2].getIcon() == xIcon || gameArray[2][2].getIcon() == oIcon )
			{
				errorMessage.setVisible(true);
			}
			if( (gameArray[2][2].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			gameArray[2][2].setIcon(xIcon);
			gameArray[2][2].repaint();
			undoStack.push(5);
			errorMessage.setVisible(false);
			playerTurn.setText("Player 2");
			player2Panel.setBackground(Color.RED);
			player1Panel.setBackground(Color.white);
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
				player1Wins++;
				p1WinLabel.setText(player1Wins + ""+ " Wins");
				playAgain.setVisible(true);
				gameTitle.setText("Player 1 Wins");
				whoWon.setText("Player 1");
			}
			else if(checkCat())
			{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
			}
			if(computer)
			{
				if(comp.win(oIcon)!=0)
				{
					undoStack.push(comp.win(oIcon));
					comp.insertO(comp.win(oIcon));
					player1Panel.setBackground(Color.RED);
					player2Panel.setBackground(Color.white);
				}
				else if(comp.block(xIcon)!=0)
				{
					undoStack.push(comp.block(xIcon));
					comp.insertO(comp.block(xIcon));
					player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.fork(oIcon) !=0)
				{
				undoStack.push(comp.fork(oIcon));
				comp.insertO(comp.fork(oIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				undoStack.push(comp.blockOpponentFork(xIcon));
				comp.insertO(comp.blockOpponentFork(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.center() !=0)
				{
				undoStack.push(comp.center());
				comp.insertO(comp.center());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				undoStack.push(comp.oppositeCorner(xIcon));
				comp.insertO(comp.oppositeCorner(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptyCorner() !=0)
										{
				undoStack.push(comp.emptyCorner());
				comp.insertO(comp.emptyCorner());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptySide() !=0)
										{
				undoStack.push(comp.emptySide());
				comp.insertO(comp.emptySide());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				if(checkWin(oIcon))
				{
					System.out.println("Computer Won");
					gameTitle.setText("Computer Wins");
					whoWon.setText("Computer");
					compWins++;
					p2WinLabel.setText(compWins + "" + " Wins");
					playAgain.setVisible(true);
				}
				else if(checkCat())
				{
					gameTitle.setText("DRAW");
				}
			}
			}
			else if( (gameArray[2][2].getIcon() == open) && (playerTurn.getText().equals("Player 2") ))
			{
				gameArray[2][2].setIcon(oIcon);
				gameArray[2][2].repaint();
				undoStack.push(5);
				errorMessage.setVisible(false);
				playerTurn.setText("Player 1");
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				player2Wins++;
				p2WinLabel.setText(player2Wins + ""+ " Wins");
				playAgain.setVisible(true);
				
				gameTitle.setText("Player 2 Wins");
				whoWon.setText("Player 2")
				;
				}
				else if(checkCat())
				{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
				}
				// if(computer)
				// {
		
				// int space = comp.firstAvailableSpace();
				// comp.insertO(space);
				// }
			}
		}
		else if(source == gameArray[2][4])
		{
			if(gameArray[2][4].getIcon() == xIcon || gameArray[2][4].getIcon() == oIcon )
			{
				errorMessage.setVisible(true);
			}
			if( (gameArray[2][4].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			gameArray[2][4].setIcon(xIcon);
			gameArray[2][4].repaint();
			undoStack.push(6);
			errorMessage.setVisible(false);
			playerTurn.setText("Player 2");
			player2Panel.setBackground(Color.RED);
			player1Panel.setBackground(Color.white);
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
				player1Wins++;
				p1WinLabel.setText(player1Wins + ""+ " Wins");
				playAgain.setVisible(true);
				gameTitle.setText("Player 1 Wins");
				whoWon.setText("Player 1");
			}
			else if(checkCat())
			{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
			}
			if(computer)
			{
				if(comp.win(oIcon)!=0)
				{
					undoStack.push(comp.win(oIcon));
					comp.insertO(comp.win(oIcon));
					player1Panel.setBackground(Color.RED);
					player2Panel.setBackground(Color.white);
				}
				else if(comp.block(xIcon)!=0)
				{
					undoStack.push(comp.block(xIcon));
					comp.insertO(comp.block(xIcon));
					player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.fork(oIcon) !=0)
				{
				undoStack.push(comp.fork(oIcon));
				comp.insertO(comp.fork(oIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				undoStack.push(comp.blockOpponentFork(xIcon));
				comp.insertO(comp.blockOpponentFork(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.center() !=0)
				{
				undoStack.push(comp.center());
				comp.insertO(comp.center());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				undoStack.push(comp.oppositeCorner(xIcon));
				comp.insertO(comp.oppositeCorner(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptyCorner() !=0)
										{
				undoStack.push(comp.emptyCorner());
				comp.insertO(comp.emptyCorner());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptySide() !=0)
										{
				undoStack.push(comp.emptySide());
				comp.insertO(comp.emptySide());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				if(checkWin(oIcon))
				{
					System.out.println("Computer Won");
					gameTitle.setText("Computer Wins");
					whoWon.setText("Computer");
					compWins++;
					p2WinLabel.setText(compWins + "" + " Wins");
					playAgain.setVisible(true);
				}
				else if(checkCat())
				{
					gameTitle.setText("DRAW");
				}
			}
			}
			else if( (gameArray[2][4].getIcon() == open) && (playerTurn.getText().equals("Player 2") ))
			{
				gameArray[2][4].setIcon(oIcon);
				gameArray[2][4].repaint();
				undoStack.push(6);
				errorMessage.setVisible(false);
				playerTurn.setText("Player 1");
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				player2Wins++;
				p2WinLabel.setText(player2Wins + ""+ " Wins");
				playAgain.setVisible(true);
				
				gameTitle.setText("Player 2 Wins");
				whoWon.setText("Player 2")
				;
				}
				else if(checkCat())
				{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
				}
			}
		}
		else if(source == gameArray[4][0])
		{
			if(gameArray[4][0].getIcon() == xIcon || gameArray[4][0].getIcon() == oIcon )
			{
				errorMessage.setVisible(true);
			}
			if( (gameArray[4][0].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			gameArray[4][0].setIcon(xIcon);
			gameArray[4][0].repaint();
			undoStack.push(1);
			errorMessage.setVisible(false);
			playerTurn.setText("Player 2");
			player2Panel.setBackground(Color.RED);
			player1Panel.setBackground(Color.white);
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
				player1Wins++;
				p1WinLabel.setText(player1Wins + ""+ " Wins");
				playAgain.setVisible(true);
				gameTitle.setText("Player 1 Wins");
				whoWon.setText("Player 1");
			}
			else if(checkCat())
			{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
			}
			if(computer)
			{
				if(comp.win(oIcon)!=0)
				{
					undoStack.push(comp.win(oIcon));
					comp.insertO(comp.win(oIcon));
					player1Panel.setBackground(Color.RED);
					player2Panel.setBackground(Color.white);
				}
				else if(comp.block(xIcon)!=0)
				{
					undoStack.push(comp.block(xIcon));
					comp.insertO(comp.block(xIcon));
					player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.fork(oIcon) !=0)
				{
				undoStack.push(comp.fork(oIcon));
				comp.insertO(comp.fork(oIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				undoStack.push(comp.blockOpponentFork(xIcon));
				comp.insertO(comp.blockOpponentFork(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.center() !=0)
				{
				undoStack.push(comp.center());
				comp.insertO(comp.center());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				undoStack.push(comp.oppositeCorner(xIcon));
				comp.insertO(comp.oppositeCorner(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptyCorner() !=0)
										{
				undoStack.push(comp.emptyCorner());
				comp.insertO(comp.emptyCorner());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptySide() !=0)
										{
				undoStack.push(comp.emptySide());
				comp.insertO(comp.emptySide());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				if(checkWin(oIcon))
				{
					System.out.println("Computer Won");
					gameTitle.setText("Computer Wins");
					whoWon.setText("Computer");
					compWins++;
					p2WinLabel.setText(compWins + "" + " Wins");
					playAgain.setVisible(true);
				}
				else if(checkCat())
				{
					gameTitle.setText("DRAW");
				}
			}
			}
			else if( (gameArray[4][0].getIcon() == open) && (playerTurn.getText().equals("Player 2") ))
			{
				gameArray[4][0].setIcon(oIcon);
				gameArray[4][0].repaint();
				undoStack.push(1);
				errorMessage.setVisible(false);
				playerTurn.setText("Player 1");
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				player2Wins++;
				p2WinLabel.setText(player2Wins + ""+ " Wins");
				playAgain.setVisible(true);
				
				gameTitle.setText("Player 2 Wins");
				whoWon.setText("Player 2")
				;
				}
				else if(checkCat())
				{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
				}
			}
		}
		else if(source == gameArray[4][2])
		{
			if(gameArray[4][2].getIcon() == xIcon || gameArray[4][2].getIcon() == oIcon )
			{
				errorMessage.setVisible(true);
			}
			if( (gameArray[4][2].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			gameArray[4][2].setIcon(xIcon);
			gameArray[4][2].repaint();
			undoStack.push(2);
			errorMessage.setVisible(false);
			playerTurn.setText("Player 2");
			player2Panel.setBackground(Color.RED);
			player1Panel.setBackground(Color.white);
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
				player1Wins++;
				p1WinLabel.setText(player1Wins + ""+ " Wins");
				playAgain.setVisible(true);
				gameTitle.setText("Player 1 Wins");
				whoWon.setText("Player 1");
			}
			else if(checkCat())
			{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
			}
			if(computer)
			{
				if(comp.win(oIcon)!=0)
				{
					undoStack.push(comp.win(oIcon));
					comp.insertO(comp.win(oIcon));
					player1Panel.setBackground(Color.RED);
					player2Panel.setBackground(Color.white);
				}
				else if(comp.block(xIcon)!=0)
				{
					undoStack.push(comp.block(xIcon));
					comp.insertO(comp.block(xIcon));
					player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.fork(oIcon) !=0)
				{
				undoStack.push(comp.fork(oIcon));
				comp.insertO(comp.fork(oIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				undoStack.push(comp.blockOpponentFork(xIcon));
				comp.insertO(comp.blockOpponentFork(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.center() !=0)
				{
				undoStack.push(comp.center());
				comp.insertO(comp.center());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				undoStack.push(comp.oppositeCorner(xIcon));
				comp.insertO(comp.oppositeCorner(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptyCorner() !=0)
										{
				undoStack.push(comp.emptyCorner());
				comp.insertO(comp.emptyCorner());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptySide() !=0)
										{
				undoStack.push(comp.emptySide());
				comp.insertO(comp.emptySide());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				if(checkWin(oIcon))
				{
					System.out.println("Computer Won");
					gameTitle.setText("Computer Wins");
					whoWon.setText("Computer");
					compWins++;
					p2WinLabel.setText(compWins + "" + " Wins");
					playAgain.setVisible(true);
				}
				else if(checkCat())
				{
					gameTitle.setText("DRAW");
				}
			}
			}
			else if( (gameArray[4][2].getIcon() == open) && (playerTurn.getText().equals("Player 2") ))
			{
				gameArray[4][2].setIcon(oIcon);
				gameArray[4][2].repaint();
				undoStack.push(2);
				errorMessage.setVisible(false);
				playerTurn.setText("Player 1");
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				player2Wins++;
				p2WinLabel.setText(player2Wins + ""+ " Wins");
				playAgain.setVisible(true);
				
				gameTitle.setText("Player 2 Wins");
				whoWon.setText("Player 2")
				;
				}
				else if(checkCat())
				{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
				}
			}
		}
		else if(source == gameArray[4][4])
		{
			if(gameArray[4][4].getIcon() == xIcon || gameArray[4][4].getIcon() == oIcon )
			{
				errorMessage.setVisible(true);
			}
			if( (gameArray[4][4].getIcon() == open) && (playerTurn.getText().equals("Player 1") ))
			{	
			gameArray[4][4].setIcon(xIcon);
			gameArray[4][4].repaint();
			undoStack.push(3);
			errorMessage.setVisible(false);
			playerTurn.setText("Player 2");
			player2Panel.setBackground(Color.RED);
			player1Panel.setBackground(Color.white);
			if(checkWin(xIcon))
			{
				System.out.println("Player 1 Wins");
				player1Wins++;
				p1WinLabel.setText(player1Wins + ""+ " Wins");
				playAgain.setVisible(true);
				gameTitle.setText("Player 1 Wins");
				whoWon.setText("Player 1");
			}
			else if(checkCat())
			{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
			}
			if(computer)
			{
				if(comp.win(oIcon)!=0)
				{
					undoStack.push(comp.win(oIcon));
					comp.insertO(comp.win(oIcon));
					player1Panel.setBackground(Color.RED);
					player2Panel.setBackground(Color.white);
				}
				else if(comp.block(xIcon)!=0)
				{
					undoStack.push(comp.block(xIcon));
					comp.insertO(comp.block(xIcon));
					player1Panel.setBackground(Color.RED);
					player2Panel.setBackground(Color.white);
				}
				else if(comp.fork(oIcon) !=0)
				{
				undoStack.push(comp.fork(oIcon));
				comp.insertO(comp.fork(oIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.blockOpponentFork(xIcon) !=0)
				{
				undoStack.push(comp.blockOpponentFork(xIcon));
				comp.insertO(comp.blockOpponentFork(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.center() !=0)
				{
				undoStack.push(comp.center());
				comp.insertO(comp.center());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.oppositeCorner(xIcon) !=0)
										{
				undoStack.push(comp.oppositeCorner(xIcon));
				comp.insertO(comp.oppositeCorner(xIcon));
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptyCorner() !=0)
										{
				undoStack.push(comp.emptyCorner());
				comp.insertO(comp.emptyCorner());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				else if(comp.emptySide() !=0)
										{
				undoStack.push(comp.emptySide());
				comp.insertO(comp.emptySide());
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				}
				if(checkWin(oIcon))
				{
					System.out.println("Computer Won");
					gameTitle.setText("Computer Wins");
					whoWon.setText("Computer");
					compWins++;
					p2WinLabel.setText(compWins + "" + " Wins");
					playAgain.setVisible(true);
				}
				else if(checkCat())
				{
					gameTitle.setText("DRAW");
				}
				
			}
			}
			else if( (gameArray[4][4].getIcon() == open) && (playerTurn.getText().equals("Player 2") ))
			{
				gameArray[4][4].setIcon(oIcon);
				gameArray[4][4].repaint();
				undoStack.push(3);
				errorMessage.setVisible(false);
				playerTurn.setText("Player 1");
				player1Panel.setBackground(Color.RED);
				player2Panel.setBackground(Color.white);
				if(checkWin(oIcon))
				{
				System.out.println("Player 2 Wins");
				player2Wins++;
				p2WinLabel.setText(player2Wins + ""+ " Wins");
				playAgain.setVisible(true);
				
				gameTitle.setText("Player 2 Wins");
				whoWon.setText("Player 2");
				}
				else if(checkCat())
				{
				System.out.println("It was a cat");
				playAgain.setVisible(true);
				gameTitle.setText("DRAW");
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
	//gameBoard.setAlignmentX(Component.CENTER_ALIGNMENT);
	gameBoard.setPreferredSize(new Dimension(300,300));
	gameBoard.setMaximumSize(new Dimension(300,300));
	innerBoard1 = new JPanel();
	innerBoard1.setLayout(new BoxLayout(innerBoard1, BoxLayout.X_AXIS));
	innerBoard1.setPreferredSize(new Dimension(60,60));
	innerBoard2 = new JPanel();
	innerBoard2.setLayout(new BoxLayout(innerBoard2, BoxLayout.X_AXIS));
	innerBoard2.setPreferredSize(new Dimension(60,60));
	innerBoard3 = new JPanel();
	innerBoard3.setLayout(new BoxLayout(innerBoard3, BoxLayout.X_AXIS));
	innerBoard3.setPreferredSize(new Dimension(60,60));
	innerBoard4 = new JPanel();
	innerBoard4.setLayout(new BoxLayout(innerBoard4, BoxLayout.X_AXIS));
	innerBoard4.setPreferredSize(new Dimension(60,60));
	innerBoard5 = new JPanel();
	innerBoard5.setLayout(new BoxLayout(innerBoard5, BoxLayout.X_AXIS));
	innerBoard5.setPreferredSize(new Dimension(60,60));



	gameArray = new JLabel[5][5];
	//Puts all the empty spaces to open lock sign
	for (int i=0; i< gameArray.length;i+=2 )
	{
		for (int j = 0; j < gameArray[0].length; j+=2)
		{
			
			gameArray[i][j] = new JLabel(open);
			
		}
		
	}
	//Put horizontall line in every other line
	for (int i=1; i< gameArray.length;i+=2 )
	{
		for (int j = 0; j < gameArray[0].length; j++)
		{
			
			gameArray[i][j] = new JLabel(horizontal);
			
		}
		
	}
	//Skips two lines because the lines only go in the middle
	for (int i=0; i< gameArray.length;i+=2 )
	{
		for (int j = 1; j < gameArray[0].length; j+=2)
		{
			
			gameArray[i][j] = new JLabel(horizontal);
			
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
  	gameTitle.setText("");
  	playAgain.setVisible(false);
  	player1Panel.setBackground(Color.RED);
  	player2Panel.setBackground(Color.white);
  	playerTurn.setText("Player 1");
  	errorMessage.setVisible(false);
  	whoWon.setText("");
  	undoStack = new Stack<Integer>();
  	//Puts all the empty spaces to open lock sign
	for (int i=0; i< gameArray.length;i+=2 )
	{
		for (int j = 0; j < gameArray[0].length; j+=2)
		{
			
			gameArray[i][j].setIcon(open);
			gameArray[i][j].repaint();
			
		}
		
	}
	//Put horizontal in every other line
	for (int i=1; i< gameArray.length;i+=2 )
	{
		for (int j = 0; j < gameArray[0].length; j++)
		{
			
			gameArray[i][j].setIcon(horizontal);
			gameArray[i][j].repaint();
			
		}
		
	}
	//Skips two lines because the lines only go in the middle
	for (int i=0; i< gameArray.length;i+=2 )
	{
		for (int j = 1; j < gameArray[0].length; j+=2)
		{
			
			gameArray[i][j].setIcon(horizontal);
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