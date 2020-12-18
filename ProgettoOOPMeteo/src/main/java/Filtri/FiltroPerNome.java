package Filtri;

import citta.Citta;
import it.univpm.ProgettoOOPMeteo.Operazioni.ElaborazioneDati;

public class FiltroPerNome {
	
	private Citta citta;

	public FiltroPerNome(String DaInserire) {
		ElaborazioneDati d = new ElaborazioneDati();
		for (int i = 0; i < d.getListacitta().size(); i++) 
			if (DaInserire.equals(d.getListacitta().get(i).getNome())) citta = d.getListacitta().get(i);
	}
	
	public Citta getCitta() {
		return citta;
	}

}
