package Jeu;

import java.util.ArrayList;

public class Plateau {
	private ArrayList<Ligne> lignes;
	
	public Plateau(){
		lignes = new ArrayList<Ligne>();
	}
	
	public void addLigne(Ligne l){
		this.lignes.add(l);
	}
	
	public ArrayList<Ligne> getLignes(){
		return this.lignes;
	}
}
