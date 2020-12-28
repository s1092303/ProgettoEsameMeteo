package Filtri;


import java.io.FileNotFoundException;
import java.io.IOException;


import org.json.simple.parser.ParseException;

/**
 * Questa classe derivando dalla classe StatisticheAScelta permette di avere le stesse funzionalita di quest'ultima ma 
 * implementando la possibilita da parte dell'utente di ricevere le statistiche delle citta in una settimana definita andando esclusivamente 
 * ad indicare  il numero di quella settimana.
 * 
 * @author Nicola Ronchini, tommaso omiccioli
 *
 */

public class StatisticheSettimanali extends StatisticheAScelta{
	
	private int settimana;
	
	/**
	 * costruttore della che classe permette di passare aumomaticamente i valori di inizio e fine della classe StatisticheAScelta passando il valore della settimana
	 *
	 * @param settimana
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public StatisticheSettimanali(int settimana  ) throws FileNotFoundException, IOException, ParseException{
		super ((settimana-1)*12, (((settimana-1)*12)+6));
		this.settimana = settimana;
		}

/**
 *  Ritorna il valore della settimana
 * @return settimana
 */
	public int getSettimana() {
		return settimana;
	}

/**
 * Modifica il valore della settimana
 * @param settimana
 */
	public void setSettimana(int settimana) {
		this.settimana = settimana;
	}



}
