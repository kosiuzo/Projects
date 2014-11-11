import java.util.*;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
public class Card{
public static Stack<SingleCard> deck = new Stack<SingleCard>();
public static SingleCard[] deckArray; 

public SingleCard[] make1DeckArray()
{
	deckArray = new SingleCard[52];

	for(int i = 0; i<deckArray.length; i++)
	{
		int index = i +1;
		
		ImageIcon image = new ImageIcon("classic-cards/"+index+""+".png");
		SingleCard label = new SingleCard(image);
		if(index<5)
		{
			label.value = 1;
		}
		else if( index > 4 &&  (index<17))
		{
			label.value = 10;
		}
		else if( index > 16 &&  (index<21))
		{
			label.value = 10;
		}
		else if( index > 20 &&  (index<25))
		{
			label.value = 9;
		}
		else if( index > 24 &&  (index<29))
		{
			label.value = 8;
		}
		else if( index > 28 &&  (index<33))
		{
			label.value = 7;
		}
		else if( index > 32 &&  (index<37))
		{
			label.value = 6;
		}
		else if( index > 36 &&  (index<41))
		{
			label.value = 5;
		}
		else if( index > 40 &&  (index<45))
		{
			label.value = 4;
		}
		else if( index > 44 &&  (index<49))
		{
			label.value = 3;
		}
		else if( index > 48 &&  (index<=52))
		{
			label.value = 2;
		}
		
		
		deckArray[i]=label;
	}
	shuffleDeckArray();
	return deckArray;
	
}

public void makeDeckStack()
{
	deck = new Stack<SingleCard>();
	for(int i =0; i<deckArray.length; i++)
	{
		deck.push(deckArray[i]);
	}
}

public void shuffleDeckArray()
{
	Random randomGen = new Random();
	for(int i =0; i<deckArray.length; i++ )
	{
		int index = randomGen.nextInt(deckArray.length);
		SingleCard temp = deckArray[i];
		deckArray[index] = deckArray[i];
		deckArray[i] = temp;
	}
}

public SingleCard getNextCard()
{
	return this.deck.pop();
}

public void makeShoe(int howManyDecks)
{
	int counter =0;
	for(int i = 0; i<howManyDecks; i++)
	{
		SingleCard[] temp = make1DeckArray();
		for(int j =0; j<temp.length; j++)
		{
			deck.push(temp[j]);
			counter++;
		}
	}
	System.out.println("How many cards in the deck " + counter);
}



}