package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import application.Dessin;
import application.Jeu;
import application.Player;
import moteurJeu.moteur.MoteurGraphique;

// TODO: Auto-generated Javadoc
/**
 * The Class TestMultietage.
 */
public class TestMultietage {

	/**
	 * Test detection escalier.
	 */
	@Test
	public void testDetectionEscalier() {
		Jeu j = new Jeu();
		Dessin d = new Dessin(j);
		MoteurGraphique m = new MoteurGraphique(j, d);
		m.lancerJeu(900, 600, 60, j, d);
		Player p = new Player(855,315,3);
		
		assertEquals("La collision n'est pas detecter",j.getcollisionEscalier(),true);
		assertEquals("La collision n'est pas detecter",j.getetremonter(),true);
	}
	
}
