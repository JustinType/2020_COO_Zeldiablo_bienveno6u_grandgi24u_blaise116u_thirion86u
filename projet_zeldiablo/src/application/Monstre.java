package application;

public class Monstre {
	
	private int x,y;
	
	public Monstre(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void deplacerMonstre(String dir) {
		if(dir.equals("right")) {
			for(int i = 0; i < 180; i++) {
				this.x--;
			}
		}else {
			for(int i = 0; i < 180; i++) {
				this.x++;
			}
		}
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
