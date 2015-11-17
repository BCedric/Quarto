package IA;

import java.util.ArrayList;

import Jeu.Jeu;
import Jeu.Case;
import Jeu.Piece;

public class NoeudCaseMax extends NoeudCaseAbstrait{

	public NoeudCaseMax(NoeudAbstrait pere, Piece coup) {
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
	public NoeudPieceAbstrait ajouterFils(Case coup) {
		NoeudPieceAbstrait n = new NoeudPieceMax(this, coup);
		this.fils.add(n);
		return n;
	}

}
