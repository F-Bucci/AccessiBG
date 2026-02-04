package struttura;

/**
 * Rappresenta un ostacolo presente sulla mappa.
 * <p>
 * Un ostacolo è un elemento che può interferire con la percorribilità
 * di un percorso (es. oggetti ingombranti).
 * </p>
 * <p>
 * Alcuni attributi testuali vengono normalizzati nel costruttore
 * nel caso in cui siano {@code null} o vuoti.
 * </p>
 */
public class Ostacolo implements ElementoMappa{
	private int id;
	private String nome;
	private String descrizione;
	private TipoOstacolo tipo;
	private double x;
	private double y;
	private String pathFoto;
	private String pathPercorso;
	private int piano;
	
	/**
     * Costruisce un oggetto {@code Ostacolo} inizializzando
     * tutti i suoi attributi.
     * <p>
     * I campi testuali {@code nome}, {@code descrizione} e {@code pathFoto}
     * vengono normalizzati se {@code null} o vuoti.
     * </p>
     *
     * @param id identificativo dell'ostacolo
     * @param nome nome dell'ostacolo
     * @param tipo tipologia dell'ostacolo
     * @param descrizione descrizione dell'ostacolo
     * @param x coordinata x sulla mappa
     * @param y coordinata y sulla mappa
     * @param pathFoto immagine dell'ostacolo
     * @param pathPercorso percorso dell'ostacolo
     * @param piano piano in cui si trova l'ostacolo
     */
	public Ostacolo(int id, String nome, TipoOstacolo tipo, String descrizione, double x, double y, String pathFoto, String pathPercorso, int piano) {
        this.id = id; // id può essere qualsiasi valore, validato altrove
        this.nome = (nome == null || nome.isBlank()) ? "Nome non specificato" : nome;
		this.tipo = (tipo == null) ? TipoOstacolo.OGGETTO_INGROMBRANTE : tipo;
		this.descrizione = (descrizione == null || descrizione.isBlank()) ? "Descrizione non presente" : descrizione;
        this.x = x; // coordinata x può essere qualsiasi valore, validato altrove
        this.y = y; // coordinata y può essere qualsiasi valore, validato altrove
        this.piano = piano; // numero del piano può essere qualsiasi valore, validato altrove
        this.pathPercorso = pathPercorso;
        this.pathFoto = (pathFoto == null || pathFoto.isBlank()) ? "Foto non disponibile" : pathFoto;
    }
	
	/**
     * Restituisce il tipo dell'ostacolo.
     *
     * @return tipologia dell'ostacolo
     */
	public TipoOstacolo getTipo() { return tipo; }

	/**
     * Restituisce la descrizione dell'ostacolo.
     *
     * @return descrizione dell'ostacolo
     */
    public String getDescrizione() { return descrizione; }
 
    /**
     * Restituisce il piano in cui si trova l'ostacolo.
     *
     * @return piano dell'ostacolo
     */
    public int getPiano() { return piano; }
	
    /**
     * Restituisce l'identificativo dell'ostacolo.
     *
     * @return id dell'ostacolo
     */
    public int getId() {
		return id;
	}
    
    /**
     * Restituisce la coordinata x dell'ostacolo.
     *
     * @return coordinata x
     */
	public double getX() {
		return x;
	}
	
	/**
     * Restituisce la coordinata y dell'ostacolo.
     *
     * @return coordinata y
     */
	public double getY() {
		return y;
	}
	
	/**
     * Restituisce il percorso associato all'ostacolo.
     * <p>
     * Attualmente il metodo restituisce {@code null}.
     * </p>
     *
     * @return {@code null}
     */
	@Override
	public String getPathPercorso() {
		return null;
	}
	
	/**
     * Restituisce l'immagine dell'ostacolo
     *
     * @return immagine dell'ostacolo
     */
	public String getPathFoto() {
		return pathFoto;
	}
	
	/**
     * Restituisce il nome dell'ostacolo.
     *
     * @return nome dell'ostacolo
     */
	public String getNome() {
		return nome;
	}
}
