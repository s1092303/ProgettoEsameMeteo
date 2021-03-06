package Filtri;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.parser.ParseException;

import citta.CittaMediaVar;
/**
 * Queta classe permette di raccogliere le citta con visibilita media massima e minima e con varianza massiam e minima in un intervallo di tempo
 * determinato. 
 * 
 * @author Nicola Ronchini, tommaso omiccioli
 *
 */
public class StatisticheVisibilita {

	private Vector<CittaMediaVar> MaxMediaVisibilita = new Vector<CittaMediaVar> ();        //vettore con la citta con la media più alta o le citta che hanno pari merito media più alta
	private Vector<CittaMediaVar> MinMediaVisibilita = new Vector<CittaMediaVar> ();        //vettore con la citta con la media più bassa o le citta che hanno pari merito media più bassa
	private Vector<CittaMediaVar> MaxVarianzaVisibilita  = new Vector<CittaMediaVar> ();    //vettore con la citta con la varianza più alta o le citta che hanno pari merito varianza più alta
	private Vector<CittaMediaVar> MinVarianzaVisibilita  = new Vector<CittaMediaVar> ();    //vettore con la citta con la varianza piu bassa o le citta che hanno pari merito varianza piu bassa
	private Vector<CittaMediaVar> ListaCitta = new Vector<CittaMediaVar>();                 //lista delle citta
	
	private int inizio;
	private int fine;
	
	/**
	 * 
	 * Il costruttore, passatogli gli istanti di inizio e di fine del periodo da analizzare, riempe i Vector della media massima
	 * e minima e della varianza massimae minima
	 * 
	 * @param inizio
	 * @param fine
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public StatisticheVisibilita (int inizio, int fine) throws FileNotFoundException, IOException, ParseException {
	
		this.inizio = inizio;
		this.fine = fine;
		
		StatisticheAScelta s = new StatisticheAScelta (inizio, fine);
		ListaCitta = s.getVettore();                                   //inizzializziamo il vettore di CittaMediaVar con le medie e varianze di tutte le citta
		
		MaxMediaVisibilita .add(0, ListaCitta.get(0));     //aggiungiamo nel vettore MaxMediaVisibilita la prima citta della listaCitta
		MinMediaVisibilita .add(0,  ListaCitta.get(0));    //aggiungiamo nel vettore MinMediaVisibilita la prima citta della listaCitta
		MaxVarianzaVisibilita .add(0, ListaCitta.get(0));  //aggiungiamo nel vettore MaxVarianzaVisibilita la prima citta della listaCitta
		MinVarianzaVisibilita .add(0, ListaCitta.get(0));  //aggiungiamo nel vettore MinVarianzaVisibilita la prima citta della listaCitta
		
		
		for (int i = 1; i<ListaCitta.size(); i++ ) {             //il for si occupa di far confrontare ogni citta con i vettori di MaxMediaVisibilita, MinMediaVisibilita, MaxVarianzaVento, MinVarianzaVento
			
			
			if(ListaCitta.get(i).getMediaVisibilita () > MaxMediaVisibilita .get(0).getMediaVisibilita ()) { MaxMediaVisibilita .removeAllElements();                                      //controllla se la media della citta i-esima è maggiore della citta che fino ad ora ha avuto la media massima
				                                                                            MaxMediaVisibilita .add(0, ListaCitta.get(i));}                                                // se cosi fosse svuota tutto il vettore MaxMediaVisibilita e lo inizzializza con queta nuova citta
			else if(ListaCitta.get(i).getMediaVisibilita () == MaxMediaVisibilita .get(0).getMediaVisibilita()) {MaxMediaVisibilita .add(MaxMediaVisibilita .size(), ListaCitta.get(i));}  //se invece la media della citta i-esima è uguale a quella della citta massima allora aggiunge anche la prima al vettore MaxMediaVisibilita 
			
			
			
			if(ListaCitta.get(i).getMediaVisibilita () < MinMediaVisibilita .get(0).getMediaVisibilita ()) { MinMediaVisibilita .removeAllElements();                                     //controllase la media della citta i-esima è minore della citta che fino ad ora ha avuto la media minima      
                                                                                            MinMediaVisibilita .add(0, ListaCitta.get(i));}                                               // se cosi fosse svuota tuttoil vettore MinMediaVisibilita e lo inizzializza con questa nuova citta
			else if(ListaCitta.get(i).getMediaVisibilita () == MinMediaVisibilita .get(0).getMediaVisibilita()) {MinMediaVisibilita .add(MinMediaVisibilita .size(), ListaCitta.get(i));} //se invecela media della citta i-esima è uguale a quella della citta minima allora aggiunge anche la prima al vettore MinMediaVisibilita
			
		    
            if(ListaCitta.get(i).getVarianzaVisibilita () > MaxVarianzaVisibilita .get(0).getVarianzaVisibilita()) { MaxVarianzaVisibilita .removeAllElements();                                        //controlla che la varianza della citta i-esima è maggiore della citta che fino ad ora ha avuto la varianza massima
                                                                                                     MaxVarianzaVisibilita .add(0, ListaCitta.get(i));}                                                 //se cosi fosse svuota tutto il vettore MaxVarianzaVisibilita e lo inizzializza con questa nuova citta
            else if(ListaCitta.get(i).getVarianzaVisibilita () == MaxVarianzaVisibilita .get(0).getVarianzaVisibilita()){ MaxVarianzaVisibilita .add(MaxVarianzaVisibilita .size(), ListaCitta.get(i));} //se invece la varianza della citta i-esima è uguale a quella della citta massima allora aggiunge anche la prima al vettore MaxVarianzaVisibilita
            
            if (ListaCitta.get(i).getVarianzaVisibilita () < MinVarianzaVisibilita .get(0).getVarianzaVisibilita()) { MinVarianzaVisibilita .removeAllElements();                                        // controlla che la varianza della citta i-esima è minima della citta che fino ad ora ha avuto la varianza minima
            																						 MinVarianzaVisibilita .add(0, ListaCitta.get(i)); }                                                  //se cosi fosse svuota tutto il vettore MinVarianzaVisibilita lo inizzializza con questa nuova citta
            else if(ListaCitta.get(i).getVarianzaVisibilita () == MinVarianzaVisibilita .get(0).getVarianzaVisibilita ()) { MinVarianzaVisibilita .add(MinVarianzaVisibilita .size(), ListaCitta.get(i));}//se invecela varianza della citta i-esima è uguale a quella della citta minima allora aggiunge anche la prima al vettore MinVarianzaVisibilita
            }
		
		}
/**
 * ritorna il vettore delle citta con media della visibilita piu alta
 * @return vettore CittaMediavar
 */

