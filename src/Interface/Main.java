package Interface;

import javax.swing.JFrame;

import Jeu.Case;
import Jeu.Jeu;
import Jeu.Piece;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		
//		args[0] = 
//		0 : pas d'IA, 
//		1 : IA1,
//		2 : IA2
		 Jeu j = new Jeu(true, args[0]);
		 j.jouer();

	}

}
