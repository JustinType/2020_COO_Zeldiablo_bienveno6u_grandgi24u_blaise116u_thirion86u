package application;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import moteurJeu.moteur.DessinAbstract;
import moteurJeu.sprite.Sprites;


public class Dessin implements DessinAbstract {
	
	Jeu j;

	public Dessin(Jeu j) {
		// charger sprites
		this.j = j;
		Sprites.chargerImage("megaman", "images/megaman.png");
		Sprites.chargerImage("escalier", "images/escalier.png");
		Sprites.chargerFeuille("case", "images/tank_tiles.png",22,12);	
	}

	@Override
	public void dessiner(BufferedImage image) {
		Graphics2D g=(Graphics2D)image.getGraphics();
		if (this.j.getPlayer().getGagne()==true) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0,0,900,600);
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
			g.drawString("Bravo ! Vous avez fini le Labyrinthe", 380, 314);
			Sprites.dessinerCentre(g,"megaman",350,300);
			g.dispose();
		}
		else {
			
			ArrayList<Case> cases = this.j.cases;
			for (Case c : cases) {
				Sprites.dessinerCentre(g, c.getSprite(), (int) c.x, (int) c.y);
			}
			Sprites.dessinerCentre(g,"megaman",j.getPlayer().getX(),j.getPlayer().getY());
		}
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
