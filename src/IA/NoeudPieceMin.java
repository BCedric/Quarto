package IA;

import Jeu.Case;
import Jeu.Piece;

public class NoeudPieceMin extends NoeudPieceAbstrait {

	public NoeudPieceMin(NoeudAbstrait pere, Case coup, IA ia) {
		super(pere, coup, ia);
	}

	@Override
	public void calculValeurNoeud() {
		if(this.estFeuille()){
			//TODO evaluation
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
	public NoeudCaseAbstrait ajouterFils(Piece coup) {
		NoeudCaseAbstrait n = new NoeudCaseMax(this, coup, this.ia);
		this.fils.add(n);
		return n;
	}

}
