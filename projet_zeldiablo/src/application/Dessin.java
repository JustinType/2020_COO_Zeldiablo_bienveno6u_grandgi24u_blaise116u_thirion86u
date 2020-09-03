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
		Sprites.chargerImage("megamort", "images/megaman-mort.png");
		Sprites.chargerImage("megagauche", "images/megaman-gauche.png");
	}

	@Override
	public void dessiner(BufferedImage image) {
		Graphics2D g=(Graphics2D)image.getGraphics();
		if (this.j.getPlayer().getGagne()==true) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0,0,900,600);
			g.setColor(Color.BLACK);
			g.drawString("Bravo ! Vous avez fini le Labyrinthe", 380, 314);
			Sprites.dessinerCentre(g,"megaman",350,300);
			g.dispose();
		}
		else if(this.j.getPlayer().getVie()<=0){
			g.setColor(Color.RED);
			g.fillRect(0, 0, 900, 600);
			g.setColor(Color.BLACK);
			g.drawString("Vous etes mort, GAME OVER", 380, 300);
			Sprites.dessinerCentre(g,"megamort",350,290);
			g.dispose();
		}
		else if(this.j.getcollisionEscalier()) {
			for (Case c : j.cases) {
				c.setSprite("case_5_4");
				c.setRempli(false);
			}
			this.j.setCases(this.j.creerLab2());
		}
		else {
			ArrayList<Case> cases = this.j.cases;
			for (Case c : cases) {
				Sprites.dessinerCentre(g, c.getSprite(), (int) c.x, (int) c.y);
			}
			String megasprite="megaman";
			if (this.j.getPlayer().getDirection()=="gauche") {
				megasprite="megagauche";
			}
			if(this.j.getPlayer().getDirection()=="droite") {
				megasprite="megaman";
			}
			Sprites.dessinerCentre(g,megasprite,j.getPlayer().getX(),j.getPlayer().getY());
			g.drawString("Vie :"+j.getPlayer().getVie(),10, 20);
			}
		}
		
	}	

