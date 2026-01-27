
package Accessibilita.AccessiBG_Backend;

import struttura.TipoDistributore;

public class Distributore {
	private int id;
	private TipoDistributore tipo;
	private boolean accessibile;
	private String posizione;
	private int piano;
	
	public Distributore(int id, TipoDistributore tipo, String posizione, boolean accessibile, int piano) {
		this.id=id;
		this.tipo = tipo;
		this.posizione = posizione;
		this.accessibile = accessibile;
		this.piano=piano;
	}
	public TipoDistributore getTipo() { return tipo; }
//    public void setTipo(TipoDistributore tipo) {this.tipo = tipo; }

    public String getPosizione() { return posizione; }
//    public void setPosizione(String posizione) { this.posizione = posizione; }

    public boolean getAccessibile() { return accessibile; }
//    public void setAccessibile(boolean accessibile) { this.accessibile = accessibile; }
    
	public int getPiano() {return piano;}
	
	public int getId() {return id;}
}