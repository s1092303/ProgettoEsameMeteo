package Filtri;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import citta.Citta;
import citta.CittaMediaVar;
import it.univpm.ProgettoOOPMeteo.Operazioni.Statistiche;

public class StatisticheASceltaPerCitta {

	protected Citta citta = new Citta ();
	protected CittaMediaVar citt = new CittaMediaVar ();
	
	protected int inizio = 0;
	protected int fine = 0;
	protected String nome;
	
	public StatisticheASceltaPerCitta(int inizio, int fine, String nome) throws FileNotFoundException, IOException, ParseException {
		this.inizio = inizio;
		this.fine = fine;
		this.nome = nome;
		
		FiltroPerNome fil = new FiltroPerNome (nome);
		Statistiche s = new Statistiche();
		this.citta = fil.getCitta();
		
		CittaMediaVar cit = new CittaMediaVar (citta.getNome(), s.mediaVento(citta, inizio, fine), s.varianzaVento(citta, inizio, fine),s.mediaVisibilita(citta, inizio, fine),s.varianzaVisibilita(citta, inizio, fine));
		citt = cit;
	}
	
	public CittaMediaVar getCittaMediaVar () {
		return citt;
	}
	}

