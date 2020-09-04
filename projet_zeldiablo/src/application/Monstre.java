package application;

import moteurJeu.sprite.Sprites;

// TODO: Auto-generated Javadoc
/**
 * The Class Monstre.
 */
public class Monstre {

	/** The y. */
	private int x,y;
	
	/** The sens. */
	private String sens;

	/**
	 * Instantiates a new monstre.
	 *
	 * @param x the x
	 * @param y the y
	 * @param n the n
	 */
	public Monstre(int x, int y, String n) {
		if(n.equals("H")) {
			sens = "left";
		}else {
			sens = "up";
		}
		this.x = x;
		this.y = y;
	}

	/**
	 * Deplacer monstre horizontale.
	 *
	 * @param x1 the x 1
	 * @param x2 the x 2
	 */
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
	
	/**
	 * Deplacer monstre verticale.
	 *
	 * @param y1 the y 1
	 * @param y2 the y 2
	 */
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

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return this.y;
	}
}
