/**This is the CutThroat class that plays hard*/
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
public class CutThroatComputerPlayer extends TicTacToePlayer
{
	public CutThroatComputerPlayer()
	{
		super("CutThroatCPU");
	}

	public CutThroatComputerPlayer(String inputName)
	{
		super(inputName);
	}
//This checks if the CutThroat could win in the next move
//The inputLetter is needed to check if X or O
	public int win(ImageIcon symbol)
	{
		if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[0][2].getIcon() == symbol) && (TicTacToePanel.gameArray[0][4].getIcon() == TicTacToePanel.open) )
			return 9;
		else if((TicTacToePanel.gameArray[2][0].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == symbol) && (TicTacToePanel.gameArray[2][4].getIcon() == TicTacToePanel.open) )
			return 6;
		else if((TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][2].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == TicTacToePanel.open) )
			return 3;
		else if((TicTacToePanel.gameArray[0][2].getIcon() == symbol) && (TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[0][0].getIcon() == TicTacToePanel.open) )
			return 7;
		else if((TicTacToePanel.gameArray[2][2].getIcon() == symbol) && (TicTacToePanel.gameArray[2][4].getIcon() == symbol) && (TicTacToePanel.gameArray[2][0].getIcon() == TicTacToePanel.open) )
			return 4;
		else if((TicTacToePanel.gameArray[4][2].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == TicTacToePanel.open) )
			return 1;
		else if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[2][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == TicTacToePanel.open) )
			return 1;
		else if((TicTacToePanel.gameArray[0][2].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == symbol) && (TicTacToePanel.gameArray[4][2].getIcon() == TicTacToePanel.open) )
			return 2;
		else if((TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[2][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == TicTacToePanel.open) )
			return 3;
		else if((TicTacToePanel.gameArray[2][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[0][0].getIcon() == TicTacToePanel.open) )
			return 7;
		else if((TicTacToePanel.gameArray[2][2].getIcon() == symbol) && (TicTacToePanel.gameArray[4][2].getIcon() == symbol) && (TicTacToePanel.gameArray[0][2].getIcon() == TicTacToePanel.open) )
			return 8;
		else if((TicTacToePanel.gameArray[2][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[0][4].getIcon() == TicTacToePanel.open) )
			return 9;
		else if((TicTacToePanel.gameArray[2][2].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[0][0].getIcon() == TicTacToePanel.open) )
			return 7;
		else if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == TicTacToePanel.open) )
			return 3;
		else if((TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == symbol) && (TicTacToePanel.gameArray[0][4].getIcon() == TicTacToePanel.open) )
			return 9;
		else if((TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == TicTacToePanel.open) )
			return 1;
		else if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == TicTacToePanel.open) )
			return 5;
		else if((TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == TicTacToePanel.open) )
			return 5;
		else if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[2][0].getIcon() == TicTacToePanel.open) )
			return 4;
		else if((TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[2][4].getIcon() == TicTacToePanel.open) )
			return 6;
		else if((TicTacToePanel.gameArray[2][0].getIcon() == symbol) && (TicTacToePanel.gameArray[2][4].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == TicTacToePanel.open) )
			return 5;
		else if((TicTacToePanel.gameArray[0][2].getIcon() == symbol) && (TicTacToePanel.gameArray[4][2].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == TicTacToePanel.open) )
			return 5;
		else if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[0][2].getIcon() == TicTacToePanel.open) )
			return 8;
		else if((TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][2].getIcon() == TicTacToePanel.open) )
			return 2;

		return 0;

	}

	//This checks if the CutThroat would lose in the next move
	//The symbol is needed to check if X or O
	public int block(ImageIcon symbol)
	{
		if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[0][2].getIcon() == symbol) && (TicTacToePanel.gameArray[0][4].getIcon() == TicTacToePanel.open) )
			return 9;
		else if((TicTacToePanel.gameArray[2][0].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == symbol) && (TicTacToePanel.gameArray[2][4].getIcon() == TicTacToePanel.open) )
			return 6;
		else if((TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][2].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == TicTacToePanel.open) )
			return 3;
		else if((TicTacToePanel.gameArray[0][2].getIcon() == symbol) && (TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[0][0].getIcon() == TicTacToePanel.open) )
			return 7;
		else if((TicTacToePanel.gameArray[2][2].getIcon() == symbol) && (TicTacToePanel.gameArray[2][4].getIcon() == symbol) && (TicTacToePanel.gameArray[2][0].getIcon() == TicTacToePanel.open) )
			return 4;
		else if((TicTacToePanel.gameArray[4][2].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == TicTacToePanel.open) )
			return 1;
		else if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[2][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == TicTacToePanel.open) )
			return 1;
		else if((TicTacToePanel.gameArray[0][2].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == symbol) && (TicTacToePanel.gameArray[4][2].getIcon() == TicTacToePanel.open) )
			return 2;
		else if((TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[2][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == TicTacToePanel.open) )
			return 3;
		else if((TicTacToePanel.gameArray[2][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[0][0].getIcon() == TicTacToePanel.open) )
			return 7;
		else if((TicTacToePanel.gameArray[2][2].getIcon() == symbol) && (TicTacToePanel.gameArray[4][2].getIcon() == symbol) && (TicTacToePanel.gameArray[0][2].getIcon() == TicTacToePanel.open) )
			return 8;
		else if((TicTacToePanel.gameArray[2][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[0][4].getIcon() == TicTacToePanel.open) )
			return 9;
		else if((TicTacToePanel.gameArray[2][2].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[0][0].getIcon() == TicTacToePanel.open) )
			return 7;
		else if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == TicTacToePanel.open) )
			return 3;
		else if((TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == symbol) && (TicTacToePanel.gameArray[0][4].getIcon() == TicTacToePanel.open) )
			return 9;
		else if((TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == TicTacToePanel.open) )
			return 1;
		else if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == TicTacToePanel.open) )
			return 5;
		else if((TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == TicTacToePanel.open) )
			return 5;
		else if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[2][0].getIcon() == TicTacToePanel.open) )
			return 4;
		else if((TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[2][4].getIcon() == TicTacToePanel.open) )
			return 6;
		else if((TicTacToePanel.gameArray[2][0].getIcon() == symbol) && (TicTacToePanel.gameArray[2][4].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == TicTacToePanel.open) )
			return 5;
		else if((TicTacToePanel.gameArray[0][2].getIcon() == symbol) && (TicTacToePanel.gameArray[4][2].getIcon() == symbol) && (TicTacToePanel.gameArray[2][2].getIcon() == TicTacToePanel.open) )
			return 5;
		else if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[0][2].getIcon() == TicTacToePanel.open) )
			return 8;
		else if((TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][2].getIcon() == TicTacToePanel.open) )
			return 2;

		return 0;

	}

	//plays a fork method
	public int fork(ImageIcon symbol)
	{
		if((TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[0][4].getIcon() == TicTacToePanel.open) )
			return 9;
		else if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[0][4].getIcon() == TicTacToePanel.open) )
			return 9;
		else if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == TicTacToePanel.open) )
			return 3;
		else if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == TicTacToePanel.open) )
			return 3;
		else if((TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[0][0].getIcon() == TicTacToePanel.open) )
			return 7;
		else if((TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[0][0].getIcon() == TicTacToePanel.open) )
			return 7;
		else if((TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == TicTacToePanel.open) )
			return 1;
		else if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == TicTacToePanel.open) )
			return 1;

		return 0;
		
	}

	//plays the blocking a fork method
	public int blockOpponentFork(ImageIcon symbol)
	{
		if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[2][0].getIcon() == TicTacToePanel.open))
			return 4;
		else if((TicTacToePanel.gameArray[0][0].getIcon() == symbol) && (TicTacToePanel.gameArray[4][4].getIcon() == symbol) && (TicTacToePanel.gameArray[2][4].getIcon() == TicTacToePanel.open))
			return 6;
		else if((TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[2][0].getIcon() == TicTacToePanel.open))
			return 4;
		else if((TicTacToePanel.gameArray[0][4].getIcon() == symbol) && (TicTacToePanel.gameArray[4][0].getIcon() == symbol) && (TicTacToePanel.gameArray[2][4].getIcon() == TicTacToePanel.open))
			return 6;

		return 0;

	}

	//checks and plays the center
	public int center()
	{
		if(this.checkAvailable(5))
		{
		return 5;
		}
		else 
		return 0;
	}

	//checks and plays the opposite corner
	public int oppositeCorner(ImageIcon symbol)
	{
		JLabel[][] tempArray = TicTacToePanel.gameArray;
		
	if( (tempArray[0][0].getIcon() == symbol) && (tempArray[4][4].getIcon() == TicTacToePanel.open))
			return 3;
		else if((tempArray[0][4].getIcon() == symbol) && (tempArray[4][0].getIcon() == TicTacToePanel.open) )
			return 1;
		else if((tempArray[4][0].getIcon() == symbol) && (tempArray[0][4].getIcon() == TicTacToePanel.open))
			return 9;
		else if((tempArray[4][4].getIcon() == symbol) && (tempArray[0][0].getIcon() == TicTacToePanel.open))
			return 7;
			
			return 0;
	}

	//checks and plays empty corner
	public int emptyCorner()
	{
		if(TicTacToePanel.gameArray[0][0].getIcon() == TicTacToePanel.open)
			return 7;
		else if(TicTacToePanel.gameArray[0][4].getIcon() == TicTacToePanel.open)
			return 9;
		else if(TicTacToePanel.gameArray[4][0].getIcon() == TicTacToePanel.open)
			return 1;
		else if (TicTacToePanel.gameArray[4][4].getIcon() == TicTacToePanel.open)
			return 3;
		return 0;
	}

	//checks and plays empty side
	public int emptySide()
	{
		if(TicTacToePanel.gameArray[0][2].getIcon() == TicTacToePanel.open)
			return 8;
		else if(TicTacToePanel.gameArray[2][0].getIcon() == TicTacToePanel.open)
			return 4;
		else if(TicTacToePanel.gameArray[2][4].getIcon() == TicTacToePanel.open)
			return 6;
		else if (TicTacToePanel.gameArray[4][2].getIcon() == TicTacToePanel.open)
			return 2;
		return 0;
	}
}