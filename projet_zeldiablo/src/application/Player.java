package application;

public class Player {
	private int x;
	private int y;
	private int vitesse;
	
	public Player(int posX,int posY,int vitesse) {
		this.x = posX;
		this.y = posY;
		this.vitesse = vitesse;
	}
	
	
	public void seDeplacer(String sens) {
		if(sens.equals("right")) {this.x += this.vitesse;}
		if(sens.equals("left")) {this.x -= this.vitesse;}
		if(sens.equals("up")) {this.y -= this.vitesse;}
		if(sens.equals("down")) {this.y += this.vitesse;}
	}
	
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	

}
