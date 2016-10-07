package BridgeDesignPattern;

public class Greutate implements Caracteristici{

	private double greutate;
	
	
	public Greutate(double greutate) {
		super();
		this.greutate = greutate;
	}

	@Override
	public String are() {
		return String.valueOf(greutate)+" kg";
	}

	@Override
	public void detalii() {
		System.out.println("Greutatea este de "+are());
	}
	
}
