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
//punto sbagliato (punto 11)
Durante lo sviluppo dell'applicazione, verrà utilizato Eclipse come ambiente di sviluppo. Tale app, con Maven, verrà scritto con il linguaggio di programmazione Java (rispettando le convenzioni definite da Oracle), che quest'ultima andrà a sostituire la parte scrittura in HTML e in JavaScript grazie al framework di Vaadin (come richiesto dalla proposta di questo progetto).

Per la realizzazione dei diagrammi UML utilizzeremo:
- Papyrus, per la realizzazione del diagramma delle classi;
- PlantUML, per i diagrammi restanti.
- Eclipse plugin per qualità codice
- Eclipse IDE

Infine, come punto di convidisione del materiale e modo di lavorare assieme al progetto si utilizza Github. Sarà presente una repository remota in cui ci sarà tutto ciò che va a definire il nostro progetto (web-app, diagrammi UML e documentazione).

Il team si impegna a seguire le norme etiche generali definite per l’ingegnere informatico. 

# 5. ATTIVITÁ DI GESTIONE
Riunione ogni settimana per eventuali problematiche riscontrate o aggiornamenti.
Si lavorerà tendenzialmente a distanza, ma possono essere convocate eventuali riunioni in presenza in caso di necessità.
Standup se lo facciamo,  possibilmente la sera e non necessariamente tutti i giorni.

# 6. RISCHI
- Non riuscire a implementare tutte le funzionalità richieste dal cliente nei tempi richiesti;
- Implementazione superficiale di alcune sedi;
- Interfaccia UI/UX essenziale.

# 7. PERSONALE
Tutti i componenti del team sono coinvolti in tutte le fasi del progetto, con un'organizzazione del personale che si ispira ai metodi agili quali Scrum e XP. I ruoli di Product Owner e Scrum master, non saranno tuttavia assegnati nella loro completezza, a causa della dimensione del team e del poco tempo a disposizione. Queste responsabilità saranno assegnate ad interim.

# 8. METODI E TECNICHE
UML sarà usato in tutte le fasi della progettazione e sviluppo del software, in particolare Papyrus sarà usato per il class diagram, mentre PathUML sarà usato per gli altri diagrammi;
Per il Front-end verrà usato Vaadin (inserire link), mentre Java sarà usato per il Back-end e verranno usati plugin per la qualità del codice (elenco plugin)
Per quanto riguarda il layer DB, Firebase (no sql) sarà sicuramente utilizzato, eventualmente affiancato da un altro DB relazionale embedded, creato tramite Eclipse.

# 9. GARANZIE DI QUALITÁ
Il team si impegna a perseguire i criteri di qualità del sw definiti dal modello di McCall, ad usare le convenzioni Java e ad integrare plugin Eclipse per aumentare la qualità del codice.

# 10. ORGANIZZAZIONE PACCHETTI DI LAVORO
L' organizzazione del team si ispira ai metodi agili come Scrum e XP, senza ruoli precisi e con il carico di lavoro ripartito per Sprint dalla durata di una settimana. I lunedì saranno usati per fare una retrospettiva sullo Sprint appena finito e per la pianificazione delle task da completare durante il nuovo Sprint. Queste task avranno delle corrispettive issues nella Kanban board di Github, che sarà usata per monitorare lo stato di queste task e per la loro assegnazione e organizzazione. 

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
Non dovrebbe servire, ma potrebbero essere considerati eventuali costi per lo spostamento nelle diversi sedi dell'Universita' di Bergamo per effettuare ricerche utili per il miglioramento dell'esperienza dell'utente.
Inoltre, verranno utilizzate risorse Open-Source e/o non a pagamento per lo sviluppo del programma.

# 13. GESTIONE CAMBIAMENTI
Il versioning ed i cambiamenti/ticket verranno gestiti tramite GitHub.

# 14. CONSEGNA
Per Gennaio sará rilasciata una versione web di prova per l’utente.
Non si esclude il rilascio di un'app su play store.
