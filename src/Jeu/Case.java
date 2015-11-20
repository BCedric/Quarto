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

	/**
	 * Fonction qui renvoie vrai si la partie est terminee faux sinon
	 * @return vrai si la partie est terminee faux sinon
	 */
	public boolean finPartie(){
		for(Ligne l:this.lignes){
			if(l.finPartie()) return true;
		}
		return false;
	}

	/**
	 * Renvoie vrai si la case est vide, faux sinon
	 * @return vrai si la case est vide, faux sinon
	 */
	public boolean estVide() {
		return this.piece == null;
	}
	
	/**
	 * Fonction permettant d'ajouter la case dans une ligne
	 * @param l
	 */
	public void ajouterLigne(Ligne l){
		this.lignes.add(l);
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
	
	public ArrayList<Ligne> getLignes(){
		return this.lignes;
	}
}
