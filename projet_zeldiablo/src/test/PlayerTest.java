package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import application.Case;
import application.Jeu;
import application.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerTest.
 */
public class PlayerTest {

	/** The j. */
	Jeu j = new Jeu();
	
	/** The p 1. */
	Player p1 = new Player(400,320,10);
	
	/**
	 * Test se deplacer droite.
	 */
	@Test
	public void testSeDeplacerDroite() {
		p1.direction("right");
		p1.seDeplacer(new ArrayList<Case>());
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers la droite",410,p1.getX());
	}
	
	/**
	 * Test se deplacer gauche.
	 */
	@Test
	public void testSeDeplacerGauche() {
		p1.direction("left");
		p1.seDeplacer(new ArrayList<Case>());
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers la left",390,p1.getX());
	}
	
	/**
	 * Test se deplacer haut.
	 */
	@Test
	public void testSeDeplacerHaut() {
		p1.direction("up");
		p1.seDeplacer(new ArrayList<Case>());
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers le haut",310,p1.getY());
	}
	
	/**
	 * Test se deplacer bas.
	 */
	@Test
	public void testSeDeplacerBas() {
		p1.direction("down");
		p1.seDeplacer(new ArrayList<Case>());
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers le bas",330,p1.getY());
	}
}
