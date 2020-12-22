package Filtri;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

/**
 * Questa classe derivando dalla classe StatisticheASceltaPerCitta permette di avere le stesse funzionalita di quest'ultima ma 
 * implementando la possibilita da parte dell'utente di ricevere le statistiche di una citta in un giorno definito andando esclusivamente 
 * ad indicare  il numero di quel giorno.
 * 
 * @author Nicola Ronchini, tommaso omiccioli
 *
 */
public class StatisticheGiornalierePerCitta extends StatisticheASceltaPerCitta {
	
	private int giorno;
	private String nome;   //nome della citta
	
	/**
	 * Costruttore della classe che permette di passare automaticamente alla classe StatisticheASceltaPerCitta i valori di inizio e fine indicando solo il numero della giornata
	 * che si vuole passare e il nome della citta
	 * 
	 * @param nome
	 * @param giorno
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public StatisticheGiornalierePerCitta (String nome, int giorno )throws FileNotFoundException, IOException, ParseException {
		
		super ((giorno-1)*12, (((giorno-1)*12)+11), nome);
		this.giorno = giorno;
		
	}

/**
 * Modifica il giorno
 * @param giorno
 */

	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}

/**
 * Modifica il nome della citta
 * @param nome
 */

	public void setNome(String nome) {
		this.nome = nome;
	}

}
