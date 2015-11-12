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
	public abstract void ajouterFils();
	
	public void annulerCoup(Jeu j, Case c){
		j.changerActif();
		j.getActif().setMain(c.getPiece());
		c.setPiece(null);
		j.getActif().setEtatCourant(j.getActif().getJouerPiece());
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
