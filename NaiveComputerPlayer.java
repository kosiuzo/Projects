/**This is the class file that plays the first available spot from left to right called naive*/
public class NaiveComputerPlayer extends TicTacToePlayer{
	public NaiveComputerPlayer()
	{
		super("CutThroatCPU");
	}
	public NaiveComputerPlayer(String inputName)
	{
		super(inputName);
	}
	
	//plays the first available space from left to right
	public int firstAvailableSpace()
	{
		int numberTracker = 1;
		for(int x = 0; x<TicTacToePanel.gameArray.length; x+=2 )
		{
			for(int y = 0; y < TicTacToePanel.gameArray[0].length; y+=2)
			{
				if (TicTacToePanel.gameArray[x][y].getIcon() == TicTacToePanel.open)
					return numberTracker;
				else
					numberTracker++;

			}
		}
		return numberTracker;
	}
}