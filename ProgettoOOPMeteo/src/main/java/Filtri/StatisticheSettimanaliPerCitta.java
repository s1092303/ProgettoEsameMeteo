package Filtri;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

/**
 * Questa classe derivando dalla classe StatisticheASceltaPerCitta permette di avere le stesse funzionalita di quest'ultima ma 
 * implementando la possibilita da parte dell'utente di ricevere le statistiche di una citta in una settimana definita andando esclusivamente 
 * ad indicare  il numero di quella settimana.
 * 
 * @author Nicola Ronchini, tommaso omiccioli
 *
 */
public class StatisticheSettimanaliPerCitta extends StatisticheASceltaPerCitta {
	
	private int settimana;
	private String nome;
	
	/**
	 * Costruttore della classe che permette di passare automaticamente alla classe StatisticheASceltaPerCitta i valori di inizio e fine indicando solo il numero della settimana
	 * che si vuole passare e il nome della citta
	 * @param nome
	 * @param settimana
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public StatisticheSettimanaliPerCitta (String nome, int settimana )throws FileNotFoundException, IOException, ParseException {
		
		super ((settimana-1)*12, (((settimana-1)*12)+83), nome);
		this.settimana = settimana;
		
	}

    /**
     * Permette di cambiare il valore della settimana
     * @param settimana
     */
     public void setSettimana(int settimana) {
		this.settimana = settimana;
	}


    /**
     * Permette di cambiare il nome
     * @param nome
     */
    public void setNome(String nome) {
		this.nome = nome;
	}

}
