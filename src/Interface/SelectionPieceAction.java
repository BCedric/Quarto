package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import EtatJoueur.EtatChoixPiece;
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
		if(j.getJ1().getEtatCourant() == j.getJ1().getChoixPiece() || j.getJ2().getEtatCourant() == j.getJ2().getChoixPiece()){
			Piece piece = p.getJ().choixPiece(p.getId());
			if(piece != null){
				if(j.getNonActif().getEtatCourant() instanceof EtatChoixPiece){
					fenetre.choisirPiece(p);
				}
				j.getNonActif().choisirPieceAction(piece);
				
			}
			if(j.getIa() != null){
				long tempsDebut = System.currentTimeMillis();
				if(j.getPieces().size() == 16){
					j.getIa().choisirPiece();
				} else{
					j.getIa().jouerPieceChoisirPiece();
				}
				long tempsFin = System.currentTimeMillis();
				float seconds = (tempsFin - tempsDebut) / 1000F;
				System.out.println("Opération effectuée en: "+ Float.toString(seconds) + " secondes.");
			}
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
