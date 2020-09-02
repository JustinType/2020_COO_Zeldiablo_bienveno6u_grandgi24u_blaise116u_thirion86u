package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import application.Jeu;
import application.Player;
import moteurJeu.moteur.JeuAbstract;

class PlayerTest {

	Jeu j = new Jeu();
	Player p1 = new Player(400,320,10);
	
	@Test
	void testSeDeplacerDroite() {
		p1.direction("right");
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers la droite",410,p1.getX());
	}
	
	@Test
	void testSeDeplacerGauche() {
		p1.direction("left");
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers la left",390,p1.getX());
	}
	
	@Test
	void testSeDeplacerHaut() {
		p1.direction("up");
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers le haut",310,p1.getY());
	}
	
	@Test
	void testSeDeplacerBas() {
		p1.direction("down");
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers le bas",330,p1.getY());
	}
}
