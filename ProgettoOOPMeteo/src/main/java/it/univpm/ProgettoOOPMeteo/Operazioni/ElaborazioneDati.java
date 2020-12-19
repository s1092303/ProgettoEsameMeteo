package it.univpm.ProgettoOOPMeteo.Operazioni;

import java.util.Vector;

import citta.Citta;
import parser.ParserJSON;

/**
 * Classe necessaria per elaborare i dati di un file JSON preso in ingresso tramite delle API
 * 
 * @author Nicola Ronchini, Tommaso Omiccioli
 *
 */

public class ElaborazioneDati {
	
	private Vector<Citta> Listacitta = new Vector<Citta> ();
	
	public ElaborazioneDati() {
		
		Vector<String> ID = new Vector<String> ();
		String url;
		ParserJSON parser = new ParserJSON();
		ID.add("london,uk");
		ID.add("rome");
		ID.add("amsterdam");
		ID.add("Madrid");
		ID.add("Paris");
		for (int i = 0; i < ID.size(); i++) {
			Citta c = new Citta();
			c.setNome(ID.get(i));
			
			for (int j=0; j<=85; j++) {
				
			c.SetPosVel( Math.random() * 10);
			c.SetPosVis( (long) ((Math.random() * 2000)+8000));}
			
			
			Listacitta.add(c);
		}
		
	}
	
	/**
	 * Restituisce il vettore Listacitta
	 * @return Listacitta
	 */

	public Vector<Citta> getListacitta() {
		return Listacitta;
	}
	
	/**
	 * Insersice un vettore Listacitta preso in ingresso
	 * @param listacitta
	 */

	public void setListacitta(Vector<Citta> listacitta) {
		Listacitta = listacitta;
	}

}
