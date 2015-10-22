package Jeu;

import java.util.ArrayList;

import CaracteristiquesPiece.Couleur;
import CaracteristiquesPiece.Forme;
import CaracteristiquesPiece.Interieur;
import CaracteristiquesPiece.Taille;


public class Piece {
	private Couleur couleur;
	private Taille taille;
	private Interieur interieur;
	private Forme forme;
	private int id;
	
	public Piece(Couleur couleur, Taille taille, Interieur interieur,
			Forme forme, int id) {
		super();
		this.couleur = couleur;
		this.taille = taille;
		this.interieur = interieur;
		this.forme = forme;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public ArrayList<String> caracteristiquesCommunes(Piece p){
		ArrayList<String> list = new ArrayList<String>();
		if(this.couleur == p.getCouleur()){
			list.add("couleur");
		}
		if(this.forme == p.forme){
			list.add("forme");
		}
		if(this.interieur== p.interieur){
			list.add("interieur");
		}
		if(this.taille== p.taille){
			list.add("taille");
		}
		return list;
	}
	
	public Couleur getCouleur() {
		return couleur;
	}

	public Taille getTaille() {
		return taille;
	}

	public Interieur getInterieur() {
		return interieur;
	}

	public Forme getForme() {
		return forme;
	}

		
}
