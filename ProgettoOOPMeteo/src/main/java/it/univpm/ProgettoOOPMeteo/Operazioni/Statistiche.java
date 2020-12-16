package it.univpm.ProgettoOOPMeteo.Operazioni;

public class Statistiche {

	 
	public Statistiche() {}
	 

   public float mediaVento (Citta cit){
       
       float somma=0;
       for (int i=0; i<cit.GetSizeVento() ; i++) {
           somma += cit.getPosVelocita(i);
       }
       return somma/cit.GetSizeVento();
       
   }
   
   public float mediaVis (Citta cit){
       
       float somma=0;
       for (int i=0; i < cit.GetSizeVis() ; i++) {
           somma += cit.getPosVisibilita(i);
       }
       return somma/cit.GetSizeVis();
   }
   
   
   public float varianzaVento (Citta cit) {
   
   float somma=0; 
   float media = mediaVento(cit);
   
   for (int i=0; i<cit.GetSizeVento(); i++) {
       somma += (cit.getPosVelocita(i) - media)*(cit.getPosVelocita(i) - media);
       }
   return somma/(cit.GetSizeVento() - 1);
}
   
   public float varianzaVis (Citta cit) {
   
   float somma=0; 
   float media = mediaVis(cit);
   
   for (int i=0; i<cit.GetSizeVis(); i++) {
       somma += (cit.getPosVisibilita(i) - media)*(cit.getPosVisibilita(i) - media);
       }
   return somma/(cit.GetSizeVis() - 1);
   }
   
}