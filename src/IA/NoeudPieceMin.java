package IA;

import Jeu.Piece;

public class NoeudPieceMin extends NoeudPieceAbstrait {

	public NoeudPieceMin(NoeudAbstrait pere, Piece coup) {
		super(pere, coup);
	}

	@Override
	public void calculValeurNoeud() {
		if(this.estFeuille()){
			//TODO evaluation
		} else {
			int val = this.fils.get(0).getValeur();
			for(NoeudPieceAbstrait n:this.fils){
				if(val > n.getValeur()){
					val = n.getValeur();
				}
			}
			this.valeur = val;
		}
		
	}

	@Override
	public NoeudPieceAbstrait ajouterFils(Piece coup) {
		NoeudPieceAbstrait n = new NoeudPieceMax(this, coup);
		this.fils.add(n);
		return n;
	}

}
