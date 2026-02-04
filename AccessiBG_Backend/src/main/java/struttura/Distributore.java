package struttura;

/**
 * Rappresenta un distributore presente nella mappa.
 * <p>
 * La classe modella le informazioni principali di un distributore,
 * come nome, descrizione, tipologia, accessibilità, posizione e
 * risorse multimediali associate.
 * </p>
 * <p>
 * I controlli di validazione su valori {@code null} o vuoti
 * vengono effettuati nel costruttore, assegnando valori di default
 * ove necessario.
 * </p>
 */
public class Distributore implements ElementoMappa{
	private int id;
	private String nome;
	private String descrizione;
	private TipoDistributore tipo;
	private boolean accessibile;
	private double x;
	private double y;
	private String pathFoto;
	private String pathPercorso;
	private int piano;
	
	/**
     * Costruisce un oggetto {@code Distributore} inizializzando
     * tutti i suoi attributi.
     * <p>
     * Gli attributi testuali vengono normalizzati nel caso in cui
     * siano {@code null} o vuoti, assegnando valori di default.
     * </p>
     *
     * @param id identificativo del distributore
     * @param nome nome del distributore
     * @param descrizione descrizione del distributore
     * @param tipo tipologia del distributore
     * @param accessibile indica se il distributore è accessibile
     * @param x coordinata X sulla mappa
     * @param y coordinata Y sulla mappa
     * @param pathFoto immagine del distributore
     * @param pathPercorso percorso per raggiungere il distributore
     * @param piano piano dell'edificio in cui si trova il distributore
     */
	public Distributore(int id, String nome, String descrizione, TipoDistributore tipo, boolean accessibile, double x, double y, String pathFoto, String pathPercorso, int piano) {
		this.id = id; // id può essere qualsiasi valore, validato altrove
		this.nome = (nome == null || nome.isBlank()) ? "Nome non specificato" : nome;
		this.descrizione = (descrizione == null || descrizione.isBlank()) ? "Descrizione non presente" : descrizione;
		this.tipo = (tipo == null) ? TipoDistributore.SNACK_E_BEVANDE : tipo;
		this.accessibile = accessibile;
		this.x = x; // coordinata x può essere qualsiasi valore, validato altrove
		this.y = y; // coordinata y può essere qualsiasi valore, validato altrove
		this.piano = piano; // numero del piano può essere qualsiasi valore, validato altrove
		this.pathFoto = (pathFoto == null || pathFoto.isBlank()) ? "Foto non disponibile" : pathFoto;
		this.pathPercorso = (pathPercorso == null || pathPercorso.isBlank()) ? "Percorso non disponibile" : pathPercorso;
	}
	
	/**
     * Restituisce la tipologia del distributore.
     *
     * @return tipo del distributore
     */
	public TipoDistributore getTipo() { return tipo; }

	/**
     * Indica se il distributore è accessibile.
     *
     * @return {@code true} se accessibile, {@code false} altrimenti
     */
    public boolean getAccessibile() { return accessibile; }
    
    /**
     * Restituisce la descrizione del distributore.
     *
     * @return descrizione del distributore
     */
    public String getDescrizione() {return descrizione;}
    
    /**
     * Restituisce il piano in cui si trova il distributore.
     *
     * @return numero del piano
     */
	public int getPiano() {return piano;}
	
	/**
     * Restituisce l'identificativo del distributore.
     *
     * @return id del distributore
     */
	public int getId() {return id;}
	
	/**
     * Restituisce la coordinata X del distributore sulla mappa.
     *
     * @return coordinata X
     */
	public double getX() {return x;}
	
	/**
     * Restituisce la coordinata Y del distributore sulla mappa.
     *
     * @return coordinata Y
     */
	public double getY() {return y;}
	
	/**
     * Restituisce il percorso per raggiungere il distributore.
     *
     * @return percorso
     */
	@Override
	public String getPathPercorso() {
		return pathPercorso;
	}
	
	/**
     * Restituisce la foto del distributore.
     *
     * @return immagine del distributore
     */
	public String getPathFoto() {
		return pathFoto;
	}
	
	/**
     * Restituisce il nome del distributore.
     *
     * @return nome del distributore
     */
    public String getNome() {
        return nome;
    }
}