package Filtri;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import citta.Citta;
import citta.CittaMediaVar;
import it.univpm.ProgettoOOPMeteo.Operazioni.Statistiche;
/**
 * Questa classe permette di inizzializzare una classe CittaMediaVar passandogli il nome della citta che vogliamo conoscere le statistiche 
 * e i momenti di inizo e di fine dell'intervallo che vogliamo prendere in considerazione
 * 
 * @author Nicola Ronchini, tommaso omiccioli
 *
 */
public class StatisticheASceltaPerCitta {

	protected Citta citta = new Citta ();                 // Classe della citta che vogliamo analizzare       
	protected CittaMediaVar citt = new CittaMediaVar ();  // classe che ristituiremo in output con i valori calcolati
	
	protected int inizio = 0;
	protected int fine = 0;
	protected String nome;
/**
 * costruttore che si occupa di inizalizare la classe CittaMediaVar passandogli il nome della citta che volgiamo analizzare come stringa
 * e i valori di inizo e di fine dell'intervallo da analizzare 
 * 	
 * @param inizio
 * @param fine
 * @param nome
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
	public StatisticheASceltaPerCitta(int inizio, int fine, String nome) throws FileNotFoundException, IOException, ParseException {
		this.inizio = inizio;
		this.fine = fine;
		this.nome = nome;
		
		FiltroPerNome fil = new FiltroPerNome (nome); //creo una classe filtro per nome per determinare quale citta dallo storico prendere
		Statistiche s = new Statistiche();            // creo una classe statistiche che mi calcoli i valori da inserire nella classe CittaMediVar
		this.citta = fil.getCitta();                  // associo l?attributo citta della classe con il risultato del filtro
		
		CittaMediaVar cit = new CittaMediaVar (citta.getNome(), s.mediaVento(citta, inizio, fine), s.varianzaVento(citta, inizio, fine),s.mediaVisibilita(citta, inizio, fine),s.varianzaVisibilita(citta, inizio, fine), s.mediaAngoloVento(citta, inizio, fine), s.varianzaAngoloVento(citta, inizio, fine));
		citt = cit;                                   //dopo aver creato la classe cit già direttamente inizializzata mediante il suo costruttore la utilizzo per inizallizare la classe attributo citt di questa classe
	}
	
	/**
	 *  restituisce la classe CittaMediaVar
	 * @return CittaMediaVar
	 */
	public CittaMediaVar getCittaMediaVar () {
		return citt;
	}
	}

