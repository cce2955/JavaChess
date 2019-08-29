
public class mainExec {

	public static void main(String[] args) {
		System.out.println("Hi, Ready to start? Setting up board");
		int x,y;
		for (x = 0, y = 0; y < 8;)
			{
				System.out.print("[]");
				++x;
				if (x >= 8)
				{
					++y;
					System.out.println("");
					x = 0;
				}
			}
		x = 0;
		y = 0; //Resetting X and Y to make pieces stay in a default coordinate
		
		//Pieces pawn[x] = new Pieces();
		//-----------------------------------------
		//Upload to this github like now (8/28/2019 8PM EST )
		//Had no idea how to spawn an array for objects but here we are
		//Also a good chance to practice merging branches
		Pieces []pawn = new Pieces[16];
		//------------------------------------------
		pawn[x] = new Pieces();
		for (x = 0; x < 16; x++)
			{
				
				pawn[x].setIndex(x);
			}
	}
}
