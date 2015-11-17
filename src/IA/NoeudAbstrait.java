package IA;

import java.util.ArrayList;

public abstract class NoeudAbstrait {
	
	protected int valeur;
	protected NoeudAbstrait pere;
	protected ArrayList<NoeudAbstrait> fils;
	
	
	
	public NoeudAbstrait(NoeudAbstrait pere){
		this.pere = pere;		
		this.fils =new ArrayList<NoeudAbstrait>();
	}
	
	
	
	public int getValeur() {
		return valeur;
	}

	public NoeudAbstrait getPere() {
		return pere;
	}
	
	
	
	public ArrayList<NoeudAbstrait> getFils() {
		return fils;
	}
}
