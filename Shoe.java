import java.util.*;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
public class Shoe{
public static Stack<SingleCard> deck = new Stack<SingleCard>();
public static SingleCard[] deckArray;
public ImageIcon cardImage;

public SingleCard[] make1DeckArray()
{
	deckArray = new SingleCard[52];
	cardImage = new ImageIcon("classic-cards/1.png");
	deckArray[0] =new SingleCard(cardImage);
	deckArray[0].value = 1;
	deckArray[0].name = "Ace of Clubs";
	cardImage = new ImageIcon("classic-cards/2.png");
	deckArray[1] =new SingleCard(cardImage);
	deckArray[1].value = 1;
	deckArray[1].name = "Ace of Spades";
	cardImage = new ImageIcon("classic-cards/3.png");
	deckArray[2] =new SingleCard(cardImage);
	deckArray[2].value = 1;
	deckArray[2].name = "Ace of Hearts";
	cardImage = new ImageIcon("classic-cards/4.png");
	deckArray[3] =new SingleCard(cardImage);
	deckArray[3].value = 1;
	deckArray[3].name = "Ace of Diamonds";
	cardImage = new ImageIcon("classic-cards/5.png");
	deckArray[4] =new SingleCard(cardImage);
	deckArray[4].value = 10;
	deckArray[4].name = "King of Clubs";
	cardImage = new ImageIcon("classic-cards/6.png");
	deckArray[5] =new SingleCard(cardImage);
	deckArray[5].value = 10;
	deckArray[5].name = "King of Spades";
	cardImage = new ImageIcon("classic-cards/7.png");
	deckArray[6] =new SingleCard(cardImage);
	deckArray[6].value = 10;
	deckArray[6].name = "King of Hearts";
	cardImage = new ImageIcon("classic-cards/8.png");
	deckArray[7] =new SingleCard(cardImage);
	deckArray[7].value = 10;
	deckArray[7].name = "King of Diamond";
	cardImage = new ImageIcon("classic-cards/9.png");
	deckArray[8] =new SingleCard(cardImage);
	deckArray[8].value = 10;
	deckArray[8].name = "Queen of Clubs";
	cardImage = new ImageIcon("classic-cards/10.png");
	deckArray[9] =new SingleCard(cardImage);
	deckArray[9].value = 10;
	deckArray[9].name = "Queen of Spades";
	cardImage = new ImageIcon("classic-cards/11.png");
	deckArray[10] =new SingleCard(cardImage);
	deckArray[10].value = 10;
	deckArray[10].name = "Queen of Hearts";
	cardImage = new ImageIcon("classic-cards/12.png");
	deckArray[11] =new SingleCard(cardImage);
	deckArray[11].value = 10;
	deckArray[11].name = "Queen of Diamond";
	cardImage = new ImageIcon("classic-cards/13.png");
	deckArray[12] =new SingleCard(cardImage);
	deckArray[12].value = 10;
	deckArray[12].name = "Jack of Clubs";
	cardImage = new ImageIcon("classic-cards/14.png");
	deckArray[13] =new SingleCard(cardImage);
	deckArray[13].value = 10;
	deckArray[13].name = "Jack of Spades";
	cardImage = new ImageIcon("classic-cards/15.png");
	deckArray[14] =new SingleCard(cardImage);
	deckArray[14].value = 10;
	deckArray[14].name = "Jack of Hearts";
	cardImage = new ImageIcon("classic-cards/16.png");
	deckArray[15] =new SingleCard(cardImage);
	deckArray[15].value = 10;
	deckArray[15].name = "Jack of Diamond";
	cardImage = new ImageIcon("classic-cards/17.png");
	deckArray[16] =new SingleCard(cardImage);
	deckArray[16].value = 10;
	deckArray[16].name = "Ten of Clubs";
	cardImage = new ImageIcon("classic-cards/18.png");
	deckArray[17] =new SingleCard(cardImage);
	deckArray[17].value = 10;
	deckArray[17].name = "Ten of Spades";
	cardImage = new ImageIcon("classic-cards/19.png");
	deckArray[18] =new SingleCard(cardImage);
	deckArray[18].value = 10;
	deckArray[18].name = "Ten of Hearts";
	cardImage = new ImageIcon("classic-cards/20.png");
	deckArray[19] =new SingleCard(cardImage);
	deckArray[19].value = 10;
	deckArray[19].name = "Ten of Diamond";
	cardImage = new ImageIcon("classic-cards/21.png");
	deckArray[20] =new SingleCard(cardImage);
	deckArray[20].value = 9;
	deckArray[20].name = "Nine of Clubs";
	cardImage = new ImageIcon("classic-cards/22.png");
	deckArray[21] =new SingleCard(cardImage);
	deckArray[21].value = 9;
	deckArray[21].name = "Nine of Spades";
	cardImage = new ImageIcon("classic-cards/23.png");
	deckArray[22] =new SingleCard(cardImage);
	deckArray[22].value = 9;
	deckArray[22].name = "Nine of Hearts";
	cardImage = new ImageIcon("classic-cards/24.png");
	deckArray[23] =new SingleCard(cardImage);
	deckArray[23].value = 9;
	deckArray[23].name = "Nine of Diamond";
	cardImage = new ImageIcon("classic-cards/25.png");
	deckArray[24] =new SingleCard(cardImage);
	deckArray[24].value = 8;
	deckArray[24].name = "Eight of Clubs";
	cardImage = new ImageIcon("classic-cards/26.png");
	deckArray[25] =new SingleCard(cardImage);
	deckArray[25].value = 8;
	deckArray[25].name = "Eight of Spades";
	cardImage = new ImageIcon("classic-cards/27.png");
	deckArray[26] =new SingleCard(cardImage);
	deckArray[26].value = 8;
	deckArray[26].name = "Eight of Hearts";
	cardImage = new ImageIcon("classic-cards/28.png");
	deckArray[27] =new SingleCard(cardImage);
	deckArray[27].value = 8;
	deckArray[27].name = "Eight of Diamond";
	cardImage = new ImageIcon("classic-cards/29.png");
	deckArray[28] =new SingleCard(cardImage);
	deckArray[28].value = 7;
	deckArray[28].name = "Seven of Clubs";
	cardImage = new ImageIcon("classic-cards/30.png");
	deckArray[29] =new SingleCard(cardImage);
	deckArray[29].value = 7;
	deckArray[29].name = "Seven of Spades";
	cardImage = new ImageIcon("classic-cards/31.png");
	deckArray[30] =new SingleCard(cardImage);
	deckArray[30].value = 7;
	deckArray[30].name = "Seven of Hearts";
	cardImage = new ImageIcon("classic-cards/32.png");
	deckArray[31] =new SingleCard(cardImage);
	deckArray[31].value = 7;
	deckArray[31].name = "Seven of Diamond";
	cardImage = new ImageIcon("classic-cards/33.png");
	deckArray[32] =new SingleCard(cardImage);
	deckArray[32].value = 6;
	deckArray[32].name = "Six of Clubs";
	cardImage = new ImageIcon("classic-cards/34.png");
	deckArray[33] =new SingleCard(cardImage);
	deckArray[33].value = 6;
	deckArray[33].name = "Six of Spades";
	cardImage = new ImageIcon("classic-cards/35.png");
	deckArray[34] =new SingleCard(cardImage);
	deckArray[34].value = 6;
	deckArray[34].name = "Six of Hearts";
	cardImage = new ImageIcon("classic-cards/36.png");
	deckArray[35] =new SingleCard(cardImage);
	deckArray[35].value = 6;
	deckArray[35].name = "Six of Diamond";
	cardImage = new ImageIcon("classic-cards/37.png");
	deckArray[36] =new SingleCard(cardImage);
	deckArray[36].value = 5;
	deckArray[36].name = "Five of Clubs";
	cardImage = new ImageIcon("classic-cards/38.png");
	deckArray[37] =new SingleCard(cardImage);
	deckArray[37].value = 5;
	deckArray[37].name = "Five of Spades";
	cardImage = new ImageIcon("classic-cards/39.png");
	deckArray[38] =new SingleCard(cardImage);
	deckArray[38].value = 5;
	deckArray[38].name = "Five of Hearts";
	cardImage = new ImageIcon("classic-cards/40.png");
	deckArray[39] =new SingleCard(cardImage);
	deckArray[39].value = 5;
	deckArray[39].name = "Five of Diamond";
	cardImage = new ImageIcon("classic-cards/41.png");
	deckArray[40] =new SingleCard(cardImage);
	deckArray[40].value = 4;
	deckArray[40].name = "Four of Clubs";
	cardImage = new ImageIcon("classic-cards/42.png");
	deckArray[41] =new SingleCard(cardImage);
	deckArray[41].value = 4;
	deckArray[41].name = "Four of Spades";
	cardImage = new ImageIcon("classic-cards/43.png");
	deckArray[42] =new SingleCard(cardImage);
	deckArray[42].value = 4;
	deckArray[42].name = "Four of Hearts";
	cardImage = new ImageIcon("classic-cards/44.png");
	deckArray[43] =new SingleCard(cardImage);
	deckArray[43].value = 4;
	deckArray[43].name = "Four of Diamond";
	cardImage = new ImageIcon("classic-cards/45.png");
	deckArray[44] =new SingleCard(cardImage);
	deckArray[44].value = 3;
	deckArray[44].name = "Three of Clubs";
	cardImage = new ImageIcon("classic-cards/46.png");
	deckArray[45] =new SingleCard(cardImage);
	deckArray[45].value = 3;
	deckArray[45].name = "Three of Spades";
	cardImage = new ImageIcon("classic-cards/47.png");
	deckArray[46] =new SingleCard(cardImage);
	deckArray[46].value = 3;
	deckArray[46].name = "Three of Hearts";
	cardImage = new ImageIcon("classic-cards/48.png");
	deckArray[47] =new SingleCard(cardImage);
	deckArray[47].value = 3;
	deckArray[47].name = "Three of Diamond";
	cardImage = new ImageIcon("classic-cards/49.png");
	deckArray[48] =new SingleCard(cardImage);
	deckArray[48].value = 2;
	deckArray[48].name = "Two of Clubs";
	cardImage = new ImageIcon("classic-cards/50.png");
	deckArray[49] =new SingleCard(cardImage);
	deckArray[49].value = 2;
	deckArray[49].name = "Two of Spades";
	cardImage = new ImageIcon("classic-cards/51.png");
	deckArray[50] =new SingleCard(cardImage);
	deckArray[50].value = 2;
	deckArray[50].name = "Two of Hearts";
	cardImage = new ImageIcon("classic-cards/52.png");
	deckArray[51] =new SingleCard(cardImage);
	deckArray[51].value = 2;
	deckArray[51].name = "Two of Diamond";
	

//	for(int i = 0; i<deckArray.length; i++)
//	{
//		int index = i +1;
//		
//		ImageIcon image = new ImageIcon("classic-cards/"+index+""+".png");
//		SingleCard label = new SingleCard(image);
//		if(index<5)
//		{
//			label.value = 1;
//		}
//		else if( index > 4 &&  (index<17))
//		{
//			label.value = 10;
//		}
//		else if( index > 16 &&  (index<21))
//		{
//			label.value = 10;
//		}
//		else if( index > 20 &&  (index<25))
//		{
//			label.value = 9;
//		}
//		else if( index > 24 &&  (index<29))
//		{
//			label.value = 8;
//		}
//		else if( index > 28 &&  (index<33))
//		{
//			label.value = 7;
//		}
//		else if( index > 32 &&  (index<37))
//		{
//			label.value = 6;
//		}
//		else if( index > 36 &&  (index<41))
//		{
//			label.value = 5;
//		}
//		else if( index > 40 &&  (index<45))
//		{
//			label.value = 4;
//		}
//		else if( index > 44 &&  (index<49))
//		{
//			label.value = 3;
//		}
//		else if( index > 48 &&  (index<=52))
//		{
//			label.value = 2;
//		}
//		
//		
//		deckArray[i]=label;
//	}
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