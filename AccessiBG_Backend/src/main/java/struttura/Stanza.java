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

	public String getNome() {return nome;}

	public boolean getAccessibile() { return accessibile; }

	public String getDescrizione() {return descrizione;}

	public int getPiano() { return piano; }

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

