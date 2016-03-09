import java.util.Random;
import java.util.Scanner;

public class BlackJack_Assignment {
	String type;
	int currentcard;
	int total =0;
	static int dealerTotal =0;
	static int playerTotal =0;
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	public BlackJack_Assignment(String Player){
		 type =Player;
			System.out.println("Game started");
			GameDeal();
			gameFinal();
	}
	void GameDeal(){
		System.out.println("first card");
		displayCard();
		System.out.println("Second card");
		displayCard();
		
	}
	void displayCard()
	{
		 currentcard = ran.nextInt(14);
		 while (currentcard == 0)
		 {
			 currentcard = ran.nextInt(14);
		 }
		 switch (currentcard)
		 {
		 case 1:
			 System.out.println(type + " Draw a jack");
			 total = total + 10;
			 System.out.println(type + "Current Total" +   "\t"+ total);
			 break;
		 case 2 :
			 System.out.println(type + " Draw a queen");
			 total = total + 10;
			 System.out.println(type + "Current Total" + "\t"+   total);
			 break;
		 case 3 :	 
			 System.out.println(type + " Draw a king");
			 total = total + 10;
			 System.out.println(type + "Current Total" +  "\t"+  total);
			 break;	
		 case 4:
			 System.out.println(type + " Draw a ace");
			 total = total + 11;
			 System.out.println(type + "Current Total" +  "\t"+  total);
			 break;
			 default:
				 System.out.println(type + " Draw a" + "\t"+ currentcard);
				 total = total + currentcard;
				 System.out.println(type + "current total"+ "\t" + total);
		 }
	}
	void gameFinal()
	{
		if(total <= 21)
		{
			if(!(type.equals("dealer")))
			{
				System.out.println("would you like to continue(yes)");
				if(scan.nextLine().equals("yes"))
				{
					displayCard();
					gameFinal();
				}
				else
				{
					System.out.println("Your total:" + "\t"+ total);
					playerTotal = total;
				}
			}
			
		}
		else
		{
			System.out.println(type + "Busted :"  + total);
			
		}
		if(type.equals("dealer"))
		{
			if((total <17 && total < 21 ) || total < playerTotal)
			{
				displayCard();
				gameFinal();
			}
			else
			{
				dealerTotal = total;
			}
		}
	}
	void winner()
	{
		
		 if((dealerTotal >21)&&(playerTotal > 21))
		{
			System.out.println("Dealer busted");
			System.out.println("Player busted");
			System.out.println("Draw");
		}
		 else if(dealerTotal > 21)
		{
			System.out.println("Dealer busted");
			System.out.println("player won");
		}
		else if(dealerTotal > playerTotal)
		{
			System.out.println("Dealer won");
		}
		else if(dealerTotal < playerTotal)
		{
			System.out.println("Player Won");
		}
		else if(dealerTotal == playerTotal)
		{
			System.out.println("Draw");
		}
		
		
	}
	public static void main(String Args[])
	{
		BlackJack_Assignment hello = new BlackJack_Assignment("hello");
		BlackJack_Assignment dealer = new BlackJack_Assignment("dealer");
		hello.winner();
	}

}
