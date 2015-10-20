package EtatJoueur;

import Jeu.Case;
import Jeu.CaseOccupeeException;
import Jeu.Joueur;

public class EtatJouerPiece extends EtatJoueur{

	public EtatJouerPiece(Joueur j) {
		super(j);
	}
	
	public void choisirCase(Case c){
		try {
			c.setPiece(j.getMain());
		} catch (CaseOccupeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		j.setMain(null);
		this.j.setEtatCourant(j.getAttente());
	}

}
