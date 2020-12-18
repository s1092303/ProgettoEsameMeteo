package Filtri;

import it.univpm.ProgettoOOPMeteo.Operazioni.ElaborazioneDati;
import it.univpm.ProgettoOOPMeteo.Operazioni.Statistiche;
import java.util.Vector;

import citta.CittaMediaVar;

public class StatisticheVentoGiornaliere {

	private Vector<CittaMediaVar> vettore = new Vector<CittaMediaVar> ();
	
	
	public StatisticheVentoGiornaliere() {
		ElaborazioneDati d = new ElaborazioneDati();
		Statistiche s = new Statistiche();
		for (int i = 0; i < d.getListacitta().size(); i++) {
			CittaMediaVar c = new CittaMediaVar();
			c.setNome(d.getListacitta().get(i).getNome());
			c.setMediaVento(s.mediaVento(d.getListacitta().get(i), 0, 3));
			c.setVarianzaVento((s.varianzaVento(d.getListacitta().get(i), 0, 3)));
			c.setMediaVisibilita(s.mediaVento(d.getListacitta().get(i), 0, 3));
			c.setVarianzaVisibilita((s.varianzaVento(d.getListacitta().get(i), 0, 3)));
			vettore.add(c);
		}
	}


	public Vector<CittaMediaVar> getVettore() {
		return vettore;
	}


	public void setVettore(Vector<CittaMediaVar> vettore) {
		this.vettore = vettore;
	}

}
