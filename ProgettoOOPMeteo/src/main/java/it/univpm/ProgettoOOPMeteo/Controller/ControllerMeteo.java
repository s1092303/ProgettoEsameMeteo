package it.univpm.ProgettoOOPMeteo.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Filtri.FiltroPerNome;
import Filtri.StatisticheAScelta;
import Filtri.StatisticheGiornaliere;
import Filtri.StatisticheGiornalierePerCitta;
import Filtri.StatisticheSettimanali;
import Filtri.StatisticheSettimanaliPerCitta;
import Filtri.StatisticheVento;
import Filtri.StatisticheVisibilita;
import citta.Citta;
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

	
	
	}
