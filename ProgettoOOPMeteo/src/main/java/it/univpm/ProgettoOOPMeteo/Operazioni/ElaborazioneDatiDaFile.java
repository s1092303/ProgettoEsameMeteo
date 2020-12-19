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

public class ElaborazioneDatiDaFile {

	private Vector<String> ID = new Vector<String>();
	private Vector<Citta> city = new Vector<Citta> ();

		public ElaborazioneDatiDaFile() throws FileNotFoundException, IOException, ParseException {
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
				JSONObject ob = (JSONObject) parser.parse(new FileReader("Storicocitta"+ ID.get(k) +".txt"));
				JSONArray a = (JSONArray) ob.get("listacitta");
				for (Object o : a) {
					JSONObject citta = (JSONObject) o;
					JSONArray visibilita = (JSONArray) citta.get("vis");
					for (Object c : visibilita) {
						vis.add((Long)c);
					}
					JSONArray velocita = (JSONArray) citta.get("velocitaVento");
					for (Object c : velocita) {
						vel.add((Double) c);
					}
					JSONArray angoli = (JSONArray) citta.get("angoloVento");
					for (Object c : angoli) {
						deg.add((Long) c);
					}
					citt.setNome(ID.get(k));
					citt.setVelocitaVento(vel);
					citt.setAngoloVento(deg);
					citt.setVis(vis);
				}
				city.add(citt);
			}
		}

		public Vector<Citta> getCity() {
			return city;
		}

		public void setCity(Vector<Citta> city) {
			this.city = city;
		}

		public Vector<String> getID() {
			return ID;
		}

		public void setID(Vector<String> iD) {
			ID = iD;
		}
	
}
