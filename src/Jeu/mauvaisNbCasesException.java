package Jeu;

public class mauvaisNbCasesException extends Exception {
	public mauvaisNbCasesException(){
		System.out.println("Le nombre de cases dans la ligne est incorrect");
	}
}
