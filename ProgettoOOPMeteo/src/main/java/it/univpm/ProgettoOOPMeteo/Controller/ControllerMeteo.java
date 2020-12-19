package it.univpm.ProgettoOOPMeteo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Filtri.FiltroPerNome;
import Filtri.StatisticheVentoGiornaliere;
import citta.Citta;
import it.univpm.ProgettoOOPMeteo.Operazioni.ElaborazioneDati;

/**
 * Controller del codice per utilizzare i metodi attraverso URL
 * 
 * @author Nicola Ronchini, Tommaso Omiccioli
 *
 */

@RestController
public class ControllerMeteo {

	@GetMapping("/ListaCitta")
	public ElaborazioneDati exampleMethod () {
		ElaborazioneDati p = new ElaborazioneDati();
		return p;
	}
	
	@PostMapping("/nomeCitta")
	public Citta method(@RequestParam(name = "param", required = false) String param) {
		try {
			FiltroPerNome f = new FiltroPerNome(param);
			return f.getCitta();
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping("/statsVento")
	public StatisticheVentoGiornaliere method2() {
		StatisticheVentoGiornaliere p = new StatisticheVentoGiornaliere();
		return p;
	}

	@GetMapping("/ListaDaFile")
	public ElaborazioneDati esempiodafile () {
		ElaborazioneDati p = new ElaborazioneDati("Storicocitta.txt");
		return p;
	}
}
