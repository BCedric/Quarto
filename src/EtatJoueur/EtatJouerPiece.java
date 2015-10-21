package EtatJoueur;

import Jeu.Case;
import Jeu.CaseOccupeeException;
import Jeu.Joueur;

public class EtatJouerPiece extends EtatJoueur{

	public EtatJouerPiece(Joueur j) {
		super(j);
	}
	
	public void choisirCase(Case c){
		
		j.getJeu().placerPiece(j.getMain(), c);
		j.setMain(null);
		this.j.setEtatCourant(j.getAttente());
	}

}
