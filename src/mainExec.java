//Main file for my project, all main stuff goes here
//I'm gonna go ahead and do a post mortem now because there's so much I could've done better
//First off those pieces in mainExec that I spawned, I could've kept them much simpler
//Instead of spawning rook at 17 or so, coulda started over at 1
//Same with everything else, glad I got things to work as they did anyway.
//On top of this, the board is spawned in a row, which technically makes sense
//but it could be better by spawning a 2D matrix [x][y] instead of a single array [x]
//That way I could've taken advantage of the posX, posY system I set up
//Even better some pen and paper documentation would be nice, for my next at home project
//I'll attempt to do that, I have a list of projects I can work on and would love to get more experience

public class mainExec {

	/*
	 * 
	 */
	
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
	//----------------------------------------------------------------------------------
	static int xCounter = 0; //I did my for loop wrong or maybe not the proper way
	//The xCounter monitors how many X values have been accounted for in the x loop so it can match up with posX and posY and show 
	//where the piece should be
	static String[] boardSpots = new String[80]; //An array that stores where all the pieces of the board are
	
	
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
		/*
		 * ID Codes:
		 * 1 Pawn
		 * 2 rook
		 * 3 bishop
		 * 4 knight
		 * 5 queen
		 * 6 king
		 */
			for (x = 0; x < 32; x++)
				{
					if (x <= 15) 						//Generate Pawns as long as they're under 16
					{
						pawn[x] = new Pieces(); 		//Make a new pawn in position x allowed by for loop
						//System.out.println(x); 		//Testing purposes
						pawn[x].setIndex(x);			//Set index for pawn, so I know pawn 1 is pawn 1 and not pawn 2 or 3 or etc.
						pawn[x].setID(1); 				//ID so I know it's a pawn
						pawn[x].getboardId("p");
						pawn[x].setColor(0);			//Set pawns black
						if (x >= 8)						//After 8 pawns have been set black, start setting them white
						{
							pawn[x].setColor(1);
						}
					}
					if (x <= 16 || x <= 19)				//Generate Rooks
						{
							rook[x] = new Pieces(); 	//Setup rooks
							rook[x].setIndex(x); 		//Gives rooks their index for positioning
							rook[x].setID(2); 			//Rook IDs
							rook[x].getboardId("r");
							rook[x].setColor(0); 		//Black Rooks!!!
							if (x >= 19)
							{
								rook[x].setColor(1); 	//White Rooks!!!
							}
						}
					if (x <= 20 || x <= 23)
						{
							bishop[x] = new Pieces();  	//Generate Bishops
							bishop[x].setIndex(x);		//Rook Index for positioning
							bishop[x].setID(3);			//Bishop IDs
							bishop[x].getboardId("b");
							bishop[x].setColor(0);		//Make em Black
							if (x >= 23)
							{
								bishop[x].setColor(1);	//Make em White
							}
						}
					if (x <= 24 || x <= 27)
						{
							knight[x] = new Pieces();	//generate knights
							knight[x].setIndex(x);		//knights indices
							knight[x].setID(4);			//knights IDs
							knight[x].getboardId("k");
							knight[x].setColor(0);		//Knights Whites
							if (x >= 27)
							{
								knight[x].setColor(1);	//Knacks Blacks
							}
						}
					if (x <= 28 || x <= 29)
						{
							queen[x] = new Pieces();	//Generate some queens
							queen[x].setIndex(x);		//Give em an index in the 29/30 range
							queen[x].setID(5);			//Queen IDs
							queen[x].getboardId("q");
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
							king[x].getboardId("K");
							king[x].setColor(0);		//Kings are black
							if (x == 32)
							{
								king[x].setColor(1);	//Kings are white
							}
						}
				}
			}
	public static void startingPosition() {//Generate the starting position, there's really no way around manually doing this.
		//After this I'll have an AI track the position of each piece
		int x = 0;
		// This sets up all the Y values of every piece
		for (x = 0; x <= 63; x++)
		{
			if (x <= 7)
				{
					pawn[x].setPosY(7);						 //Set all pawns at the bottom to the 7th space of the grid
				}
			if (x >= 8 && x <=15)
				{
					pawn[x].setPosY(1);						//Set all pawns at the top to the second line
				}
			if (x ==16 || x ==17)
				{
					rook[x].setPosY(7); 					//Repeat each line
				}
			if (x == 18 || x == 19)
				{
					rook[x].setPosY(0);
				}
			if (x == 20 || x == 21)
				{
					bishop[x].setPosY(7);
				}
			if (x == 22 || x == 23)
				{
					bishop[x].setPosY(0);
				}
			if (x == 22 || x == 23)
				{
					knight[x].setPosY(7);
				}
			if (x == 22 || x == 23)
				{
					knight[x].setPosY(0);
				}
			if (x == 22)
				{
					queen[x].setPosY(7);
				}
			if (x ==23)
				{
					queen[x].setPosY(0);
				}
			if (x == 24)
				{
					king[x].setPosY(7);
				}
			if (x ==25)
				{
					king[x].setPosY(0);
				}
		}
		//Here is where I'll initialize all pieces in their X position
		//Graph for each space is right below  this list
		//---------------------------------------------------------
		//Start Init
		pawn[0].setPosX(48);							//Initialize each pawn in their position
		pawn[1].setPosX(49);							//[] [] [] [] [] [] [] [] These pawns go above the 8th row
		pawn[2].setPosX(50);							//[57] [58] [59] [60] [61] [62] [63] [64]
		pawn[3].setPosX(51);
		pawn[4].setPosX(52);
		pawn[5].setPosX(53);
		pawn[6].setPosX(54);
		pawn[7].setPosX(55);
		for (x=8; x <= 15; x++)
		{
				pawn[x].setPosX(x); //Thank god these variables match, x equals x and all that's I ask for
		}
		rook[16].setPosX(56);
		rook[17].setPosX(63);
		rook[18].setPosX(0);
		rook[19].setPosX(7);
		bishop[20].setPosX(57);
		bishop[21].setPosX(61);
		bishop[22].setPosX(2);
		bishop[23].setPosX(5);
		knight[24].setPosX(58);
		knight[25].setPosX(62);
		knight[26].setPosX(1);
		knight[27].setPosX(6);
		queen[28].setPosX(59);
		queen[29].setPosX(3);
		king[30].setPosX(4);
		king[31].setPosX(60);
		//End Init
		//----------------------------------------------------------------------------------
		/*Graph for reference
		 * 0r	1k	2b	3Q	4K	5b 	6k 	7r
		 * 8p 	9p	10p	11p	12p	13p	14p	15p
		 * 16 	17	18	19	20	21	22	23
		 * 24	25	26	27	28	29	30	31
		 * 32	33	34	35	36	37	38	39
		 * 40	41	42	43	44	45	46	47
		 * 48p	49p	50p	51p	52p	53p	54p	55p
		 * 56r	56k	57b	58Q	59K	60b	61k	62r
		 */
		
		
		
	}
	public static void createBoard() //Creates a board, this is more for show than anything
	{
		//Shot myself in the foot here, my new strategy to get this working despite the memory hog it'll create is to create an array and store the
		//results and then print them out
		//yeah I might just do that
		System.out.println("Hi, Ready to start? Setting up board");
		int x, x2, y;
		y = 0;
		x=0;
		x2 = 0;
		xCounter = 0;
		for (x = 0; x <= 65; ++x)
		{
			boardSpots[x] = "[ ] "; //Create empty spaces on the board all across
			//Any spots taken by the pieces will be overwritten
		}
		//The board was flattened to a single row, separated by 7 cuts
		//first line has 8 spots
		//Second has 8, etc. So spot 13 would be the fifth space on the second row
		/*On second thought I'm gonna draw a grid to keep me from going insane
		 * 		/*Graph for reference
		 * 0r	1k	2b	3Q	4K	5b 	6k 	7r
		 * 8p 	9p	10p	11p	12p	13p	14p	15p
		 * 16 	17	18	19	20	21	22	23
		 * 24	25	26	27	28	29	30	31
		 * 32	33	34	35	36	37	38	39
		 * 40	41	42	43	44	45	46	47
		 * 48p	49p	50p	51p	52p	53p	54p	55p
		 * 56r	56k	57b	58Q	59K	60b	61k	62r
		 */

		
		//----------------------------------------------------------------------------------
		// Explanation of Code and some notes for my mental health
		//If PosX matches X and posY matches Y, then slap [p] in the position of X
		//so for example pawn [8], has a posX of 8 and a Y of 2
		//so if x == 8 and y == 2, then board spots [8] will have "[p] inserted
		//At least that's the theory
		//------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------
		/*	If I reach the point of no return I'll build a table here of values that match up to PosX and posY
		 * Default Positions for reference
		 * 
		 * So the below code is going to look weird let's try to break it down
		 * X will iterate to 64 integers 0-64
		 * Within each count to 64, Y will iterate 8 times
		 *X 1 (y 1,2,3,4,5,6,7,8) X 2 (y, 1,2,3,4,5,6,7,8), etc.
		 * Within these two loops, x2 will activate on a per piece basis
		 * Pawns will count to 15, rooks to 4, etc.
		 * Within these third minicounts, the third count will check the position of piece[third count] and then compare
		 * Position X and Position Y to see if they match with counting X and counting Y
		 * Basically
		 * --------------------
		 * If Piece[Third Counter].posX == X1 AND Piece[Third Counter].PosY == y
		 * Then counting X will enter the row of boardSpots[counting X] to be spawned in createBoard();
		 * ---------------------
		 *  
		 */
		
		for (x = 0; x <= 64; ++x) { //This is really ugly but here I go 
				//Iterate by X, coincides with PosX
				{
					//++xCounter; //Obsolete counter, doesn't affect anything thatI can recall, trying to tie this code together and clean it up
					for (y = 0; y < 8; ++y)
					{//Iterate by Y, coincides with posY
						for (x2 = 0; x2 <= 15; ++x2) //While X is counting up, cycle through all instances of a pawn
							{
								if (pawn[x2].getPosX() == x && pawn[x2].getPosY() == y)
									{
										boardSpots[x] = "[p] "; //If posX and PosY match, replace [] with [p]
									}
							}
						for( x2 = 16; x2 >=16 && x2 <= 19; ++x2)
							{
							
								if (rook[x2].getPosX() == x && rook[x2].getPosY() == y)
								{
									boardSpots[x] = "[r] "; //If posX and PosY match, replace with [r]
								}
							}
						
						for(x2 = 20; x2 >=20 && x2 <= 23; ++x2)
							{
								
								if (bishop[x2].getPosX() == x && bishop[x2].getPosY() == y)
								{
									boardSpots[x] = "[b] "; //If match, then [b]
								}
							}
						for(x2 = 24; x2 >=24 && x2 <= 27; ++x2)
							{
							
							if (knight[x2].getPosX() == x && knight[x2].getPosY() == y)
								{
									boardSpots[x] = "[k] "; //Match then [k]
								}
							}
						for( x2 = 28; x2 >=28 && x2 <= 29; ++x2)
							{
							
							if (queen[x2].getPosX() == x && queen[x2].getPosY() == y)
								{
									boardSpots[x] = "[Q] ";
								}
							}
						for (x2 = 30; x2 <= 31; ++x2)
							{
							
							if (king[x2].getPosX() == x && king[x2].getPosY() == y)
								{
									boardSpots[x] = "[K] ";
								}
							}
						}
					}
				}
		}
			
	
	public static void clearScreen() { //Clear the console call before postBoard() so the console won't get cluttered  
	      
		for (int i = 0; i < 50; ++i) System.out.println();  
	}  
	
	public static void postBoard()//Post the board to the console
	{
		//Call every time a move is made, this will check the position of every piece and then post it to console
		//Seems like an easy fix but it's like 1:30 AM so I'm gonna make a branch out of this and call it a night
		int x,y, counter;
		x = 0;
		y = 0;
		counter = 0;
		for (y = 0; y <= 7; ++y)//Count up in y
		{
			
			while (x <= 7)//while x is less than 8, count up on everything
			{
				System.out.print(boardSpots[counter]);
				++x;//Iterate so this loop will end
				++counter;
			}
			x = 0;//Once you leave, change x back to zero so y will iterate and we can do the loop again
			System.out.println(""); //make a new line
		}
	}
					
	
	
	public static void printBlank()
	{
		System.out.println("");
	}
	
	
	public static void main(String[] args) {
		createPieces(); 			//Create Pieces First
		startingPosition();			//Set their Position
		createBoard();				//Generate the board and set the pieces in their place.
		postBoard(); 				//Post board to console for your eyeball viewing
		//clearScreen();			//Clear the screen,a  crude method but whatever, use postBoard(); after calling
		
		
		
		
		//debugOutput();
			
	}
	
}
