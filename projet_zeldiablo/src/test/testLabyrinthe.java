package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import moteurJeu.moteur.MoteurGraphique;
import application.Case;
import application.Dessin;
import application.Jeu;


public class testLabyrinthe {

	@Test
	public void testPerso() {
		Jeu j = new Jeu();
		Dessin d = new Dessin(j);
		MoteurGraphique m = new MoteurGraphique(j, d);
		m.lancerJeu(900, 600, 60);
		
		int x = j.getPlayer().getX();
		int y = j.getPlayer().getY();
		assertEquals("Le perso doit etre initialise au centre", 450, x);
		assertEquals("Le perso doit etre initialise au centre", 300, y);
	}
	
	@Test
	public void testCases() {
		Jeu j = new Jeu();
		Dessin d = new Dessin(j);
		MoteurGraphique m = new MoteurGraphique(j, d);
		m.lancerJeu(900, 600, 60);
		
		ArrayList<Case> cases = j.getCases();
		
		assertEquals("Une case devrait se trouver ici", 15, cases.get(0).getX());
		assertEquals("Une case devrait se trouver ici", 15, cases.get(0).getY());
	}

}
