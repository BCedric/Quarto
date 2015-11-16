package IA;

import java.util.ArrayList;

import Jeu.Jeu;
import Jeu.Case;

public class NoeudCaseMax extends NoeudCaseAbstrait{

	public NoeudCaseMax(NoeudCaseAbstrait pere) {
		super(pere);
	}

	@Override
	public void calculValeurNoeud() {
		if(this.estFeuille()){
			//TODO evaluation
		} else {
			int val = this.fils.get(0).getValeur();
			for(NoeudCaseAbstrait n:this.fils){
				if(val < n.getValeur()){
					val = n.getValeur();
				}
			}
			this.valeur = val;
		}
	}
	
	@Override
	public NoeudCaseAbstrait ajouterFils() {
		NoeudCaseAbstrait n = new NoeudCaseMin(this);
		this.fils.add(n);
		return n;
	}

}
