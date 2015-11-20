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
	protected int profondeur =2;
	
	public IA(Jeu jeu, Joueur j){
		this.jeu =jeu;
		this.j = j;
	}
	/**
	 * Fonction permettant d'evaluer le jeu 
	 * @param j la situation du jeu en cours
	 * @return renvoie un entier qui rend compte de la situation de la partie
	 */
	public abstract int evaluation(Jeu j);
	
	/**
	 * Fonction permettant de choisir le coup à jouer (coup à jouer et piece à donner à l'adversaire)
	 */
	public void jouerPieceChoisirPiece(){
		//Creation de la racine
		NoeudMax racine = new NoeudMax(null,this, null, null);
		
		racine.nb =0;
		
		racine.calculIA(this.jeu, racine.getCoupsCases(jeu), racine.getCoupsPieces(jeu), this.profondeur);
		
		//du coup à jouer
		for(NoeudAbstrait n:racine.fils){
			if(n.getValeur() == racine.getValeur()){
				Case c = n.getCoupCase();
				Piece p = n.getCoupPiece();
				
				//joue la piece donnée par l'adversaire
				jeu.getVue().jouerPiece(jeu.getVue().getPlateau().getCase(c.getId()));
				j.choisirCaseAction(c);
				
				
				if(jeu.isFinPartie()){
					//si le coup termine la partie, on affiche la fenetre de fin de partie
					for(Ligne l:jeu.getPlateau().getLignes()){
						if(l.finPartie()){
							new FenetreFinDePartie(jeu,l).setVisible(true);
							jeu.getVue().finPartie();
						}
						
					}
					
				} else {
					//sinon, on choisi la piece à donner à l'adversaire
					this.j.choisirPieceAction(p);
					jeu.getVue().choisirPiece(jeu.getVue().getPiecesDispo().getPiece(p.getId()));
				}
				System.out.println(n.nb);
				break;
			}
		}
	}
	
	/**
	 * Fonction permettant de choisir la piece à donner à l'adversaire
	 */
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
