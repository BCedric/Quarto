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
	
	private JPanel zoneJ1;
	private JPanel zoneJ2;
	private JPanel plateau;
	private JPanel piecesDispo;
	
	public FenetreJeu(String img, Jeu j){
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel1 =new JPanel();
		JPanel panel2 =new JPanel();
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
		this.setVisible(true);
	}
	
	public JPanel getZone(Joueur j){
		if(((ZoneJoueur) this.zoneJ1).getJ() == j) return this.zoneJ1;
		else return this.zoneJ2;
	}

	public JPanel getZoneJ1() {
		return zoneJ1;
	}

	public JPanel getZoneJ2() {
		return zoneJ2;
	}

	public JPanel getPlateau() {
		return plateau;
	}

	public JPanel getPiecesDispo() {
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
