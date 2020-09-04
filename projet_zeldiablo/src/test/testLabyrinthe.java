package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import moteurJeu.moteur.MoteurGraphique;
import application.Case;
import application.Dessin;
import application.Jeu;


// TODO: Auto-generated Javadoc
/**
 * The Class testLabyrinthe.
 */
public class testLabyrinthe {

	/**
	 * Test perso.
	 */
	@Test
	public void testPerso() {
		Jeu j = new Jeu();
		
		int x = j.getPlayer().getX();
		int y = j.getPlayer().getY();
		/*
		// On test si le perso apparait au milieu (V1)
		assertEquals("Le perso doit etre initialise au centre", 450, x);
		assertEquals("Le perso doit etre initialise au centre", 300, y);
		*/
		
		// On test si le perso apparait au bon endroit (apres V1)
		assertEquals("Le perso doit etre initialise au bon endroit", 465, x);
		assertEquals("Le perso doit etre initialise au bon endroit", 45, y);
		
		ArrayList<Case> cases = j.getCases();
		// On test si la premiere case du labyrinthe par defaut est au bon endroit (165,45)
		assertEquals("Une case devrait se trouver ici", 165, cases.get(0).getX());
		assertEquals("Une case devrait se trouver ici", 45, cases.get(0).getY());
	}	

}
