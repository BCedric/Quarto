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

	public void choisirPiece(Piece p, FenetreJeu fenetre, PieceIHM pihm){
		Jeu jeu = this.j.getJeu();
		jeu.getPieces().remove(p);
		if(j == jeu.getJ1()){
			jeu.getJ2().setMain(p);
		} else{
			jeu.getJ1().setMain(p);
		}
		this.j.setEtatCourant(j.getAttente());
		this.j.getJeu().getActif().setEtatCourant(this.j.getJeu().getActif().getJouerPiece());
		
		pihm.getConteneur().remove(pihm);
		fenetre.getZone(j.getJeu().getActif()).add(pihm);
		pihm.setLocation(fenetre.getZone(j.getJeu().getActif()).getWidth()/2-pihm.getWidth()/2, fenetre.getZone(j.getJeu().getActif()).getHeight()/2-pihm.getHeight()/2);
		fenetre.repaint();
		
	}
}
