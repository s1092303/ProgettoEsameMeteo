package it.univpm.ProgettoOOPMeteo.Operazioni;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import citta.Citta;

/**
 * Questa classe serve a prendere in input da un file gli storici di cinque citta
 * @author Nicola Ronchini, Tommaso Omiccioli
 *
 */

public class ElaborazioneDatiDaFile {

	private Vector<String> ID = new Vector<String>(); // vettore di stringhe contenente i nomi delle varie citta
	private Vector<Citta> city = new Vector<Citta> (); // vettore di un oggetto Citta che conterrà i dati presi in input

	/**
	 * Costruttore della classe, serve per fare il parsing del file preso in input
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
		public ElaborazioneDatiDaFile() throws FileNotFoundException, IOException, ParseException {
			//aggiungo i nomi delle varie citta
			ID.add("london,uk");
			ID.add("rome");
			ID.add("amsterdam");
			ID.add("Madrid");
			ID.add("Paris");
			JSONParser parser = new JSONParser();
			for (int k = 0; k < ID.size(); k++) {
				Citta citt = new Citta();
				Vector<Double> vel = new Vector<Double> ();
				Vector<Long> vis = new Vector<Long> ();
				Vector<Long> deg = new Vector <Long> ();
				JSONObject ob = (JSONObject) parser.parse(new FileReader("Storicocitta"+ ID.get(k) +".txt")); //prendo in input ogni volta un file diverso per ogni citta
				JSONArray a = (JSONArray) ob.get("listacitta");
				for (Object o : a) {
					JSONObject citta = (JSONObject) o;
					JSONArray visibilita = (JSONArray) citta.get("vis");
					for (Object c : visibilita) { //riempo il vettore delle visiiblita
						vis.add((Long)c);
					}
					JSONArray velocita = (JSONArray) citta.get("velocitaVento");
					for (Object c : velocita) { //riempo il vettore delle velocita dei venti
						vel.add((Double) c);
					}
					JSONArray angoli = (JSONArray) citta.get("angoloVento");
					for (Object c : angoli) { //riempo il vettore delle angolazioni dei venti
						deg.add((Long) c);
					}
					//copio tutte le informazioni in un oggetto di tipo Citta
					citt.setNome(ID.get(k));
					citt.setVelocitaVento(vel);
					citt.setAngoloVento(deg);
					citt.setVis(vis);
				}
				city.add(citt); //inserisco l'oggetto di tipo Citta precedentemente creato nel vettore
			}
		}

		/**
		 * Restituisce il vettore delle citta
		 * @return city
		 */
		
		public Vector<Citta> getCity() {
			return city;
		}
		
		/**
		 * Modifica il vettore delle citta con uno preso in input
		 * @param city
		 */

		public void setCity(Vector<Citta> city) {
			this.city = city;
		}
		
		/**
		 * Restituisce il vettore dei nomi delle citta
		 * @return ID
		 */

		public Vector<String> getID() {
			return ID;
		}
		
		/**
		 * Modifico il vettore dei nomi delle citta con uno preso in input
		 * @param iD
		 */

		public void setID(Vector<String> ID) {
			this.ID = ID;
		}
	
}
