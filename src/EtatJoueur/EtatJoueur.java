package EtatJoueur;

import Jeu.Case;
import Jeu.Joueur;
import Jeu.Piece;

public abstract class EtatJoueur {
	private Joueur j;
	
	public void choisirPiece(Piece p){
		System.out.println("Vous ne pouvez pas choisir de pi�ce maintenant");
	}
	public void choisirCase(Case c){
		System.out.println("Vous ne pouvez pas choisir d'emplacement maintenant");
	}

}