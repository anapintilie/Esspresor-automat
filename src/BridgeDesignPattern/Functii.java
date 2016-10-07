package BridgeDesignPattern;

public class Functii implements Caracteristici{
	private String functii;

	public Functii(String functii) {
		super();
		this.functii = functii;
	}

	@Override
	public String are() {
		return functii;
	}

	@Override
	public void detalii() {
		System.out.println("Contine atat functii de baza, cat si functii avansate,de ultima tehnologie.Acestea fiind "+are()+" .");
	}
	
	
}
