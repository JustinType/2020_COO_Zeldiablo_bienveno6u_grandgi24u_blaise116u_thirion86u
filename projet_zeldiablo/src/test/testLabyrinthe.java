package test;

import org.junit.Test;

import moteurJeu.moteur.MoteurGraphique;
import application.Dessin;
import application.Jeu;
import application.Case;


public class testLabyrinthe {

	@Test
	public void testTaille() {
		Jeu j = new Jeu();
		Dessin d = new Dessin(j);
		MoteurGraphique m = new MoteurGraphique(j, d);
		m.lancerJeu(600, 400, 60);
		
		
	}

}
