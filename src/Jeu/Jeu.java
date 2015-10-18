package Jeu;

import java.util.ArrayList;

import CaracteristiquesPiece.Couleur;
import CaracteristiquesPiece.Forme;
import CaracteristiquesPiece.Interieur;
import CaracteristiquesPiece.Taille;

public class Jeu {
	private Plateau plateau;
	private ArrayList<Piece> pieces;
	
	public Jeu(){
		Plateau plateau = new Plateau();
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

}
