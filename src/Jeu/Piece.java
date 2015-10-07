package Jeu;

public class Piece {
	private Couleur couleur;
	private Taille taille;
	private Interieur interieur;
	private Forme forme;
	
	public Piece(Couleur couleur, Taille taille, Interieur interieur,
			Forme forme) {
		super();
		this.couleur = couleur;
		this.taille = taille;
		this.interieur = interieur;
		this.forme = forme;
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
