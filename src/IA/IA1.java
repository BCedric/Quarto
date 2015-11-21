package IA;

import Jeu.Jeu;
import Jeu.Joueur;

public class IA1 extends IA{

	public IA1(Jeu jeu, Joueur j) {
		super(jeu, j);
	}

	@Override
	public int evaluation(Jeu j, NoeudAbstrait n) {
		int i=0;
//		i = (int) (Math.random()*100)+1;
		if(j.isFinPartie() && j.getNonActif() == this.j){
			i+=20;
		} else {
			i-=20;
		}
		return i;
	}

}
