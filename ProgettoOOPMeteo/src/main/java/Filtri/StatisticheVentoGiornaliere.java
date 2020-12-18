package Filtri;

import it.univpm.ProgettoOOPMeteo.Operazioni.ElaborazioneDati;
import it.univpm.ProgettoOOPMeteo.Operazioni.Statistiche;
import java.util.Vector;

public class StatisticheVentoGiornaliere {

	private Vector<Float> medie = new Vector<Float> ();
	
	
	public StatisticheVentoGiornaliere() {
		ElaborazioneDati d = new ElaborazioneDati();
		Statistiche s = new Statistiche();
		for (int i = 0; i < d.getListacitta().size(); i++) {
			medie.add(s.mediaVento(d.getListacitta().get(i), 0, 3));
		}
	}
	
	public Vector<Float> GetMedie() {
		return medie;
	}
	
}
