package othelo;

public class Board {
private int BoardArraySize=8;
private int BoardArray[][];
private int cellfilled;
int count;
private int player1Symbol;
private int player2Symbol;
private String P1;
private String P2;
Board(int Symbol1,int Symbol2,String P1,String P2)
{	this.P1=P1;
	this.P2=P2;
	player1Symbol=Symbol1;
	player2Symbol=Symbol2;
	cellfilled=4;
	BoardArray=new int[BoardArraySize][BoardArraySize];
	BoardArray[3][3] = player1Symbol;
	BoardArray[3][4] = player2Symbol;
	BoardArray[4][3] = player2Symbol;
	BoardArray[4][4] = player1Symbol;
	
	
}
void result()
{
	if(count==32)
		System.out.println("DRAW!!");
	else if(count>32)
		System.out.println(P1+" wins!!");
	else
		System.out.println(P2+" wins");
}
private void print_cell_filled()
{	
	 count=0;
	for(int i=0;i<8;i++)
	{
		for(int j=0;j<8;j++)
		{
			if(BoardArray[i][j]==player1Symbol)
				count++;
		}
	}
	System.out.println("Number of "+player1Symbol+"'s:"+count);
	System.out.println("Number of "+player2Symbol+"'s:"+(cellfilled-count));
}
public void print() {
	
	for(int i=0;i<BoardArraySize*5;i++)
	{
		System.out.print("-");
	}
	System.out.print("----");
	System.out.println();
	System.out.print("    ");
	for(int i=0;i<BoardArraySize;i++)
	{
		System.out.print((i+1)+"    ");
	}
	System.out.println();
	for(int i=0;i<BoardArraySize*5;i++)
	{
		System.out.print("-");
	}
	System.out.print("----");
	System.out.println();
	for(int i=0;i<BoardArraySize;i++)
	{System.out.print(i+1+" ");
		for(int j=0;j<BoardArraySize;j++)
		{	
			System.out.print("| "+BoardArray[i][j]+" |");
		}
		System.out.print(" "+(i+1));
		System.out.println();
	}
	for(int i=0;i<BoardArraySize*5;i++)
	{
		System.out.print("-");
	}
	System.out.print("----");
	System.out.println();
	System.out.print("    ");
	for(int i=0;i<BoardArraySize;i++)
	{
		System.out.print((i+1)+"    ");
	}
	System.out.println();
	for(int i=0;i<BoardArraySize*5;i++)
	{
		System.out.print("-");
	}
	System.out.print("----");
	System.out.println();
	print_cell_filled();
	
}
public boolean handle(int symbol,int x, int y) 
	{
		x=x-1;
		y=y-1;
		if(x<0||x>8||y<0||y>8||BoardArray[x][y]!=0)
	        return false;
	    int posX[]={-1,-1,0,1,1,1,0,-1};
	    int posY[]={0,1,1,1,0,-1,-1,-1};
	    boolean check=false;
	    //int symbol2=(symbol==player1Symbol)?player2Symbol:player1Symbol;
	    for(int i=0;i<8;i++)
	    {
	      boolean check_everyLoop=false;
	      int varX=posX[i];
	      int varY=posY[i];
	      int newX=x+varX;
	      int newY=y+varY;
	      if(newX<0||newX>7||newY<0||newY>7)
	        continue;
	      else if(BoardArray[newX][newY]==0)
	        continue;
	      else if(BoardArray[newX][newY]==symbol)
	        continue;
	      while(newX>0&&newX<8&&newY>0&&newY<8&&BoardArray[newX][newY]!=symbol&&BoardArray[newX][newY]!=0)
	      {
	        newX=newX+varX;
	       newY=newY+varY;
	      }
	      if(newX>0&&newX<8&&newY>0&&newY<8&&BoardArray[newX][newY]==symbol)
	      {
	        check=true;
	        check_everyLoop=true;
	      }
	      while(check_everyLoop&&(newX!=x||newY!=y))
	      {
				newX=newX-varX;
	       newY=newY-varY;
	        BoardArray[newX][newY]=symbol;
	      }
	    }
	    if(check)
	    {
	    	cellfilled++;
	    	if(cellfilled==64)
	    	{
	    		print();
	    		
	    	}
	    }
	    return check;
	}
}
