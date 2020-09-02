package application;

import java.util.ArrayList;

import application.Case;

public class Player {
	private int x;
	private int y;
	private int xVel;
	private int yVel;
	private int vitesse;

	
	public Player(int posX,int posY,int vitesse) {
		this.x = posX;
		this.y = posY;
		this.vitesse = vitesse;
		this.xVel = 0;
		this.yVel = 0;
	}
	
	
	public void direction(String sens) {
		if(sens.equals("right")) {this.xVel = this.vitesse;}
		if(sens.equals("left")) {this.xVel = -this.vitesse;}
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
		}
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
}
