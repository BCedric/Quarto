package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import Jeu.Joueur;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ZoneJoueur extends JPanel{
	
	private Joueur j;
	
	public ZoneJoueur(Joueur j){
		this.j = j;
		this.setPreferredSize(new Dimension(100, 150));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new FlowLayout());
		if(j.getJeu().getJ1() == j){
			this.add(new JLabel("Joueur 1"));
		} else this.add(new JLabel("Joueur 2"));
		this.setOpaque(false);
	}
	
	public void insererPiece(PieceIHM p){
		this.add(p);
		p.setLocation(this.getWidth()/2-p.getWidth()/2, this.getHeight()/2-p.getHeight()/2);
		this.repaint();
	}
	
	public PieceIHM retirerPiece(){
		for(Component comp:this.getComponents()){
			if(comp instanceof PieceIHM){
				this.remove(comp);
				this.repaint();
				return (PieceIHM) comp;
			}
		}
		
		return null;
	}

	public Joueur getJ() {
		return j;
	}
}
