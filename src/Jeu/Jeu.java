package Jeu;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import CaracteristiquesPiece.Couleur;
import CaracteristiquesPiece.Forme;
import CaracteristiquesPiece.Interieur;
import CaracteristiquesPiece.Taille;
import IA.IA;
import IA.IA1;
import IA.IA2;
import Interface.FenetreJeu;

public class Jeu {
	private Plateau plateau;
	private ArrayList<Piece> pieces;
	private Joueur j1;
	private Joueur j2;
	private IA ia;
	private Joueur actif;
	private FenetreJeu vue;
	private boolean finPartie;
	
	public Jeu(boolean b, String ia){
		this.build();
		
		if(ia.equals("1")) this.ia = new IA1(this, this.j1);
		if(ia.equals("2")) this.ia = new IA2(this, this.j1);
		if(ia.equals("0")) this.ia = null;
		if(b) this.vue = new FenetreJeu("img/texture.jpg", this);
	}
	
	/**
	 * Construction du jeu
	 */
	private void build(){
		this.plateau = new Plateau();
		this.finPartie = false;
		j1 = new Joueur(this);
		j2 = new Joueur(this);
		j1.setEtatCourant(j1.getAttente());
		j2.setEtatCourant(j2.getChoixPiece());
		this.actif = j1;
		this.pieces = new ArrayList<Piece>();
		pieces.add(new Piece(Couleur.clair, Taille.grand, Interieur.plein, Forme.carree, 1));
		pieces.add(new Piece(Couleur.clair, Taille.grand, Interieur.plein, Forme.rond, 2));
		pieces.add(new Piece(Couleur.clair, Taille.grand, Interieur.vide, Forme.carree, 3));
		pieces.add(new Piece(Couleur.clair, Taille.grand, Interieur.vide, Forme.rond, 4));
		pieces.add(new Piece(Couleur.clair, Taille.petit, Interieur.plein, Forme.carree, 5));
		pieces.add(new Piece(Couleur.clair, Taille.petit, Interieur.plein, Forme.rond, 6));
		pieces.add(new Piece(Couleur.clair, Taille.petit, Interieur.vide, Forme.carree, 7));
		pieces.add(new Piece(Couleur.clair, Taille.petit, Interieur.vide, Forme.rond, 8));
		pieces.add(new Piece(Couleur.sombre, Taille.grand, Interieur.plein, Forme.carree, 9));
		pieces.add(new Piece(Couleur.sombre, Taille.grand, Interieur.plein, Forme.rond, 10));
		pieces.add(new Piece(Couleur.sombre, Taille.grand, Interieur.vide, Forme.carree, 11));
		pieces.add(new Piece(Couleur.sombre, Taille.grand, Interieur.vide, Forme.rond, 12));
		pieces.add(new Piece(Couleur.sombre, Taille.petit, Interieur.plein, Forme.carree, 13));
		pieces.add(new Piece(Couleur.sombre, Taille.petit, Interieur.plein, Forme.rond, 14));
		pieces.add(new Piece(Couleur.sombre, Taille.petit, Interieur.vide, Forme.carree, 15));
		pieces.add(new Piece(Couleur.sombre, Taille.petit, Interieur.vide, Forme.rond, 16));
	}
	
	/**
	 * Lancement du jeu
	 */
	public void jouer(){
		if(this.vue != null){
			this.vue.jouer();
		} else {
			Scanner sc = new Scanner(System.in);
			Case c = null;
			Piece p = null;
			int n;
			while(true){
				Joueur actif=this.getActif();
				Joueur nonActif=this.getNonActif();
				
				while(p==null){
					if(this.getJ1() == actif){
						System.out.println("J2 choisi une piece");
					} else {
						System.out.println("J1 choisi une piece");
					}
					n = sc.nextInt();
					p = this.choixPiece(n);
				}
				nonActif.choisirPieceAction(p);
				p=null;
				
				while(c == null){
					if(this.getJ1() == actif){
						System.out.println("J1 choisi une case");
					} else {
						System.out.println("J2 choisi une case");
					}
					n=sc.nextInt();
					c = this.choixCase(n);
				}
				actif.choisirCaseAction(c);
				if(c.finPartie()) break;
				c=null;
				
			}
			System.out.println("Fin de partie");
		}
	}
	
	/**
	 * Placement d'une piece dans une case
	 * @param p Piece a placer
	 * @param c Case dans laquelle mettre la piece
	 * @return renvoie true si la piece a bien ete placee dans la case
	 */
	public boolean placerPiece(Piece p, Case c){		
		c.setPiece(p);
		for(Ligne l : c.getLignes()){
			if(l.finPartie()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Renvoie la piece d'identifiant n
	 * @param n identifiant de la piece
	 * @return la piece 
	 */
	public Piece choixPiece(int n){
		for(Piece p:this.pieces){
			if(p.getId() == n){
				return p;
			}
		}
		return null;
	}
	
	/**
	 * Change de joueur actif
	 */
	public void changerActif(){
		if(j1 != actif){
			actif = j1;
		} else {
			actif = j2;
		}
	}
	
	public Plateau getPlateau() {
		return plateau;
	}

	public FenetreJeu getVue() {
		return vue;
	}
	
	public Joueur getActif() {
		return actif;
	}
	
	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public Joueur getNonActif(){
		if(actif == j1){
			return j2;
		} else return j1;
	}

	public Case choixCase(int n){
		return this.plateau.choixCase(n);
	}

	public Joueur getJ1() {
		return j1;
	}

	public Joueur getJ2() {
		return j2;
	}
	
	public boolean isFinPartie() {
		return finPartie;
	}

	public void setFinPartie(boolean finPartie) {
		this.finPartie = finPartie;
	}

	public IA getIa() {
		return ia;
	}

}
