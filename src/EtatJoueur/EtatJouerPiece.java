package EtatJoueur;

import java.awt.Component;

import javax.swing.JFrame;

import Interface.CaseIHM;
import Interface.FenetreFinDePartie;
import Interface.FenetreJeu;
import Interface.PieceIHM;
import Jeu.Case;
import Jeu.Joueur;
import Jeu.Ligne;

public class EtatJouerPiece extends EtatJoueur{

	public EtatJouerPiece(Joueur j) {
		super(j);
	}
	
	@Override
	public boolean choisirCase(Case c){
		boolean finPartie;
		finPartie = j.getJeu().placerPiece(j.getMain(), c);
		j.setMain(null);
		this.j.setEtatCourant(j.getChoixPiece());
		j.getJeu().changerActif();
		
		return finPartie;
	}
}
