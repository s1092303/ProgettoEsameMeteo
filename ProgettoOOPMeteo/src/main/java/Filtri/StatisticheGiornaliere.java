package Filtri;

import it.univpm.ProgettoOOPMeteo.Operazioni.ElaborazioneDati;
import it.univpm.ProgettoOOPMeteo.Operazioni.ElaborazioneDatiDaFile;
import it.univpm.ProgettoOOPMeteo.Operazioni.Statistiche;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.parser.ParseException;

import citta.CittaMediaVar;

public class StatisticheGiornaliere extends StatisticheAScelta{
	
	private int giorno;
	
	
	public StatisticheGiornaliere(int giorno  ) throws FileNotFoundException, IOException, ParseException{
		super ((giorno-1)*12, (((giorno-1)*12)+11));
		this.giorno = giorno;
		}



}
