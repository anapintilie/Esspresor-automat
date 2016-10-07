package BridgeDesignPattern;

public class Alimentare implements Caracteristici {
	
	private String alimentare;

	public Alimentare(String alimentare) {
		super();
		this.alimentare = alimentare;
	}

	@Override
	public String are() {
		return alimentare;
	}

	@Override
	public void detalii() {
		System.out.println("Alimentarea se refera la tipul cafelei.Aceasta este "+ are());
	}
	
	
}
