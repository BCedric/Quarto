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
	
	public abstract void calculValeurNoeud(Jeu j);
	public abstract NoeudAbstrait ajouterFils(Case c, Piece p);
	public abstract boolean elagage();
	
	public void calculIA(Jeu j, ArrayList<Case> coupsCase, ArrayList<Piece> coupsPiece, int prof){
		boolean elaguer = false;
		if(prof == 0 || j.isFinPartie() ){
			this.calculValeurNoeud(j);
		} else {
			for(Piece p : coupsPiece){
				if(coupsCase != null){
					for(Case c:coupsCase){
						j.getActif().choisirCaseAction(c);
						if(!j.isFinPartie() && !j.getPieces().isEmpty()){
							j.getNonActif().choisirPieceAction(p);
							NoeudAbstrait n =this.ajouterFils(c, p);
							n.calculIA(j,n.getCoupsCases(j), n.getCoupsPieces(j), prof-1);
							this.calculValeurNoeud(j);
							elaguer = this.elagage();
							this.annulerCoupPiece(j);
						} else {
							NoeudAbstrait n =this.ajouterFils(c, p);
							n.calculIA(j,n.getCoupsCases(j), n.getCoupsPieces(j), prof-1);
							this.calculValeurNoeud(j);
							elaguer = this.elagage();
						}
						this.annulerCoupCase(j, c);
						if(elaguer){
							break;
						}
					}
				} else{
					j.getNonActif().choisirPieceAction(p);
					NoeudAbstrait n =this.ajouterFils(null, p);
					n.calculIA(j,n.getCoupsCases(j), n.getCoupsPieces(j), prof-1);
					this.calculValeurNoeud(j);
					elaguer = this.elagage();
					this.annulerCoupPiece(j);
				}
				if(elaguer){
					break;
				}
			}
		}
	}
	
	public void annulerCoupCase(Jeu j, Case c){
		j.changerActif();
		j.getActif().setMain(c.getPiece());
		c.setPiece(null);
		j.getActif().setEtatCourant(j.getActif().getJouerPiece());
		if(j.isFinPartie()) j.setFinPartie(false);
	}
	
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
	
	public ArrayList<Piece> getCoupsPieces(Jeu j){
		ArrayList<Piece> coups = (ArrayList<Piece>) j.getPieces().clone();
		return coups;
	}
	
	public ArrayList<Case> getCoupsCases(Jeu j){
		ArrayList<Case> coups = new ArrayList<Case>();
		for(Case c:j.getPlateau().getCases()){
			if(c.estVide()) coups.add(c);
		}
		return coups;
	}
}
