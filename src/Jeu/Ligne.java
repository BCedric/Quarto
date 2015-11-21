package Jeu;

import java.util.ArrayList;

public class Ligne {
	private ArrayList<Case> cases;
	
	
	public Ligne(Case[] cases) {
		this.cases=new ArrayList<Case>();
		for(Case c:cases){
			this.cases.add(c);
			c.ajouterLigne(this);
		}
	}
	
	/**
	 * Teste si la ligne est complete
	 * @return true si la ligne est complete, false sinon
	 */
	public boolean estComplète(){
		for(Case c:this.cases){
			if(c.estVide()){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Teste si la partie est terminée
	 * @return true si la partie est terminée
	 */
	public boolean finPartie(){
		if(this.estComplète()){
			if(this.caracteristiquesCommunes().isEmpty()){
				return false;
			}

			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Case> getCases() {
		return cases;
	}

	/**
	 * Fonction renvoyant la liste des caractéristiques communes des pieces présentes sur la ligne 
	 * @return les caractéristique communes aux pieces 
	 */
	public ArrayList<String> caracteristiquesCommunes(){
		ArrayList<String> caracCommunesGlobales = new ArrayList<String>();
		String s;
		Piece p1;
		Piece p2;
		caracCommunesGlobales.add("couleur");
		caracCommunesGlobales.add("taille");
		caracCommunesGlobales.add("interieur");
		caracCommunesGlobales.add("forme");
		for(int i=1;i<cases.size();++i){
			p1 = cases.get(i-1).getPiece();
			p2 = cases.get(i).getPiece();
			ArrayList<String> caracCommunes = p1.caracteristiquesCommunes(p2);
			for(int j = caracCommunesGlobales.size()-1;j>=0 ;--j){
				s=caracCommunesGlobales.get(j);
				if(!caracCommunes.contains(s)){
					caracCommunesGlobales.remove(s);
				}
			}
		}
		return caracCommunesGlobales;
	}

}
