package Filtri;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.parser.ParseException;

import citta.CittaMediaVar;
import it.univpm.ProgettoOOPMeteo.Operazioni.ElaborazioneDatiDaFile;
import it.univpm.ProgettoOOPMeteo.Operazioni.Statistiche;
/**
 * Questa classe permette di inizializzare un vettore di CittaMediaVar per tutte le citta disponibili nello storico calcolando poi le statistiche 
 *  dell'intervallo che vogliamo prendere in considerazione andando a passare gli istanti di inizio e fine
 * 
 * @author Nicola Ronchini, tommaso omiccioli
 *
 */

public class StatisticheAScelta {

	private Vector<CittaMediaVar> vettore = new Vector<CittaMediaVar> ();  //vettore di CittaMediaVar che andremo a riempire 
	
	protected int inizio = 0;
	protected int fine = 0;
/**
 * Costruttore della classe si occupa mediante un ciclo di riempire il vettore  delle CittaMediaVar con tutte le caratteristiche 
 * delle citta nello storico
 * 	
 * @param inizio
 * @param fine
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
	
	public StatisticheAScelta(int inizio, int fine) throws FileNotFoundException, IOException, ParseException {
		this.inizio = inizio;
		this.fine = fine;
		
		ElaborazioneDatiDaFile d = new ElaborazioneDatiDaFile();
		Statistiche s = new Statistiche();
		for (int i = 0; i < d.getCity().size(); i++) {                                         //ciclo for per aggiungere al vettore ogni singola citta un ciclo alla volta
			CittaMediaVar c = new CittaMediaVar();                                             //crea un nuova CittaMediaVar
			c.setNome(d.getCity().get(i).getNome());                                           //Inserisce il suo nome
			c.setMediaVento(s.mediaVento(d.getCity().get(i), inizio, fine));                   //calcola la media del vento e la aggiunge alla classe
			c.setVarianzaVento((s.varianzaVento(d.getCity().get(i), inizio, fine)));           //calcola la varianza del vento  e l'aggiunge alla classe
			c.setMediaVisibilita(s.mediaVisibilita(d.getCity().get(i), inizio, fine));         //calcola la media della visibilita l'aggiunge alla classe
			c.setVarianzaVisibilita((s.varianzaVisibilita(d.getCity().get(i), inizio, fine))); //calcola la varianza della visibilita e l'aggiunge alla classe
			c.setMediaAngoloVento(s.mediaAngoloVento(d.getCity().get(i), inizio, fine));       //calcola la media dell'angolo del vento e l'aggiunge alla classe
			c.setVarianzaAngoloVento(s.varianzaAngoloVento(d.getCity().get(i), inizio, fine)); //calcola la varianza dell'angolo del vento e l'aggiunge alla classe
			vettore.add(c);                                                                    //aggiunge la classe cittaMediaVar nel vettore 
		}
	}

	/**
	 * restituisce il vettore CittaMediaVar
	 * @return vettoredi CittaMediaVar
	 */

	public Vector<CittaMediaVar> getVettore() {
		return vettore;
	}
 /**
  * sostituisce il vettore CittaMediaVar dentro la classe
  * @param vettore
  */

	public void setVettore(Vector<CittaMediaVar> vettore) {
		this.vettore = vettore;
	}

}


