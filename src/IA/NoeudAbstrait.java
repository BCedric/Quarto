package IA;

import java.util.ArrayList;

public abstract class NoeudAbstrait {
	
	protected int valeur;
	protected NoeudAbstrait pere;
	
	
	
	public NoeudAbstrait(NoeudAbstrait pere){
		this.pere = pere;		
	}
	
	
	
	public int getValeur() {
		return valeur;
	}

	public NoeudAbstrait getPere() {
		return pere;
	}
	
	
}
