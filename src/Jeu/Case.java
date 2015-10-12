package Jeu;

public abstract class Case {
	private int id;
	private Piece piece;
	
	public Case(int id){
		this.id = id;
	}

	public void occupeCase(Piece piece) throws CaseOccupeeException{
		if(this.piece == null){
			this.piece = piece;
		} else{
			throw new CaseOccupeeException();
		}
	}
	
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public int getId() {
		return id;
	}
}
