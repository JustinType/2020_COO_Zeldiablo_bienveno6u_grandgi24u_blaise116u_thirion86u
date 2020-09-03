package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import application.Case;
import application.Jeu;
import application.Mur;
import application.Player;

public class InertieTest {


	Jeu j = new Jeu();
	Player p1 = new Player(400,320,10);
	ArrayList<Case> cases = new ArrayList<Case>();

	@Test
	public void testInertie() {
	
		p1.direction("right");
		
		for(int i = 0; i <= 5; i++) {
			p1.seDeplacer(cases);
			p1.reduceVel();}
		
		
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers la droite",445,p1.getX());
		
		p1.seDeplacer(cases);
		p1.reduceVel();
		
		assertEquals("le Personnage aurais du se deplacer de sa vitesse vers la droite",449,p1.getX());
	}

}
