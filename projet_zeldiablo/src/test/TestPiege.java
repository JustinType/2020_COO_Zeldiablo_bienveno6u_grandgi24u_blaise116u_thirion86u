package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import application.Case;
import application.Dessin;
import application.Jeu;
import application.Player;
import moteurJeu.moteur.MoteurGraphique;

// TODO: Auto-generated Javadoc
/**
 * The Class TestPiege.
 */
public class TestPiege {

	/**
	 * Test.
	 */
	@Test
	public void test() {
		Jeu j = new Jeu();
		ArrayList<Case> cases = j.getCases();
		
		// Initialisation du personnage a cote d'une case piege
		Player p = new Player(645,225,5);

		
		// Test des points de vie du personnage
		assertEquals("Le Personnage ne doit pas avoir perdu de vie",10,p.getVie());
		
		// Deplacement du personnage sur la case piege
		p.direction("right");
		p.seDeplacer(cases);
		
		// Test de la collision avec la case Piege
		assertEquals("Le Personnage doit avoir un point de vie en moins",9,p.getVie());
	
		// Test du systeme de vie
		p.setVie(20);
		assertEquals("Le Personnage doit avoir 20 points de vie",20,p.getVie());
	}

}
