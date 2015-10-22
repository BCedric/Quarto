package Jeu;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Jeu j = new Jeu();
		Case c = null;
		Piece p = null;
		int n;
		while(true){
			Joueur actif=j.getActif();
			Joueur nonActif=j.getNonActif();
			
			while(p==null){
				if(j.getJ1() == actif){
					System.out.println("J2 choisi une piece");
				} else {
					System.out.println("J1 choisi une piece");
				}
				n = sc.nextInt();
				p = j.choixPiece(n);
			}
			nonActif.choisirPieceAction(p);
			p=null;
			
			while(c == null){
				if(j.getJ1() == actif){
					System.out.println("J1 choisi une case");
				} else {
					System.out.println("J2 choisi une case");
				}
				n=sc.nextInt();
				c = j.choixCase(n);
			}
			actif.choisirCaseAction(c);
			if(c.finPartie()) break;
			c=null;
			j.changerActif();
		}
		System.out.println("Fin de partie");
	}

}
