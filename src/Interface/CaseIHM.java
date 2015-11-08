package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Jeu.Jeu;

public class CaseIHM extends JPanel{
	
	private Jeu j;
	private int id;
	
	public CaseIHM(Jeu j, int id){
		this.id = id;
		this.j =j;
		setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(85, 85));
		this.setOpaque(false);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	public int getId() {
		return id;
	}

	public Jeu getJ() {
		return j;
	}
	
	
}
