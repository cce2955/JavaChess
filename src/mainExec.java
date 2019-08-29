
public class mainExec {

	//For some reason I just like making functions and plopping them in main
	//A throwback to my javascript days
	public static void createPawns() //Creates chess Pieces

	{
		int x;
		//Pieces pawn[x] = new Pieces();
		//-----------------------------------------
		//Upload to this github like now (8/28/2019 8PM EST )
		//Had no idea how to spawn an array for objects but here we are
		//Also a good chance to practice merging branches
		Pieces []pawn = new Pieces[16]; //Spawns an empty object for Pawns
		//------------------------------------------
		
		for (x = 0; x < 16; x++)
			{
				pawn[x] = new Pieces(); 		//Make a new pawn in position x allowed by for loop
				//System.out.println(x); 		//Testing purposes
				pawn[x].setIndex(x);			//Set index for pawn, so I know pawn 1 is pawn 1 and not pawn 2 or 3 or etc.
				pawn[x].setID(1); 				//ID so I know it's a pawn, but that's redundant now, it might be good for UI purposes though
				pawn[x].setColor(0);			//Set pawns black
				
				if (x >= 8)						//After 8 pawns have been set black, start setting them white
				{
					pawn[x].setColor(1);
				
					
				}
			}
		
		
	
	}
	public static void createBoard() //Creates a board, this is more for show than anything

	{
		System.out.println("Hi, Ready to start? Setting up board");
		int x,y;
		for (x = 0, y = 0; y < 8;)
			{
				System.out.print("[]"); 				//Prints brackets
				++x; 
				if (x >= 8) 							//When a row of brackets is made, bump Y by one and make a new line, start over
				{
					++y;
					System.out.println("");
					x = 0;
				}
			}
	}
	public static void main(String[] args) {
		createBoard();
		createPawns();
			
	}
}
