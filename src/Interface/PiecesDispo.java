package Interface;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import Jeu.Jeu;
import Jeu.Piece;

public class PiecesDispo extends JPanel{

	private static final int taille = 4;
	
	public PiecesDispo(Jeu j, FenetreJeu fj){
		PieceIHM pieceIhm = null;
		
		setLayout(new FlowLayout());
		for(int i=0; i<taille*taille;++i){
			pieceIhm = new PieceIHM("img/piece"+(i+1)+".png", i+1, j, this);
			pieceIhm.addMouseListener(new SelectionPieceAction(fj));
			this.add(pieceIhm);
		}
		this.setPreferredSize(new Dimension(640, 300));
	}
}