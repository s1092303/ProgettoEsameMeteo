package parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 * Questa classe è necessaria per ordinare i dati presi in input da una API esterna
 * 
 * @author Nicola Ronchini, Tommaso Omiccioli
 *
 */

public class ParserJSON {
	
	private JSONObject jo = null; // creo un oggetto di tipo JSON
	private double speed; 
	private long deg;
	private long vis;
    

	/**
	 * Restituisce un oggetto di tipo JSON
	 * @return jo
	 */
	
	public JSONObject getJo() {
		return jo;
	}
	
	/**
	 * Inserisce un oggetto di tipo JSON preso in input
	 * @param jo
	 */

	public void setJo(JSONObject jo) {
		this.jo = jo;
	}
	
	/**
	 * Questo metodo prende in input una stringa URL necessaria per collegarsi ad una API esterna che ci fornisce i dati rigurdanti alle citta
	 * Il metodo cerca i campi wind e visibility del file JSON in ingresso e li salva all'interno della classe
	 * @param url
	 */
	
	public void chiamataAPI(String url) {
		try {
			URLConnection openConnection = new URL(url).openConnection(); //apro la connesione URL
			InputStream fin = openConnection.getInputStream(); //apro il flusso di input
			
			String data = "";
			String line = "";
			try {
				BufferedReader Bread = new BufferedReader(new InputStreamReader(fin));
			     while ( ( line = Bread.readLine() ) != null ) {
				   data+= line; //mi salvo il contenuto del JSON in una string data
			   }
			} finally {
			   fin.close();
			}
				this.jo = (JSONObject) JSONValue.parseWithException(data); // effettuo il parsing di data
				JSONObject getSth = (JSONObject) jo.get("wind"); //ricerca del campo wind
				speed = (Double) getSth.get("speed"); //all'interno del campo wind cerca il campo speed e salvo il contenuto in una variabile speed
				deg = (Long) getSth.get("deg"); // successivamente cerca anche il campo deg (angolo del vento) e salvo il contenuto in una variabile deg
				vis = (Long) jo.get("visibility"); // cerca il campo visibility e salva il suo contenuto in una variabile vis
		} catch (IOException | ParseException e) { // cerca eccezioni di I/O o errori di parsing
			e.printStackTrace();
		} catch (Exception e) { // cerca eccezioni di ogni tipo
			e.printStackTrace();
		}
	}
	
	/**
	 * Restituisce il valore di speed
	 * @return speed
	 */
	
	public Double getSpeed() {
		return speed;
	}
	
	/**
	 * Restituisce il valore di deg
	 * @return deg
	 */
	
	public long getDeg() {
		return deg;
	}
	
	/**
	 * Restituisce il valore di vis
	 * @return vis
	 */
	
	public long getVis() {
		return vis;
	}

}
