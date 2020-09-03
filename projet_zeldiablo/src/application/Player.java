package application;

import java.util.ArrayList;

public class Player {
	private int vie;
	private int x;
	private int y;
	private int xVel;
	private int yVel;
	private int vitesse;
	private boolean gagne;
	private String direction;
	private Effect effet;
	private boolean piege;
	private boolean shrek;
	
	public Player(int posX,int posY,int vitesse) {
		this.x = posX;
		this.y = posY;
		this.vitesse = vitesse;
		this.xVel = 0;
		this.yVel = 0;
		this.setVie(10);
		this.direction="megaman";
		this.piege=false;
		this.setShrek(false);
	}
	
	
	public void direction(String sens) {
		if(sens.equals("right")) {this.xVel = this.vitesse;this.direction="droite";}
		if(sens.equals("left")) {this.xVel = -this.vitesse;this.direction="gauche";}
		if(sens.equals("up")) {this.yVel = -this.vitesse;}
		if(sens.equals("down")) {this.yVel = this.vitesse;}	
		
	}
	
	public void seDeplacer(ArrayList<Case> c) {	
			if(this.xVel != 0) { deplacerAxe(c,this.xVel,0);}
			if(this.yVel != 0) { deplacerAxe(c,0,this.yVel);}
	}

	public boolean collision(Case c,int xv,int yv) {
		return ((this.x  + xv -30 < c.getX()) && 
				(this.x  + xv +30 > c.getX()) &&
				(this.y + yv -30< c.getY()) && 
				(this.y + yv +30> c.getY()));}
		
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
				c.setSprite("case_5_4");
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
	
	public void doEffect() {
		if (effet != null) {
			System.out.println("effet");
			if(this.effet.increseTime()) {	
				this.vitesse = this.effet.getVitesse();
			}else {
				this.effet = null;
				this.vitesse = 3;
			}}
		}
	
	
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public void reduceVel() {
		if (this.xVel > 0) {this.xVel-=1;}
		if (this.xVel < 0) {this.xVel+=1;}
		if (this.yVel > 0) {this.yVel-=1;}
		if (this.yVel < 0) {this.yVel+=1;}
		
	}
	
	public boolean getGagne() {
		return this.gagne;
	}


	public int getVie() {
		return vie;
	}


	public void setVie(int vie) {
		this.vie = vie;
	}
	
	public String getDirection() {
		return this.direction;
	}
	

	public boolean getPiege() {
		return this.piege;
	}
	
	public void setPiege(boolean p) {
		this.piege=p;
	}


	public boolean isShrek() {
		return shrek;
	}


	public void setShrek(boolean shrek) {
		this.shrek = shrek;
	}
}