package Filtri;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.parser.ParseException;

import citta.CittaMediaVar;

public class StatisticheVisibilita {

	private Vector<CittaMediaVar> MaxMediaVisibilita = new Vector<CittaMediaVar> ();  
	private Vector<CittaMediaVar> MinMediaVisibilita = new Vector<CittaMediaVar> ();
	private Vector<CittaMediaVar> MaxVarianzaVisibilita  = new Vector<CittaMediaVar> ();
	private Vector<CittaMediaVar> MinVarianzaVisibilita  = new Vector<CittaMediaVar> ();
	private Vector<CittaMediaVar> ListaCitta = new Vector<CittaMediaVar>();
	
	private int inizio;
	private int fine;
	
	
	public StatisticheVisibilita (int inizio, int fine) throws FileNotFoundException, IOException, ParseException {
	
		this.inizio = inizio;
		this.fine = fine;
		
		StatisticheAScelta s = new StatisticheAScelta (inizio, fine);
		ListaCitta = s.getVettore();
		
		MaxMediaVisibilita .add(0, ListaCitta.get(0));
		MinMediaVisibilita .add(0,  ListaCitta.get(0));
		MaxVarianzaVisibilita .add(0, ListaCitta.get(0));
		MinVarianzaVisibilita .add(0, ListaCitta.get(0));
		
		for (int i = 1; i<ListaCitta.size(); i++ ) {
			
			if(ListaCitta.get(i).getMediaVisibilita () > MaxMediaVisibilita .get(0).getMediaVisibilita ()) { MaxMediaVisibilita .removeAllElements();
				                                                                            MaxMediaVisibilita .add(0, ListaCitta.get(i));}
			else if(ListaCitta.get(i).getMediaVisibilita () == MaxMediaVisibilita .get(0).getMediaVisibilita()) {MaxMediaVisibilita .add(MaxMediaVisibilita .size(), ListaCitta.get(i));}
			
			
			if(ListaCitta.get(i).getMediaVisibilita () < MinMediaVisibilita .get(0).getMediaVisibilita ()) { MinMediaVisibilita .removeAllElements();
                                                                                            MinMediaVisibilita .add(0, ListaCitta.get(i));}
			else if(ListaCitta.get(i).getMediaVisibilita () == MinMediaVisibilita .get(0).getMediaVisibilita()) {MinMediaVisibilita .add(MinMediaVisibilita .size(), ListaCitta.get(i));}	
			
		    
            if(ListaCitta.get(i).getVarianzaVisibilita () > MaxVarianzaVisibilita .get(0).getVarianzaVisibilita()) { MaxVarianzaVisibilita .removeAllElements();
                                                                                                     MaxVarianzaVisibilita .add(0, ListaCitta.get(i));}
            else if(ListaCitta.get(i).getVarianzaVisibilita () == MaxVarianzaVisibilita .get(0).getVarianzaVisibilita()){ MaxVarianzaVisibilita .add(MaxVarianzaVisibilita .size(), ListaCitta.get(i));}
            
            if (ListaCitta.get(i).getVarianzaVisibilita () < MinVarianzaVisibilita .get(0).getVarianzaVisibilita()) { MinVarianzaVisibilita .removeAllElements();
            																						 MinVarianzaVisibilita .add(0, ListaCitta.get(i)); }
            else if(ListaCitta.get(i).getVarianzaVisibilita () == MinVarianzaVisibilita .get(0).getVarianzaVisibilita ()) { MinVarianzaVisibilita .add(MinVarianzaVisibilita .size(), ListaCitta.get(i));}
            }
		
		}


	public Vector<CittaMediaVar> getMaxMediaVisibilita() {
		return MaxMediaVisibilita ;
	}


	public void setMaxMediaVisibilita(Vector<CittaMediaVar> maxMediaVisibilita) {
		MaxMediaVisibilita  = maxMediaVisibilita;
	}


	public Vector<CittaMediaVar> getMinMediaVisibilita() {
		return MinMediaVisibilita ;
	}


	public void setMinMediaVisibilita(Vector<CittaMediaVar> minMediaVisibilita) {
		MinMediaVisibilita  = minMediaVisibilita;
	}


	public Vector<CittaMediaVar> getMaxVarianzaVisibilita() {
		return MaxVarianzaVisibilita ;
	}


	public void setMaxVarianzaVisibilita(Vector<CittaMediaVar> maxVarianzaVisibilita) {
		MaxVarianzaVisibilita = maxVarianzaVisibilita;
	}
	
	public Vector<CittaMediaVar> getMinVarianzaVisibilita() {
		return MinVarianzaVisibilita;
	}
	
	public void setMinVarianzaVisibilita(Vector<CittaMediaVar> minVarianzaVisibilita) {
		MinVarianzaVisibilita = minVarianzaVisibilita;
	}
}