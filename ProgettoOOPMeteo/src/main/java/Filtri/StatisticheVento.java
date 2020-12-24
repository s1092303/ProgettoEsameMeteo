package Filtri;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.parser.ParseException;

import citta.CittaMediaVar;

public class StatisticheVento {

	private Vector<CittaMediaVar> MaxMediaVento = new Vector<CittaMediaVar> ();             //vettore con la citta con la media più alta o le citta che hanno pari merito media più alta
	private Vector<CittaMediaVar> MinMediaVento = new Vector<CittaMediaVar> ();
	private Vector<CittaMediaVar> MaxVarianzaVento = new Vector<CittaMediaVar> ();
	private Vector<CittaMediaVar> MinVarianzaVento = new Vector<CittaMediaVar> ();
	private Vector<CittaMediaVar> ListaCitta = new Vector<CittaMediaVar>();
	
	private int inizio;
	private int fine;
	
	
	public StatisticheVento (int inizio, int fine) throws FileNotFoundException, IOException, ParseException {
	
		this.inizio = inizio;
		this.fine = fine;
		
		StatisticheAScelta s = new StatisticheAScelta (inizio, fine);
		ListaCitta = s.getVettore();
		
		MaxMediaVento.add(0, ListaCitta.get(0));
		MinMediaVento.add(0,  ListaCitta.get(0));
		MaxVarianzaVento.add(0, ListaCitta.get(0));
		MinVarianzaVento.add(0, ListaCitta.get(0));
		
		for (int i = 1; i<ListaCitta.size(); i++ ) {
			
			if(ListaCitta.get(i).getMediaVento() > MaxMediaVento.get(0).getMediaVento()) { MaxMediaVento.removeAllElements();
				                                                                            MaxMediaVento.add(0, ListaCitta.get(i));}
			else if(ListaCitta.get(i).getMediaVento() == MaxMediaVento.get(0).getMediaVento()) {MaxMediaVento.add(MaxMediaVento.size(), ListaCitta.get(i));}
			
			
			if(ListaCitta.get(i).getMediaVento() < MinMediaVento.get(0).getMediaVento()) { MinMediaVento.removeAllElements();
                                                                                            MinMediaVento.add(0, ListaCitta.get(i));}
			else if(ListaCitta.get(i).getMediaVento() == MinMediaVento.get(0).getMediaVento()) {MinMediaVento.add(MinMediaVento.size(), ListaCitta.get(i));}	
			
		    
            if(ListaCitta.get(i).getVarianzaVento() > MaxVarianzaVento.get(0).getVarianzaVento()) { MaxVarianzaVento.removeAllElements();
                                                                                                     MaxVarianzaVento.add(0, ListaCitta.get(i));}
            else if(ListaCitta.get(i).getVarianzaVento() == MaxVarianzaVento.get(0).getVarianzaVento()){ MaxVarianzaVento.add(MaxVarianzaVento.size(), ListaCitta.get(i));}
            
            if (ListaCitta.get(i).getVarianzaVento() < MinVarianzaVento.get(0).getVarianzaVento()) { MinVarianzaVento.removeAllElements();
            																						 MinVarianzaVento.add(0, ListaCitta.get(i)); }
            else if(ListaCitta.get(i).getVarianzaVento() == MinVarianzaVento.get(0).getVarianzaVento()) { MinVarianzaVento.add(MinVarianzaVento.size(), ListaCitta.get(i));}
            }
		
		}


	public Vector<CittaMediaVar> getMaxMediaVento() {
		return MaxMediaVento;
	}


	public void setMaxMediaVento(Vector<CittaMediaVar> maxMediaVento) {
		MaxMediaVento = maxMediaVento;
	}


	public Vector<CittaMediaVar> getMinMediaVento() {
		return MinMediaVento;
	}


	public void setMinMediaVento(Vector<CittaMediaVar> minMediaVento) {
		MinMediaVento = minMediaVento;
	}


	public Vector<CittaMediaVar> getMaxVarianzaVento() {
		return MaxVarianzaVento;
	}


	public void setMaxVarianzaVento(Vector<CittaMediaVar> maxVarianzaVento) {
		MaxVarianzaVento = maxVarianzaVento;
	}


	public Vector<CittaMediaVar> getMinVarianzaVento() {
		return MinVarianzaVento;
	}


	public void setMinVarianzaVento(Vector<CittaMediaVar> minVarianzaVento) {
		MinVarianzaVento = minVarianzaVento;
	}
	
	
	
	
}
