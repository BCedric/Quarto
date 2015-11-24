package IA;

import java.util.ArrayList;

import Jeu.Case;
import Jeu.Jeu;
import Jeu.Piece;

public abstract class NoeudAbstrait {
	
	protected int valeur;
	protected NoeudAbstrait pere;
	protected ArrayList<NoeudAbstrait> fils;
	protected IA ia;
	protected Piece coupPiece;
	protected Case coupCase;
	public static int nb =0;
	
	
	
	public NoeudAbstrait(NoeudAbstrait pere, IA ia, Case c, Piece p){
		this.nb++;
		this.pere = pere;		
		this.fils =new ArrayList<NoeudAbstrait>();
		this.ia = ia;
		this.coupCase = c;
		this.coupPiece = p;
	}
	/**
	 * Fonction permettant de calculer la valeur du noeud
	 * @param j la situation du jeu en cours
	 */
	public abstract void calculValeurNoeud(Jeu j);
	
	/**
	 * Ajout d'un fils 
	 * @param c le coup a jouer pour arriver dans cette configuration
	 * @param p la piece a donner pour arriver dans cette configuration
	 * @return le noeud cree
	 */
	public abstract NoeudAbstrait ajouterFils(Case c, Piece p);
	
	/**
	 * fonction supprimant les branches inutiles
	 * @return true si la branche a ete supprimee, false sinon
	 */
	public abstract boolean elagage();
	
	/**
	 * Fonction qui creee l'arbre et choisi le coup a jouer
	 * @param j la situation du jeu en cours
	 * @param coupsCase les coups possibles
	 * @param coupsPiece les pieces disponible a donner a l'adversaire
	 * @param prof la profodeur de l'arbre
	 */
	public void calculIA(Jeu j, ArrayList<Case> coupsCase, ArrayList<Piece> coupsPiece, int prof){
		boolean elaguer = false;
		
		//Si la on doit s'arreter ou si la partie est fini, on calcul la valeur du noeud
		if(prof == 0 || j.isFinPartie() ){
			this.calculValeurNoeud(j);
		} else {
			for(Piece p : coupsPiece){
				// Le premier a jouer donne uniquement une piece, on teste donc si la liste des coup existe
				if(coupsCase != null){
					for(Case c:coupsCase){
						
						//on effectue le coup c
						j.getActif().choisirCaseAction(c);
						
						//Si la partie n'est pas terminee, on donne une piece a l'adversaire
						if(!j.isFinPartie() && !j.getPieces().isEmpty()){
							j.getNonActif().choisirPieceAction(p);
							
							//on cree un nouveau noeud et on calcul sa valeur
							NoeudAbstrait n =this.ajouterFils(c, p);
							n.calculIA(j,n.getCoupsCases(j), n.getCoupsPieces(j), prof-1);
							this.calculValeurNoeud(j);
							
							//suppression des branche inutiles
//							elaguer = n.elagage();
							
							//annulation du don de la piece
							this.annulerCoupPiece(j);
						} else {
							//on cree un nouveau noeud et on calcul sa valeur
							NoeudAbstrait n =this.ajouterFils(c, p);
							n.calculIA(j,n.getCoupsCases(j), n.getCoupsPieces(j), prof-1);
							this.calculValeurNoeud(j);
							
							//suppression des branche inutiles
//							elaguer = n.elagage();
						}
						
						//annulation du coup
						this.annulerCoupCase(j, c);
						
						//si l'elagagage a fonctionne, il ne sert a rien de continuer sur cette branche
						if(elaguer){
							break;
						}
					}
				} else{
					//si on c'est le premier tour (don d'une piece seulement)
					j.getNonActif().choisirPieceAction(p);
					NoeudAbstrait n =this.ajouterFils(null, p);
					n.calculIA(j,n.getCoupsCases(j), n.getCoupsPieces(j), prof-1);
					this.calculValeurNoeud(j);
//					elaguer = n.elagage();
					this.annulerCoupPiece(j);
				}
				
				//si l'elagagage a fonctionne, il ne sert a rien de continuer sur cette branche
				if(elaguer){
					break;
				}
			}
		}
	}
	
	/**
	 * Annulation du depot d'une piece dans une case
	 * @param j La situation du jeu en cours
	 * @param c La case dans laquelle la piece a ete jouee 
	 */
	public void annulerCoupCase(Jeu j, Case c){
		j.changerActif();
		j.getActif().setMain(c.getPiece());
		c.setPiece(null);
		j.getActif().setEtatCourant(j.getActif().getJouerPiece());
		if(j.isFinPartie()) j.setFinPartie(false);
	}
	
	/**
	 * Annulation du don d'une piece a l'adversaire
	 * @param j La situation du jeu en cours
	 */
	public void annulerCoupPiece(Jeu j){
		j.getPieces().add(j.getActif().getMain());
		j.getActif().setMain(null);
		j.getActif().setEtatCourant(j.getActif().getAttente());
		j.getNonActif().setEtatCourant(j.getNonActif().getChoixPiece());
	}
	
	
	
	public int getValeur() {
		return valeur;
	}

	public NoeudAbstrait getPere() {
		return pere;
	}
	
	public boolean estFeuille(){
		return this.fils.isEmpty();
	}
	
	public ArrayList<NoeudAbstrait> getFils() {
		return fils;
	}

	public Piece getCoupPiece() {
		return coupPiece;
	}

	public Case getCoupCase() {
		return coupCase;
	}
	/**
	 * Renvoie les pieces disponibles
	 * @param j La situation du jeu en cours
	 * @return pieces disponibles
	 */
	public ArrayList<Piece> getCoupsPieces(Jeu j){
		ArrayList<Piece> coups = (ArrayList<Piece>) j.getPieces().clone();
		return coups;
	}
	
	/**
	 * Renvoie les cases disponibles
	 * @param j La situation du jeu en cours
	 * @return les cases disponibles
	 */
	public ArrayList<Case> getCoupsCases(Jeu j){
		ArrayList<Case> coups = new ArrayList<Case>();
		for(Case c:j.getPlateau().getCases()){
			if(c.estVide()) coups.add(c);
		}
		return coups;
	}
}
