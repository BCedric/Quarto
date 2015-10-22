package Jeu;

import java.util.ArrayList;

public class Plateau {
	private ArrayList<Ligne> lignes;
	private ArrayList<Case> cases;
	
	public Plateau(){
		this.cases = new ArrayList<Case>();
		lignes = new ArrayList<Ligne>();
		Case c1 = this.nouvelleCase(1);
		Case c2 = this.nouvelleCase(2);
		Case c3 = this.nouvelleCase(3);
		Case c4 = this.nouvelleCase(4);
		Case c5 = this.nouvelleCase(5);
		Case c6 = this.nouvelleCase(6);
		Case c7 = this.nouvelleCase(7);
		Case c8 = this.nouvelleCase(8);
		Case c9 = this.nouvelleCase(9);
		Case c10 = this.nouvelleCase(10);
		Case c11 = this.nouvelleCase(11);
		Case c12 = this.nouvelleCase(12);
		Case c13 = this.nouvelleCase(13);
		Case c14 = this.nouvelleCase(14);
		Case c15 = this.nouvelleCase(15);
		Case c16 = this.nouvelleCase(16);
		
		this.addLigne(c1,c2,c3,c4);
		this.addLigne(c5,c6,c7,c8);
		this.addLigne(c9,c10,c11,c12);
		this.addLigne(c13,c14,c15,c16);
		
		this.addLigne(c1,c5,c9,c13);
		this.addLigne(c2,c6,c10,c14);
		this.addLigne(c3,c7,c11,c15);
		this.addLigne(c4,c8,c12,c16);
		
		this.addLigne(c1,c6,c11,c16);
		this.addLigne(c4,c7,c10,c13);
	}
	
	private Case nouvelleCase(int n){
		Case c = new Case(n);
		this.cases.add(c);
		return c;
	}
	
	private void addLigne(Case c1, Case c2, Case c3, Case c4){
		Case [] l ={c1,c2,c3,c4}; 
		try {
			this.lignes.add(new Ligne(l));
		} catch (mauvaisNbCasesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Case choixCase(int n){
		for(Case c:this.cases){
			if(c.getId() == n){
				return c;
			}
		}
		return null;
	}
	
	public ArrayList<Ligne> getLignes(){
		return this.lignes;
	}
}
