package test;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Effect;
import application.Jeu;
import application.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class EffectTest.
 */
public class EffectTest {
	
	/** The j. */
	Jeu j = new Jeu();
	
	/** The p 1. */
	Player p1 = new Player(400,320,10);
	
	
	/**
	 * Test.
	 */
	@Test
	public void test() {
		p1.setEffect(new Effect(5,1));
		p1.direction("up");
		p1.doEffect();
		assertEquals("La vitesse devrais etre a 1",1,p1.getvitesse());
		p1.doEffect();
		assertEquals("La vitesse devrais etre a 1",1,p1.getvitesse());
		p1.doEffect();
		assertEquals("La vitesse devrais etre a 1",1,p1.getvitesse());
		p1.doEffect();
		assertEquals("La vitesse devrais etre a 1",1,p1.getvitesse());
		p1.doEffect();
		assertEquals("La vitesse devrais etre a 1",3,p1.getvitesse());
		
		
		
	}

}
