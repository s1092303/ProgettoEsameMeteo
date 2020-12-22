package Filtri;



import java.io.FileNotFoundException;
import java.io.IOException;


import org.json.simple.parser.ParseException;

/**
 * Questa classe derivando dalla classe StatisticheAScelta permette di avere le stesse funzionalita di quest'ultima ma 
 * implementando la possibilita da parte dell'utente di ricevere le statistiche delle citta in un giorno definito andando esclusivamente 
 * ad indicare  il numero di quel girono.
 * 
 * @author Nicola Ronchini, tommaso omiccioli
 *
 */

public class StatisticheGiornaliere extends StatisticheAScelta{
	
	private int giorno;
	
/**
 * costruttore della classe che permette di passare aumomaticamente i valori di inizio e fine della classe StatisticheAScelta passando il valore della giornata
 * 
 * @param giorno
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
	public StatisticheGiornaliere(int giorno  ) throws FileNotFoundException, IOException, ParseException{
		super ((giorno-1)*12, (((giorno-1)*12)+11));
		this.giorno = giorno;
		}
/**
 * restituisce il numero del giorno
 * @return giorno
 */

	public int getGiorno() {
		return giorno;
	}
/**
 * Permette di cambiare il giorno
 * @param giorno
 */
	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}



}
