package application;

public abstract class Case {
	public int x;
	public int y;
	public String sprite;
	public boolean rempli;
	
	public Case(int x, int y, boolean rempli)
	{
		this.x = x;
		this.y = y;
		this.rempli = rempli;
	}
	
	public int getX(){return this.x;}
	public int getY(){return this.y;}
	public String getSprite() {return this.sprite;}
	public boolean getRempli() { return this.rempli; }

}
