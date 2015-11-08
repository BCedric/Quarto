package Interface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ConteneurBackground extends JPanel{
	private Image img;
	private int x;
	private int y;
	
	public ConteneurBackground(String s){
		super();
		this.img = new ImageIcon(s).getImage();
		this.x=0;
		this.y=0;
	}
	
	public ConteneurBackground(String s, int x, int y){
		super();
		this.x=x;
		this.y=y;
		this.img = new ImageIcon(s).getImage();
	}
	
	public void paintComponent(Graphics g) {
	    g.drawImage(img, x, y, null);
	}
}
