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
        this.id = id;
        this.nome = nome;
		this.tipo = tipo;
        this.descrizione = descrizione;
        this.x = x;
        this.y = y;
        this.piano = piano;
        this.pathPercorso = pathPercorso;
        this.pathFoto = pathFoto;
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
