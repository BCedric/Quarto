package Interface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Jeu.Jeu;
import Jeu.Joueur;
import Jeu.Ligne;

public class FenetreFinDePartie extends JFrame{
	
	private JPanel conteneur;
	
	public FenetreFinDePartie(Jeu j, Ligne l){
		String carac="";
		String joueur;
		this.conteneur=new JPanel();
		this.setContentPane(this.conteneur);
		conteneur.setLayout(new FlowLayout());
		
		this.setSize(300, 200);
		this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-this.getWidth()/2, Toolkit.getDefaultToolkit().getScreenSize().height/2-this.getHeight());
		
		for(String s:l.caracteristiquesCommunes()){
			carac=carac+" "+s;
		}
		if(j.getActif() == j.getJ1()) joueur = "J1";
		else joueur="J2";
		
		conteneur.add(new JLabel("Le joueur "+joueur+" gagne la partie"));
		conteneur.add(new JLabel("La ligne a en commun : "+carac));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
