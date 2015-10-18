package Jeu;

public class Case {
	private int id;
	private Piece piece;
	
	public Case(int id){
		this.id = id;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) throws CaseOccupeeException {
		if(this.piece == null){
			this.piece = piece;
		} else{
			throw new CaseOccupeeException();
		}
	}

	public int getId() {
		return id;
	}

	public boolean estVide() {
		return this.piece == null;
	}
}
