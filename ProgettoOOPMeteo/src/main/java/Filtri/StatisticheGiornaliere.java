package Filtri;



import java.io.FileNotFoundException;
import java.io.IOException;


import org.json.simple.parser.ParseException;



public class StatisticheGiornaliere extends StatisticheAScelta{
	
	private int giorno;
	
	
	public StatisticheGiornaliere(int giorno  ) throws FileNotFoundException, IOException, ParseException{
		super ((giorno-1)*12, (((giorno-1)*12)+11));
		this.giorno = giorno;
		}


	public int getGiorno() {
		return giorno;
	}


	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}



}
