package IA;

import java.util.ArrayList;

import Jeu.Case;
import Jeu.CaseOccupeeException;
import Jeu.Jeu;
import Jeu.Piece;

public abstract class NoeudCaseAbstrait extends NoeudAbstrait{
	
	
	protected Piece coup;

	
	public NoeudCaseAbstrait( NoeudAbstrait pere, Piece coup, IA ia){
		super(pere, ia);
		this.coup = coup;
	}
	
	public abstract void calculValeurNoeud();
	public abstract NoeudPieceAbstrait ajouterFils(Case c);
	
	
	public ArrayList<Case> getCoups(Jeu j){
		ArrayList<Case> coups = new ArrayList<Case>();
		for(Case c:j.getPlateau().getCases()){
			if(c.estVide()) coups.add(c);
		}
		return coups;
	}
	
	public void calculIA(Jeu j, ArrayList<Case> coups, int prof){
		
		if(prof == 0 || j.isFinPartie() ){
			this.calculValeurNoeud();
		} else {
			for(Case c:coups){
				j.getActif().choisirCaseAction(c);
				NoeudPieceAbstrait n =this.ajouterFils(c);
				
				
				n.calculIA(j,n.getCoups(j), prof-1);
				this.calculValeurNoeud();
				
				this.calculValeurNoeud();
				this.annulerCoup(j, c);
			}
		}
	}
	
	public static void annulerCoup(Jeu j, Case c){
		j.changerActif();
		j.getActif().setMain(c.getPiece());
		c.setPiece(null);
		j.getActif().setEtatCourant(j.getActif().getJouerPiece());
		if(j.isFinPartie()) j.setFinPartie(false);
	}
	
	
	
	
	
	
	public boolean estFeuille(){
		return this.fils.isEmpty();
	}
	
}
