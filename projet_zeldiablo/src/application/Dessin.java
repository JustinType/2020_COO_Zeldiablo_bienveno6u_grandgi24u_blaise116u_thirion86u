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
	Monstre m = new Monstre(435,255,"H");
	Monstre m2 = new Monstre(135,495," ");
	Monstre m3 = new Monstre(855,555," ");

	public Dessin(Jeu j) {
		// charger sprites
		this.j = j;
		Sprites.chargerImage("megaman", "images/megaman.png");
		Sprites.chargerImage("escalier", "images/escalier.png");
		Sprites.chargerFeuille("case", "images/tank_tiles.png",22,12);	
		Sprites.chargerImage("megamort", "images/megaman-mort.png");
		Sprites.chargerImage("megagauche", "images/megaman-gauche.png");
		Sprites.chargerImage("monstre", "images/monstre.png");
		Sprites.chargerImage("lent", "images/lent.png");
		Sprites.chargerImage("rapide", "images/rapide.png");
		Sprites.chargerImage("Shrek", "images/shrek.png");
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
			if(!this.j.getetremonter()) {
				Sprites.dessinerCentre(g, "monstre", m.getX(), m.getY());
				Sprites.dessinerCentre(g, "monstre", m2.getX(), m2.getY());
				Sprites.dessinerCentre(g, "monstre", m3.getX(), m3.getY());
				m.deplacerMonstreHorizontale(435,615);
				m2.deplacerMonstreVerticale(315, 495);
				m3.deplacerMonstreVerticale(345, 555);
			}
			
			if (this.j.getPlayer().isShrek()) {
				g.setColor(Color.DARK_GRAY);
				g.fillRect(0,0,900,600);
				g.setColor(Color.WHITE);
				Sprites.dessinerCentre(g,"Shrek",350,300);
				g.drawString("Tu as trouv� SHREK !!!", 350, 314);
				g.dispose();
			}
			
			if(j.getPlayer().getPiege()==true) {
				j.getPlayer().setPiege(false);
				Sprites.dessinerCentre(g,"megamort",j.getPlayer().getX(),j.getPlayer().getY());
				long start=System.nanoTime();
				while((System.nanoTime()-start)<60);
				Sprites.dessinerCentre(g,megasprite,j.getPlayer().getX(),j.getPlayer().getY());
				}
			if((j.getPlayer().getX() > m.getX()-10 && j.getPlayer().getX() < m.getX()+10)||(j.getPlayer().getX() > m2.getX()-10 && j.getPlayer().getX() < m2.getX()+10)||(j.getPlayer().getX() > m3.getX()-10 && j.getPlayer().getX() < m3.getX()+10)) {
				if((j.getPlayer().getY() > m.getY()-10 && j.getPlayer().getY() < m.getY()+10)||(j.getPlayer().getY() > m2.getY()-10 && j.getPlayer().getY() < m2.getY()+10)||(j.getPlayer().getY() > m3.getY()-10 && j.getPlayer().getY() < m3.getY()+10)) {
					j.getPlayer().setVie(j.getPlayer().getVie()-1);
				}
			}
			Sprites.dessinerCentre(g,megasprite,j.getPlayer().getX(),j.getPlayer().getY());				
			g.drawString("Vie :"+j.getPlayer().getVie(),10,20);
		} 
		
	}


}	

