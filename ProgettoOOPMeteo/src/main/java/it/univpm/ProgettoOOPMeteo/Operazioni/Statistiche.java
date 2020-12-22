package it.univpm.ProgettoOOPMeteo.Operazioni;

import citta.Citta;

/**
 * Questa classe ha lo scopo di implementare i metodi che deterimnano la media e la varianza per il vento e la visibilità 
 * della citta che viene passata come attributo di tutti i metodi nel lasso di tempo compreso tra i valori di inizio e fine
 * 
 * @author Nicola Ronchini, Tommaso Omiccioli
 *
 */
public class Statistiche {
	
	/**
	 * Costruttore di Default senza parametri inclusi
	 */
	 public Statistiche() {}
	 
	
	 /**
	  * Questo metodo si occupa di calcolare la media del vento tra un rilevazione di inizio e una di fine
	  * 
	  * @param citta
	  * @param inizio
	  * @param fine
	  * @return mediaVento
	  */
	 public float mediaVento (Citta citta, int inizio, int fine){
		
			float somma=0;
		    
			for (int i = inizio; i <= fine ; i++) {
		    	somma += citta.getPosVelocita(i);
		    }
			return (somma/((fine + 1) - inizio));
	 }
		
	 /**
	  * Questo metodo si occupa di calcolare la media della visibilita tra un rilevazione di inizio e una di fine
	  * 
	  * @param citta
	  * @param inizio
	  * @param fine
	  * @return mediaVisibilita
	  */
	
	 public float mediaVisibilita (Citta citta, int inizio, int fine){
		
	        float somma=0;
		    
			for (int i=inizio; i<=fine ; i++) {
		    	somma += citta.getPosVisibilita(i);
		    }
			return somma/((fine+1) - inizio);
	}
		
		
	 /**
	  * Questo metodo si occupa di calcolare la media dell'inclinazione dei venti tra un rilevazione di inizio e una di fine
	  * 
	  * @param citta
	  * @param inizio
	  * @param fine
	  * @return mediaAngoloVento
	  */
	
	 public float mediaAngoloVento (Citta citta, int inizio, int fine){
		
	        float somma=0;
		    
			for (int i=inizio; i<=fine ; i++) {
		    	somma += citta.getPosAngolo(i);
		    }
			return somma/((fine+1) - inizio);
	}
	
	 /**
	 * Questo metodo si occupa di calcolare la varianza della velocita del vento tra un rilevazione di inizio e una di fine
	 * 
	 * @param citta
	 * @param inizio
	 * @param fine
	 * @return varianzaVento
	 */
    public float varianzaVento (Citta citta, int inizio, int fine) {
	
	float somma=0; 
	
	float media = mediaVento(citta, inizio, fine);
	
	for (int i=inizio; i<=fine; i++) {
		somma += (citta.getPosVelocita(i) - media)*(citta.getPosVelocita(i) - media);
		}
	return somma/((fine+1) - inizio);
}
	

	 
	 /**
	 * Questo metodo si occupa di calcolare la varianza della visibilita tra un rilevazione di inizio e una di fine
	 * 
	 * @param citta
	 * @param inizio
	 * @param fine
	 * @return varianzaVisibilita
	 */
   public float varianzaVisibilita (Citta citta, int inizio, int fine) {
	
	float somma=0; 
	
	float media = mediaVisibilita(citta, inizio, fine);
	
	for (int i=inizio; i<=fine; i++) {
		somma += (citta.getPosVisibilita(i) - media)*(citta.getPosVisibilita(i) - media);
		}
	return somma/((fine+1) - inizio);
}
	 
   /**
  	 * Questo metodo si occupa di calcolare la varianza del?inclinazione dei venti tra un rilevazione di inizio e una di fine
  	 * 
  	 * @param citta
  	 * @param inizio
  	 * @param fine
  	 * @return varianzaAngoloVento
  	 */
     public float varianzaAngoloVento (Citta citta, int inizio, int fine) {
  	
  	float somma=0; 
  	
  	float media = mediaAngoloVento(citta, inizio, fine);
  	
  	for (int i=inizio; i<=fine; i++) {
  		somma += (citta.getPosAngolo(i) - media)*(citta.getPosAngolo(i) - media);
  		}
  	return somma/((fine+1) - inizio);
  }


}