
public class Pieces {
	private int idType;
	private int posX;
	private int posY;
	private int color;
	private int idIndex;
	private String boardId;
	
	public void chessPiece (int idType, int posX, int posY, int color, int index, String boardId)
	{
		//To make things easy I'm gonna set up chess pieces with IDs
		//1 is pawn, 2 is rook, 3 is knight, 4, is bishop, 
		//5 is queen and 6 is king
		//Colors will be by number, 0 for black or 1 for white or whatever I forget, I'll decide something I'm a one man project I do what I want.
		//Index defines the pieces individiually, if a piece has an index of 3, that piece is piece 3, even if there are 200 pawns, pawn 3 will always be
		//pawn 3
	}
	
	public String setboardId()
	{
		return this.boardId;
	}
	public void getboardId(String screenId)
	{
		this.boardId = screenId;
	}
	public int getId(){
		return this.idType;
		
	}
	public void setID(int typeID)
	{
		this.idType = typeID;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public void setPosX(int idPosX) {
		this.posX = idPosX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public void setPosY(int idPosY)
	{
		this.posY = idPosY;
	}
	public int getColor()
	{
		return this.color;
	}
	public void setColor (int idColor) {
		this.color = idColor;
	}
	
	public int getIndex() {
		return this.idIndex;
	}
	
	public void setIndex(int indexSet) {
		this.idIndex = indexSet;
	}
}