	public Vector<CittaMediaVar> getMaxMediaVisibilita() {
		return MaxMediaVisibilita ;
	}

/**
 * consente di modificare il vettore MaxMediaVisibilita
 * @param maxMediaVisibilita
 */
	public void setMaxMediaVisibilita(Vector<CittaMediaVar> maxMediaVisibilita) {
		MaxMediaVisibilita  = maxMediaVisibilita;
	}

/**
 * ritorna il vettore della citta con la media di visibilita piu bassa 
 * @return vettore CittaMediaVar
 */
	public Vector<CittaMediaVar> getMinMediaVisibilita() {
		return MinMediaVisibilita ;
	}

/**
 * consente di modificare il vettre MinMediaVisibilita
 * @param minMediaVisibilita
 */
	public void setMinMediaVisibilita(Vector<CittaMediaVar> minMediaVisibilita) {
		MinMediaVisibilita  = minMediaVisibilita;
	}

/**
 * ritorna il vettore della citta con la varianza della visibilita piu alta 
 * @return vettore CittaMediaVAr
 */
	public Vector<CittaMediaVar> getMaxVarianzaVisibilita() {
		return MaxVarianzaVisibilita ;
	}

/**
 * consente di modificare il vettore MaxVarianzaVisibiita 
 * @param maxVarianzaVisibilita
 */
	public void setMaxVarianzaVisibilita(Vector<CittaMediaVar> maxVarianzaVisibilita) {
		MaxVarianzaVisibilita = maxVarianzaVisibilita;
	}
	
	/**
	 * ritorna il vettore della citta con la varianza della visibilita minima
	 * @return vettore CittaMediaVar
	 */
	public Vector<CittaMediaVar> getMinVarianzaVisibilita() {
		return MinVarianzaVisibilita;
	}
	
	/**
	 * consente di modificare il vettore MinVarianzaVisibiita
	 * @param minVarianzaVisibilita
	 */
	public void setMinVarianzaVisibilita(Vector<CittaMediaVar> minVarianzaVisibilita) {
		MinVarianzaVisibilita = minVarianzaVisibilita;
	}
}