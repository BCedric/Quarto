package IA;

public class NoeudCaseMin extends NoeudCaseAbstrait{

	public NoeudCaseMin(NoeudCaseAbstrait pere) {
		super(pere);
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
	public NoeudCaseAbstrait ajouterFils() {
		NoeudCaseAbstrait n = new NoeudCaseMax(this);
		this.fils.add(n);
		return n;
	}

}
