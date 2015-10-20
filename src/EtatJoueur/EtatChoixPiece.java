package EtatJoueur;

import Jeu.Case;
import Jeu.Jeu;
import Jeu.Joueur;
import Jeu.Piece;

public class EtatChoixPiece extends EtatJoueur{
	public EtatChoixPiece(Joueur j) {
		super(j);
	}

	public void choisirPiece(Piece p){
		Jeu jeu = this.j.getJeu();
		if(j == jeu.getJ1()){
			jeu.getJ2().setMain(p);
		} else{
			jeu.getJ1().setMain(p);
		}
		this.j.setEtatCourant(j.getAttente());
	}
}
