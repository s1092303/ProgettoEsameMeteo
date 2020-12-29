package Filtri;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import citta.Citta;
import it.univpm.ProgettoOOPMeteo.Operazioni.ElaborazioneDatiDaFile;

/**
 * Questa classe permette, dato in input il nome di una citta come stringa, di ritornare in output la citta con quel nome
 * 
 * @author Nicola Ronchini, Tommaso Omiccioli
 *
 */


public class FiltroPerNome {
	
	private Citta citta;
/**
 * Costruttore che prende come parametro la stringa da utilizzare come nome della citta da cercare e una volta trovata inizializza l'attributo
 * della classe citta con la citta trvata
 * 
 * @param DaInserire
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
	public FiltroPerNome(String DaInserire) throws FileNotFoundException, IOException, ParseException {
		ElaborazioneDatiDaFile d = new ElaborazioneDatiDaFile();
		
		for (int i = 0; i < d.getCity().size(); i++) 
			if (DaInserire.equals(d.getCity().get(i).getNome())) citta = d.getCity().get(i);
	}
	
	/**
	 * Restituisce la citta 
	 * @return Citta
	 */
	public Citta getCitta() {
		if (citta == null) return null;
		else return citta;
	}

}
