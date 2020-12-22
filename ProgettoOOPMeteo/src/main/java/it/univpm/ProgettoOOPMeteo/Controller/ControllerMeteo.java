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
	public StatisticheAScelta method2() throws FileNotFoundException, IOException, ParseException {
		StatisticheAScelta p = new StatisticheAScelta(0,20);
		return p;
	}

	@GetMapping("/ListaDaFile")
	public ElaborazioneDatiDaFile esempiodafile () throws ParseException, FileNotFoundException, IOException {
		ElaborazioneDatiDaFile p = new ElaborazioneDatiDaFile();
		return p;
	}
	
	@GetMapping("/StatisticheGiorno")
	public StatisticheGiornaliere method3(@RequestParam (value = "param" ,required = false)int param) throws FileNotFoundException, IOException, ParseException {
	StatisticheGiornaliere p = new StatisticheGiornaliere (param);
	return p;
	}
	
	@GetMapping("/StatisticheSettimana")
	public StatisticheSettimanali method4(@RequestParam (value = "param" ,required = false)int param) throws FileNotFoundException, IOException, ParseException {
	StatisticheSettimanali p = new StatisticheSettimanali (param);
	return p;
	}
	@GetMapping("/StatisticheGiornoCitta")
	public StatisticheGiornalierePerCitta method5(@RequestParam (value = "NomeCitta" ,required = false)String NomeCitta, @RequestParam(value = "Giorno" , required = false) int Giorno) throws FileNotFoundException, IOException, ParseException {
	StatisticheGiornalierePerCitta p = new StatisticheGiornalierePerCitta (NomeCitta, Giorno);
	return p;
	}
	
	@GetMapping("/StatisticheSettimanaCitta")
	public StatisticheSettimanaliPerCitta method6(@RequestParam (value = "NomeCitta" ,required = false)String NomeCitta, @RequestParam(value = "Settimana", required = false )int Settimana) throws FileNotFoundException, IOException, ParseException {
	StatisticheSettimanaliPerCitta p = new StatisticheSettimanaliPerCitta (NomeCitta, Settimana);
	return p;
	}
	}

