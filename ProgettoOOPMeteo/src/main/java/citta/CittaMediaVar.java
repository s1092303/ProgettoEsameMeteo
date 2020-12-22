package citta;

/**
 * Questa classe serve esclusivamente per creare un output tramite API con solo il nome della citta, la media e varianza del vento/visibilita
 * @author Nicola Ronchini, Tommaso Omiccioli
 *
 */

public class CittaMediaVar {

	private String nome;
	private float mediaVento;
	private float varianzaVento;
	private float mediaVisibilita;
	private float varianzaVisiblita;
	private float mediaAngoloVento;
	private float varianzaAngoloVento;
	
	/**
	 * Costruttore senza parametri
	 */
	
	public CittaMediaVar() {}
	
	/**
	 * Costruttore che prende in input varie statistiche elaborate da altre classi
	 * @param nome
	 * @param mediaVento
	 * @param varianzaVento
	 * @param mediaVisibilita
	 * @param varianzaVisibilita
	 */
	
	public CittaMediaVar(String nome, float mediaVento, float varianzaVento, float mediaVisibilita, float varianzaVisibilita,
						float mediaAngoloVento, float varianzaAngoloVento) {
		this.nome = nome;
		this.mediaVento = mediaVento;
		this.varianzaVento = varianzaVento;
		this.mediaVisibilita = mediaVisibilita;
		this.varianzaVisiblita = varianzaVisibilita;
		this.mediaAngoloVento = mediaAngoloVento;
		this.varianzaAngoloVento = varianzaAngoloVento;
	}

	/**
	 * Restituisce la stringa nome
	 * @return nome
	 */
	
	public String getNome() {
		return nome;
	}
	
	/**
	 * Inserisco una stringa presa in input nel campo nome
	 * @param nome
	 */

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Restituisce il valore della media delle velocita dei venti 
	 * @return mediaVento
	 */

	public float getMediaVento() {
		return mediaVento;
	}
	
	/**
	 * Inserisco un valore preso in input in mediaVento
	 * @param mediaVento
	 */

	public void setMediaVento(float mediaVento) {
		this.mediaVento = mediaVento;
	}
	
	/**
	 * Restituisce il valore di varianzaVento
	 * @return varianzaVento
	 */

	public float getVarianzaVento() {
		return varianzaVento;
	}
	
	/**
	 * Modifico il valore di varianzaVento con uno preso in input
	 * @param varianzaVento
	 */

	public void setVarianzaVento(float varianzaVento) {
		this.varianzaVento = varianzaVento;
	}
	
	/**
	 * Restituisce il valore di mediaVisiblita
	 * @return mediaVisiblita
	 */

	public float getMediaVisibilita() {
		return mediaVisibilita;
	}
	
	/**
	 * Modifico il valore di mediaVisibilita con uno preso in input
	 * @param mediaVisibilita
	 */

	public void setMediaVisibilita(float mediaVisibilita) {
		this.mediaVisibilita = mediaVisibilita;
	}
	
	/**
	 * Restituisce il valore di varianzaVisibilita
	 * @return varianzaVisibilita
	 */

	public float getVarianzaVisibilita() {
		return varianzaVisiblita;
	}
	
	/**
	 * Modifico il valore di varianzaVisibilita con uno preso in input
	 * @param varianzaVisiblita
	 */

	public void setVarianzaVisibilita(float varianzaVisiblita) {
		this.varianzaVisiblita = varianzaVisiblita;
	}
	
	public float getMediaAngoloVento() {
		return mediaAngoloVento;
	}
	
	public void setMediaAngoloVento(float mediaAngoloVento) {
		this.mediaAngoloVento = mediaAngoloVento;
	}
	
	public float getVarianzaAngoloVento() {
		return varianzaAngoloVento;
	}
	
	public void setVarianzaAngoloVento(float varianzaAngoloVento) {
		this.varianzaAngoloVento = varianzaAngoloVento;
	}
}
