package application;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

public class Jeu implements JeuAbstract {

	ArrayList<Case> cases, cases2; 

	int spawnX = 465;
	int spawnY = 45;
	int vitesse = 3;
	Player p1 = new Player(spawnX, spawnY, vitesse);
	private Boolean collisionEscalier = false; 
	private Boolean etremonter = false;
	Map m = new Map();

	public Jeu() {
		// Creation du labyrinthe par defaut
		this.cases = new ArrayList<>();   
		
		String[][] lab = m.getLab();
		
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
				else if(lab[i][j].contentEquals("T")) {
					this.cases.add(new CaseTP(((j+1)*30)+15,((i+1)*30)+15,1));
				}
				else if(lab[i][j].contentEquals("t")) {
					this.cases.add(new CaseTP(((j+1)*30)+15,((i+1)*30)+15,2));
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

	public ArrayList<Case> creerLab2() {
		this.cases2 = new ArrayList<>();
		
		String[][] lab2 = m.getLab2();

		for (int i=0; i<18 ; i++) {
			for (int j = 0 ; j<28; j++) {
				if (lab2[i][j].equals("X")) {
					this.cases2.add(new Mur(((j+1)*30)+15, ((i+1)*30)+15));
				} else if(lab2[i][j].equals("E")) {
					this.cases2.add(new Escalier(((j+1)*30)+15, ((i+1)*30)+15));
				} else if(lab2[i][j].equals("P")) {
					this.cases2.add(new Piege(((j+1)*30)+15, ((i+1)*30)+15));
				}
				else if(lab2[i][j].contentEquals("V")) {
					this.cases2.add(new Victoire(((j+1)*30)+15,((i+1)*30)+15));
				}
				else if(lab2[i][j].contentEquals("T")) {
					this.cases.add(new CaseTP(((j+1)*30)+15,((i+1)*30)+15,1));
				}
				else if(lab2[i][j].contentEquals("t")) {
					this.cases.add(new CaseTP(((j+1)*30)+15,((i+1)*30)+15,2));
				}
			}
		}

		for (int y=15; y<600 ; y+=30) {
			this.cases2.add(new Mur(15, y));
		}
		for (int y=15; y<600 ; y+=30) {
			this.cases2.add(new Mur(885, y));
		}
		for (int i=15; i<900 ; i+=30) {
			this.cases2.add(new Mur(i, 15));
		}
		for (int i=15; i<900 ; i+=30) {
			this.cases2.add(new Mur(i, 585));
		}
		return this.cases2;
	}

	@Override
	public String evoluer(CClavier clavier, CSouris souris) {
		if(this.p1.getX() > 840 && this.p1.getX() < 870 && this.etremonter == false) {
			if(this.p1.getY() > 300 && this.p1.getY() < 330 && this.etremonter == false) {
				this.collisionEscalier = true;
				this.etremonter = true;
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
	
	public Boolean getetremonter() {
		return this.etremonter;
	}
	
	public void setCases(ArrayList<Case> c) {
		this.cases = c;
	}
}
