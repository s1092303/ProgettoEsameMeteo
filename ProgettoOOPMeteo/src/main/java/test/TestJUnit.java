package test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import Filtri.StatisticheASceltaPerCitta;

public class TestJUnit {
		
	@Test
	void NomeMancante() throws FileNotFoundException, IOException, ParseException {
		StatisticheASceltaPerCitta c = new StatisticheASceltaPerCitta(0, 83, "Firenze");
		assertEquals(null, c.getCittaMediaVar());
	}
	
}
