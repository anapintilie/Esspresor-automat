package BridgeDesignPattern;

public class CapacitateRezervorApa implements Caracteristici{

	private double litri;
	
	
	public CapacitateRezervorApa(double litri) {
		super();
		this.litri = litri;
	}

	@Override
	public String are() {
		return String.valueOf(litri)+" l";
	}

	@Override
	public void detalii() {
		System.out.println("Rezervorul apei este de "+are()+ " .");
	}

}
