package struttura;

public class Ostacolo {
	private int id;
	private String descrizione;
	private TipoOstacolo tipo;
	private double x;
	private double y;
	private int piano;
	
	public Ostacolo(int id, TipoOstacolo tipo, String descrizione, double x, double y, int piano) {
       this.id=id;
		this.tipo = tipo;
        this.descrizione = descrizione;
        this.x=x;
        this.y=y;
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
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
}
