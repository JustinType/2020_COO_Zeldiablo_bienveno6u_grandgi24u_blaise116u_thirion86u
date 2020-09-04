package application;

// TODO: Auto-generated Javadoc
/**
 * The Class Case.
 */
public abstract class Case {
	
	/** The x. */
	public int x;
	
	/** The y. */
	public int y;
	
	/** The sprite. */
	public String sprite;
	
	/** The rempli. */
	public boolean rempli;
	
	/**
	 * Instantiates a new case.
	 *
	 * @param x the x
	 * @param y the y
	 * @param rempli the rempli
	 */
	public Case(int x, int y, boolean rempli)
	{
		this.x = x;
		this.y = y;
		this.rempli = rempli;
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX(){return this.x;}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY(){return this.y;}
	
	/**
	 * Gets the sprite.
	 *
	 * @return the sprite
	 */
	public String getSprite() {return this.sprite;}
	
	/**
	 * Sets the sprite.
	 *
	 * @param sprite the new sprite
	 */
	public void setSprite(String sprite) {this.sprite = sprite;}
	
	/**
	 * Gets the rempli.
	 *
	 * @return the rempli
	 */
	public boolean getRempli() { return this.rempli; }
	
	/**
	 * Sets the rempli.
	 *
	 * @param rempli the new rempli
	 */
	public void setRempli(boolean rempli) {this.rempli = rempli;}

}
