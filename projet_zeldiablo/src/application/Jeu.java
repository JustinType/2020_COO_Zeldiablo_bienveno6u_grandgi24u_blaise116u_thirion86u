package application;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

public class Jeu implements JeuAbstract {
	
	ArrayList<Case> cases; 
	Player p1 = new Player(400,320,10);
	
	public Jeu() {
		// Création du labyrinthe par défaut
		this.cases = new ArrayList<>();
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
		
		
		this.cases.add(new Mur(45,75));
		this.cases.add(new Mur(45,225));
		this.cases.add(new Mur(75,225));
		this.cases.add(new Mur(105,225));
		this.cases.add(new Mur(105,255));
		
		this.cases.add(new Mur(585,255));
		this.cases.add(new Mur(555,255));
		this.cases.add(new Mur(525,255));
		this.cases.add(new Mur(495,255));
		this.cases.add(new Mur(365,255));
		this.cases.add(new Mur(365,225));
		this.cases.add(new Mur(365,195));
		
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
	
}
