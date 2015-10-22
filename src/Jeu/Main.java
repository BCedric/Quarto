package Jeu;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Jeu j = new Jeu();
		Case c;
		Piece p;
		int n;
		while(true){
			if(j.getActif() == j.getJ1()){
				System.out.println("J2 choisi une piece");
				n = sc.nextInt();
				p = j.choixPiece(n);
				j.getJ2().choisirPieceAction(p);
				System.out.println("J1 choisi une case");
				n = sc.nextInt();
				c = j.choixCase(n);
				j.getJ1().choisirCaseAction(c);
				j.changerActif();
			} else {
				System.out.println("J1 choisi une piece");
				n = sc.nextInt();
				p = j.choixPiece(n);
				j.getJ1().choisirPieceAction(p);
				System.out.println("J2 choisi une case");
				n = sc.nextInt();
				c = j.choixCase(n);
				j.getJ2().choisirCaseAction(c);
				j.changerActif();
			}
		}
	}

}
