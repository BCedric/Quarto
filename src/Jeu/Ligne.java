package Jeu;

import java.util.ArrayList;

public class Ligne {
	private ArrayList<Case> cases;
	
	
	public Ligne(Case[] cases) throws mauvaisNbCasesException{
		this.cases=new ArrayList<Case>();
		for(Case c:cases){
			this.cases.add(c);
			c.ajouterLigne(this);
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
