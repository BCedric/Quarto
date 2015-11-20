package IA;

import java.util.ArrayList;

import Interface.FenetreFinDePartie;
import Jeu.Case;
import Jeu.Jeu;
import Jeu.Joueur;
import Jeu.Ligne;
import Jeu.Piece;

public abstract class IA {

	protected Joueur j;
	protected Jeu jeu;
	protected int profondeur = 4;
	
	public IA(Jeu jeu, Joueur j){
		this.jeu =jeu;
		this.j = j;
	}
	
	public abstract int evaluation(Jeu j);
	
	public void jouerPieceChoisirPiece(){
		NoeudMax racine = new NoeudMax(null,this, null, null);
		racine.nb =0;
		ArrayList<Case> coups = new ArrayList<Case>();
		for(Case c:this.jeu.getPlateau().getCases()){
			if(c.estVide()) coups.add(c);
		}
		racine.calculIA(this.jeu, racine.getCoupsCases(jeu), racine.getCoupsPieces(jeu), this.profondeur);
		for(NoeudAbstrait n:racine.fils){
			if(n.getValeur() == racine.getValeur()){
				Case c = n.getCoupCase();
				Piece p = n.getCoupPiece();
				jeu.getVue().jouerPiece(jeu.getVue().getPlateau().getCase(c.getId()));
				j.choisirCaseAction(c);
				if(jeu.isFinPartie()){
					for(Ligne l:jeu.getPlateau().getLignes()){
						if(l.finPartie()){
							new FenetreFinDePartie(jeu,l).setVisible(true);
							jeu.getVue().finPartie();
						}
						
					}
					
				} else {
					this.j.choisirPieceAction(p);
					jeu.getVue().choisirPiece(jeu.getVue().getPiecesDispo().getPiece(p.getId()));
				}
				System.out.println(n.nb);
				break;
			}
		}
	}
	
	public void choisirPiece(){
		NoeudMax racine = new NoeudMax(null,this, null, null);
		ArrayList<Piece> coups = (ArrayList<Piece>) this.jeu.getPieces().clone();
		racine.calculIA(this.jeu, null , coups, this.profondeur);
		for(NoeudAbstrait n:racine.fils){
			if(n.getValeur() == racine.getValeur()){
				Piece p = n.getCoupPiece();
				this.j.choisirPieceAction(p);
				jeu.getVue().choisirPiece(jeu.getVue().getPiecesDispo().getPiece(p.getId()));
				break;
				
			}
		}
		
	}

	public Jeu getJeu() {
		return jeu;
	}
}
