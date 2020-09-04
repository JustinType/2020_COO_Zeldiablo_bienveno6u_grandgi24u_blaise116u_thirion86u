package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import application.Case;
import application.Jeu;
import application.Player;

public class TestTP {

	@Test
	public void test() {
		Jeu j = new Jeu();
		ArrayList<Case> cases = j.getCases();
		
		// Initialisation du personnage juste a cote de la caseTP
		Player p = new Player(765,405,10);
		// Deplacement du personnage sur la caseTP
		p.direction("right");
		p.seDeplacer(cases);
		
		// Test de la teleportation
		assertEquals("Le Personnage doit s'etre teleporte",60,p.getX());
		assertEquals("Le Personnage doit s'etre teleporte",60,p.getY());
		
	}

}
