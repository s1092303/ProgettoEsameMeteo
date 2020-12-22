package Filtri;


import java.io.FileNotFoundException;
import java.io.IOException;


import org.json.simple.parser.ParseException;



public class StatisticheSettimanali extends StatisticheAScelta{
	
	private int settimana;
	
	
	public StatisticheSettimanali(int settimana  ) throws FileNotFoundException, IOException, ParseException{
		super ((settimana-1)*12, (((settimana-1)*12)+83));
		this.settimana = settimana;
		}


	public int getSettimana() {
		return settimana;
	}


	public void setSettimana(int settimana) {
		this.settimana = settimana;
	}



}
