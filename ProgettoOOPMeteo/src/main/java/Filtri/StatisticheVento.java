package Filtri;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.parser.ParseException;

import citta.CittaMediaVar;
/**
 * Queta classe permette di raccogliere le citta con velocita del vento media massima e minima e con varianza massiam e minima in un intervallo di tempo
 * determinato. 
 * 
 * @author Nicola Ronchini, tommaso omiccioli
 *
 */
public class StatisticheVento {

	private Vector<CittaMediaVar> MaxMediaVento = new Vector<CittaMediaVar> ();             //vettore con la citta con la media più alta o le citta che hanno pari merito media più alta
	private Vector<CittaMediaVar> MinMediaVento = new Vector<CittaMediaVar> ();             //vettore con la citta con la media più bassa o le citta che hanno pari merito media più bassa
	private Vector<CittaMediaVar> MaxVarianzaVento = new Vector<CittaMediaVar> ();          //vettore con la citta con la varianza più alta o le citta che hanno pari merito varianza più alta
	private Vector<CittaMediaVar> MinVarianzaVento = new Vector<CittaMediaVar> ();          //vettore con la citta con la varianza piu bassa o le citta che hanno pari merito varianza piu bassa
	private Vector<CittaMediaVar> ListaCitta = new Vector<CittaMediaVar>();                 //lista delle citta 
	
	private int inizio;
	private int fine;
	
	/**
	 * 
	 * Il costruttore, passatogli a gli istanti di inizio e di fine del periodo da analizzare, riempe i Vector della media massima
	 * e minima e della varianza massimae minima
	 * 
	 * @param inizio
	 * @param fine
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public StatisticheVento (int inizio, int fine) throws FileNotFoundException, IOException, ParseException {
	
		this.inizio = inizio;
		this.fine = fine;
		
		StatisticheAScelta s = new StatisticheAScelta (inizio, fine);         
		ListaCitta = s.getVettore();                             //inizzializziamo il vettore di CittaMediaVar con le medie e varianze di tutte le citta
		
		MaxMediaVento.add(0, ListaCitta.get(0));                 //aggiungiamo nel vettore MaxMediaVento la prima citta della listaCitta
		MinMediaVento.add(0,  ListaCitta.get(0));                //aggiungiamo nel vettore MinMediaVento la prima citta della listaCitta
		MaxVarianzaVento.add(0, ListaCitta.get(0));              //aggiungiamo nel vettore MaxVarianzaVento la prima citta della listaCitta
		MinVarianzaVento.add(0, ListaCitta.get(0));              //aggiungiamo nel vettore MinVarianzaVento la prima citta della listaCitta
		
		for (int i = 1; i<ListaCitta.size(); i++ ) {             //il for si occupa di far confrontare ogni citta con i vettori di MaxMediaVento, MinMediaVento, MaxVarianzaVento, MinVarianzaVento
			
			if(ListaCitta.get(i).getMediaVento() > MaxMediaVento.get(0).getMediaVento()) { MaxMediaVento.removeAllElements();                                 //controllla se la media della citta i-esima è maggiore della citta che fino ad ora ha avuto la media massima
				                                                                            MaxMediaVento.add(0, ListaCitta.get(i));}                         // se cosi fosse svuota tutto il vettore MaxMediaVento e lo inizzializza con queta nuova citta
			else if(ListaCitta.get(i).getMediaVento() == MaxMediaVento.get(0).getMediaVento()) {MaxMediaVento.add(MaxMediaVento.size(), ListaCitta.get(i));}  //se invece la media della citta i-esima è uguale a quella della citta massima allora aggiunge anche la prima al vettore MaxMediaVento 
			
			
			if(ListaCitta.get(i).getMediaVento() < MinMediaVento.get(0).getMediaVento()) { MinMediaVento.removeAllElements();                                 //controllla se la media della citta i-esima è minore della citta che fino ad ora ha avuto la media minima  
                                                                                            MinMediaVento.add(0, ListaCitta.get(i));}                         // se cosi fosse svuota tutto il vettore MinMediaVento e lo inizzializza con queta nuova citta
			else if(ListaCitta.get(i).getMediaVento() == MinMediaVento.get(0).getMediaVento()) {MinMediaVento.add(MinMediaVento.size(), ListaCitta.get(i));}  //se invece la media della citta i-esima è uguale a quella della citta minima allora aggiunge anche la prima al vettore MinMediaVento 
			
			
		    
            if(ListaCitta.get(i).getVarianzaVento() > MaxVarianzaVento.get(0).getVarianzaVento()) { MaxVarianzaVento.removeAllElements();                                   //controllla se la varianza della citta i-esima è maggiore della citta che fino ad ora ha avuto la varianza massima
                                                                                                     MaxVarianzaVento.add(0, ListaCitta.get(i));}                           // se cosi fosse svuota tutto il vettore MaxVarianzaVento e lo inizzializza con queta nuova citta
            else if(ListaCitta.get(i).getVarianzaVento() == MaxVarianzaVento.get(0).getVarianzaVento()){ MaxVarianzaVento.add(MaxVarianzaVento.size(), ListaCitta.get(i));} //se invece la varianza della citta i-esima è uguale a quella della citta massima allora aggiunge anche la prima al vettore MaxVarianzaVento 
			
            
            if (ListaCitta.get(i).getVarianzaVento() < MinVarianzaVento.get(0).getVarianzaVento()) { MinVarianzaVento.removeAllElements();                                  //controllla se la varianza della citta i-esima è minore della citta che fino ad ora ha avuto la varianza minima
            																						 MinVarianzaVento.add(0, ListaCitta.get(i)); }                          // se cosi fosse svuota tutto il vettore MinVarianzaVento e lo inizzializza con queta nuova citta
            else if(ListaCitta.get(i).getVarianzaVento() == MinVarianzaVento.get(0).getVarianzaVento()) { MinVarianzaVento.add(MinVarianzaVento.size(), ListaCitta.get(i));}//se invece la varianza della citta i-esima è uguale a quella della citta minima allora aggiunge anche la prima al vettore MinVarianzaVento 
			
            }
		
		}

/**
 * Ritorna il vettore di CittaMediaVento che rappresentano le citta piu ventose
 * @return vettore CittaMediaVar
 */
	public Vector<CittaMediaVar> getMaxMediaVento() {
		return MaxMediaVento;
	}

/**
 * Contente di modificare il vettore MaxMediaVento
 * @param maxMediaVento
 */
	public void setMaxMediaVento(Vector<CittaMediaVar> maxMediaVento) {
		MaxMediaVento = maxMediaVento;
	}

