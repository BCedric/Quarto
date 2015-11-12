package Interface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import Jeu.Case;
import Jeu.Jeu;
import Jeu.Ligne;
import Jeu.Piece;

public class SelectionCaseAction implements MouseListener{
	
	private FenetreJeu fenetre;
	
	public SelectionCaseAction(FenetreJeu fenetre){
		this.fenetre = fenetre;
	}

	public void mouseClicked(MouseEvent arg0) {
		CaseIHM caseihm = (CaseIHM) arg0.getSource();
		Jeu j =caseihm.getJ();
		Case c = j.choixCase(caseihm.getId());
		fenetre.jouerPiece(caseihm);
		
		if(c != null){
			if(j.getActif().choisirCaseAction(c)){
				for(Ligne l:c.getLignes()){
					if(l.finPartie()){
						fenetre.finPartie();
						JFrame fin = new FenetreFinDePartie(j,l);
						fin.setVisible(true);
						break;
					}
				}
				
			}
		}	
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
