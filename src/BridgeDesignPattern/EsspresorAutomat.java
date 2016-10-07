package BridgeDesignPattern;

public class EsspresorAutomat extends Esspresor{

	private Caracteristici c2;
	private Caracteristici c3;
	private Caracteristici c4;
	private Caracteristici c5;
	private Caracteristici c6;



	public EsspresorAutomat(String numeEsspresor, Caracteristici caracteristici, Caracteristici c2, Caracteristici c3,
			Caracteristici c4,Caracteristici c5,Caracteristici c6) {
		super(numeEsspresor, caracteristici);
		this.c2 = c2;
		this.c3 = c3;
		this.c4 = c4;
		this.c5 = c5;
		this.c6 = c6;

	}



	@Override
	public void afisareDetalii() {
		System.out.println("Esspresor "+getNumeEsspresor() +" -Specificatii:\n "+caracteristici.are()+",\n "+c2.are()+",\n "+c3.are()+",\n "+c4.are()+",\n "+ c5.are()+",\n "+c6.are()+".\n");
	}
	
	
}
