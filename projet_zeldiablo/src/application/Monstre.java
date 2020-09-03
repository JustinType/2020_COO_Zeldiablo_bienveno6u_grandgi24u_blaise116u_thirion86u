package application;

public class Monstre {
	
	private int x,y;
	
	public Monstre(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void deplacerMonstre(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
