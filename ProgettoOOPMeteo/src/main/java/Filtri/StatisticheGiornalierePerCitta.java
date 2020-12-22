package Filtri;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class StatisticheGiornalierePerCitta extends StatisticheASceltaPerCitta {
	
	private int giorno;
	private String nome;
	
	public StatisticheGiornalierePerCitta (String nome, int giorno )throws FileNotFoundException, IOException, ParseException {
		
		super ((giorno-1)*12, (((giorno-1)*12)+11), nome);
		this.giorno = giorno;
		
	}



	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}

}
