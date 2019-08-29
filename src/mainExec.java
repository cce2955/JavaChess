
public class mainExec {

	//For some reason I just like making functions and plopping them in main
	//A throwback to my javascript days
	
	//--------------------------------------------------------------------------------
	//Spawns all the pieces, bound is set to 32 so each piece gets its own ID, this will become a mess later
	//Thankfully everything is grouped by type so this is where IDs come in
	//by checking IDs I can keep track of types so I can push them to either side of the board slightly easier
	static Pieces []pawn = new Pieces[32]; 			//Spawns an empty object for Pawns
	static Pieces []rook = new Pieces[32]; 			//Spawns an empty object for Rooks
	static Pieces []bishop = new Pieces[32]; 		//Spawns an empty object for Bishops
	static Pieces []knight = new Pieces[32]; 		//Spawns an empty object for Knights
	static Pieces []king = new Pieces[32]; 			//Spawns an empty object for Kings
	static Pieces []queen = new Pieces[32];			//Spawns an empty object for Queens
	
	public static void createPieces(){ //Creates chess Pieces
		int x;
		//Pieces pawn[x] = new Pieces();
		//-----------------------------------------
		//Upload to this github like now (8/28/2019 8PM EST )
		//Had no idea how to spawn an array for objects but here we are
		//Also a good chance to practice merging branches
		/*Pieces []pawn = new Pieces[16]; 		//Spawns an empty object for Pawns
		Pieces []rook = new Pieces[4]; 			//Spawns an empty object for Rooks
		Pieces []bishop = new Pieces[4]; 		//Spawns an empty object for Bishops
		Pieces []knight = new Pieces[4]; 		//Spawns an empty object for Knights
		Pieces []king = new Pieces[2]; 			//Spawns an empty object for Kings
		Pieces []queen = new Pieces[2];			//Spawns an empty object for Queens*/
		//------------------------------------------
		//16+4+4+4+2+2 = 32, thanks for coming to my ted talk
		
		//For some reason bishops have dominated all bounds above their limits, so bug fixing is on that right now 8/28/2019 10:25
		//Bishop bug fixed 8/28/2019 10:33
		//All pieces spawn correctly, they're grouped by IDs
			for (x = 0; x < 32; x++)
				{
					if (x <= 16) 						//Generate Pawns as long as they're under 16
					{
						pawn[x] = new Pieces(); 		//Make a new pawn in position x allowed by for loop
						//System.out.println(x); 		//Testing purposes
						pawn[x].setIndex(x);			//Set index for pawn, so I know pawn 1 is pawn 1 and not pawn 2 or 3 or etc.
						pawn[x].setID(1); 				//ID so I know it's a pawn
						pawn[x].setColor(0);			//Set pawns black
						if (x >= 8)						//After 8 pawns have been set black, start setting them white
						{
							pawn[x].setColor(1);
						}
					}
					if (x <= 17 || x <= 20)				//Generate Rooks
						{
							rook[x] = new Pieces(); 	//Setup rooks
							rook[x].setIndex(x); 		//Gives rooks their index for positioning
							rook[x].setID(2); 			//Rook IDs
							rook[x].setColor(0); 		//Black Rooks!!!
							if (x >= 19)
							{
								rook[x].setColor(1); 	//White Rooks!!!
							}
						}
					if (x <= 21 || x <= 24)
						{
							bishop[x] = new Pieces();  	//Generate Bishops
							bishop[x].setIndex(x);		//Rook Index for positioning
							bishop[x].setID(3);			//Bishop IDs
							bishop[x].setColor(0);		//Make em Black
							if (x >= 23)
							{
								bishop[x].setColor(1);	//Make em White
							}
						}
					if (x <= 25 || x <= 28)
						{
							knight[x] = new Pieces();	//generate knights
							knight[x].setIndex(x);		//knights indices
							knight[x].setID(4);			//knights IDs	
							knight[x].setColor(0);		//Knights Whites
							if (x >= 27)
							{
								knight[x].setColor(1);	//Knacks Blacks
							}
						}
					if (x <= 29 || x <= 30)
						{
							queen[x] = new Pieces();	//Generate some queens
							queen[x].setIndex(x);		//Give em an index in the 29/30 range
							queen[x].setID(5);			//Queen IDs
							queen[x].setColor(0);		//Queens are Black!!
							if (x == 30)
							{
								queen[x].setColor(1);	//There are white queens too
							}
						}
					if (x <=31)
						{
							king[x] = new Pieces();		//Generate some Kings
							king[x].setIndex(x);		//Give em an index in the 31/32 range
							king[x].setID(6);			//Kings have an index of 6
							king[x].setColor(0);		//Kings are black
							if (x == 32)
							{
								king[x].setColor(1);	//Kings are white
							}
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
	public static void debugOutput() //Debugging function, it'll print out stuff just for checking
	{
		int x;
		//This entire function is for me to plug in at random moments, the debugger in eclipse isn't working how I'm used to
		//So I'll just activate this and waste an extra 30 minutes making sure all the variables are working correctly
		//Thanks eclipse
		
		//System.out.println("Queen ID is " + king[30].getId() + "and Index is: " + queen[2].getIndex());
		/*for (x = 0; x <= 36; x++)
		{
			System.out.println("X is at: " + x);
			while (x <= 16) 						//Generate Pawns as long as they're under 16
			{
				System.out.println("Pawn Stats, ID: " + pawn[x].getId() + " index: " + pawn[x].getIndex() + " color:" + pawn[x].getColor());
				++x;
			}
			while (x <= 17 || x <= 20)				//Generate Rooks
			{
				System.out.println("Rook Stats, ID: " + rook[x].getId() + " index: " + rook[x].getIndex() + " color:" + rook[x].getColor());
				++x;
			}
			while (x <= 21 || x <= 24)
			{
				System.out.println("Bishop Stats, ID: " + bishop[x].getId() + " index: " + bishop[x].getIndex() + " color:" + bishop[x].getColor());
				++x;
			}
			while (x <= 25 || x <= 28)
			{
				System.out.println("Knight Stats, ID: " + knight[x].getId() + " index: " + knight[x].getIndex() + " color:" + knight[x].getColor());
				++x;
			}
			while (x <= 29 || x <= 30)
			{
				System.out.println("queen Stats, ID: " + queen[x].getId() + " index: " + queen[x].getIndex() + " color:" + queen[x].getColor());
				++x;
			}
			while (x <= 31)
			{
				System.out.println("king Stats, ID: " + king[x].getId() + " index: " + king[x].getIndex() + " color:" + king[x].getColor());
				++x;
				
			}
			
		}*/
	}
	public static void main(String[] args) {
		createBoard();
		createPieces();
		debugOutput();
			
	}
	
}
