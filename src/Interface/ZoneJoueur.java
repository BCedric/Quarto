package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import Jeu.Joueur;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ZoneJoueur extends JPanel{
	
	private Joueur j;
	
	public ZoneJoueur(Joueur j){
		this.j = j;
		this.setPreferredSize(new Dimension(100, 150));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new FlowLayout());
	}

	public Joueur getJ() {
		return j;
	}
}
