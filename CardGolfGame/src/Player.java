public class Player 
{
	private char[][]Board = new char [3][3];
	private char[][]Turned = new char [3][3];
	
	//this intializes all the variables to a board from a inputed array. 
	public Player(char[]b, String a)
	{
		Board[0][0] = b[0];
		Board[0][1] = b[1];
		Board[0][2] = b[2];
		Board[1][0] = b[3];
		Board[1][1] = b[4];
		Board[1][2] = b[5];
		Board[2][0] = b[6];
		Board[2][1] = b[7];
		Board[2][2] = b[8];
		
	}

	//This displays the card on the board at a certain inputed ints
	public char cardAt(int r, int c)
	{
		char x = Board [r][c];
		return x;
	}
	
	//this will check is the card is flipped at the inputed location and then prints out that card if it is
	public boolean flip(int r, int c)
	{
		if(Turned[r][c] != 'h')
		{
			Turned[r][c] = 'h';
			System.out.print(Board[r][c]);
			return true;	
		}
		else
			return false;
		
	}
	
	//this method is used to set a card to the board
	public void setTo(int r, int c, char card)
	{
		Board[r][c] = card;	
	}
	
	//this will make all the values in the Turned[] to 'h', meaning that everything can be turned as everything has been uncovered
	public void turnALL()
	{
		Turned[0][0] = 'h';
		Turned[0][1] = 'h';
		Turned[0][2] = 'h';
		Turned[1][0] = 'h';
		Turned[1][1] = 'h';
		Turned[1][2] = 'h';
		Turned[2][0] = 'h';
		Turned[2][1] = 'h';
		Turned[2][2] = 'h';
	}
	
	//will check if card has been turned
	public boolean isTurned(int r, int c)
	{
		if(Turned[r][c] == 'h')
		{
			return true;
		}
		else
			return false;
	}
	
	//the place holde 'h' is added to a seperate array to show that the card has been flipped
	public void turn(int r, int c)
	{
		Turned[r][c] = 'h';
	}
	
	
	//will check if all have been turned by checking if every value in the array is 'h'
	public boolean allTurned()
	{
		if(Turned[0][0] == 'h' && Turned[0][1] == 'h'&& Turned[0][2] == 'h'&& Turned[1][0] == 'h'&& Turned[1][1] == 'h'&& Turned[1][2] == 'h'&& Turned[2][0] == 'h'&& Turned[2][1] == 'h'&& Turned[2][2] == 'h')
		{
			return true;
		}
		else
			return false;
	}
	
	//this will display board based on if the user has already uncovered the card or not
	public void displayBoard()
	{
		if (Turned[0][0] == 'h')
			System.out.print(Board[0][0]+" ");
		else
			System.out.print("* ");
		
		if (Turned[0][1] == 'h')
			System.out.print(Board[0][1]+" ");
		else
			System.out.print("* ");
		
		if (Turned[0][2] == 'h')
			System.out.println(Board[0][2]);
		else
			System.out.println("*");
		
		if (Turned[1][0] == 'h')
			System.out.print(Board[1][0]+" ");
		else
			System.out.print("* ");
		
		if (Turned[1][1] == 'h')
			System.out.print(Board[1][1]+" ");
		else
			System.out.print("* ");
		
		if (Turned[1][2] == 'h')
			System.out.println(Board[1][2]);
		else
			System.out.println("*");
		
		if (Turned[2][0] == 'h')
			System.out.print(Board[2][0]+" ");
		else
			System.out.print("* ");
		
		if (Turned[2][1] == 'h')
			System.out.print(Board[2][1]+" ");
		else
			System.out.print("* ");
		
		if (Turned[2][2] == 'h')
			System.out.println(Board[2][2]);
		else
			System.out.println("*");
	
	}
	
	
	//this one calculates the points 
	public int CalculatePts()
	{
		char c = 0;
		int pts = 0,x = 0;
		
		//these if statements will change the value of x spots if they are in a row
		if (Board[0][0] == Board[0][1] && Board[0][2] == Board[0][0])
		{	
			Board[0][0]='0';
			Board[0][1]='0';
			Board[0][2]='0';
		}	
		
		if (Board[1][0] == Board[1][1] && Board[1][2] == Board[1][0])
		{	
			Board[1][0]='0';
			Board[1][1]='0';
			Board[1][2]='0';
		}	
			
		if (Board[2][0] == Board[2][2] && Board[2][2] == Board[2][1])
		{	
			Board[2][0]='0';
			Board[2][1]='0';
			Board[2][2]='0';
		}	
		
		if (Board[0][0] == Board[1][0] && Board[2][0] == Board[0][0])
		{	
			Board[0][0]='0';
			Board[1][0]='0';
			Board[2][0]='0';
		}	
		
		if (Board[0][1] == Board[1][1] && Board[0][1] == Board[2][1])
		{	
			Board[0][1]='0';
			Board[1][1]='0';
			Board[2][1]='0';
		}	
			
		if (Board[0][2] == Board[1][2] && Board[2][2] == Board[1][2])
		{	
			Board[0][2]='0';
			Board[1][2]='0';
			Board[2][2]='0';
		}	
		
		if (Board[0][0] == Board[1][1] && Board[0][0] == Board[2][2])
		{	
			Board[0][0]='0';
			Board[1][1]='0';
			Board[2][2]='0';
		}	
			
		if (Board[0][2] == Board[1][1] && Board[0][2] == Board[2][0])
		{	
			Board[0][2]='0';
			Board[1][1]='0';
			Board[2][0]='0';
		}	
		
		//integrated for loops. q is the row, i the column. when i reaches max q increases by one and i increases again.
		//loops stops when q reaches max
		for(int q = 0; q<3; q++)
		{	
			for(int i = 0; i<3; i++)
			{
				c = Board[q][i];
			    
				switch(c)
			    {
			    	  case '0': 
			    		  		x=0;
			    		  		break;
				      case 'A': 
				    	  		x=1;
				    	  		break;
				      case '2': 
				    	  		x=2;
				    	  		break;
				      case '3': 
				    	  		x=3;
				    	  		break;
				      case '4': 
				    	  		x=4;
				    	  		break;
				      case '5': 
				    	  		x=5;
				    	  		break;
				      case '6': 
				    	  		x=6;
				    	  		break;
				      case '7': 
				    	  		x=7;
				    	  		break;
				      case '8': 
				    	  		x=8;
				    	  		break;
				      case '9': 
				    	  		x=9;
				    	  		break;
				      case 'T': 
				    	  		x=10;
				    	  		break;
				      case 'J': 
				    	  		x=10;
				    	  		break;
				      case 'Q': 
				    	  		x=10;
				    	  		break;
				      case 'K': 
				    	  		x=0;
				    	  		break;
				      case '?': 
				    	  		x=-5;
				    	  		break;
			    }
			    
				pts+=x;
			}	
		}
		return pts;
	}
	
}
