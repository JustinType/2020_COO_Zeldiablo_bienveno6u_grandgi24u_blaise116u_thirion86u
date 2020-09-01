package application;

import moteurJeu.moteur.DessinAbstract;
import moteurJeu.moteur.JeuAbstract;
import moteurJeu.moteur.MoteurGraphique;


public class Main {

	public static void main(String[] args) {
		//on cree un jeu
		JeuAbstract j = new Jeu();
		
		//on cree une interface graphique
		DessinAbstract d = new Dessin((Jeu) j);	
				
		//on cree le moteur et on lance le jeu
		MoteurGraphique m=new MoteurGraphique(j, d);
		
		//on lance le moteur
		int fps=60;
		int tailleX=600;
		int tailleY=400;
		m.lancerJeu(tailleX, tailleY, fps);
	}
}
