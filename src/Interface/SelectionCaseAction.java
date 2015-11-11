package Interface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Jeu.Case;
import Jeu.Jeu;
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
			j.getActif().choisirCaseAction(c);
		}	
		j.changerActif();
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
