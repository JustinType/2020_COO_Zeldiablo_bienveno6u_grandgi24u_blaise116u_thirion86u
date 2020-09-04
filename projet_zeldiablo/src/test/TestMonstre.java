package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import application.Dessin;
import application.Jeu;
import application.Monstre;
import moteurJeu.moteur.MoteurGraphique;

// TODO: Auto-generated Javadoc
/**
 * The Class TestMonstre.
 */
public class TestMonstre {
	
	/**
	 * Tester deplacement horizontale.
	 */
	@Test
	public void TesterDeplacementHorizontale() {
		Jeu j = new Jeu();
		Dessin d = new Dessin(j);
		MoteurGraphique m = new MoteurGraphique(j, d);
		m.lancerJeu(900, 600, 60, j, d);
		
		Monstre monstre = new Monstre(675,45," ");
		monstre.deplacerMonstreHorizontale(675, 825);
		Boolean test = false;
		if(monstre.getX() > 675) {
			test = true;
		}
		
		assertEquals("Test Deplacement du monstre",test,true);
	}
	
	/**
	 * Tester deplacement verticale.
	 */
	@Test
	public void TesterDeplacementVerticale() {
		Jeu j = new Jeu();
		Dessin d = new Dessin(j);
		MoteurGraphique m = new MoteurGraphique(j, d);
		m.lancerJeu(900, 600, 60, j, d);
		
		Monstre monstre = new Monstre(675,45," ");
		monstre.deplacerMonstreVerticale(45, 135);
		Boolean test = false;
		if(monstre.getY() > 45) {
			test = true;
		}
		
		assertEquals("Test Deplacement du monstre",test,true);
	}
	
}
