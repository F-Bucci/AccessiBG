package struttura;


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

	public Stanza(int id, String nome, int posti, String descrizione, boolean accessibile, double x, double y,
			TipoStanza tipoStan, String pathPercorso,String pathFoto,int piano) {
		super();
		this.id = id;
		this.nome = nome;
		this.posti = posti;
		this.descrizione = descrizione;
		this.accessibile = accessibile;
		this.x = x;
		this.y = y;
		this.tipoStan = tipoStan;
		this.piano = piano;
		this.pathPercorso=pathPercorso;
		this.pathFoto=pathFoto;
	}

	public String getNome() {return nome;}
	//	    public void setNome(String nome) { this.nome = nome; }

	public boolean getAccessibile() { return accessibile; }
	//	    public void setAccessibile(boolean accessibile) { this.accessibile = accessibile;}

	public String getDescrizione() {return descrizione;}
	//	    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

	public int getPiano() { return piano; }
	//	    public void setPiano(Piano piano) { this.piano = piano; }

	public int getId() {
		return id;
	}

	public int getPosti() {
		return posti;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public TipoStanza getTipoStan() {
		return tipoStan;
	}

	@Override
	public String getPathPercorso() {
	    return this.pathPercorso; // Ritorna la variabile che hai nella classe
	}

	public String getPathFoto() {
		return pathFoto;
	}
}

