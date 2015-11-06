package Interface;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import Jeu.Jeu;

public class PlateauIHM extends JPanel{
	
	private static final int taille = 4;

	public PlateauIHM(Jeu jeu, FenetreJeu fj){
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
	
	
}
