package Interface;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Jeu.Jeu;

public class PlateauIHM extends ConteneurBackground{
	
	private static final int taille = 4;
	

	public PlateauIHM(Jeu jeu, FenetreJeu fj){
		super("img/texture.jpg", -800, -650);
		CaseIHM caseIhm = null;
		setLayout(new GridLayout(taille,taille));
		for(int i=0; i<taille;++i){
			for(int j=0;j<taille;++j){
				caseIhm = new CaseIHM(jeu, j+1+(i*taille));
				caseIhm.addMouseListener(new SelectionCaseAction(fj));
				add(caseIhm);
			}
		}
	}
	
	/**
	 * Fonction qui renvoie une case du plateau
	 * @param i identifiant de la case
	 * @return la case d'identifiant i
	 */
	public CaseIHM getCase(int i){
		if(i<1 || i>16) return null;
		for(Component c:this.getComponents()){
			if(c instanceof CaseIHM && ((CaseIHM) c).getId()==i){
				return (CaseIHM) c;
			}
		}
		return null;
	}
}
