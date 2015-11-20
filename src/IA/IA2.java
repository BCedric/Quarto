package IA;

import CaracteristiquesPiece.Couleur;
import Jeu.Jeu;
import Jeu.Joueur;
import Jeu.Piece;

public class IA2 extends IA{

	public IA2(Jeu jeu, Joueur j) {
		super(jeu, j);
	}

	@Override
	public int evaluation(Jeu j) {
		int eval = 0;
		for(Piece p:j.getPieces()){
			if(p.getCouleur()==Couleur.clair){
				++eval;
			}
		}
		return eval;
	}

}
