package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import application.Case;
import application.Jeu;
import application.Mur;
import application.Player;
import application.Victoire;

// TODO: Auto-generated Javadoc
/**
 * The Class CollisionsTest.
 */
public class CollisionsTest {

	/** The j. */
	Jeu j = new Jeu();
	
	/** The p 1. */
	Player p1 = new Player(400,320,10);
	
	/** The cases. */
	ArrayList<Case> cases = new ArrayList<Case>();
	
	
	
	
	/**
	 * Test collisions droite.
	 */
	@Test
	public void testCollisionsDroite() {
		cases.add(new Mur(440, 320));
		p1.direction("right");
		
		for(int i = 0; i <= 5; i++) {p1.seDeplacer(cases);}
		
		
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers la droite",410,p1.getX());
	}
	
	/**
	 * Test collisions gauche.
	 */
	@Test
	public void testCollisionsGauche() {
		cases.add(new Mur(360, 320));
		p1.direction("left");
		for(int i = 0; i <= 10; i++) {p1.seDeplacer(cases);}
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers la left",390,p1.getX());
	}
	
	/**
	 * Test collisions haut.
	 */
	@Test
	public void testCollisionsHaut() {
		cases.add(new Mur(400, 280));
		p1.direction("up");
		for(int i = 0; i <= 5; i++) {p1.seDeplacer(cases);}
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers le haut",310,p1.getY());
	}
	
	/**
	 * Test collisions bas.
	 */
	@Test
	public void testCollisionsBas() {
		cases.add(new Mur(400, 360));
		p1.direction("down");
		for(int i = 0; i <= 10; i++) {p1.seDeplacer(cases);}
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers le bas",330,p1.getY());
	}
	
	/**
	 * Test detection arrive.
	 */
	@Test
	public void testDetectionArrive() {
		cases.add(new Victoire (400,340));
		p1.direction("right");
		p1.seDeplacer(cases);
		assertEquals("le personnage aurait du gagner",true,p1.getGagne());
		
	}
}
