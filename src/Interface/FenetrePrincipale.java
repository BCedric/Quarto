package Interface;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetrePrincipale extends JFrame {
private JComboBox liste;
	
	public FenetrePrincipale(){
		super();
		build();
	}
	
	public void build(){
		this.setTitle("Quarto");
		this.setSize(320,240);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(this.buildPanel());
		
	}

	private Container buildPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		this.liste = new JComboBox(new Object[]{"0 joueur", "1 joueur", "2 joueur"});
		JButton bouton = new JButton(new JouerAction("jouer", this));
		
		
		 
		panel.add(liste);
		panel.add(bouton);
		
		return panel;
	}

	public JComboBox getListe() {
		return liste;
	}
}
