package IA;

import Jeu.Case;
import Jeu.Jeu;
import Jeu.Piece;

public class NoeudMin extends NoeudAbstrait{

	public NoeudMin(NoeudAbstrait pere, IA ia, Case c, Piece p) {
		super(pere, ia, c, p);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public NoeudAbstrait ajouterFils(Case c, Piece p) {
		NoeudAbstrait n = new NoeudMax(this, this.ia, c, p);
		this.fils.add(n);
		return n;
	}

	public void calculValeurNoeud(Jeu j) {
		if(this.estFeuille()){
			this.valeur = ia.evaluation(j, this);
		} else {
			int val = this.fils.get(0).getValeur();
			for(NoeudAbstrait n:this.fils){
				if(val > n.getValeur()){
					val = n.getValeur();
				}
			}
			this.valeur = val;
		}
	}
	
	@Override
	public boolean elagage(){
		if(this.pere != null && !this.estFeuille()){
			for(NoeudAbstrait n:this.fils){
				if(n.valeur < this.pere.getValeur()){
					this.pere.getFils().remove(this);
					return true;
				}
			}
				
		}
		return false;
	}


}
