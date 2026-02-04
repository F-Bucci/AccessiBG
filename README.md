# AccessiBG

AccessiBG è una webapp che fornisce informazioni sull'accessibilità degli spazi dell'Università degli Studi di Bergamo: sedi, aule, biblioteche, mense, parcheggi e servizi connessi.  
Per iniziare, clona questo repository.

---

## Responsabili del progetto

- 1077719 | Filippo Guidomaria Bucci
- 1053039 | Allison Rosa Perez Murillo
- 1080937 | Monteleone Daniele
- 1080548 | Cuni Luizo

---

## Struttura del repository

```
.
├── AccessiBG_sqlite/      # Modulo per creazione e popolamento DB SQLite
├── AccessiBG_Backend/     # Backend: DAO, servizi e logica applicativa
├── accessibilita-unibg/   # Frontend Vaadin (app web principale)
├── Documentazione/        # Project plan, design, testing, ecc.
└── README.md              # Questo file
```

---

## Architettura del progetto

Il repository è composto da tre progetti che collaborano tra di loro, e sono le seguenti:

- **AccessiBG_sqlite**  
  Contiene la logica per creare e gestire il database SQLite (package `gestione_db`, classe principale `CreateDB`) + Jooq.

- **AccessiBG_Backend**  
  Implementa DAO e servizi (package `dao`, `struttura`): può essere avviato come servizio separato se l'architettura lo richiede.

- **accessibilita-unibg**  
  Applicazione web basata su Vaadin + Spring Boot. Contiene le view (`it.unibg.accessibilita.base.ui`), la classe `DBInit` che invoca `CreateDB` all'avvio e le risorse frontend in `src/main/frontend`.

---

## Requisiti

- Java 17 o superiore
- Maven 4.0
- IDE Java (IntelliJ, Eclipse, VS Code) per sviluppo locale (preferibilmente Eclipse)
- Sistema Operativo: Windows (10 e 11), MacOS e Linux (qualsiasi distro più recente)

---

## Avvio rapido (ordine consigliato)

Nota: alcuni moduli locali potrebbero dover essere installati nel repository Maven locale (`mvn install`) affinché gli altri progetti li risolvano come dipendenze.

1) Preparare il modulo SQLite
- Vai nella cartella del progetto SQLite e installalo localmente:
  ```bash
  cd AccessiBG_sqlite
  ./mvnw install
  ```
  oppure, se non è presente il wrapper:
  ```bash
  mvn install
  ```
  Questo rende disponibile la classe `gestione_db.CreateDB` agli altri progetti.

2) Avviare il backend (opzionale, se usato separatamente)
- Dal progetto backend:
  ```bash
  cd AccessiBG_Backend
  ./mvnw spring-boot:run
  ```
  Oppure:
  ```bash
  ./mvnw package
  java -jar target/<nome-backend>-<versione>.jar
  ```
- Controlla eventuali file `application.properties` / `application.yml` per porta e configurazioni DB.

3) Avviare l'app frontend (accessibilita-unibg)
- Dal progetto frontend:
  ```bash
  cd accessibilita-unibg
  ./mvnw spring-boot:run
  ```
- Durante l'avvio la classe `DBInit` (in `it.unibg.accessibilita.DBInit`) chiama `gestione_db.CreateDB` per creare/inizializzare il DB se necessario. Per questo è utile che il passo 1 sia già stato eseguito.
- Apri il browser su: http://localhost:8080 (porta di default, verificare in caso di override).

Per build di produzione:
```bash
cd accessibilita-unibg
./mvnw -Pproduction package
docker build -t accessibiltia-unibg:latest .
```

---

## Esecuzione in IDE

- Importa i progetti come Maven projects nel tuo IDE.
- Esegui la classe `Application` in `accessibilita-unibg` per avviare l'app Vaadin.

---

## Note tecniche e punti di interesse

- Inizializzazione DB: `accessibilita-unibg/src/main/java/it/unibg/accessibilita/DBInit.java` utilizza `gestione_db.CreateDB` per creare/popolare il DB all'avvio.
- View principali: `it.unibg.accessibilita.base.ui` contiene varie view, come ad esempio: `HomeView`, `SediView` e `MainLayout`.

---

## Documentazione

Per vedere la documentazione del progetto andare nella cartella `Documentazione/` per:
- Project plan
- Design e diagrammi
- Strategy di testing (es. `Documentazione/5. Testing.md`)
- Altri documenti utili
