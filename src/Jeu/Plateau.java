package Jeu;

import java.util.ArrayList;

public class Plateau {
	private ArrayList<Ligne> lignes;
	
	public Plateau(){
		lignes = new ArrayList<Ligne>();
		Case c1 = new Case(1);
		Case c2 = new Case(2);
		Case c3 = new Case(3);
		Case c4 = new Case(4);
		Case c5 = new Case(5);
		Case c6 = new Case(6);
		Case c7 = new Case(7);
		Case c8 = new Case(8);
		Case c9 = new Case(9);
		Case c10 = new Case(10);
		Case c11 = new Case(11);
		Case c12 = new Case(12);
		Case c13 = new Case(13);
		Case c14 = new Case(14);
		Case c15 = new Case(15);
		Case c16 = new Case(16);
		
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
	
	private void addLigne(Case c1, Case c2, Case c3, Case c4){
		Case [] l ={c1,c2,c3,c4}; 
		try {
			this.lignes.add(new Ligne(l));
		} catch (mauvaisNbCasesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Ligne> getLignes(){
		return this.lignes;
	}
}
