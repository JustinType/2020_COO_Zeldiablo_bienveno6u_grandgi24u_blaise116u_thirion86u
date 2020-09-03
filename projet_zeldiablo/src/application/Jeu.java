package application;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

public class Jeu implements JeuAbstract {
	
	ArrayList<Case> cases; 
	
	int spawnX = 465;
	int spawnY = 45;
	int vitesse = 3;
	Player p1 = new Player(spawnX, spawnY, vitesse);
	private Boolean collisionEscalier = false;
	
	public Jeu() {
		// Creation du labyrinthe par defaut
		this.cases = new ArrayList<>();   
		 
		String[][] lab = { {" "," "," "," "," ","X"," "," "," ","X"," "," "," ","X"," ","X","X"," "," "," ","X"," "," "," "," "," "," ","X"},
						   {" ","X","X","X","X","X"," ","X"," ","X"," ","X"," ","X"," "," ","X"," ","X"," ","X"," ","X","X","X","X"," ","X"},
						   {" "," "," "," "," "," "," ","X"," "," "," ","X"," ","X","X"," ","X"," ","X","X","X"," ","X","X"," ","X"," "," "},
						   {"X","X"," ","X","X","X","X","X"," ","X","X","X"," "," ","X","P"," "," ","X"," "," "," "," ","X"," ","X","X"," "},
						   {" ","X"," ","X"," "," "," ","X"," "," "," ","X","X","X","X"," ","X"," "," "," ","X","X"," ","X"," "," "," "," "},
						   {" "," "," "," "," ","X","X","X","X","X"," "," "," "," ","X"," ","X","X","X","X","X"," "," "," "," ","X","X"," "},
						   {" ","X","X","X"," ","X"," "," "," ","X","X"," ","X"," ","X","X","X"," ","X"," "," "," ","X","X","X","X"," "," "},
						   {" ","X","P"," "," ","X"," ","X"," "," "," "," ","X"," "," "," "," "," "," "," ","X","X","X"," "," "," "," "," "},
						   {" ","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X","X","X"," "," "," "," "," ","X"," ","X"," "},
						   {" "," "," "," "," "," "," ","X"," "," ","X"," ","X","V"," "," ","X"," ","X","X","X"," ","X","X","X"," ","X","E"},
						   {"X","X","X"," ","X","X","X","X"," ","X","X"," ","X","X","X"," ","X"," "," "," ","X"," "," "," "," "," ","X"," "},
						   {" "," ","X"," ","X"," "," "," "," "," "," "," "," "," ","X"," ","X"," ","X"," ","X","X","X","X"," ","X","X"," "},
						   {" ","X","X"," ","X"," ","X","X","X"," ","X","X","X"," ","X"," "," "," ","X","X","X"," "," ","X"," "," ","X"," "},
						   {" "," ","X"," ","X"," ","X"," "," "," ","X"," "," "," ","X"," ","X"," "," "," "," "," "," ","X","X","X","X"," "},
						   {" "," "," "," "," "," ","X"," ","X","X","X","X","X","X","X"," ","X","X","X","X","X","X"," ","X"," "," "," "," "},
						   {" ","X"," "," ","X"," ","X"," "," "," "," "," ","X"," "," "," "," "," ","X"," "," "," "," ","X"," "," ","X"," "},
						   {" ","X","X","X","X"," ","X"," ","X","X","X"," ","X"," ","X","X","X"," ","X","X","X"," ","X","X","X","X","X"," "},
						   {" "," "," "," ","X"," "," "," ","X"," "," "," "," "," ","X"," "," "," "," "," ","X"," "," "," "," "," "," "," "}
						   
						   
						  };
		
		for (int i=0; i<18 ; i++) {
			for (int j = 0 ; j<28; j++) {
				if (lab[i][j].equals("X")) {
					this.cases.add(new Mur(((j+1)*30)+15, ((i+1)*30)+15));
				} else if(lab[i][j].equals("E")) {
					this.cases.add(new Escalier(((j+1)*30)+15, ((i+1)*30)+15));
				} else if(lab[i][j].equals("P")) {
					this.cases.add(new Piege(((j+1)*30)+15, ((i+1)*30)+15));
				}
				else if(lab[i][j].contentEquals("V")) {
					this.cases.add(new Victoire(((j+1)*30)+15,((i+1)*30)+15));
				}
			}
		}
		
		for (int y=15; y<600 ; y+=30) {
			this.cases.add(new Mur(15, y));
		}
		for (int y=15; y<600 ; y+=30) {
			this.cases.add(new Mur(885, y));
		}
		for (int i=15; i<900 ; i+=30) {
			this.cases.add(new Mur(i, 15));
		}
		for (int i=15; i<900 ; i+=30) {
			this.cases.add(new Mur(i, 585));
		}
		
	}
	
	
	@Override
	public String evoluer(CClavier clavier, CSouris souris) {
		if(this.p1.getX() > 840 && this.p1.getX() < 870) {
			if(this.p1.getY() > 300 && this.p1.getY() < 330) {
				this.collisionEscalier = true;
			}else {
				this.collisionEscalier = false;
			}
		}else {
			this.collisionEscalier = false;
		}
		if(clavier.isPressed(KeyEvent.VK_RIGHT)) {
			p1.direction("right");
		}
		if(clavier.isPressed(KeyEvent.VK_LEFT)) { 
			p1.direction("left");
		}
		if(clavier.isPressed(KeyEvent.VK_UP)) {
			p1.direction("up");
		}
		if(clavier.isPressed(KeyEvent.VK_DOWN)) {
			p1.direction("down");
		}
		p1.seDeplacer(cases);	
		p1.reduceVel();
		
		
		return ("");
	}

	@Override
	public boolean etreFini() {
		// le jeu n'est jamais fini
		return false;
	}

	public Player getPlayer() {
		return p1;
	}
	
	public ArrayList<Case> getCases() {
		return this.cases;
	}
	
	public Boolean getcollisionEscalier() {
		return this.collisionEscalier;
	}
	
}
