package Jeu;

import java.util.ArrayList;

public class Ligne {
	private ArrayList<Case> cases;
	
	public Ligne(Case[] cases) throws mauvaisNbCasesException{
		for(Case c:cases){
			this.cases.add(c);
		} if(this.cases.size() != 4){
			throw new mauvaisNbCasesException();
		}
	}
	
	public boolean estComplète(){
		for(Case c:this.cases){
			if(c.estVide()){
				return false;
			}
		}
		return true;
	}
	
	public boolean finPartie(){
		if(this.estComplète()){
			ArrayList<String> caracCommunesGlobales = new ArrayList<String>();
			caracCommunesGlobales.add("couleur");
			caracCommunesGlobales.add("taille");
			caracCommunesGlobales.add("interieur");
			caracCommunesGlobales.add("forme");
			for(int i=1;i<cases.size();++i){
				Piece p1 = cases.get(i-1).getPiece();
				Piece p2 = cases.get(i).getPiece();
				ArrayList<String> caracCommunes = p1.caracteristiquesCommunes(p2);
				for(String s : caracCommunesGlobales){
					if(!caracCommunes.contains(s)){
						caracCommunesGlobales.remove(s);
					}
				}
				if(caracCommunesGlobales.isEmpty()){
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

}
