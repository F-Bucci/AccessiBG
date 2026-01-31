package struttura;

public class Stanza {
	private int id;
	private String nome;
	private int posti;
	private String descrizione;
	private boolean accessibile;
	private int x;
	private int y;
	private TipoStanza tipoStan;
	private int piano;
	private String edificio;

	public Stanza(int id, String nome, int posti, String descrizione, boolean accessibile, int x, int y,
			TipoStanza tipoStan, int piano, String edificio) {
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
		this.edificio=edificio;
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public TipoStanza getTipoStan() {
		return tipoStan;
	}

	public String getEdificio() {
		return edificio;
	}
}

