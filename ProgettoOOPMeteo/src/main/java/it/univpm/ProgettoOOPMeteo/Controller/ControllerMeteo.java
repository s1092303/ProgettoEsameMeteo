package it.univpm.ProgettoOOPMeteo.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Filtri.FiltroPerNome;
import Filtri.StatisticheAScelta;
import Filtri.StatisticheASceltaPerCitta;
import Filtri.StatisticheGiornaliere;
import Filtri.StatisticheGiornalierePerCitta;
import Filtri.StatisticheSettimanali;
import Filtri.StatisticheSettimanaliPerCitta;
import Filtri.StatisticheVento;
import Filtri.StatisticheVisibilita;
import citta.Citta;
import citta.CittaMediaVar;
import it.univpm.ProgettoOOPMeteo.Operazioni.ElaborazioneDati;
import it.univpm.ProgettoOOPMeteo.Operazioni.ElaborazioneDatiDaFile;

/**
 * Controller del codice per utilizzare i metodi attraverso URL
 * 
 * @author Nicola Ronchini, Tommaso Omiccioli
 *
 */

@RestController
public class ControllerMeteo {

	@GetMapping("/ListaCitta") 
	public Vector<CittaMediaVar> exampleMethod(
			@RequestParam(required = false, defaultValue = "1") String NomeCitta) throws FileNotFoundException, IOException, ParseException {
		StatisticheAScelta p = new StatisticheAScelta(0, 85);
		if (NomeCitta.equals("1")) {
			return p.getVettore();
		}
		else {
			StatisticheASceltaPerCitta c = new StatisticheASceltaPerCitta(0, 85, NomeCitta);
			Vector<CittaMediaVar> CittaScelta = new Vector<CittaMediaVar> ();
			CittaScelta.add(c.getCittaMediaVar());
			return CittaScelta;
		}
	}
	
	
}
