package application;

import java.util.ArrayList;

import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

public class Jeu implements JeuAbstract {
	
	ArrayList<Case> cases; 
	
	public Jeu() {
		// Création du labyrinthe par défaut
		this.cases = new ArrayList<>();
		for (int y=15; y<400 ; y+=30) {
			this.cases.add(new Case(15, y));
		}
		for (int y=15; y<400 ; y+=30) {
			this.cases.add(new Case(585, y));
		}
		for (int i=15; i<600 ; i+=30) {
			this.cases.add(new Case(i, 15));
		}
		for (int i=15; i<600 ; i+=30) {
			this.cases.add(new Case(i, 385));
		}
		
		
		this.cases.add(new Case(45,75));
		this.cases.add(new Case(45,225));
		this.cases.add(new Case(75,225));
		this.cases.add(new Case(105,225));
		this.cases.add(new Case(105,255));
		
		this.cases.add(new Case(585,255));
		this.cases.add(new Case(555,255));
		this.cases.add(new Case(525,255));
		this.cases.add(new Case(495,255));
		this.cases.add(new Case(365,255));
		this.cases.add(new Case(365,225));
		this.cases.add(new Case(365,195));
		
	}
	
	@Override
	public String evoluer(CClavier controle, CSouris souris) {
		// evoluer ne fait rien
		return ("");
	}

	@Override
	public boolean etreFini() {
		// le jeu n'est jamais fini
		return false;
	}

	
}
