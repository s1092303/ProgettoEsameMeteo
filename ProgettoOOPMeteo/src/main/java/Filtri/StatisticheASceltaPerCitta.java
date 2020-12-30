package Filtri;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import citta.Citta;
import citta.CittaMediaVar;
import it.univpm.ProgettoOOPMeteo.Operazioni.ElaborazioneDatiDaFile;
import it.univpm.ProgettoOOPMeteo.Operazioni.Statistiche;
/**
 * Questa classe permette di inizializzare una classe CittaMediaVar passandogli il nome della citta della quale vogliamo conoscere le statistiche 
 * e i momenti di inizo e di fine dell'intervallo che vogliamo prendere in considerazione
 * 
 * @author Nicola Ronchini, tommaso omiccioli
 *
 */
public class StatisticheASceltaPerCitta {

	protected Citta citta = new Citta ();                 // Classe della citta che vogliamo analizzare       
	protected CittaMediaVar citt = new CittaMediaVar ();  // classe che restituiremo in output con i valori calcolati
	
	protected int inizio = 0;
	protected int fine = 0;
	protected String nome;
	private int MaxCampionamento = ElaborazioneDatiDaFile.MaxCampionamento;
/**
 * costruttore che si occupa di inizializzare la classe CittaMediaVar passandogli il nome della citta che vogliamo analizzare come stringa
 * e i valori di inizo e di fine dell'intervallo da analizzare 
 * 	
 * @param inizio
 * @param fine
 * @param nome
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
	public StatisticheASceltaPerCitta(int inizio, int fine, String nome) throws FileNotFoundException, IOException, ParseException, NullPointerException {
		this.inizio = inizio;
		this.fine = fine;
		this.nome = nome;
		
		FiltroPerNome fil = new FiltroPerNome (nome); //creo una classe filtro per nome per determinare quale citta dallo storico prendere
		Statistiche s = new Statistiche();            // creo una classe statistiche che mi calcoli i valori da inserire nella classe CittaMediVar
		this.citta = fil.getCitta();                  // associo l'attributo citta della classe con il risultato del filtro
		
		if (this.citta != null && (inizio >= 0)&&(inizio <= MaxCampionamento) && (fine >= 0) &&(fine<=MaxCampionamento) && (inizio <= fine)) {      //if per controllare che inizo e fine siano valori accettabili
		CittaMediaVar cit = new CittaMediaVar (citta.getNome(), s.mediaVento(citta, inizio, fine),
												s.varianzaVento(citta, inizio, fine),
												s.mediaVisibilita(citta, inizio, fine),
												s.varianzaVisibilita(citta, inizio, fine), 
												s.mediaAngoloVento(citta, inizio, fine), 
												s.varianzaAngoloVento(citta, inizio, fine));
			this.citt = cit;
		}
		else {
			CittaMediaVar cit = new CittaMediaVar (null, 0, 0, 0, 0, 0, 0);
			this.citt = cit;
		}   								  //dopo aver creato la classe cit già direttamente inizializzata mediante il suo costruttore la utilizzo per inizializzare la classe attributo citt di questa classe
	}
	
	/**
	 *  restituisce la classe CittaMediaVar
	 * @return CittaMediaVar
	 */
	public CittaMediaVar getCittaMediaVar () {
		if (this.citt.getNome() == null) return null;
		return this.citt;
		}
	}

