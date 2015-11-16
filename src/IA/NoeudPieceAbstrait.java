package IA;

import java.util.ArrayList;

import Jeu.Case;
import Jeu.Jeu;
import Jeu.Piece;

public abstract class NoeudPieceAbstrait extends NoeudAbstrait{

	protected ArrayList<NoeudPieceAbstrait> fils;
	protected Piece coup;

	
	public NoeudPieceAbstrait(NoeudAbstrait pere, Piece coup){
		super(pere);
		this.coup = coup;
		this.fils=new ArrayList<NoeudPieceAbstrait>();
	}
	
	public abstract void calculValeurNoeud();
	public abstract NoeudPieceAbstrait ajouterFils(Piece coup);
	
	public void calculIA(Jeu j, ArrayList<Piece> coups, int prof){
		if(prof == 0 || j.isFinPartie() ){
			this.calculValeurNoeud();
		} else {
			for(Piece p:coups){
				j.getNonActif().choisirPieceAction(p);
				NoeudPieceAbstrait n =this.ajouterFils(p);
				
				
				n.calculIA(j,n.getCoups(j), prof-1);
				
				this.calculValeurNoeud();
				this.annulerCoup(j);
			}
		}
	}
	
	public void annulerCoup(Jeu j){
		j.getPieces().add(j.getActif().getMain());
		j.getActif().setMain(null);
	}
	
	public ArrayList<Piece> getCoups(Jeu j){
		ArrayList<Piece> coups = (ArrayList<Piece>) j.getPieces().clone();
		return coups;
	}
	
	
	public ArrayList<NoeudPieceAbstrait> getFils() {
		return fils;
	}
	
	public boolean estFeuille(){
		return this.fils.isEmpty();
	}

	public Piece getCoup() {
		return coup;
	}
}
