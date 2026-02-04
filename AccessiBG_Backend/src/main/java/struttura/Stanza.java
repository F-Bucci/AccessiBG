package struttura;

/**
 * Rappresenta una stanza all'interno di un edificio.
 * <p>
 * Una stanza può essere un'aula, un ufficio o un altro tipo di ambiente
 * ed è caratterizzata da informazioni spaziali, descrittive e di accessibilità.
 * </p>
 * <p>
 * I campi testuali e numerici vengono normalizzati nel costruttore
 * per garantire valori coerenti e sicuri.
 * </p>
 */
public class Stanza implements ElementoMappa{
	private int id;
	private String nome;
	private int posti;
	private String descrizione;
	private boolean accessibile;
	private double x;
	private double y;
	private TipoStanza tipoStan;
	private String pathFoto;
	private String pathPercorso;
	private int piano;

	/**
     * Costruisce un oggetto {@code Stanza} inizializzando
     * tutte le sue proprietà.
     * <p>
     * I parametri testuali {@code null} o vuoti vengono sostituiti
     * con valori di default. Il numero di posti non può essere negativo.
     * </p>
     *
     * @param id identificativo della stanza
     * @param nome nome della stanza
     * @param posti numero di posti disponibili
     * @param descrizione descrizione della stanza
     * @param accessibile indica se la stanza è accessibile
     * @param x coordinata X della stanza
     * @param y coordinata Y della stanza
     * @param tipoStan tipo della stanza
     * @param pathPercorso percorso associato alla stanza
     * @param pathFoto immagine della stanza
     * @param piano piano in cui è situata la stanza
     */
	public Stanza(int id, String nome, int posti, String descrizione, boolean accessibile, double x, double y,
			TipoStanza tipoStan, String pathPercorso,String pathFoto,int piano) {
		this.id = id; // id può essere qualsiasi valore, validato altrove
		this.nome = (nome == null || nome.isBlank()) ? "Nome non specificato" : nome;
		this.posti = (posti < 0) ? 0 : posti;
		this.descrizione = (descrizione == null || descrizione.isBlank()) ? "Descrizione non presente" : descrizione;
		this.accessibile = accessibile;
		this.x = x; // coordinata x può essere qualsiasi valore, validato altrove
		this.y = y; // coordinata y può essere qualsiasi valore, validato altrove
		this.tipoStan = (tipoStan == null) ? TipoStanza.AULA : tipoStan; 
		this.piano = piano; // numero di piano può essere qualsiasi valore, validato altrove
		this.pathPercorso = (pathPercorso == null || pathPercorso.isBlank()) ? "Percorso non disponibile" : pathPercorso;
		this.pathFoto = (pathFoto == null || pathFoto.isBlank()) ? "Foto non disponibile" : pathFoto;
	}

	/**
     * Restituisce il nome della stanza.
     *
     * @return nome della stanza
     */
	public String getNome() {return nome;}

	/**
     * Indica se la stanza è accessibile.
     *
     * @return {@code true} se accessibile, {@code false} altrimenti
     */
	public boolean getAccessibile() { return accessibile; }

	/**
     * Restituisce la descrizione della stanza.
     *
     * @return descrizione della stanza
     */
	public String getDescrizione() {return descrizione;}

	/**
     * Restituisce il piano in cui si trova la stanza.
     *
     * @return numero del piano
     */
	public int getPiano() { return piano; }

	/**
     * Restituisce l'identificativo della stanza.
     *
     * @return id della stanza
     */
	public int getId() {
		return id;
	}

	/**
     * Restituisce il numero di posti disponibili nella stanza.
     *
     * @return numero di posti
     */
	public int getPosti() {
		return posti;
	}

	/**
     * Restituisce la coordinata X della stanza.
     *
     * @return coordinata X
     */
	public double getX() {
		return x;
	}

	/**
     * Restituisce la coordinata Y della stanza.
     *
     * @return coordinata Y
     */
	public double getY() {
		return y;
	}

	/**
     * Restituisce il tipo della stanza.
     *
     * @return tipo della stanza
     */
	public TipoStanza getTipoStan() {
		return tipoStan;
	}

	/**
     * Restituisce il percorso associato alla stanza.
     *
     * @return path del percorso
     */
	@Override
	public String getPathPercorso() {
	    return this.pathPercorso; // Ritorna la variabile che hai nella classe
	}

	/**
     * Restituisce l'immagine della stanza.
     *
     * @return immagine della stanza
     */
	public String getPathFoto() {
		return pathFoto;
	}
}

