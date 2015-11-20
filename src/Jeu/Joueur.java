package Jeu;

import EtatJoueur.EtatAttente;
import EtatJoueur.EtatChoixPiece;
import EtatJoueur.EtatJouerPiece;
import EtatJoueur.EtatJoueur;
import Interface.CaseIHM;
import Interface.FenetreJeu;
import Interface.PieceIHM;

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
	
	/**
	 * Action de choisir une piece
	 * @param p piece choisie
	 */
	public void choisirPieceAction(Piece p){
		this.etatCourant.choisirPiece(p);
	}

	/**
	 * Action de choisir une case 
	 * @param c Case choisie
	 * @return renvoie vrai si le coup déclenche une fin de partie
	 */
	public boolean choisirCaseAction(Case c){
		this.jeu.setFinPartie(this.etatCourant.choisirCase(c));
		return this.jeu.isFinPartie();
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
