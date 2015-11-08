package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import Jeu.Jeu;
import Jeu.Piece;

public class PieceIHM extends ConteneurBackground{
	private int id;
	private Jeu j;
	private JComponent conteneur;
	
	public PieceIHM(String img, int i, Jeu j, JPanel conteneur){
		super(img);
		this.setConteneur(conteneur);
		this.id = i;
		this.j = j;
		this.setPreferredSize(new Dimension(80, 80));
	}
	
	 public Jeu getJ() {
		return j;
	}
	 
	public int getId() {
		return id;
	}

	public JComponent getConteneur() {
		return conteneur;
	}

	public void setConteneur(JComponent conteneur) {
		this.conteneur = conteneur;
	}

}
