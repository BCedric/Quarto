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
	private Joueur tour;
	
	public Jeu(){
		Plateau plateau = new Plateau();
		j1 = new Joueur(this);
		j2 = new Joueur(this);
		this.tour = j1;
		pieces.add(new Piece(Couleur.clair, Taille.grand, Interieur.plein, Forme.carree));
		pieces.add(new Piece(Couleur.clair, Taille.grand, Interieur.plein, Forme.rond));
		pieces.add(new Piece(Couleur.clair, Taille.grand, Interieur.vide, Forme.carree));
		pieces.add(new Piece(Couleur.clair, Taille.grand, Interieur.vide, Forme.rond));
		pieces.add(new Piece(Couleur.clair, Taille.petit, Interieur.plein, Forme.carree));
		pieces.add(new Piece(Couleur.clair, Taille.petit, Interieur.plein, Forme.rond));
		pieces.add(new Piece(Couleur.clair, Taille.petit, Interieur.vide, Forme.carree));
		pieces.add(new Piece(Couleur.clair, Taille.petit, Interieur.vide, Forme.rond));
		pieces.add(new Piece(Couleur.sombre, Taille.grand, Interieur.plein, Forme.carree));
		pieces.add(new Piece(Couleur.sombre, Taille.grand, Interieur.plein, Forme.rond));
		pieces.add(new Piece(Couleur.sombre, Taille.grand, Interieur.vide, Forme.carree));
		pieces.add(new Piece(Couleur.sombre, Taille.grand, Interieur.vide, Forme.rond));
		pieces.add(new Piece(Couleur.sombre, Taille.petit, Interieur.plein, Forme.carree));
		pieces.add(new Piece(Couleur.sombre, Taille.petit, Interieur.plein, Forme.rond));
		pieces.add(new Piece(Couleur.sombre, Taille.petit, Interieur.vide, Forme.carree));
		pieces.add(new Piece(Couleur.sombre, Taille.petit, Interieur.vide, Forme.rond));
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

	public Joueur getJ1() {
		return j1;
	}

	public Joueur getJ2() {
		return j2;
	}
	
	
	
	

}
