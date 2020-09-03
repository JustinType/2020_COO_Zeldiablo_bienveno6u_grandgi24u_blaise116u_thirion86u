package application;

import moteurJeu.moteur.MoteurGraphique;


public class Main {
	
	public static void main(String[] args) {
		//on cree un jeu
		Jeu j = new Jeu();
		
		//on cree une interface graphique
		Dessin d = new Dessin((Jeu) j);	
				
		//on cree le moteur et on lance le jeu
		MoteurGraphique m=new MoteurGraphique(j, d);
		
		//on lance le moteur
		int fps=60;
		int tailleX=900;
		int tailleY=600;
		m.lancerJeu(tailleX, tailleY, fps, j, d);
	}
}
