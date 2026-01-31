package struttura;

public class Ostacolo {
	private int id;
	private String descrizione;
	private TipoOstacolo tipo;
	private int piano;
	
	public Ostacolo(int id, TipoOstacolo tipo, String descrizione, int piano) {
       this.id=id;
		this.tipo = tipo;
        this.descrizione = descrizione;
        this.piano=piano;
    }
	public Ostacolo() {}
	
	public TipoOstacolo getTipo() { return tipo; }
//    public void setTipo(TipoOstacolo tipo) { this.tipo = tipo; }

    public String getDescrizione() { return descrizione; }
//    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }
 
    public int getPiano() { return piano; }
//    public void setPiano(int piano) { this.piano = piano; }
	
    public int getId() {
		return id;
	}
}
