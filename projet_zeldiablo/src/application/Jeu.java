package application;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

public class Jeu implements JeuAbstract {
	
	ArrayList<Case> cases; 
	Player p1 = new Player(450,300,10);
	
	public Jeu() {
		// Creation du labyrinthe par defaut
		this.cases = new ArrayList<>();
		
		String[][] lab = { {" "," "," "," "," ","X"," "," "," ","X"," "," "," ","X"," ","X","X"," "," "," ","X"," "," "," "," "," "," ","X"},
						   {" ","X","X","X","X","X"," ","X"," ","X"," ","X"," ","X"," "," ","X"," ","X"," ","X"," ","X","X","X","X"," ","X"},
						   {" "," "," "," "," "," "," ","X"," "," "," ","X"," ","X","X"," ","X"," ","X","X","X"," ","X","X"," ","X"," "," "},
						   {"X","X"," ","X","X","X","X","X"," ","X","X","X"," "," ","X"," "," "," ","X"," "," "," "," ","X"," ","X","X"," "},
						   {" ","X"," ","X"," "," "," ","X"," "," "," ","X","X","X","X"," ","X"," "," "," ","X","X"," ","X"," "," "," "," "},
						   {" "," "," "," "," ","X","X","X","X","X"," "," "," "," ","X"," ","X","X","X","X","X"," "," "," "," ","X","X"," "},
						   {" ","X","X","X"," ","X"," "," "," ","X","X"," ","X"," ","X","X","X"," ","X"," "," "," ","X","X","X","X"," "," "},
						   {" ","X"," "," "," ","X"," ","X"," "," "," "," ","X"," "," "," "," "," "," "," ","X","X","X"," "," "," "," ","X"},
						   {" ","X","X","X","X","X"," ","X","X","X","X","X","X","X","X","X","X","X","X"," "," "," "," "," ","X"," ","X","X"},
						   {" "," "," "," "," "," "," ","X"," "," ","X"," ","X"," "," "," ","X"," ","X","X","X"," ","X","X","X"," ","X"," "},
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
					this.cases.add(new Mur(((j+1)*30)+15,((i+1)*30)+15));
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
		
		if(clavier.isPressed(KeyEvent.VK_RIGHT)) {
			p1.seDeplacer("right");
		}
		if(clavier.isPressed(KeyEvent.VK_LEFT)) { 
			p1.seDeplacer("left");
		}
		if(clavier.isPressed(KeyEvent.VK_UP)) {
			p1.seDeplacer("up");
		}
		if(clavier.isPressed(KeyEvent.VK_DOWN)) {
			p1.seDeplacer("down");
		}

		
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
	
}
