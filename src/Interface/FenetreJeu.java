package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Jeu.Jeu;
import Jeu.Joueur;

public class FenetreJeu extends JFrame{
	
	private ZoneJoueur zoneJ1;
	private ZoneJoueur zoneJ2;
	private PlateauIHM plateau;
	private PiecesDispo piecesDispo;
	private Jeu j;
	
	public FenetreJeu(String img, Jeu j){
		this.j=j;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel1 =new JPanel();
		JPanel panel2 =new ConteneurBackground("img/texture1.jpg");
		panel2.setLayout(new BorderLayout());
		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		panel1.setLayout(new FlowLayout());
		this.plateau = new PlateauIHM(j, this);
		panel1.add(this.plateau);
		this.piecesDispo =new PiecesDispo(j, this); 
		panel1.add(this.piecesDispo);
		panel2.add(panel1, BorderLayout.CENTER);
		this.zoneJ1 =new ZoneJoueur(j.getJ1());
		this.zoneJ2 = new ZoneJoueur(j.getJ2());
		panel2.add(this.zoneJ1, BorderLayout.SOUTH);
		panel2.add(this.zoneJ2, BorderLayout.NORTH);
		
		this.setContentPane(panel2);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
	}
	
	public void jouer(){
		this.setVisible(true);
	}
	
	public void jouerPiece(CaseIHM c){
		PieceIHM p=null;
		if(this.zoneJ1.getJ() == this.j.getActif()){
			p=zoneJ1.retirerPiece();
		} else p=zoneJ2.retirerPiece();
		c.add(p);
		p.setLocation(c.getWidth()/2-p.getWidth()/2, c.getHeight()/2-p.getHeight()/2);
		c.repaint();
	}
	
	public void choisirPiece(PieceIHM p){
		this.piecesDispo.retirerPiece(p);
		if(this.zoneJ1.getJ() == this.j.getActif()){
			zoneJ1.insererPiece(p);
		} else zoneJ2.insererPiece(p);
	}
	
	public ZoneJoueur getZone(Joueur j){
		if(((ZoneJoueur) this.zoneJ1).getJ() == j) return this.zoneJ1;
		else return this.zoneJ2;
	}

	public ZoneJoueur getZoneJ1() {
		return zoneJ1;
	}

	public ZoneJoueur getZoneJ2() {
		return zoneJ2;
	}

	public PlateauIHM getPlateau() {
		return plateau;
	}

	public PiecesDispo getPiecesDispo() {
		return piecesDispo;
	}

	public void finPartie() {
		JLabel text = new JLabel("Fin");
		System.out.println("fin de partie");
		this.piecesDispo.removeAll();
		this.piecesDispo.add(text);
		
		
		this.repaint();
	}
	

}
