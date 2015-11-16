package IA;

import Jeu.Case;

public class NoeudCaseMin extends NoeudCaseAbstrait{

	public NoeudCaseMin(NoeudCaseAbstrait pere, Case coup) {
		super(pere, coup);
	}

	@Override
	public void calculValeurNoeud() {
		if(this.estFeuille()){
			//TODO evaluation
		} else {
			int val = this.fils.get(0).getValeur();
			for(NoeudCaseAbstrait n:this.fils){
				if(val > n.getValeur()){
					val = n.getValeur();
				}
			}
			this.valeur = val;
		}
		
	}

	@Override
	public NoeudCaseAbstrait ajouterFils(Case coup) {
		NoeudCaseAbstrait n = new NoeudCaseMax(this, coup);
		this.fils.add(n);
		return n;
	}

}
