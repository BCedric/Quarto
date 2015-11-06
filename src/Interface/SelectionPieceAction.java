package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Jeu.Jeu;
import Jeu.Piece;


public class SelectionPieceAction implements MouseListener {

	private FenetreJeu fenetre;
	
	public SelectionPieceAction(FenetreJeu fenetre){
		this.fenetre = fenetre;
	}

	public void mouseClicked(MouseEvent arg0) {
		PieceIHM p = (PieceIHM) arg0.getSource();
		Jeu j =p.getJ();
		Piece piece = p.getJ().choixPiece(p.getId());
		if(piece != null){
			j.getNonActif().choisirPieceAction(piece, fenetre, p);
		}	
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
