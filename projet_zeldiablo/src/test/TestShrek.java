package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import application.Case;
import application.Jeu;
import application.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class TestShrek.
 */
public class TestShrek {

	/**
	 * Test.
	 */
	@Test
	public void test() {
		Jeu j = new Jeu();
		ArrayList<Case> cases = j.getCases();
		
		// Initialisation du personnage juste a cote de la caseShrek
		Player p = new Player(105,555,10);
		
		// Test de Shrek
		assertEquals("Le personnage ne doit pas avoir trouve Shrek",false,p.isShrek());
		
		// Deplacement du personnage sur la caseShrek
		p.direction("right");
		p.seDeplacer(cases);
		
		// Test de Shrek
		assertEquals("Le personnage doit avoir trouve Shrek",true,p.isShrek());
	}

}
