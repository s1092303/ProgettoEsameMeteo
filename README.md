# ProgettoEsameMeteo
Salve a tutti,

Questo programma è stato creato per l'esame di programmazione ad oggetti del corso di ingengeria informatica ad Ancona.

Il programma ha il compito di raccogliere dati metereologici (visibilità, velocità e angolo di inclinazione del vento), precedentemente presi in input attraverso le API fornite da OpenWeather,  e rielaborarli creando statistiche riguardanti media e varianza (su base giornaliera o settimanale).

Le lista delle città è composta da 5 capitali di diversi stati dell'Europa quali : Londra (ID: london,uk), Madrid (ID: Madrid), Parigi (ID: Paris), Roma (ID: rome) e Amsterdam(ID : amsterdam).

I risultati sarà possibile controllarli attraverso la chiamata di determinate API, su Postman o all'interno di un motore di ricerca, alle quali verranno passate valori riguardanti alle basi su cui fare le statistiche oppure scegliendo una determinata città.

# Come scaricarlo

Da Eclipse bisogna scaricare i plugin di maven e SpringBoot.

Successivamente bisogna importarlo tramite file e poi import come mostrato in figura.

[![primo.png](https://i.postimg.cc/W4FL7jBr/primo.png)](https://postimg.cc/XZbzjM77)

Dopodiché bisogna scaricare il plugin di Egit dal link in basso a destra ( m2e marketplace) 

[![secondo.png](https://i.postimg.cc/ZnYwVxWg/secondo.png)](https://postimg.cc/HcK0L544)

Prima di poter eseguire il codice bisogna prima includere alcune librerie, nello specifico JSONsimple e JUnit5.

Per la prima bisogna fare tasto destro sul progetto e andare su "build path" e cliccare "add external archives" come mostrato nella seguente immagine

[![1.png](https://i.postimg.cc/mrNLyyT1/1.png)](https://postimg.cc/xk8V0HJ9)

Invece per aggiungere JUnit5 bisgona andare nella classe dei test e fare clic destro negli errori nella barra a sinistra (ne basta uno) e cliccare su "Add JUnit5".

[![2.png](https://i.postimg.cc/gJ2Wq9M1/2.png)](https://postimg.cc/67ggtPxh)

[![3.png](https://i.postimg.cc/MHhJSnW8/3.png)](https://postimg.cc/YLfsNqGX)

Infine basta far partire il programma dal main

[![terzo.png](https://i.postimg.cc/YS187sgZ/terzo.png)](https://postimg.cc/qtv2XQ1x)

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

# Rotte


| Tipo | Rotta                         | Funzione                  |
| :--: | :---------------------------: | :----------------------------------------------------------------------------------------------: |
| get  | /ListaCitta                   | Stampa le statistiche delle città                                                                |
| get  | /EstremiStatisticheVento      | Stampa le citta con media e varianza minima e massima rispetto alla ventosità                    |
| get  | /EstremiStatisticheVisibilità | Stampa le citta con media e varianza minima e massima rispetto alla visibilità                   |
| get  | /StatsAScelta                 | Stampa le statistiche delle città, potendo scegliere la singola città o un campionamento diverso |

# Filtri ed alcuni esempi

Il programma permette di visualizzare le statistiche di alcune capitali europee; la ricerca è possibile effetuarla attraverso degli ID:

-Londra = london,uk

-Roma = rome

-Amsterdam = amsterdam

-Madrid = Madrid

-Parigi = Paris

I metodi possono essere richiamate attraverso postman insersendo le seguenti rotte:

<pre><code> http://localhost:8080/ListaCitta</code></pre>

Questo primo metodo (GET) permette di visualizzare le statistiche settimanali di tutte le città nel caso non venga passato nessun parametro, mentre stampa le statistiche di una singola città inserendo l'ID all'interno di postman nei campi key, inserendo la stringa NomeCitta, e value (gli ID) oppure nel seguente modo (esempio con Roma):

<pre><code> http://localhost:8080/ListaCitta?NomeCitta=rome</code></pre>

L'output verrà formattato in JSON.

<pre><code> http://localhost:8080/EstremiStatisticheVento</code></pre>
<pre><code> http://localhost:8080/EstremiStatisticheVisibilita</code></pre>

Questi due metodi permettono di visualizzare le i valori massimi e minimi della media e della varianza rispettivamente alla ventosità e alla visiblità

<pre><code> http://localhost:8080/StatsAScelta</code></pre>

Questo metodo permette di visualizzare le statistiche scegliendo un periodo di campionamento (giornaliero o a intervalli di due ore). Si possono utilizzare diversi parametri quali l'ID della citta, il tipo di campionamento, il giorno, l'inizio e la fine.

L'ID della città non è un parametro necessario, in caso non venga inserito il metodo stampa le statistiche di tutte le città. 

Esempio:

<pre><code> http://localhost:8080/StatsAScelta?nome=london,uk</code></pre>

Il campionamento può essere specificato come "Giornaliero" oppure si può evitare di specificarlo; in tal caso il programma prendere per default il campionamento ad intervalli di due ore. 

Un esempio di utilizzo di questo parametro è il seguente:

<pre><code> http://localhost:8080/StatsAScelta?Campionamento=Giornaliero</code></pre>

Per esempio questa rotta da come risultato: 

<pre><code>
[
    {
        "nome": "london,uk",
        "mediaVento": 7.209398,
        "varianzaVento": 5.817421,
        "mediaVisibilita": 9011.0,
        "mediaAngoloVento": 131.16667,
        "varianzaAngoloVento": 5556.806,
        "varianzaVisibilita": 322468.66
    },
    {
        "nome": "rome",
        "mediaVento": 5.67364,
        "varianzaVento": 10.545113,
        "mediaVisibilita": 9101.583,
        "mediaAngoloVento": 118.583336,
        "varianzaAngoloVento": 5003.4097,
        "varianzaVisibilita": 332218.75
    },
    {
        "nome": "amsterdam",
        "mediaVento": 5.518375,
        "varianzaVento": 10.101326,
        "mediaVisibilita": 8559.5,
        "mediaAngoloVento": 122.583336,
        "varianzaAngoloVento": 3632.91,
        "varianzaVisibilita": 178126.08
    },
    {
        "nome": "Madrid",
        "mediaVento": 5.508675,
        "varianzaVento": 8.701848,
        "mediaVisibilita": 8946.583,
        "mediaAngoloVento": 133.16667,
        "varianzaAngoloVento": 5671.472,
        "varianzaVisibilita": 343089.94
    },
    {
        "nome": "Paris",
        "mediaVento": 5.578587,
        "varianzaVento": 4.830351,
        "mediaVisibilita": 8888.667,
        "mediaAngoloVento": 106.666664,
        "varianzaAngoloVento": 9735.556,
        "varianzaVisibilita": 180656.73
    }
]
</code></pre>

In questo modo il programma stamperà le statistiche giornaliere di tutte le città prendendo per default il primo giorno, nel caso che si voglia scegliere un giorno specifico si può utilizzare il terzo parametro "giorno", inserendo un numero da 1 a 7 ( se il numero non appartiene a questo intervallo il programma non ritorna niente).

Per esempio la seguente rotta stampa le statistiche di Roma nel terzo giorno:

<pre><code> http://localhost:8080/StatsAScelta?nome=rome&Campionamento=Giornaliero&giorno=3 </code></pre>

Non inserendo il tipo di campionamento il programma utilizzerà di default il campionamento per due ore. In questo caso è possibile usare i due parametri "inizio" e "fine".
Il campionamento iniziale per prendere i dati è stato effettuato ad intervalli di due ore per una settimana, per cui il valori passati possono variare tra 0 e 83 (se il valore di inizio e maggiore di quello di fine il programma non ritornerà nulla).
I valori di default di inizio e di fine sono rispettivamente 0 e 83.

Per esempio, se voglio avere le statistiche di Parigi per il terzo e il quarto giorno dovrei scrivere: 

<pre><code> http://localhost:8080/StatsAScelta?nome=Paris&inizio=24&fine=47 </code></pre>

Questa rotta da come risultato:

<pre><code> 
[
    {
        "nome": "Paris",
        "mediaVento": 5.8937874,
        "varianzaVento": 8.832495,
        "mediaVisibilita": 8923.625,
        "mediaAngoloVento": 158.33333,
        "varianzaAngoloVento": 3849.5554,
        "varianzaVisibilita": 361899.97
    }
]
</code></pre>

# Autori

**Nicola Ronchini**   : https://github.com/s1092303

**Tommaso Omiccioli** : https://github.com/s1093667
