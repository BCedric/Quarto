package Jeu;

import java.util.ArrayList;

public class Case {
	private int id;
	private Piece piece;
	private ArrayList<Ligne> lignes;
	
	public Case(int id){
		this.id = id;
		lignes = new ArrayList<Ligne>();
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public int getId() {
		return id;
	}
	
	public boolean finPartie(){
		for(Ligne l:this.lignes){
			if(l.finPartie()) return true;
		}
		return false;
	}

	public boolean estVide() {
		return this.piece == null;
	}
	
	public void ajouterLigne(Ligne l){
		this.lignes.add(l);
	}
	
	public ArrayList<Ligne> getLignes(){
		return this.lignes;
	}
}
