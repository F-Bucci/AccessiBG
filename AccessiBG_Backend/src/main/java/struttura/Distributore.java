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
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.accessibile = accessibile;
		this.x = x;
		this.y = y;
		this.piano = piano;
		this.pathFoto = pathFoto;
		this.pathPercorso = pathPercorso;
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