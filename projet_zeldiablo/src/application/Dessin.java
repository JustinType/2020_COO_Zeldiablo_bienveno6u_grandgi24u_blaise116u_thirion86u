package application;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import moteurJeu.moteur.DessinAbstract;
import moteurJeu.sprite.Sprites;


public class Dessin implements DessinAbstract {
	
	Jeu jeu;

	public Dessin(Jeu j) {
		// charger sprites
		this.jeu = j;
		Sprites.chargerImage("megaman", "images/megaman.png");
		Sprites.chargerFeuille("case", "images/tank_tiles.png",22,12);
	}

	@Override
	public void dessiner(BufferedImage image) {
		Graphics2D g=(Graphics2D)image.getGraphics();
		
		ArrayList<Case> cases = this.jeu.cases;
		for (Case c : cases) {
			Sprites.dessinerCentre(g, "case_11_1", (int) c.x, (int) c.y);
		}
		Sprites.dessinerCentre(g, "megaman", 300, 200);
	}
}
