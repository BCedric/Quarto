package EtatJoueur;

import java.awt.Component;

import javax.swing.JFrame;

import Interface.CaseIHM;
import Interface.FenetreFinDePartie;
import Interface.FenetreJeu;
import Interface.PieceIHM;
import Jeu.Case;
import Jeu.CaseOccupeeException;
import Jeu.Joueur;
import Jeu.Ligne;

public class EtatJouerPiece extends EtatJoueur{

	public EtatJouerPiece(Joueur j) {
		super(j);
	}
	
	public void choisirCase(Case c){
		
		FenetreJeu fenetre = j.getJeu().getVue();
		boolean finPartie;
		finPartie = j.getJeu().placerPiece(j.getMain(), c);
		j.setMain(null);
		this.j.setEtatCourant(j.getChoixPiece());
		
		
		if(finPartie){
			for(Ligne l:c.getLignes()){
				if(l.finPartie()){
					fenetre.finPartie();
					JFrame fin = new FenetreFinDePartie(j.getJeu(),l);
					fin.setVisible(true);
					break;
				}
			}
		}
	}
}
