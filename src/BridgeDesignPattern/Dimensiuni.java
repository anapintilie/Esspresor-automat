package BridgeDesignPattern;

public class Dimensiuni implements Caracteristici{

	private int lungime;
	private int inaltime;
	private int latime;
	
	public Dimensiuni(int lungime, int inaltime, int latime) {
		super();
		this.lungime = lungime;
		this.inaltime = inaltime;
		this.latime = latime;
	}

	@Override
	public String are() {
		return String.valueOf(lungime)+" "+String.valueOf(latime)+" "+String.valueOf(inaltime)+" mm";
	}

	@Override
	public void detalii() {
		System.out.println("Dimensiunile sunt exprimate in lungime,latime si inaltime,iar acestea sunt: "+are()+" .");
	}

}
