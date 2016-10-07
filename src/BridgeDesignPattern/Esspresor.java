package BridgeDesignPattern;

public abstract class Esspresor {
	private String numeEsspresor;
	
	
	public String getNumeEsspresor() {
		return numeEsspresor;
	}

	protected Caracteristici caracteristici;

	
	
	public Esspresor(String numeEsspresor, Caracteristici caracteristici) {
		super();
		this.numeEsspresor = numeEsspresor;
		this.caracteristici = caracteristici;
	}



	public abstract void afisareDetalii();
}
