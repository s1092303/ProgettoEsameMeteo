package Filtri;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.parser.ParseException;

import citta.CittaMediaVar;
import it.univpm.ProgettoOOPMeteo.Operazioni.ElaborazioneDatiDaFile;
import it.univpm.ProgettoOOPMeteo.Operazioni.Statistiche;


public class StatisticheAScelta {

	private Vector<CittaMediaVar> vettore = new Vector<CittaMediaVar> ();
	
	protected int inizio = 0;
	protected int fine = 0;
	
	
	public StatisticheAScelta(int inizio, int fine) throws FileNotFoundException, IOException, ParseException {
		this.inizio = inizio;
		this.fine = fine;
		
		ElaborazioneDatiDaFile d = new ElaborazioneDatiDaFile();
		Statistiche s = new Statistiche();
		for (int i = 0; i < d.getCity().size(); i++) {
			CittaMediaVar c = new CittaMediaVar();
			c.setNome(d.getCity().get(i).getNome());
			c.setMediaVento(s.mediaVento(d.getCity().get(i), inizio, fine));
			c.setVarianzaVento((s.varianzaVento(d.getCity().get(i), inizio, fine)));
			c.setMediaVisibilita(s.mediaVisibilita(d.getCity().get(i), inizio, fine));
			c.setVarianzaVisibilita((s.varianzaVisibilita(d.getCity().get(i), inizio, fine)));
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


