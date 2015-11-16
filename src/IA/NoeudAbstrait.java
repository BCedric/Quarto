package IA;

import java.util.ArrayList;

import Jeu.Case;
import Jeu.CaseOccupeeException;
import Jeu.Jeu;

public abstract class NoeudAbstrait {
	
	protected int valeur;
	protected ArrayList<NoeudAbstrait> fils;
	protected NoeudAbstrait pere;

	public NoeudAbstrait( NoeudAbstrait pere){
		this.pere=pere;
		this.fils=new ArrayList<NoeudAbstrait>();
	}
	
	public abstract void calculValeurNoeud();
	public abstract NoeudAbstrait ajouterFils();
	
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

	public ArrayList<NoeudAbstrait> getFils() {
		return fils;
	}

	public NoeudAbstrait getPere() {
		return pere;
	}	
}
