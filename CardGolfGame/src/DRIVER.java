import java.util.Scanner;
public class DRIVER 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);

		//Welcome message to user
		System.out.println("---------------------WELCOME---------------------");
		System.out.println();
		
		//Asking name inputs
		System.out.println("What is the name of 1st player: ");
		String Player1 = in.next();
		System.out.println();
		System.out.println("What is the name of 2nd player: ");
		String Player2 = in.next();
		System.out.println();
		System.out.println();
		
		//declaring object from DeckAndDiscard class
		DeckAndDiscard a = new DeckAndDiscard();
		
		//objects froom Player class
		Player one = new Player(a.getP1(), Player1);
		Player two = new Player(a.getP2(), Player2);
		
		
		//asking user 1 to flip card
		System.out.print(Player1 +" time to decide which 2 cards you want to turn over \nWhich card do you want to flip (row col): ");
		int row1 = in.nextInt(); int col1 = in.nextInt();
		
		//checking for valid input	
		while(row1>=3 || row1<0|| col1>=3 || col1<0)
		{
			System.out.print("Please choose a valid card: ");
			row1 = in.nextInt(); col1 = in.nextInt();
			System.out.println();
		}
		
		//to make sure a valid card has been inputed
		while(one.isTurned(row1, col1) == true || row1>=3 || row1<0|| col1>=3 || col1<0)
		{
			System.out.print("Please choose a valid card: ");
			row1 = in.nextInt(); col1 = in.nextInt();	
			System.out.println();
		}
		
		one.turn(row1, col1);
		
		System.out.print("Which card do you want to flip (row col): ");
		row1 = in.nextInt(); col1 = in.nextInt();
		
		//valid input check
		while(row1>=3 || row1<0|| col1>=3 || col1<0)
		{
			System.out.print("Please choose a valid card: ");
			row1 = in.nextInt(); col1 = in.nextInt();
			System.out.println();
		}
		
		//loop to assure user is inputing a un-turned and valid card
		while(one.isTurned(row1, col1) == true || row1>=3 || row1<0|| col1>=3 || col1<0)
		{
			System.out.print("Please choose a valid card: ");
			row1 = in.nextInt(); col1 = in.nextInt();	
		}
		
		one.turn(row1, col1);
		System.out.println();
		
		//asking user 2 to flip card
		System.out.print(Player2 +" time to decide which 2 cards you want to turn over \nWhich card do you want to flip (row col): ");
		row1 = in.nextInt(); col1 = in.nextInt();
		
		//make sure user inputs a valid input
		while(row1>=3 || row1<0|| col1>=3 || col1<0)
		{
			System.out.print("Please choose a valid card: ");
			row1 = in.nextInt(); col1 = in.nextInt();
			System.out.println();
		}
		
		
		//to make sure a valid card has been inputed
		
		while(row1>=3 || row1<0|| col1>=3 || col1<0)
		{
			System.out.print("Please choose a valid card: ");
			row1 = in.nextInt(); col1 = in.nextInt();
			System.out.println();
		}
		
		
		while(two.isTurned(row1, col1) == true|| row1>=3 || row1<0|| col1>=3 || col1<0)
		{
			System.out.print("Please choose a un-turned card: ");
			row1 = in.nextInt(); col1 = in.nextInt();	
		}
		
		two.turn(row1, col1);
		
		System.out.print("Which card do you want to flip (row col): ");
		row1 = in.nextInt(); col1 = in.nextInt();
		
		//to make sure a valid card has been inputed
		
		while(row1>=3 || row1<0|| col1>=3 || col1<0)
		{
			System.out.print("Please choose a valid card: ");
			row1 = in.nextInt(); col1 = in.nextInt();
			System.out.println();
		}
		
		while(two.isTurned(row1, col1) == true|| row1>=3 || row1<0|| col1>=3 || col1<0)
		{
			System.out.print("Please choose a un-turned card: ");
			row1 = in.nextInt(); col1 = in.nextInt();	
		}
		
		two.turn(row1, col1);
		System.out.println();
		
		
		//here we pick a card from the deck and place it in the discard
		a.pickACard();
		a.discard();
		
		int x = 0;
		
		//while loop which will check if any user has a complete board
		//this will also check if the card in the deck have run out, as the unshuffled placeholder card 'D' will be the last
		while(one.allTurned() == false && two.allTurned() == false || a.onTopOfDiscard() == 'D')
		{
			
			
		
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			//Displaying the card added to the discard
			System.out.println("Discard pile has " + a.onTopOfDiscard());
			System.out.println();
			
			
			//Every loop, the value of x will increase by 1, when odd: goes to player one (if); if even, will go to player 2 (else)
			x = x+1;
			if (x%2!=0)
			{
				System.out.println("It is "+Player1+"'s turn:\n---------------\nHere is your Board: ");
				System.out.println();
				one.displayBoard();
				System.out.println();
				System.out.print("Do you want the card on the discard pile(0) or a new card(1): ");
				int ans = in.nextInt();
				
				//making sure user inputs a valid input
				while(ans != 0 && ans != 1)
				{
					System.out.print("Please input a valid input:  ");
					ans = in.nextInt();
				}
				
				//basic if or else which will determine be selecting the path the user wishes to proceed
				
				//if user wants a new card
				if(ans==1)
				{
					
					//picking out a new card
					a.pickACard();
					a.discard();
					
					//will break if there are no more cards in the deck
					if(a.onTopOfDiscard() == 'D')
						break;
					
					
					System.out.print("The card you are playing is "+a.onTopOfDiscard()+"\n\nReplace a card(0) or Toss it (1)? ");
					int toss = in.nextInt();
					
					//checking if its a valid input
					while(toss != 0 && toss != 1)
					{
						System.out.print("Please input a valid input:  ");
						toss = in.nextInt();
					}
					
					//if user wants to replace a card in their deck
					if(toss==0)
					{
						System.out.print(Player1+", do you want to replace a flipped card(0) or flip a new card(1) ");
						int replace = in.nextInt();
						
						while(replace != 0 && replace != 1)
						{
							System.out.print("Please input a valid input:  ");
							replace = in.nextInt();
						}
						
						//if user wants to flip a new card
						
						
						if(replace == 1)
						{	
							System.out.print("Which new card do you want to flip (row col): ");
							row1 = in.nextInt(); col1 = in.nextInt();
							
							//Making user inputs something valid
							
							while(row1>=3 || row1<0|| col1>=3 || col1<0)
							{
								System.out.print("Please choose a valid card: ");
								row1 = in.nextInt(); col1 = in.nextInt();
								System.out.println();
							}
								
							while(one.isTurned(row1, col1) == true || row1>=3 || row1<0|| col1>=3 || col1<0)
							{
								System.out.print("Please choose a valid card: ");
								row1 = in.nextInt(); col1 = in.nextInt();	
							}
							
							//now the card will be revealed next time we show the player's deck
							one.turn(row1, col1);
							
							//the card will be replaced without the user knowing its value
							char ha = one.cardAt(row1, col1);
							one.setTo(row1, col1, a.onTopOfDiscard());
							a.swap(ha);
									
						}
						
						//if user wants to change a already revealed card
						else if(replace == 0)
						{
							System.out.print("Which card do you want to replace (row)(col): ");
							row1 = in.nextInt(); col1 = in.nextInt();
							
							//making sure a proper input
						
							while(row1>=3 || row1<0|| col1>=3 || col1<0)
							{
								System.out.print("Please choose a valid card: ");
								row1 = in.nextInt(); col1 = in.nextInt();
								System.out.println();
							}
							
							while(one.isTurned(row1, col1) == false || row1>=3 || row1<0|| col1>=3 || col1<0)
							{
								System.out.print("Please choose a valid card: ");
								row1 = in.nextInt(); col1 = in.nextInt();	
							}
							
							char ha = one.cardAt(row1, col1);
							one.setTo(row1, col1, a.onTopOfDiscard());
							a.swap(ha);
						}
					}	
				}
				
				//if user wants the card on top of the discard pack
				else if(ans==0)
				{	
					System.out.print(Player1+", do you want to replace a flipped card(0) or flip a new card(1) ");
					int replace = in.nextInt();
					
					//checking for proper user input
					while(replace != 0 && replace != 1)
					{
						System.out.print("Please input a valid input:  ");
						replace = in.nextInt();
					}
					
					if(replace == 1)
					{	
						System.out.print("Which new card do you want to flip (row col): ");
						row1 = in.nextInt(); col1 = in.nextInt();
						
						//making sure for proper input
						while(row1>=3 || row1<0|| col1>=3 || col1<0)
						{
							System.out.print("Please choose a valid card: ");
							row1 = in.nextInt(); col1 = in.nextInt();
							System.out.println();
						}
						
						while(one.isTurned(row1, col1) == true || row1>=3 || row1<0|| col1>=3 || col1<0)
						{
							System.out.print("Please choose a valid card: ");
							row1 = in.nextInt(); col1 = in.nextInt();	
						}
						
						//makes card unhidden next round.
						one.turn(row1, col1);
						
						//replaces card
						char ha = one.cardAt(row1, col1);
						one.setTo(row1, col1, a.onTopOfDiscard());
						a.swap(ha);
								
					}
					
					else if (replace == 0)
					{
						System.out.print("Which card do you want to replace (row)(col): ");
						row1 = in.nextInt(); col1 = in.nextInt();
						
						//making sure for proper input
						while(row1>=3 || row1<0|| col1>=3 || col1<0)
						{
							System.out.print("Please choose a valid card: ");
							row1 = in.nextInt(); col1 = in.nextInt();
							System.out.println();
						}
						
						while(one.isTurned(row1, col1) == false || row1>=3 || row1<0|| col1>=3 || col1<0)
						{
							System.out.print("Please choose a valid card: ");
							row1 = in.nextInt(); col1 = in.nextInt();	
						}
						
						//replaces card
						char ha = one.cardAt(row1, col1);
						one.setTo(row1, col1, a.onTopOfDiscard());
						a.swap(ha);
					}
					
				}
			}
			
			else 
			{
				System.out.println("It is "+Player2+"'s turn:\n---------------\nHere is your Board: ");
				System.out.println();
				two.displayBoard();
				System.out.println();
				System.out.print("Do you want the card on the discard pile(0) or a new card(1): ");
				int ans = in.nextInt();
				
				//making sure user inputs a valid input
				while(ans != 0 && ans != 1)
				{
					System.out.print("Please input a valid input:  ");
					ans = in.nextInt();
				}
				
				//basic if or else which will determine be selecting the path the user wishes to proceed
				
				//if user wants a new card
				if(ans==1)
				{
					
					//picking out a new card
					a.pickACard();
					a.discard();
					

					//will break if there are no more cards in the deck
					if(a.onTopOfDiscard() == 'D')
						break;
					
					
					
					System.out.print("The card you are playing is "+a.onTopOfDiscard()+"\n\nReplace a card(0) or Toss it (1)? ");
					int toss = in.nextInt();
					
					//checking if its a valid input
					while(toss != 0 && toss != 1)
					{
						System.out.print("Please input a valid input:  ");
						toss = in.nextInt();
					}
					
					//if user wants to replace a card in their deck
					if(toss==0)
					{
						System.out.print(Player2+", do you want to replace a flipped card(0) or flip a new card(1) ");
						int replace = in.nextInt();
						
						while(replace != 0 && replace != 1)
						{
							System.out.print("Please input a valid input:  ");
							replace = in.nextInt();
						}
						
						//if user wants to flip a new card
						
						
						if(replace == 1)
						{	
							System.out.print("Which new card do you want to flip (row col): ");
							row1 = in.nextInt(); col1 = in.nextInt();
							
							//Making user inputs something valid
							while(row1>=3 || row1<0|| col1>=3 || col1<0)
							{
								System.out.print("Please choose a valid card: ");
								row1 = in.nextInt(); col1 = in.nextInt();
								System.out.println();
							}
							
							while(two.isTurned(row1, col1) == true || row1>=3 || row1<0|| col1>=3 || col1<0)
							{
								System.out.print("Please choose a valid card: ");
								row1 = in.nextInt(); col1 = in.nextInt();	
							}
							
							//now the card will be revealed next time we show the player's deck
							two.turn(row1, col1);
							
							//the card will be replaced without the user knowing its value
							char ha = two.cardAt(row1, col1);
							two.setTo(row1, col1, a.onTopOfDiscard());
							a.swap(ha);
									
						}
						
						//if user wants to change a already revealed card
						else if(replace == 0)
						{
							System.out.print("Which card do you want to replace (row)(col): ");
							row1 = in.nextInt(); col1 = in.nextInt();
							
							//making sure a proper input
							while(row1>=3 || row1<0|| col1>=3 || col1<0)
							{
								System.out.print("Please choose a valid card: ");
								row1 = in.nextInt(); col1 = in.nextInt();
								System.out.println();
							}
							
							while(two.isTurned(row1, col1) == false || row1>=3 || row1<0|| col1>=3 || col1<0)
							{
								System.out.print("Please choose a valid card: ");
								row1 = in.nextInt(); col1 = in.nextInt();	
							}
							
							char ha = two.cardAt(row1, col1);
							two.setTo(row1, col1, a.onTopOfDiscard());
							a.swap(ha);
						}
					}	
				}
				
				//if user wants the card on top of the discard pack
				else if(ans==0)
				{	
					System.out.print(Player2+", do you want to replace a flipped card(0) or flip a new card(1) ");
					int replace = in.nextInt();
					
					//checking for proper user input
					while(replace != 0 && replace != 1)
					{
						System.out.print("Please input a valid input:  ");
						replace = in.nextInt();
					}
					
					if(replace == 1)
					{	
						System.out.print("Which new card do you want to flip (row col): ");
						row1 = in.nextInt(); col1 = in.nextInt();
						
						//making sure for proper input
						while(row1>=3 || row1<0|| col1>=3 || col1<0)
						{
							System.out.print("Please choose a valid card: ");
							row1 = in.nextInt(); col1 = in.nextInt();
							System.out.println();
						}
						
						while(two.isTurned(row1, col1) == true || row1>=3 || row1<0|| col1>=3 || col1<0)
						{
							System.out.print("Please choose a valid card: ");
							row1 = in.nextInt(); col1 = in.nextInt();	
						}
						
						//makes card unhidden next round.
						two.turn(row1, col1);
						
						//replaces card
						char ha = two.cardAt(row1, col1);
						two.setTo(row1, col1, a.onTopOfDiscard());
						a.swap(ha);
								
					}
					
					else if (replace == 0)
					{
						System.out.print("Which card do you want to replace (row)(col): ");
						row1 = in.nextInt(); col1 = in.nextInt();
						
						//making sure for proper input
						while(row1>=3 || row1<0|| col1>=3 || col1<0)
						{
							System.out.print("Please choose a valid card: ");
							row1 = in.nextInt(); col1 = in.nextInt();
							System.out.println();
						}
						
						while(two.isTurned(row1, col1) == false || row1>=3 || row1<0|| col1>=3 || col1<0)
						{
							System.out.print("Please choose a valid card: ");
							row1 = in.nextInt(); col1 = in.nextInt();	
						}
						
						//replaces card
						char ha = two.cardAt(row1, col1);
						two.setTo(row1, col1, a.onTopOfDiscard());
						a.swap(ha);
					}
					
				}
		
			}
		}
		
		
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		//checking who turned all the cards
		if (one.allTurned()==true)
		{
		  System.out.print(Player1+" has turned all their cards!!!");
		}
		else if(two.allTurned()==true)
		{
		  System.out.print(Player2+" has turned all their cards!!!");
		}
		//this is to tell the user that the cards in the deck have ran out
		else if(a.onTopOfDiscard()=='D')
		{
		  System.out.print("The Deck has run out of cards!!!");
		}
		System.out.println();
		System.out.println();
		
		//turning all cards so they can be revealed
		one.turnALL();
		two.turnALL();
		
		//displaying the boards
		System.out.println(Player1+"\n----------------------");
		one.displayBoard();
		System.out.println();
		System.out.println(Player2+"\n----------------------");
		two.displayBoard();
		System.out.println();
		
		//this is to calculate the points
		int ptsOne = one.CalculatePts();
		int ptsTwo = two.CalculatePts();
		
		
		//Statement based on the games outcome.
		System.out.println("Final Scores:\n\t"+Player1+" scored "+ptsOne+"\n\t"+Player2+" scored "+ptsTwo);
		
		System.out.println();
		if (ptsOne < ptsTwo)
		{
		  System.out.print(Player1+" WINS!!!");
		}
		else if(ptsTwo < ptsOne)
		{
			  System.out.println(Player2+" WINS!!!");
		}
		
		if (ptsOne == ptsTwo)
		{
		  System.out.println("It is A TIE!");
		}
		
		System.out.println();
		System.out.println("Thanks For Playing!!!!!!");
	
		in.close();
		
	}

}
