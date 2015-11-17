package IA;

import Jeu.Case;
import Jeu.Piece;

public class NoeudCaseMin extends NoeudCaseAbstrait{

	public NoeudCaseMin(NoeudAbstrait pere, Piece coup) {
		super(pere, coup);
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
	public NoeudPieceAbstrait ajouterFils(Case coup) {
		NoeudPieceAbstrait n = new NoeudPieceMin(this, coup);
		this.fils.add(n);
		return n;
	}

}
