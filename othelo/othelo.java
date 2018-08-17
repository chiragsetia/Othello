package othelo;

import java.util.Scanner;
class othello {

	Player P1,P2;
	Board board;
	private Scanner scanner;
	public othello()
	{
		play();
	}
	private void play() 
	{
		P1=data(1);
		P2=data(2);
		Scanner input=new Scanner(System.in);
		while(P1.getName().equals(P2.getName())||P1.getSymbol()==P2.getSymbol())
		{
			if(P1.getName().equals(P2.getName()))
			{
				
				System.out.println("Name already excited"+"\n"+"Enter new name for player 2");
				String name=input.nextLine();
				P2.setName(name);
			}
			else
			{
				System.out.println("Symbol already excited"+"\n"+"Enter new Symbol for player 2");
				int symbol=input.nextInt();
				P2.setSymbol(symbol);
			}
				
		}
		int n=64;
		board=new Board(P1.getSymbol(),P2.getSymbol(), P1.getName(), P2.getName());
		boolean player_1=true;
		board.print();
		while(n>0)
		{
			
			
			boolean ans = false;
			if(player_1) {
				System.out.println(P1.getName()+" with Symbol:"+P1.getSymbol()+" turns.");
				int x = input.nextInt();
				int y = input.nextInt();
				
				ans = board.handle(P1.getSymbol(), x, y);
			}
			else {
				System.out.println(P2.getName()+" with Symbol:"+P2.getSymbol()+" turns.");
				int x = input.nextInt();
				int y = input.nextInt();
				ans = board.handle(P2.getSymbol(), x, y);
			}
			if(ans) {
				n--;
				if(n!=0)
					board.print();	
				
				player_1=!player_1;
				
			}
			else {
				System.out.println("INVALID CHOICE \nEnter Again");
			}
		}
		input.close();
	}
	private Player data(int n)
	{
		System.out.println("Enter the name of player "+n);
		scanner = new Scanner(System.in);
		String name=scanner.nextLine();
		System.out.println("Enter the Symbol(Integer only) for player "+n);
		int Symbol=scanner.nextInt();
		//input.close();
		return(new Player(name,Symbol));
	}
}
