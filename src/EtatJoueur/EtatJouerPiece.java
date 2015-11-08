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
	
	public void choisirCase(Case c, FenetreJeu fenetre, CaseIHM caseihm){
		
		j.getJeu().placerPiece(j.getMain(), c);
		j.setMain(null);
		this.j.setEtatCourant(j.getChoixPiece());
		
		PieceIHM p = null;
		for(Component component : fenetre.getZone(j).getComponents()){
			if(component instanceof PieceIHM) p = (PieceIHM) component; 
		}
		fenetre.getZone(j).remove(p);
		caseihm.add(p);
		p.setLocation(caseihm.getWidth()/2-p.getWidth()/2, caseihm.getHeight()/2-p.getHeight()/2);
		fenetre.repaint();
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
