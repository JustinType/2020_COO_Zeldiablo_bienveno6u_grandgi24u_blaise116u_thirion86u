package application;

import application.Case;

public class Player {
	private int x;
	private int y;
	private int xVel;
	private int yVel;
	private int vitesse;
	private Jeu jeu;
	
	public Player(int posX,int posY,int vitesse, Jeu j) {
		this.x = posX;
		this.y = posY;
		this.vitesse = vitesse;
		this.xVel = 0;
		this.yVel = 0;
		this.jeu = j;
	}
	
	
	public void direction(String sens) {
		if(sens.equals("right")) {this.xVel = this.vitesse;}
		if(sens.equals("left")) {this.xVel = -this.vitesse;}
		if(sens.equals("up")) {this.yVel = -this.vitesse;}
		if(sens.equals("down")) {this.yVel = this.vitesse;}	
		
	}
	
	public void seDeplacer() {
		if (!jeu.collision(this.x+this.xVel, this.y+this.yVel)) {
			this.x+= this.xVel;
			this.y+= this.yVel;
		}
		
	}

	public void Collision(Case c) {
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
