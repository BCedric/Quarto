package Interface;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;



public class ListNbJoueur extends DefaultComboBoxModel<String>{
	private ArrayList<String> list;

	
	public ListNbJoueur(String[] list) {
		super();
		this.list = new ArrayList<String>();
		for(String s:list){
			this.list.add(s);
		}
	}
	
	public ArrayList<String> getList(){
		return this.list;
	}
	
	@Override
	public String getElementAt(int index) {
		return list.get(index);
	}
 
	@Override
	public int getSize() {
		return list.size();
	}
 
	@Override
	public int getIndexOf(Object element) {
		return list.indexOf(element);
	}
	
	
}
