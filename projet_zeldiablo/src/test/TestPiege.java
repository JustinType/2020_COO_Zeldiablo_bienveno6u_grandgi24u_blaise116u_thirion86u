package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import application.Case;
import application.Dessin;
import application.Jeu;
import application.Player;
import moteurJeu.moteur.MoteurGraphique;

public class TestPiege {

	@Test
	public void test() {
		Jeu j = new Jeu();
		Dessin d = new Dessin(j);
		MoteurGraphique m = new MoteurGraphique(j, d);
		m.lancerJeu(900, 600, 60, j, d);
		Player p = new Player(465,45,5);
		
		// Test des points de vie du personnage
		assertEquals("Le Personnage ne doit pas avoir perdu de vie",10,p.getVie());
		
		p.direction("down");
		p.seDeplacer(new ArrayList<Case>());
		
		// Test de la collision avec la case Piege
		assertEquals("Le Personnage doit avoir un point de vie en moins",9,p.getVie());
	
		p.setVie(20);
		assertEquals("Le Personnage doit avoir 20 points de vie",20,p.getVie());
	}

}
