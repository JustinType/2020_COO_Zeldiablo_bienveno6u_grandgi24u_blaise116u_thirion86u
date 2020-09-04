package application;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

// TODO: Auto-generated Javadoc
/**
 * The Class Jeu.
 */
public class Jeu implements JeuAbstract {

	/** The cases 2. */
	ArrayList<Case> cases, cases2; 

	/** The spawn X. */
	int spawnX = 465;
	
	/** The spawn Y. */
	int spawnY = 45;
	
	/** The vitesse. */
	int vitesse = 3;
	
	/** The p 1. */
	Player p1 = new Player(spawnX, spawnY, vitesse);
	
	/** The collision escalier. */
	private Boolean collisionEscalier = false; 
	
	/** The etremonter. */
	private Boolean etremonter = false;
	
	/** The m. */
	Map m = new Map();

	/**
	 * Instantiates a new jeu.
	 */
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
				}else if(lab[i][j].contentEquals("R")) {
					this.cases.add(new Rapide(((j+1)*30)+15,((i+1)*30)+15));
				}else if(lab[i][j].contentEquals("L")) {
					this.cases.add(new Lent(((j+1)*30)+15,((i+1)*30)+15));
				}else if(lab[i][j].contentEquals("S")) {
					this.cases.add(new CaseShrek(((j+1)*30)+15,((i+1)*30)+15));
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

	/**
	 * Creer lab 2.
	 *
	 * @return the array list
	 */
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
					this.cases2.add(new CaseTP(((j+1)*30)+15,((i+1)*30)+15,1));
				}
				else if(lab2[i][j].contentEquals("t")) {
					this.cases2.add(new CaseTP(((j+1)*30)+15,((i+1)*30)+15,2));
				}else if(lab2[i][j].contentEquals("R")) {
					this.cases2.add(new Rapide(((j+1)*30)+15,((i+1)*30)+15));
				}else if(lab2[i][j].contentEquals("L")) {
					this.cases2.add(new Lent(((j+1)*30)+15,((i+1)*30)+15));
				}else if(lab2[i][j].contentEquals("S")) {
					this.cases2.add(new CaseShrek(((j+1)*30)+15,((i+1)*30)+15));
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

	/**
	 * Evoluer.
	 *
	 * @param clavier the clavier
	 * @param souris the souris
	 * @return the string
	 */
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
		p1.doEffect();

		return ("");
	}

	/**
	 * Etre fini.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean etreFini() {
		// le jeu n'est jamais fini
		return false;
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer() {
		return p1;
	}

	/**
	 * Gets the cases.
	 *
	 * @return the cases
	 */
	public ArrayList<Case> getCases() {
		return this.cases;
	}

	/**
	 * Gets the collision escalier.
	 *
	 * @return the collision escalier
	 */
	public Boolean getcollisionEscalier() {
		return this.collisionEscalier;
	}
	
	/**
	 * Gets the etremonter.
	 *
	 * @return the etremonter
	 */
	public Boolean getetremonter() {
		return this.etremonter;
	}
	
	/**
	 * Sets the cases.
	 *
	 * @param c the new cases
	 */
	public void setCases(ArrayList<Case> c) {
		this.cases = c;
	}
}
