# 1. INTRODUZIONE
L’accessibilità fisica e digitale rappresenta un requisito essenziale per garantire autonomia, partecipazione attiva e pari opportunità all’interno della società.
Il progetto, con l'obiettivo di promuovere inclusione e benessere, prevede la realizzazione di una web-app dedicata alla consultazione di guide strutturate sull’accessibilità di edifici e spazi, consentendo agli utenti, in particolare persone con esigenze specifiche di mobilità o accesso, di pianificare i propri spostamenti in maniera consapevole e sicura.

L’applicazione si focalizzerà sugli spazi dell’Università degli Studi di Bergamo, includendo sedi, aule, biblioteche, bar, mense e centri sportivi. Per ciascun luogo saranno fornite informazioni dettagliate e aggiornate su percorsi, infrastrutture, servizi di supporto e caratteristiche rilevanti dell’accessibilità, con l’obiettivo di creare uno strumento pratico e utile a tutti quelli che ne necessitano.

Come riferimento funzionale e ispirazione progettuale, l’applicazione si baserà su alcuni criteri adottati da AccessAble (https://www.accessable.co.uk/), una web-app che fornisce informazioni utili sull'accessibilità degli spaci pubblici e privati in Regno Unito e in Irlanda.

I responsabili del progetto sono i seguenti:
- 1077719 | Filippo Guidomaria Bucci;
- 1053039 | Allison Rosa Perez Murillo;
- 1080937 | Monteleone Daniele;
- 1080548 | Cuni Luizo.

# 2. MODELLO DEL PROCESSO
Tra i vari modelli di processo messi a disposizione, è stato deciso assieme di attuare quello della programmazione estrema (eXtreme Programming).
Tale decisione è stata presa per le seguenti ragioni:

- Gruppo piccolo;
- Riunione settimanale veloce, conveniente per noi che abbiamo difficoltà a trovare un'orario in cui siamo tutti disponibili;
- Intera squadra, in cui abbiamo il Cliente (ruolo coperto da uno dei membri del gruppo) che prende varie decisioni sullo sviluppo del progetto, e il resto dei componenti svolgono il loro ruolo/ruoli in base alle loro competenze;
- Sviluppo basato sui test, il team crea dei test semplici e automatizzati;
- Test dei clienti, il Cliente esegue il prototipo per assicurarsi che i requisiti siano stati implementati e rispettati;
- Piccole uscite, il team si impegna a effettuare delle piccole release funzionali il più frequentemente possibile che saranno accessibili sulla piattaforma Github da parte del team (compreso il Cliente) e da parte dei professori interessati;
- Design semplice, il team si impegna a creare la web-app mantenendo per l'intero sviluppo un design semplice ma efficace, adattabile a nuove aggiunte/modifiche future;
- Programmazione in coppia, dove uno scrive e l'altro guarda e interviene quando è necessario; in questa maniera si avrà un codice migliore. Questa operazione viene effettuata mentre si sta in chiamata sulla piattaforma Meet;
- Proprietà collettiva del codice, il team si divide a coppie a rotazione in modo che ogni membro del team programmi su diversi aspetti del codice aiutando così la comprensione delle funzionalità.

# 3. ORGANIZZAZIONE PROCESSO
Il team di progetto lavora in modo collaborativo, seguendo i principi della metodologia Extreme Programming: tutti i membri partecipano alle attività dove possono dare il proprio contributo.

Il ruolo di Cliente (seguendo una delle pratiche della programmazione estrema), che decide le priorità e conferma le funzionalità sviluppate, è ricoperto da un membro del gruppo, come punto di riferimento per il progresso del progetto.

Gli altri ruoli del team (sviluppatore, tester, analista, responsabile qualità, ecc.) non sono né fissi, né tantomeno esclusivi. Infatti, una persona può avere più ruoli, in base alle competenze e alle necessità del momento.

Il team manterrà un confronto costante con i docenti dell’Università degli Studi di Bergamo per ottenere materiali utili al progetto (mappe dei piani degli edifici delle sedi universitarie), ricevere feedback sul lavoro svolto e migliorare le scelte di sviluppo dell’applicazione.

Tutte le attività e le comunicazioni saranno registrate per garantire chiarezza e tracciabilità durante il progetto.

# 4. NORME, LINEE GUIDA, PROCEDURE
La documentazione verrà consegnata seguendo le tempistiche prestabilite ossia:
- Project plan: verrà consegnato il 16 dicembre 2025 in formato markdown;
- Documentazione completa: sarà consegnata 5 giorni prima della presentazione concordata del progetto.

Per assicurarsi della qualità e comprensibilità della documentazione qui presente, la stessa sarà rivista e corretta da tutti i componenti del team.

Il team rispetterà, durante lo sviluppo, le linee guida e gli standard dettati dalle convenzioni per la programmazione Java come definite da Oracle.
Inoltre, il team si impegna a seguire le norme etiche generali definite per l’ingegnere informatico. 

# 5. ATTIVITÁ DI GESTIONE
Il team si riunirà una volta a settimana su Google Meet o in presenza per discutere di eventuali problematiche riscontrate, aggiornamenti e idee da implementare durante il prossimo Sprint. Per risolvere eventuali problemi urgenti possono essere convocate ulteriori riunione, mentre verranno utilizzati altri mezzi di comunicazione per feedback giornalieri, come ad esempio WhatsApp.
Si lavorerà tendenzialmente a distanza, ma possono essere convocate eventuali riunioni in presenza in caso di necessità.

Per monitorare lo stato di avanzamento del progetto si utilizzerà la Kanban Board di GitHub e le sue issues, ognuna delle quali conterrà una etichetta che esplicherà a quale sprint essa appartiene.

# 6. RISCHI
- Non riuscire a implementare tutte le funzionalità richieste dal cliente nei tempi richiesti (interfaccia UI/UX essenziale);
- Implementazione superficiale di alcune sedi ed edifici;
- Eventuali problemi col software;
- Tempistiche allungate a causa di nuovi strumenti che il team deve utilizzare pur non avendone una conoscenza approfondita;
- Possibilità che una riunione possa essere rimandata a causa di impegni personali di qualche membro del team.

# 7. PERSONALE
Tutti i componenti del team sono coinvolti in tutte le fasi del progetto, con un'organizzazione del personale che si ispira ai metodi agili quali Scrum e XP. I ruoli di Product Owner e Scrum master, non saranno tuttavia assegnati nella loro completezza, a causa della dimensione del team e del poco tempo a disposizione. Queste responsabilità saranno assegnate ad interim.

# 8. METODI E TECNICHE

Per la raccolta dei requisiti ci saranno delle riunioni con il Cliente. Attraverso le richieste fornite verrà redatta l'ingegneria dei requisiti, implementandole con un forte focus sull'accessibilità, prendendo spunto dal sito AccessAble (https://www.accessable.co.uk/).

Per la progettazione e lo sviluppo del software verranno utilizzati i diagrammi UML basandoci su software e plugins come Papyrus (per il Class Diagramm e Component Diagramm) e PlantUml utilizzando Eclipse come IDE. Inoltre ci baseremo su Papyrus per la generazione delle classi.
Il progetto verrà gestito dal team utilizzando le diverse funzioni della piattaforma di GitHub per gestire il lavoro sincrono e per organizzarne il versioning, mentre i task verranno gestiti dalla Kanban Board.

Verrà utilizzato il framework di Vaadin per implementare l'interfaccia grafica della webapp utilizzando il linguaggio Java.
Verrà utilizzata la libreria Jooq per poter gestire il database da Eclipse. 

Effettueremo diversi test durante l'implementazione del codice attraverso Junit ed Eclemma.

# 9. GARANZIE DI QUALITÁ
Il team implementa il codice affinchè sia leggibile, pulito e manutenibile e si impegna a seguire le seguenti pratiche all'interno dell'ambiente di sviluppo:

- Convenzioni per la progettazione in Java come definite da Oracle;
- I fattori di qualità di McCall;
- L'utilizzo di JavaDoc per garantire la comprensione del codice, non solo all'interno del team, ma anche per garantire che sia manutenibile in  futuro;
- Analisi statica con plugin di Eclipse come Stan4j, pmd e SonarQube per garantire un'ottima qualità del codice e che sia pulito, evitando cosi        eventuali duplicazioni del codice;
- La complessità ciclomatica di McCabe.

Inoltre il team si impegna a garantire la stabilità del codice attraverso un rigoroso processo di testing utilizzando JUnit ed Eclemma.

# 10. ORGANIZZAZIONE PACCHETTI DI LAVORO
L'organizzazione del team si ispira ai metodi agili come Scrum e XP, senza ruoli precisi. Ad ogni sprint vengono definiti i task che devono essere implementati dai membri nel team senza nessuna struttura gerarchica.
Alla fine dello sprint viene fatta una retrospettiva per verificare lo stato dei task.

# 11. RISORSE
Il team per supportare il progetto utilizzerà diversi strumenti.
Per quanto riguarda il lato hardware ogni membro del team utilizzerà per la maggior parte del progetto il proprio PC personale, oppure  è possibile che un PC possa esssere condiviso per eseguire in maniera più efficiente eventuali lavori specifici sul progetto.

Questo progetto, inoltre, sarà scritto interamente in Java, utilizzando Vaadin per la creazione della web app, senza l'utilizzo di altri linguaggi di programmazione. 
Verrà utilizzato, oltre alla documentazione fornita sul sito ufficiale di Vaadin, lo strumento per la creazione di una Preview della web app.

Per lo svilippo del progetto verrà utillizzato Eclipse IDE come ambiente di sviluppo, insieme a diversi plugin per la realizzazione di diagrammi UML e per l'analisi statica.

In particolare si citano:
- Papyrus UML per la creazione dei diagrammi UML e la generazione delle classi attraverso il diagramma delle classi;
- Stan4J per l'analisi della struttura del codice;
- Pmd per individuare eventuale duplicazione del codice nel progetto;
- SonarQube per identificare problemi e migliorare la qualità del codice.

# 12. BUDGET

Risorse umane: totale 7680;
- Sviluppatori (senza distinzione)128h stimate 15€/h    totale 128hx4 personex15€/h=7680
Infrastruttura tecnica:         totale 290€
- Database (Jooq)               220€/anno
- Repository Git (Github)        50€/anno
- Dominio web                    20€/anno
Strumenti software:             totale 210€
- Canva (mappe, foto)           100€/anno
- Interfaccia grafica (Vaadin)  110€/anno
Ricerca, analisi e validazione con utente:       totale 70-130€
- Interviste esplorative                         50-100€
- Materiale informativo (questionari, stampe)    20-30€
Eventuali spese per riunioni e cancelleria       30-60€
Totale: 8280-8370€
Eventuali altri software utilizzati ma non citati sono da considerarsi a costo 0€.

# 13. GESTIONE CAMBIAMENTI

Le eventuali modifiche vengono discusse durante la retrospettiva in cui viene analizzato l'impatto sui requisiti, sull'architettura ed eventuali costi. In base alla valutazione effettuata dal team, le modifiche vengono approvate o meno.
Le modifiche approvate vengono transformate in task e inserite all'interno della Kanban Board. 

Inoltre, per gestire i cambiamenti radicali verranno utilizzati i branch, in modo che possano essere visionati e testati dal team prima di effettuare un merge.


# 14. CONSEGNA
La webapp e la sua documentazione sarà disponibile tramite GitHub, al quale le persone interessate ne avranno accesso entro la data prestabilita.
Piu precisamente:
- il project plan verrà consegnato il 16 dicembre 2025 in formato markdown;
- la documentazione completa insieme al codice, invece, saranno consegnati 5 giorni prima della presentazione concordata del progetto con la data ancora da definire.
Inoltre la webapp sarà eseguibile senza l'installazione di programmi o plugin aggiuntivi.


