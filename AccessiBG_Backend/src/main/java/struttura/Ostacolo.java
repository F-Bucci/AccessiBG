package struttura;

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
	
	public Ostacolo() {}
	
	public TipoOstacolo getTipo() { return tipo; }

    public String getDescrizione() { return descrizione; }
 
    public int getPiano() { return piano; }
	
    public int getId() {
		return id;
	}
    
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	@Override
	public String getPathPercorso() {
		return null;
	}
	
	public String getPathFoto() {
		return pathFoto;
	}
	
	public String getNome() {
		return nome;
	}
}
