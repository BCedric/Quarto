package IA;

import java.util.ArrayList;

import Jeu.Case;
import Jeu.CaseOccupeeException;
import Jeu.Jeu;

public abstract class NoeudCaseAbstrait {
	
	protected int valeur;
	protected ArrayList<NoeudCaseAbstrait> fils;
	protected NoeudCaseAbstrait pere;

	public NoeudCaseAbstrait( NoeudCaseAbstrait pere){
		this.pere=pere;
		this.fils=new ArrayList<NoeudCaseAbstrait>();
	}
	
	public abstract void calculValeurNoeud();
	public abstract NoeudCaseAbstrait ajouterFils();
	
	public void calculIA(Jeu j, ArrayList<Case> coups, int prof){
		if(prof == 0 || j.isFinPartie() ){
			this.calculValeurNoeud();
		} else {
			for(Case c:coups){
				j.getActif().choisirCaseAction(c);
				this.ajouterFils().calculIA(j,this.getCoups(j), prof-1);
				this.calculValeurNoeud();
				this.annulerCoup(j, c);
			}
		}
	}
	
	public void annulerCoup(Jeu j, Case c){
		j.changerActif();
		j.getActif().setMain(c.getPiece());
		c.setPiece(null);
		j.getActif().setEtatCourant(j.getActif().getJouerPiece());
		if(j.isFinPartie()) j.setFinPartie(false);
	}
	
	public ArrayList<Case> getCoups(Jeu j){
		ArrayList<Case> coups = new ArrayList<Case>();
		for(Case c:j.getPlateau().getCases()){
			if(c.estVide()) coups.add(c);
		}
		return coups;
	}
	
	public boolean estFeuille(){
		return this.fils.isEmpty();
	}
	
	public int getValeur() {
		return valeur;
	}

	public ArrayList<NoeudCaseAbstrait> getFils() {
		return fils;
	}

	public NoeudCaseAbstrait getPere() {
		return pere;
	}	
}
