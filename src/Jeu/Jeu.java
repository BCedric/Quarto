package Jeu;

import java.util.ArrayList;

import CaracteristiquesPiece.Couleur;
import CaracteristiquesPiece.Forme;
import CaracteristiquesPiece.Interieur;
import CaracteristiquesPiece.Taille;

public class Jeu {
	private Plateau plateau;
	private ArrayList<Piece> pieces;
	private Joueur j1;
	private Joueur j2;
	private Joueur actif;
	
	public Jeu(){
		this.plateau = new Plateau();
		j1 = new Joueur(this);
		j2 = new Joueur(this);
		j1.setEtatCourant(j1.getAttente());
		j2.setEtatCourant(j2.getChoixPiece());
		this.actif = j1;
		this.pieces = new ArrayList<Piece>();
		pieces.add(new Piece(Couleur.clair, Taille.grand, Interieur.plein, Forme.carree, 1));
		pieces.add(new Piece(Couleur.clair, Taille.grand, Interieur.plein, Forme.rond, 2));
		pieces.add(new Piece(Couleur.clair, Taille.grand, Interieur.vide, Forme.carree, 3));
		pieces.add(new Piece(Couleur.clair, Taille.grand, Interieur.vide, Forme.rond, 4));
		pieces.add(new Piece(Couleur.clair, Taille.petit, Interieur.plein, Forme.carree, 4));
		pieces.add(new Piece(Couleur.clair, Taille.petit, Interieur.plein, Forme.rond, 6));
		pieces.add(new Piece(Couleur.clair, Taille.petit, Interieur.vide, Forme.carree, 7));
		pieces.add(new Piece(Couleur.clair, Taille.petit, Interieur.vide, Forme.rond, 8));
		pieces.add(new Piece(Couleur.sombre, Taille.grand, Interieur.plein, Forme.carree, 9));
		pieces.add(new Piece(Couleur.sombre, Taille.grand, Interieur.plein, Forme.rond, 10));
		pieces.add(new Piece(Couleur.sombre, Taille.grand, Interieur.vide, Forme.carree, 11));
		pieces.add(new Piece(Couleur.sombre, Taille.grand, Interieur.vide, Forme.rond, 12));
		pieces.add(new Piece(Couleur.sombre, Taille.petit, Interieur.plein, Forme.carree, 13));
		pieces.add(new Piece(Couleur.sombre, Taille.petit, Interieur.plein, Forme.rond, 14));
		pieces.add(new Piece(Couleur.sombre, Taille.petit, Interieur.vide, Forme.carree, 15));
		pieces.add(new Piece(Couleur.sombre, Taille.petit, Interieur.vide, Forme.rond, 16));
	}
	
	public boolean placerPiece(Piece p, Case c){
		try {
			c.setPiece(p);
		} catch (CaseOccupeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Ligne l : c.getLignes()){
			if(l.finPartie()){
				return true;
			}
		}
		return false;
	}
	
	public Piece choixPiece(int n){
		for(Piece p:this.pieces){
			if(p.getId() == n){
				return p;
			}
		}
		return null;
	}
	
	public void changerActif(){
		if(j1 != actif){
			actif = j1;
		} else {
			actif = j2;
		}
	}
	
	public Joueur getActif() {
		return actif;
	}
	
	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public Joueur getNonActif(){
		if(actif == j1){
			return j2;
		} else return j1;
	}

	public Case choixCase(int n){
		return this.plateau.choixCase(n);
	}

	public Joueur getJ1() {
		return j1;
	}

	public Joueur getJ2() {
		return j2;
	}

}
