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
 * Controller del codice per utilizzare i metodi attraverso postaman o un motore di ricerca
 * 
 * @author Nicola Ronchini, Tommaso Omiccioli
 *
 */

@RestController
public class ControllerMeteo {

	/**
	 * Questa prima rotta permette di scegliere cosa stampare in output (o la lista completa di tutte le città, in caso l'utente
	 * non specifica niente, o una a scelta, inserendo il nome)
	 * @param NomeCitta
	 * @return un vettore di citta sulla base di quello che ha scelto l'utente
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	
	@GetMapping("/ListaCitta") 
	public Vector<CittaMediaVar> exampleMethod(
			@RequestParam(required = false, defaultValue = "1") String NomeCitta) throws FileNotFoundException, IOException, ParseException {
		StatisticheSettimanali p = new StatisticheSettimanali(1);
		if (NomeCitta.equals("1")) {
			return p.getVettore();
		}
		else {
			StatisticheSettimanaliPerCitta c = new StatisticheSettimanaliPerCitta(NomeCitta, 1);
			Vector<CittaMediaVar> CittaScelta = new Vector<CittaMediaVar> ();
			CittaScelta.add(c.getCittaMediaVar());
			return CittaScelta;
		}
	}
	
	/**
	 * Questo metodo stampa in output le citta che hanno media e varianza minima/massima della ventosità
	 * @return un vettore di citta
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	
	@GetMapping("/EstremiStatisticheVento") 
	public StatisticheVento method1() throws FileNotFoundException, IOException, ParseException {
		StatisticheVento wind = new StatisticheVento(0, 85);
		return wind;		
	}
	
	/**
	 * Questo metodo stampa in output le citta che hanno media e varianza minima/massima della visibilità
	 * @return un vettore di citta
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */

	@GetMapping("/EstremiStatisticheVisibilita") 
	public StatisticheVisibilita method2() throws FileNotFoundException, IOException, ParseException {
		StatisticheVisibilita vis = new StatisticheVisibilita(0, 85);
		return vis;		
	}
	
	/**
	 * Questo metodo stampa le statistiche in base a ciò che gli passa l'utente.
	 * Il primo parametro passabile è il nome della città( in caso non venga passato niente il metodo stampa tutto il vettore).
	 * Il secondo parametro specifica il tempo di campionamento per controllare un giorno in particolare ( se non viene inserito il metodo stampa le statistiche per tutta la settimana).
	 * Il parametro giorno serve per scegliere un determinato giorno( per default è il primo).
	 * Gli ultimi due parametri servono per specificare l'inizio e la fine in caso non si sia scelto il campionamento giornaliero.
	 * @param nome
	 * @param Campionamento
	 * @param giorno
	 * @param inizio
	 * @param fine
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	
	@GetMapping("/StatsAScelta")
	public Vector<CittaMediaVar> method3(
			@RequestParam(defaultValue = "1", required = false) String nome,
			@RequestParam(defaultValue = "1", required = false) String Campionamento,
			@RequestParam(defaultValue = "1", required = false) Integer giorno,
			@RequestParam(defaultValue = "0", required = false) Integer inizio,
			@RequestParam(defaultValue = "85", required = false) Integer fine) throws FileNotFoundException, IOException, ParseException {
		if (nome.equals("1")) {
			if (Campionamento.equals("1")) {
				StatisticheAScelta s = new StatisticheAScelta(inizio,fine);
				return s.getVettore();
			}
			else if (Campionamento.equals("Giornaliero")) {
				if (giorno > 7) return null;
				StatisticheGiornaliere s = new StatisticheGiornaliere(giorno);
				return s.getVettore();
			}
		}
		else {
			if (Campionamento.equals("1")) {
				StatisticheASceltaPerCitta s = new StatisticheASceltaPerCitta(inizio,fine, nome);
				Vector<CittaMediaVar> StatisticheASceltaPerCitta = new Vector<CittaMediaVar> ();
				StatisticheASceltaPerCitta.add(s.getCittaMediaVar()); 
				return StatisticheASceltaPerCitta;
			}
			else if (Campionamento.equals("Giornaliero")) {
				if (giorno > 7) return null;
				StatisticheGiornalierePerCitta s = new StatisticheGiornalierePerCitta(nome, giorno);
				Vector<CittaMediaVar> StatisticheGiornalierePerCitta = new Vector<CittaMediaVar> ();
				StatisticheGiornalierePerCitta.add(s.getCittaMediaVar());
				return StatisticheGiornalierePerCitta;
			}
		}
		return null;
	}
}