	/**
	 * Ritorna il vettore di CittaMediaVento che rappresentano le citta meno ventose
	 * @return vettore CittaMediaVar
	 */
	public Vector<CittaMediaVar> getMinMediaVento() {
		return MinMediaVento;
	}

	/**
	 * Contente di modificare il vettore MinMediaVento
	 * @param maxMediaVento
	 */
	public void setMinMediaVento(Vector<CittaMediaVar> minMediaVento) {
		MinMediaVento = minMediaVento;
	}

	/**
	 * Ritorna il vettore di CittaMediaVento che rappresentano le citta con varianza piu alta
	 * @return vettore CittaMediaVar
	 */
	public Vector<CittaMediaVar> getMaxVarianzaVento() {
		return MaxVarianzaVento;
	}

	/**
	 * Contente di modificare il vettore MaxVarianzaVento
	 * @param maxMediaVento
	 */
	public void setMaxVarianzaVento(Vector<CittaMediaVar> maxVarianzaVento) {
		MaxVarianzaVento = maxVarianzaVento;
	}

	/**
	 * Ritorna il vettore di CittaMediaVento che rappresentano le citta con varianza piu bassa
	 * @return vettore CittaMediaVar
	 */
	public Vector<CittaMediaVar> getMinVarianzaVento() {
		return MinVarianzaVento;
	}

	/**
	 * Contente di modificare il vettore MinVarianzaVento
	 * @param maxMediaVento
	 */
	public void setMinVarianzaVento(Vector<CittaMediaVar> minVarianzaVento) {
		MinVarianzaVento = minVarianzaVento;
	}
	
	
	
	
}
