package application;

public abstract class Case {
	public int x;
	public int y;
	public String sprite;
	
	public Case(int x, int y)
	{
		this.x = x;
		this.y = y;		
	}
	
	public int getX(){return this.x;}
	public int getY(){return this.y;}
	public String getSprite() {return this.sprite;}

}
