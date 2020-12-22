package Filtri;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import citta.Citta;
import it.univpm.ProgettoOOPMeteo.Operazioni.ElaborazioneDatiDaFile;

/**
 *  
 * 
 * @author Nicola Ronchini, Tommaso Omiccioli
 *
 */


public class FiltroPerNome {
	
	private Citta citta;

	public FiltroPerNome(String DaInserire) throws FileNotFoundException, IOException, ParseException {
		ElaborazioneDatiDaFile d = new ElaborazioneDatiDaFile();
		
		for (int i = 0; i < d.getCity().size(); i++) 
			if (DaInserire.equals(d.getCity().get(i).getNome())) citta = d.getCity().get(i);
	}
	
	public Citta getCitta() {
		return citta;
	}

}
