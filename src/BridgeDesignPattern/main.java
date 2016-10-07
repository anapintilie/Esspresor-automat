package BridgeDesignPattern;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class main {

	public static void main(String[] args) {
		
		Esspresor e1=new EsspresorAutomat("Philips",
										new Alimentare( "boabe"),
										new CapacitateRezervorApa( 2.5),
										new Functii( "autocuratare"),
										new Greutate(12.4),
										new Dimensiuni(370,350,400),
										new Putere( 1200));
		e1.afisareDetalii();
		
		Caracteristici alimentare=new Alimentare("macinata");
		Caracteristici rezervor  = new CapacitateRezervorApa(3.0);
		Caracteristici dimensiuni=new Dimensiuni(285,375,360);
		Caracteristici functii=new Functii("cappuccino");
		Caracteristici greutate=new Greutate(10);
		Caracteristici putere=new Putere(1450);
		/*
		//invocare metode are() si detalii() pt instanta putere a clasei Putere:
		System.out.println(putere.are());
		putere.detalii();
		System.out.println();
		
		//invocare metode are() si detalii() pt instanta alimentare a clasei Alimentare:
				System.out.println(alimentare.are());
				alimentare.detalii();
		System.out.println();
		
		//invocare metode are() si detalii() pt instanta rezervor a clasei CapacitateRezervorApa:
		System.out.println(rezervor.are());
		rezervor.detalii();
		System.out.println();
		
		//invocare metode are() si detalii() pt instanta dimensiuni a clasei Dimenisiuni:
				System.out.println(dimensiuni.are());
				dimensiuni.detalii();
		System.out.println();
		
		//invocare metode are() si detalii() pt instanta functii a clasei Functii:
		System.out.println(functii.are());
		functii.detalii();
		System.out.println();
		
		//invocare metode are() si detalii() pt instanta greutate a clasei Greutate:
		System.out.println(greutate.are());
		greutate.detalii();
		*/
		
		//instanta de Scanner pt a citi de la consola:
		Scanner scann = new Scanner(System.in);
		
		String denumire="Philips";
		Caracteristici alimentare1;
		Caracteristici rezervor1 ;
		Caracteristici dimensiuni1;
		Caracteristici functii1;
		Caracteristici greutate1;
		Caracteristici putere1;
		
		System.out.print("Dati o denumire a esspresorului: ");
		denumire = scann.nextLine();
		
		System.out.print("Dati tipul alimentarii: ");
		alimentare1 = new Alimentare(scann.nextLine());
		
		System.out.print("Dati capacitatea rezervorului de apa: ");
		rezervor1 = new CapacitateRezervorApa(Double.parseDouble(scann.nextLine()));
		
		System.out.print("Dati dimensiunile: ");
		int x,y,z;
		x=Integer.parseInt(scann.nextLine());
		y=Integer.parseInt(scann.nextLine());
		z=Integer.parseInt(scann.nextLine());
		dimensiuni1 = new Dimensiuni(x,y,z);
		
		System.out.print("Dati numele functiei: ");
		functii1 = new Functii(scann.nextLine());
		
		System.out.print("Dati greutatea: ");
		greutate1 = new Greutate(Double.parseDouble(scann.nextLine()));
		
		System.out.print("Dati puterea: ");
		putere1 = new Putere(Integer.parseInt(scann.nextLine()));
		
		Esspresor ess=new EsspresorAutomat(denumire,alimentare1,rezervor1,dimensiuni1,functii1,greutate1,putere1);
		
		String linie;
		System.out.print("Pentru a scrie un obiect in fisier, introduceti formatul fisierului dorit.\n"+
		"Optiuni format fisier: TXT,XML,JSON sau Consola,EXIT:\n ");
		linie=scann.nextLine();

		
		while (linie != "Exit") {
			switch (linie) {
			
			case "XML":
				try{
					//fisier XML
				
					DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
				    Document doc = docBuilder.newDocument();
				    Element rootElement = doc.createElement("EsspresorAutomat");
				    doc.appendChild(rootElement);
				    
				    Element spec = doc.createElement("Specificatii:");
				    spec.appendChild(doc.createTextNode(denumire));
				    rootElement.appendChild(spec);
				   
				    Element alimentare2 = doc.createElement("Alimentare");
				    alimentare2.appendChild(doc.createTextNode(((Caracteristici) alimentare1).are()));
				    spec.appendChild(alimentare2);
				    
				    Element rezervor2 = doc.createElement("CapacitateRezervorApa");
				    rezervor2.appendChild(doc.createTextNode(((Caracteristici) rezervor1).are()));
				    spec.appendChild(rezervor2);
				    
				    Element dimensiuni2 = doc.createElement("Dimensiuni");
				    dimensiuni2.appendChild(doc.createTextNode(((Caracteristici) dimensiuni1).are()));
				    spec.appendChild(dimensiuni2);
				    
				    Element functii2 = doc.createElement("Functii");
				    functii2.appendChild(doc.createTextNode(((Caracteristici) functii1).are()));
				    spec.appendChild(functii2);
				    
				    Element greutate2 = doc.createElement("Greutate");
				    greutate2.appendChild(doc.createTextNode(((Caracteristici) greutate1).are()));
				   spec.appendChild(greutate2);
				   
				   Element putere2 = doc.createElement("Putere");
				    putere2.appendChild(doc.createTextNode(((Caracteristici) putere1).are()));
				   spec.appendChild(putere2);
				    
				    TransformerFactory transformerFactory = TransformerFactory.newInstance();
				    Transformer transformer = transformerFactory.newTransformer();
				    DOMSource source = new DOMSource(doc);
				    StreamResult result = new StreamResult(new File("EsspresorAutomatXML.xml"));
				    transformer.transform(source, result);
				    System.out.println("Fisier XML salvat ca : EsspresorAutomat!");
				
				}
			 catch (Exception e){
				 e.printStackTrace();
			 }
				System.out.print("Introduceti formatul dorit al fisierului, pentru a scrie obiectul: ");
				linie = scann.nextLine();
				break;
				
			case "TXT":
				// fisier TXT
				try {
					BufferedWriter buffer = new BufferedWriter(new FileWriter(new File("EsspresorAutomatTXT.txt")));
					buffer.write("Denumire: ");
					buffer.write(denumire + "\n");
					buffer.write("Alimentare: ");
					buffer.write(alimentare1.are() + "\n");
					buffer.write("Capacitate rezervor apa: ");
					buffer.write(rezervor1.are() + "\n");
					buffer.write("Dimensiuni: ");
					buffer.write(dimensiuni1.are() + "\n");
					buffer.write("Functii: ");
					buffer.write(functii1.are() + "\n");
					buffer.write("Greutate: ");
					buffer.write(greutate1.are() + "\n");
					buffer.write("Putere: ");
					buffer.write(putere1.are() + "\n");

					System.out.println("Fisier TXT salvat ca: EsspresorAutomatTXT!");
					buffer.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				System.out.print("Introduceti formatul dorit al fisierului, pentru a scrie obiectul: ");
				linie = scann.nextLine();
				break;
		
			case "JSON":
				// scriere in fisier JSON:
				
				JSONObject object = new JSONObject();
				JSONArray EsspresorAutomat = new JSONArray();

				object.put("Denumire: ", denumire);
				EsspresorAutomat.add("Alimentare: " + alimentare1.are());
				EsspresorAutomat.add("Capacitate rezervor apa: " + rezervor1.are());
				EsspresorAutomat.add("Dimensiuni: " + dimensiuni1.are());
				EsspresorAutomat.add("Functii: " + functii1.are());
				EsspresorAutomat.add("Greutate: " + greutate1.are());
				EsspresorAutomat.add("Putere: " + putere1.are());

				object.put("Caracteristici", EsspresorAutomat);

				try (FileWriter file = new FileWriter("EsspresorAutomatJSON.txt")) {
					file.write(object.toJSONString());
					System.out.println("Fisier JSON salvat ca: EsspresorAutomatJSON!");
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.print("Introduceti formatul dorit al fisierului, pentru a scrie obiectul: ");
				linie = scann.nextLine();
				break;

			case "Consola":
				System.out.println();
				ess.afisareDetalii();
				System.out.println();
				System.out.print("Introduceti formatul dorit al fisierului, pentru a scrie obiectul: ");
				linie = scann.nextLine();
				break;
			default:
				System.exit(0);

			}
		}
	}
}
