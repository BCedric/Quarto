package Jeu;

import EtatJoueur.EtatAttente;
import EtatJoueur.EtatChoixPiece;
import EtatJoueur.EtatJouerPiece;
import EtatJoueur.EtatJoueur;

public class Joueur {
	private Jeu j;
	private EtatJoueur etatCourant;
	private EtatAttente attente;
	private EtatChoixPiece choixPiece;
	private EtatJouerPiece jouerPiece;
	private Piece main;
	
	public Joueur(){
		this.attente = new EtatAttente(this);
		this.choixPiece = new EtatChoixPiece(this);
		this.jouerPiece = new EtatJouerPiece(this);
	}

	public Piece getMain() {
		return main;
	}

	public void setMain(Piece main) {
		this.main = main;
	}

	public EtatJoueur getEtatCourant() {
		return etatCourant;
	}

	public void setEtatCourant(EtatJoueur etatCourant) {
		this.etatCourant = etatCourant;
	}

	public EtatAttente getAttente() {
		return attente;
	}

	public EtatChoixPiece getChoixPiece() {
		return choixPiece;
	}

	public EtatJouerPiece getJouerPiece() {
		return jouerPiece;
	}

	
}
