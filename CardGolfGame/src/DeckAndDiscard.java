import java.util.Arrays;

public class DeckAndDiscard 

{
	
	//extra place holder card 'D' was added so that we know of the deck runs out
	private char[]deck = {'A','A','A','A','2','2','2','2','3','3','3','3','4','4','4','4','5','5','5','5','6','6','6','6','7','7','7','7','8','8','8','8','9','9','9','9','T','T','T','T','J','J','J','J','Q','Q','Q','Q','K','K','K','K','?','?','D'};;;
	private char[]discardPile = new char[54];
	private char[]P1 = new char[54];
	private char[]P2 = new char[54];
	
	private int a=0,b=0,c=54;
	
	//switches the spot of two cards in the array by making a randomn number between 0 and 53. 
	//this is repeated 1000 times
	//does not shuffle last placeholder card 'D'
	public void shuffle(char[] deck)
	{
		for(int i = 0; i<=1000; i++)
			{
			    int x = (int)((Math.random()*(54)));
			    int y = (int)((Math.random()*(54)));
			    
				char a = deck[x];
				char b = deck[y];
				
				deck[x] = b;
				deck[y] = a;
			}
	}
	
	
	//This distrebutes the shuffled cards to player and deck
	public DeckAndDiscard()
	{
		shuffle(deck);
		//18 because 18 cards have been dealt to the two decks
		a=18;
		b=0;
		
		for(int x = 0; x<9; x++)
			P1[x] = deck[x];
		
		for(int x = 0,q = 9; x<9; x++)
			P2[x] = deck[q++];	
	}

	//to show that a card has been picked, all while adding a value so that the next time its the next card in the deck
	public char pickACard()
	{ 
		return deck[a++];
	}	

	//places the picked card in the discard, all while adding a value to b so that the next time it puts it in the next array spot
	public void discard()
	{
		discardPile[b++] = deck[a-1];
	}
	
	//this show what card was last on the discard pile
	public char onTopOfDiscard()
	{
		return discardPile[b-1];
	}
	
	//this swaps places of a inputed char with one in the array
	public void swap(char x)
	{
		discardPile[b-1] = x;
	}
	
	//displays the values in the deck
	public void displayDeck()
	{
		for(int i= a;i<c;i++) 
		{
			System.out.print(deck[i]+" ");
		}
	}

	//displays cards in discard pile
	public void displaydiscardPile()
	{
		for(int i= 0; i<b; i++)
		System.out.print(discardPile[i]+" ");
	}
	
	//this displays the cards the players have
	public void displayPlayerCards()
	{
		for(int i= 0; i<9; i++)
			System.out.print(P1[i]+" ");
		System.out.println();
		for(int i= 0; i<9; i++)
			System.out.print(P2[i]+" ");
	}


	public char[] getP1() {
		return P1;
	}


	public void setP1(char[] p1) {
		P1 = p1;
	}


	public char[] getP2() {
		return P2;
	}


	public void setP2(char[] p2) {
		P2 = p2;
	}

		
}