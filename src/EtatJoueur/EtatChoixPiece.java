package EtatJoueur;

import java.awt.BorderLayout;

import Interface.FenetreJeu;
import Interface.PieceIHM;
import Jeu.Case;
import Jeu.Jeu;
import Jeu.Joueur;
import Jeu.Piece;

public class EtatChoixPiece extends EtatJoueur{
	public EtatChoixPiece(Joueur j) {
		super(j);
	}
	
	@Override
	public void choisirPiece(Piece p){
		Jeu jeu = this.j.getJeu();
		jeu.getPieces().remove(p);
		if(j == jeu.getJ1()){
			jeu.getJ2().setMain(p);
		} else{
			jeu.getJ1().setMain(p);
		}
		this.j.setEtatCourant(j.getAttente());
		this.j.getJeu().getActif().setEtatCourant(this.j.getJeu().getActif().getJouerPiece());		
	}
}
