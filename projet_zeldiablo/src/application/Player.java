package application;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player {
	
	/** The vie. */
	private int vie;
	
	/** The x. */
	private int x;
	
	/** The y. */
	private int y;
	
	/** The x vel. */
	private int xVel;
	
	/** The y vel. */
	private int yVel;
	
	/** The vitesse. */
	private int vitesse;
	
	/** The gagne. */
	private boolean gagne;
	
	/** The direction. */
	private String direction;
	
	/** The effet. */
	private Effect effet;
	
	/** The piege. */
	private boolean piege;
	
	/** The shrek. */
	private boolean shrek;
	
	/**
	 * Instantiates a new player.
	 *
	 * @param posX the pos X
	 * @param posY the pos Y
	 * @param vitesse the vitesse
	 */
	public Player(int posX,int posY,int vitesse) {
		this.x = posX;
		this.y = posY;
		this.vitesse = vitesse;
		this.xVel = 0;
		this.yVel = 0;
		this.setVie(10);
		this.direction="";
		this.piege=false;
		this.setShrek(false);
	}
	
	
	/**
	 * Direction.
	 *
	 * @param sens the sens
	 */
	public void direction(String sens) {
		if(sens.equals("right")) {this.xVel = this.vitesse;this.direction="droite";}
		if(sens.equals("left")) {this.xVel = -this.vitesse;this.direction="gauche";}
		if(sens.equals("up")) {this.yVel = -this.vitesse;}
		if(sens.equals("down")) {this.yVel = this.vitesse;}	
		
	}
	
	/**
	 * Se deplacer.
	 *
	 * @param c the c
	 */
	public void seDeplacer(ArrayList<Case> c) {	
			if(this.xVel != 0) { deplacerAxe(c,this.xVel,0);}
			if(this.yVel != 0) { deplacerAxe(c,0,this.yVel);}
	}

	/**
	 * Collision.
	 *
	 * @param c the c
	 * @param xv the xv
	 * @param yv the yv
	 * @return true, if successful
	 */
	public boolean collision(Case c,int xv,int yv) {
		return ((this.x  + xv -30 < c.getX()) && 
				(this.x  + xv +30 > c.getX()) &&
				(this.y + yv -30< c.getY()) && 
				(this.y + yv +30> c.getY()));}
		
	/**
	 * Deplacer axe.
	 *
	 * @param cases the cases
	 * @param xv the xv
	 * @param yv the yv
	 */
	public void deplacerAxe(ArrayList<Case> cases,int xv,int yv) {
		this.x+= xv;
		this.y+= yv;
		
		for (Case c : cases) {
			if (collision(c,xv,yv) && c.getRempli()==true) {
				if (xv > 0) {this.x = c.getX()-30;}
				if (xv < 0) {this.x = c.getX()+30;}
				if (yv > 0) {this.y = c.getY()-30;}
				if (yv < 0) {this.y = c.getY()+30;}	
			}	
			else if (collision(c,xv,yv) && c.getSprite()=="case_0_2") {
				this.gagne=true;
			}
			else if (collision(c,xv,yv) && c.getSprite()=="case_12_9") {
				c.setSprite("case_6_4");
				this.vie--;
				this.piege=true;
			}
			else if (collision(c,xv,yv) && c.getSprite()=="case_2_3") {
				if (((CaseTP) c).getNumero() == 1) {
					this.x = 60;
					this.y = 60;
				} else {
					this.x = 765;
					this.y = 345;
				}
			}else if (collision(c,xv,yv) && c.getSprite()=="lent") {
				this.effet = new Effect(240,1);
			}
			else if (collision(c,xv,yv) && c.getSprite()=="rapide") {
				this.effet = new Effect(60,10);;
			}
			else if (collision(c,xv,yv) && c.getSprite()=="case_5_4") {
				this.shrek = true;
			}
		}
	}
	
	/**
	 * Do effect.
	 */
	public void doEffect() {
		if (effet != null) {
			if(this.effet.increseTime()) {	
				this.vitesse = this.effet.getVitesse();
			}else {
				this.effet = null;
				this.vitesse = 3;
			}}
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
	
	/**
	 * Reduce vel.
	 */
	public void reduceVel() {
		if (this.xVel > 0) {this.xVel-=1;}
		if (this.xVel < 0) {this.xVel+=1;}
		if (this.yVel > 0) {this.yVel-=1;}
		if (this.yVel < 0) {this.yVel+=1;}
		
	}
	
	/**
	 * Gets the gagne.
	 *
	 * @return the gagne
	 */
	public boolean getGagne() {
		return this.gagne;
	}


	/**
	 * Gets the vie.
	 *
	 * @return the vie
	 */
	public int getVie() {
		return vie;
	}


	/**
	 * Sets the vie.
	 *
	 * @param vie the new vie
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}
	
	/**
	 * Gets the direction.
	 *
	 * @return the direction
	 */
	public String getDirection() {
		return this.direction;
	}
	

	/**
	 * Gets the piege.
	 *
	 * @return the piege
	 */
	public boolean getPiege() {
		return this.piege;
	}
	
	/**
	 * Sets the piege.
	 *
	 * @param p the new piege
	 */
	public void setPiege(boolean p) {
		this.piege=p;
	}


	/**
	 * Checks if is shrek.
	 *
	 * @return true, if is shrek
	 */
	public boolean isShrek() {
		return shrek;
	}


	/**
	 * Sets the shrek.
	 *
	 * @param shrek the new shrek
	 */
	public void setShrek(boolean shrek) {
		this.shrek = shrek;
	}
	
	/**
	 * Sets the effect.
	 *
	 * @param e the new effect
	 */
	public void setEffect(Effect e) {
		this.effet = e;
	}
	
	/**
	 * Gets the vitesse.
	 *
	 * @return the vitesse
	 */
	public int getvitesse() {
		return this.vitesse;
	}
}