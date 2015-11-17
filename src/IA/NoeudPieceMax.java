package IA;

import Jeu.Case;
import Jeu.Piece;

public class NoeudPieceMax extends NoeudPieceAbstrait{

	public NoeudPieceMax(NoeudAbstrait pere, Case coup) {
		super(pere, coup);
		
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
	public NoeudCaseAbstrait ajouterFils(Piece coup) {
		NoeudCaseAbstrait n = new NoeudCaseMin(this, coup);
		this.fils.add(n);
		return n;
	}


}
