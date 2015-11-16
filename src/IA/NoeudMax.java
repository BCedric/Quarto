package IA;

import java.util.ArrayList;

import Jeu.Jeu;
import Jeu.Case;

public class NoeudMax extends NoeudAbstrait{

	public NoeudMax(NoeudAbstrait pere) {
		super(pere);
	}

	@Override
	public void calculValeurNoeud() {
		if(this.estFeuille()){
			//TODO evaluation
		} else {
			int val = this.fils.get(0).getValeur();
			for(NoeudAbstrait n:this.fils){
				if(val < n.getValeur()){
					val = n.getValeur();
				}
			}
			this.valeur = val;
		}
	}
	
	@Override
	public NoeudAbstrait ajouterFils() {
		NoeudAbstrait n = new NoeudMin(this);
		this.fils.add(n);
		return n;
	}

}
