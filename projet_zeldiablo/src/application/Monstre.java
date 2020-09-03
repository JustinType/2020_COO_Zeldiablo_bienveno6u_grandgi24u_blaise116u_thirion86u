package application;

import moteurJeu.sprite.Sprites;

public class Monstre {

	private int x,y;
	private String sens;

	public Monstre(int x, int y, String n) {
		if(n.equals("H")) {
			sens = "left";
		}else {
			sens = "up";
		}
		this.x = x;
		this.y = y;
	}

	public void deplacerMonstreHorizontale(int x1, int x2) {
		if(sens.equals("left")) {
			this.x--;
			if(x <= x1) {
				sens = "right";
			}
		}else {
			this.x++;
			if(x >= x2) {
				sens = "left";
			}
		}
	}
	
	public void deplacerMonstreVerticale(int y1, int y2) {
		if(sens.equals("up")) {
			this.y--;
			if(y <= y1) {
				sens = "down";
			}
		}else {
			this.y++;
			if(y >= y2) {
				sens = "up";
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
