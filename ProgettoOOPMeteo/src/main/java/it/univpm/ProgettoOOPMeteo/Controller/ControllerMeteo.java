package it.univpm.ProgettoOOPMeteo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProgettoOOPMeteo.Operazioni.ElaborazioneDati;

/**
 * Controller del codice per utilizzare i metodi attraverso URL
 * 
 * @author Nicola Ronchini, Tommaso Omiccioli
 *
 */

@RestController
public class ControllerMeteo {

	@GetMapping("/ListaCitta")
	public ElaborazioneDati exampleMethod () {
		ElaborazioneDati p = new ElaborazioneDati();
		return p;
	}
	
}
