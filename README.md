# ProgettoEsameMeteo
Salve a tutti,

Questo programma è stato creato per l'esame di programmazione ad oggetti del corso di ingengeria informatica ad Ancona.

Il programma ha il compito di raccogliere dati metereologici (visibilità, velocità e angolo di inclinazione del vento), precedentemente presi in input attraverso le API fornite da OpenWeather,  e rielaborarli creando statistiche riguardanti media e varianza (su base giornaliera o settimanale).

Le lista delle città è composta da 5 capitali di diversi stati dell'Europa quali : Londra (ID: london,uk), Madrid (ID: Madrid), Parigi (ID: Paris), Roma (ID: rome) e Amsterdam(ID : amsterdam).

I risultati sarà possibile controllarli attraverso la chiamata di determinate API, su Postman o all'interno di un motore di ricerca, alle quali verranno passate valori riguardanti alle basi su cui fare le statistiche oppure scegliendo una determinata città.

# Diagrammi UML

Diagramma dei casi d'uso

[![case-UMLEsame.png](https://i.postimg.cc/SN00HNJN/case-UMLEsame.png)](https://postimg.cc/nM1wDx46)

Diagramma delle classi

[![Citta.png](https://i.postimg.cc/3wknKmqM/Citta.png)](https://postimg.cc/xkSK5JYg)

[![Filtri.png](https://i.postimg.cc/bNLTkmcc/Filtri.png)](https://postimg.cc/TpLgXq3C)

[![Operazioni.png](https://i.postimg.cc/5ybBFCs2/Operazioni.png)](https://postimg.cc/cgkgprqp)

[![Parser.png](https://i.postimg.cc/5tzL73Gt/Parser.png)](https://postimg.cc/NygKL1Qh)

Diagramma delle sequenze

[![diagramma-delle-sequenze.png](https://i.postimg.cc/65T7bc4N/diagramma-delle-sequenze.png)](https://postimg.cc/hfWPf90C)

# Funzionamento codice

Il programma permette di visualizzare le statistiche di alcune capitali europee
