package Filtri;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class StatisticheSettimanaliPerCitta extends StatisticheASceltaPerCitta {
	
	private int settimana;
	private String nome;
	
	public StatisticheSettimanaliPerCitta (String nome, int settimana )throws FileNotFoundException, IOException, ParseException {
		
		super ((settimana-1)*12, (((settimana-1)*12)+83), nome);
		this.settimana = settimana;
		
	}



	public int getSettimana() {
		return settimana;
	}



	public void setSettimana(int settimana) {
		this.settimana = settimana;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
