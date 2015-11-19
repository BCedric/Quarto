package IA;

import java.util.ArrayList;

public abstract class NoeudAbstrait {
	
	protected int valeur;
	protected NoeudAbstrait pere;
	protected ArrayList<NoeudAbstrait> fils;
	protected IA ia;
	
	
	
	public NoeudAbstrait(NoeudAbstrait pere, IA ia){
		this.pere = pere;		
		this.fils =new ArrayList<NoeudAbstrait>();
		this.ia = ia;
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
