package IA;

import java.util.ArrayList;

import Jeu.Case;
import Jeu.Jeu;
import Jeu.Piece;

public abstract class NoeudPieceAbstrait extends NoeudAbstrait{

	protected Case coup;

	
	public NoeudPieceAbstrait(NoeudAbstrait pere, Case coup, IA ia){
		super(pere, ia);
		this.coup = coup;
	}
	
	public abstract void calculValeurNoeud(Jeu j);
	public abstract NoeudCaseAbstrait ajouterFils(Piece coup);
	
	public ArrayList<Piece> getCoups(Jeu j){
		ArrayList<Piece> coups = (ArrayList<Piece>) j.getPieces().clone();
		return coups;
	}
	
	public void calculIA(Jeu j, ArrayList<Piece> coups, int prof){
		if(prof == 0 || j.isFinPartie() ){
			this.calculValeurNoeud(j);
		} else {
			for(Piece p:coups){
				j.getNonActif().choisirPieceAction(p);
				NoeudCaseAbstrait n =this.ajouterFils(p);
				
				
				n.calculIA(j,n.getCoups(j), prof-1);
				
				this.calculValeurNoeud(j);
				this.annulerCoup(j);
			}
		}
	}
	
	public void annulerCoup(Jeu j){
		j.getPieces().add(j.getActif().getMain());
		j.getActif().setMain(null);
	}
	
	
	
	
	public boolean estFeuille(){
		return this.fils.isEmpty();
	}

	public Case getCoup() {
		return coup;
	}
}
