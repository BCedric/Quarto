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
	protected int profondeur = 5;
	
	public IA(Jeu jeu, Joueur j){
		this.jeu =jeu;
		this.j = j;
	}
	
	public abstract int evaluation(Jeu j);
	
	public void jouerPiece(){
		NoeudCaseMax racine = new NoeudCaseMax(null, null, this);
		ArrayList<Case> coups = new ArrayList<Case>();
		for(Case c:this.jeu.getPlateau().getCases()){
			if(c.estVide()) coups.add(c);
		}
		racine.calculIA(this.jeu, coups, this.profondeur);
		for(NoeudAbstrait n:racine.fils){
			if(n.getValeur() == racine.getValeur()){
				Case c = ((NoeudPieceAbstrait) n).getCoup();
				jeu.getVue().jouerPiece(jeu.getVue().getPlateau().getCase(c.getId()));
				j.choisirCaseAction(c);
				if(jeu.isFinPartie()){
					for(Ligne l:jeu.getPlateau().getLignes()){
						if(l.finPartie()){
							new FenetreFinDePartie(jeu,l).setVisible(true);
							jeu.getVue().finPartie();
						}
						
					}
					
				}
				break;
				
			}
		}
	}
	
	public void choisirPiece(){
		NoeudPieceMax racine = new NoeudPieceMax(null, null, this);
		ArrayList<Piece> coups = (ArrayList<Piece>) this.jeu.getPieces().clone();
		racine.calculIA(this.jeu, coups, this.profondeur);
		for(NoeudAbstrait n:racine.fils){
			if(n.getValeur() == racine.getValeur()){
				System.out.println(racine .getValeur());
				Piece p = ((NoeudCaseAbstrait) n).getCoup();
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
