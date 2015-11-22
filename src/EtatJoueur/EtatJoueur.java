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
	
	/**
	 * Action de choisir une piece
	 * @param p piece choisie
	 */
	public void choisirPiece(Piece p){
		System.out.println("Vous ne pouvez pas choisir de piece maintenant");
	}
	
	/**
	 * Action de choisir une case pour y poser une piece
	 * @param c Case choisie
	 * @return
	 */
	public boolean choisirCase(Case c){
		System.out.println("Vous ne pouvez pas choisir d'emplacement maintenant");
		return false;
	}

}
