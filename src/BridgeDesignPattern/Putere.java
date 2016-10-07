package BridgeDesignPattern;

public class Putere implements Caracteristici{

	private int putere;
	
	
	public Putere(int putere) {
		this.putere = putere;
	}

	@Override
	public String are() {
		return String.valueOf(putere)+" W";
	}


	@Override
	public void detalii() {
		System.out.println("Puterea este de "+are());
	}

}
