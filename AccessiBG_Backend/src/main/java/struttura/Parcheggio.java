package struttura;

public class Parcheggio {

	private String nome;
	private TipoParcheggio tipo;
	private boolean postiDisabili;
	private String indirizzo;
	private String facolta;
	private String pathFoto;
	
	public Parcheggio(String nome, TipoParcheggio tipo, boolean postiDisabili, String indirizzo, String pathFoto, String facolta) {
        this.nome = (nome == null || nome.isBlank()) ? "Nome non specificato" : nome;
        this.tipo = (tipo == null) ? TipoParcheggio.LIBERO : tipo;
        this.postiDisabili = postiDisabili;
        this.indirizzo = (indirizzo == null || indirizzo.isBlank()) ? "Indirizzo non disponibile" : indirizzo;
        this.facolta = (facolta == null || facolta.isBlank()) ? "Facoltà non specificata" : facolta;
        this.pathFoto = (pathFoto == null || pathFoto.isBlank()) ? "Foto non disponibile" : pathFoto;
    }
	
	public boolean getPostiDisabili() { return postiDisabili; }
	
    public TipoParcheggio getTipo() {return tipo;}
    
    public String getNome() { return nome; }
    
    public String getIndirizzo() { return indirizzo; }

	public String getFacolta() {return facolta;}

	public String getPathFoto() {return pathFoto;}
}
