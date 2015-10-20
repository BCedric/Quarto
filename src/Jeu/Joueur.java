package Jeu;

import EtatJoueur.EtatAttente;
import EtatJoueur.EtatChoixPiece;
import EtatJoueur.EtatJouerPiece;
import EtatJoueur.EtatJoueur;

public class Joueur {
	private Jeu jeu;
	private EtatJoueur etatCourant;
	private EtatAttente attente;
	private EtatChoixPiece choixPiece;
	private EtatJouerPiece jouerPiece;
	private Piece main;
	
	
	public Joueur(Jeu j){
		this.attente = new EtatAttente(this);
		this.choixPiece = new EtatChoixPiece(this);
		this.jouerPiece = new EtatJouerPiece(this);
		this.jeu = j;
	}
	
	public void choisirPieceAction(Piece p){
		this.etatCourant.choisirPiece(p);
	}
	

	public void choisirCaseAction(Case c){
		this.etatCourant.choisirCase(c);
	}
	
	public Jeu getJeu() {
		return jeu;
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
