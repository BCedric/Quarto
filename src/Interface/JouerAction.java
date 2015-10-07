package Interface;


import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;


public class JouerAction extends AbstractAction{
	private FenetrePrincipale fenetre;
	public JouerAction(String text, FenetrePrincipale fenetre){
		super(text);
		this.fenetre = fenetre;
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Object selected = fenetre.getListe().getSelectedItem();
		System.out.println(selected.toString());
	}
	

}
