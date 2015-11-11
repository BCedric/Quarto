package EtatJoueur;

import Interface.CaseIHM;
import Interface.FenetreJeu;
import Interface.PieceIHM;
import Jeu.Case;
import Jeu.Joueur;
import Jeu.Piece;

public abstract class EtatJoueur {
	protected Joueur j;
	
	public EtatJoueur(Joueur j){
		this.j=j;
	}
	
	public void choisirPiece(Piece p){
		System.out.println("Vous ne pouvez pas choisir de pièce maintenant");
	}
	public void choisirCase(Case c){
		System.out.println("Vous ne pouvez pas choisir d'emplacement maintenant");
	}

}
