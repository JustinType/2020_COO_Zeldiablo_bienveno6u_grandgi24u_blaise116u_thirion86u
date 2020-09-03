package application;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import moteurJeu.moteur.DessinAbstract;
import moteurJeu.sprite.Sprites;


public class Dessin implements DessinAbstract {
	
	Jeu j;
	public Graphics2D g;

	public Dessin(Jeu j) {
		// charger sprites
		this.j = j;
		Sprites.chargerImage("megaman", "images/megaman.png");
		Sprites.chargerImage("escalier", "images/escalier.png");
		Sprites.chargerFeuille("case", "images/tank_tiles.png",22,12);	
	}

	@Override
	public void dessiner(BufferedImage image) {
		this.g=(Graphics2D)image.getGraphics();
		
		ArrayList<Case> cases = this.j.cases;
		for (Case c : cases) {
			Sprites.dessinerCentre(g, c.getSprite(), (int) c.x, (int) c.y);
		}
		Sprites.dessinerCentre(g,"megaman",j.getPlayer().getX(),j.getPlayer().getY());
	}
	
	@Override
	public void repaint() {
		for (Case c : j.cases) {
			c.setSprite("case_5_4");
			c.setRempli(false);
		}
		
		System.out.println("Escalier3");
	}
}
