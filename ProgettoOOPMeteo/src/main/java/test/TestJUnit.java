package test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import Filtri.StatisticheAScelta;
import Filtri.StatisticheASceltaPerCitta;
/**
 * Classe di test per verificare il corretto funzionamento delle classi StatisticheASceltaPerCitta e StatisticheAScelta rispetto 
 * i paramtri passati quali nome, inizio e fine
 * @author Nicola Ronchini, tommaso omiccioli
 *
 */
public class TestJUnit {
		
	     /**
		 * Test per verificare il passaggio di un nome di citta non presente nella lista
		 * @throws FileNotFoundException
		 * @throws IOException
		 * @throws ParseException
		 */
	@Test
	void NomeMancante() throws FileNotFoundException, IOException, ParseException {
		StatisticheASceltaPerCitta c = new StatisticheASceltaPerCitta(0, 83, "Firenze");
		assertEquals(null, c.getCittaMediaVar());
	}
	
	/**
	 * Test per verificare il passaggio dei parametri di inizio e fine al di fuori del range accettato
	 * @throws FileNotFoundException
	 * @throws NullPointerException
	 * @throws IOException
	 * @throws ParseException
	 */
	@Test
	void ParametriErrati () throws FileNotFoundException, NullPointerException, IOException, ParseException {
		StatisticheASceltaPerCitta c = new StatisticheASceltaPerCitta(-2, 99, "rome");
		assertEquals(null, c.getCittaMediaVar());
		}
	
	/**
	 * Test per verificare il passaggio dei parametri di inizio e fine al di fuori del range accettato
	 * @throws FileNotFoundException
	 * @throws NullPointerException
	 * @throws IOException
	 * @throws ParseException
	 */
	@Test
	void ParametriErrati2 () throws FileNotFoundException, NullPointerException, IOException, ParseException {
		StatisticheAScelta c = new StatisticheAScelta(-2, 99);
		assertEquals(null, c.getVettore());
		}
	
}
