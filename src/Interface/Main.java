package Interface;

import javax.swing.JFrame;

import Jeu.Case;
import Jeu.CaseOccupeeException;
import Jeu.Jeu;
import Jeu.Piece;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		
		 Jeu j = new Jeu(true);
		 j.jouer();
//		 Piece p = j.choixPiece(1);
//		 j.getNonActif().choisirPieceAction(p);
//		 j.getActif().choisirCaseAction(j.choixCase(1));
//		 Case ca = null;
//		 for(Case c : j.getPlateau().getCases()){
//			 if(c.getId() == 1){
//				 ca =c;
//				 break;
//			 }
//		 }
//		 new NoeudMax(null).annulerCoup(j, ca);
	}

}
