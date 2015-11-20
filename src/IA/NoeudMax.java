package IA;

import Jeu.Case;
import Jeu.Jeu;
import Jeu.Piece;

public class NoeudMax extends NoeudAbstrait {

	public NoeudMax(NoeudAbstrait pere, IA ia, Case c, Piece p) {
		super(pere, ia, c, p);
	}
	
	@Override
	public NoeudAbstrait ajouterFils(Case c, Piece p) {
		NoeudAbstrait n = new NoeudMin(this, this.ia, c, p);
		this.fils.add(n);
		return n;
	}

	@Override
	public void calculValeurNoeud(Jeu j) {
		if(this.estFeuille()){
			this.valeur = ia.evaluation(j);
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
	
	public boolean elagage(){
		if(this.pere != null && this.valeur > this.pere.getValeur()){
			this.pere.getFils().remove(this);
			return true;
		}
		return false;
	}
}
