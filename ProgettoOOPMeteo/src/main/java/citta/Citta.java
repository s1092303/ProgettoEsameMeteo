package citta;

import java.util.Vector;

/**
 * Questa classe ha lo scopo di raggruppare i dati delle diverse citta in base al nome, generando anche tre diversi vettori che contengonoù
 * le informazioni relative alla velocta del vento, al suo angolo di inclinazione e la visibilita
 * 
 * @author Nicola Ronchini, Tommaso Omiccioli
 *
 */

public class Citta {

	private String nome;
	private Vector<Double> VelocitaVento = new Vector<Double> (); 
	private Vector<Long> AngoloVento = new Vector<Long> ();
	private Vector<Long> vis = new Vector<Long> ();
	private Double MediaVento;
	/**
	 * Costruttore di Default senza parametri inclusi
	 */
	public Citta() {}
	
	/**
	 * Costruttore con parametri da inserire
	 * Ogni oggetto Citta è costituito dal nome della citta e
	 * da 3 vettori che registrano i dati durante un periodo
	 * @param nome
	 * @param vel
	 * @param deg
	 * @param visi
	 */
	public Citta(String nome, Double vel, Long deg
			, Long visi) {
		this.nome = nome; // Inserisco il nome della citta
		VelocitaVento.add(vel); // Creo un vettore per registrare le velocita dei venti
		AngoloVento.add(deg); //Creo un vettore per registrare l'angolo del vento
		vis.add(visi); //Creo un vettore per registrare la visibilita
	}
	
    /**
     * Resituisco il nome
     * @return nome
     */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Inserisco un nome passato in input
	 * @param nome
	 */

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Restituisce l'intero vettore delle velocita dei venti
	 * @return VelocitaVento
	 */
	
	public Vector<Double> getVelocitaVento() {
		return VelocitaVento;
	}
	
	/**
	 * Sostituisce il vettore delle velocita con un altro vettore preso in input
	 * @param velocitaVento
	 */

	public void setVelocitaVento(Vector<Double> velocitaVento) {
		VelocitaVento = velocitaVento;
	}
	
	/**
	 * Restituisce il vettore dell'inclinazione dei venti
	 * @return AngoloVento
	 */

	public Vector<Long> getAngoloVento() {
		return AngoloVento;
	}
	
	/**
	 * Sostituisce il vettore dell'inclinazione dei venti con un altro vettore preso in input
	 * @param angoloVento
	 */

	public void setAngoloVento(Vector<Long> angoloVento) {
		AngoloVento = angoloVento;
	}
	
	/**
	 * Restituisce il vettore delle visibilità
	 * @return vis
	 */

	public Vector<Long> getVis() {
		return vis;
	}
	
	/**
	 * Sostituisce il vettore della visibilità con un altro vettore preso in input
	 * @param vis
	 */

	public void setVis(Vector<Long> vis) {
		this.vis = vis;
	}
	
	/**
	 * Restituisce un elemento del vettore VelocitaVento in base all'indice preso in input
	 * @param i
	 * @return elemento del vettore VelocitaVento
	 */
	
	public Double getPosVelocita(int i) {
		return VelocitaVento.get(i);
	}
	
	/**
	 * Restituisce un elemento del vettore AngoloVento in base all'indice preso in input
	 * @param i
	 * @return elemento del vettore AngoloVento
	 */
	
	public Long getPosAngolo(int i) {
		return AngoloVento.get(i);
	} 
	
	/**
	 * Restituisce un elemento del vettore vis in base all'indice preso in input
	 * @param i
	 * @return elemento del vettore vis
	 */

	public Long getPosVisibilita(int i) {
		return vis.get(i);
	}
	
	/**
	 * Inserisce un valore speed nel primo posto libero del vettore VeloctaVento
	 * @param speed
	 */
	
	public void SetPosVel(Double speed) {
		VelocitaVento.add(speed);
	}
	
	/**
	 * Inserisce un valore deg nel primo posto libero del vettore AngoloVento
	 * @param deg
	 */

	public void SetPosAng(Long deg) {
		AngoloVento.add(deg);
	}
	
	/**
	 * Inserisce un valore visi nel primo posto libero del vettore vis
	 * @param visi
	 */

	public void SetPosVis(Long visi) {
		vis.add(visi);
	}
	
	/**
	 * Restituisce la lunghezza del vettore delle velocita dei venti
	 * @return
	 */
	
	public int GetSizeVento() {
		return VelocitaVento.size();
	}
	
	/**
	 * Restituisce la lunghezza del vettore della visibilita
	 * @return
	 */
	
	public int GetSizeVis() {
		return vis.size();
	}
	
	public void setMediaVento(Double med) {
		MediaVento = med;
	}
	
	public Double GetMediaVento() {
		return MediaVento;
	}

}
