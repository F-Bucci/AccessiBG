package struttura;

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
	
	public TipoDistributore getTipo() { return tipo; }

    public boolean getAccessibile() { return accessibile; }
    
    public String getDescrizione() {return descrizione;}
    
	public int getPiano() {return piano;}
	
	public int getId() {return id;}
	
	public double getX() {return x;}
	
	public double getY() {return y;}
	
	@Override
	public String getPathPercorso() {
		return pathPercorso;
	}
	
	public String getPathFoto() {
		return pathFoto;
	}
	
	public String getNome() {
		return nome;
	}
}