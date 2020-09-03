package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import application.Case;
import application.Jeu;
import application.Mur;
import application.Player;

public class CollisionsTest {

	Jeu j = new Jeu();
	Player p1 = new Player(400,320,10);
	ArrayList<Case> cases = new ArrayList<Case>();
	
	
	
	
	@Test
	public void testSeDeplacerDroite() {
		cases.add(new Mur(440, 320));
		p1.direction("right");
		
		for(int i = 0; i <= 5; i++) {p1.seDeplacer(cases);}
		
		
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers la droite",410,p1.getX());
	}
	
	@Test
	public void testSeDeplacerGauche() {
		cases.add(new Mur(360, 320));
		p1.direction("left");
		for(int i = 0; i <= 10; i++) {p1.seDeplacer(cases);}
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers la left",390,p1.getX());
	}
	
	@Test
	public void testSeDeplacerHaut() {
		cases.add(new Mur(400, 280));
		p1.direction("up");
		for(int i = 0; i <= 5; i++) {p1.seDeplacer(cases);}
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers le haut",310,p1.getY());
	}
	
	@Test
	public void testSeDeplacerBas() {
		cases.add(new Mur(400, 360));
		p1.direction("down");
		for(int i = 0; i <= 10; i++) {p1.seDeplacer(cases);}
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers le bas",330,p1.getY());
	}
}
