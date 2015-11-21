package IA;

import java.util.ArrayList;

import CaracteristiquesPiece.Couleur;
import Jeu.Case;
import Jeu.Jeu;
import Jeu.Joueur;
import Jeu.Ligne;
import Jeu.Piece;

public class IA2 extends IA{

	public IA2(Jeu jeu, Joueur j) {
		super(jeu, j);
	}

	@Override
	public int evaluation(Jeu jeu, NoeudAbstrait n) {
		int eval = 0;
		if(jeu.getActif() == this.j){
			if(this.peutGagner(jeu)) eval +=20;
			if(this.jeu.isFinPartie()) eval-=20;
			if(this.placementParDefault(jeu,n)) eval-=10;
			if(this.EviterLigneAvecUneCaseVide(jeu, n)) eval+=10;
		} else {
			if(this.peutGagner(jeu)) eval -=20;
			if(this.jeu.isFinPartie()) eval+=20;
			if(this.placementParDefault(jeu,n)) eval+=10;
			if(this.EviterLigneAvecUneCaseVide(jeu, n)) eval-=10;
		}
		
		return eval;
	}
	
	/**
	 * Cette fonction determine si, dans la configuration courante, le joueur actif peut gagner
	 * @param j configuration du jeu
	 * @return vrai si le joueur peut gagner
	 */
	public boolean peutGagner(Jeu j){
		
		for(Ligne l : j.getPlateau().getLignes()){
			for(Case c:l.getCases()){
				if(c.estVide()){
					c.setPiece(j.getActif().getMain());
					if(l.finPartie()){
						c.setPiece(null);
						return true;
					}
					c.setPiece(null);
				}
			}
		}
		return false;
	}
	
	/**
	 * Si toutes les piece disponibles permettent de finir la partie sur une même case et 
	 * que la piece que le joueur vient jouer ne permet pas de finir la partie, alors, la piece doit être jouée dans 
	 * cette case pour éviter de laisser gagner l'adversaire
	 * @param j configuration du jeu
	 * @param n le noeud courant
	 * @return 
	 */
	public boolean placementParDefault(Jeu j, NoeudAbstrait n){
		Piece coupjoue = n.getCoupCase().getPiece();
		for(Piece p:j.getPieces()){
			n.getCoupCase().setPiece(p);
			if(!j.isFinPartie()){
				n.getCoupCase().setPiece(coupjoue);
				return false;
			}
		}
		n.getCoupCase().setPiece(coupjoue);
		return true;
	}
	
	public boolean EviterLigneAvecUneCaseVide(Jeu j, NoeudAbstrait n){

		ArrayList<Piece> pieces= new ArrayList<Piece>();
		int nb =0;
		for(Ligne l:n.getCoupCase().getLignes()){
			for(Case c:l.getCases()){
				if(!c.estVide()){
					pieces.add(c.getPiece());
					++nb;
				}
			}
			if(nb == 3){
				ArrayList<String> cc1 = pieces.get(0).caracteristiquesCommunes(pieces.get(1));
				ArrayList<String> cc2 = pieces.get(1).caracteristiquesCommunes(pieces.get(2));
				ArrayList<String> cc3 = pieces.get(0).caracteristiquesCommunes(pieces.get(2));
				
				for(String s:cc1){
					if(cc2.contains(s) && cc3.contains(s)) return true;
				}
			}
		}
		return false;
	}

}
