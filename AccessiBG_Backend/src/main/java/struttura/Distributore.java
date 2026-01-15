
package struttura;

public class Distributore {

	public TipoDistributore tipo;
	public boolean accessibile;
	public String posizione;
	private Piano piano;

	public Distributore() {}
	
	public Distributore(TipoDistributore tipo, String posizione, boolean accessibile) {
		this.tipo = tipo;
		this.posizione = posizione;
		this.accessibile = accessibile;
	}
	public TipoDistributore getTipo() { return tipo; }
    public void setTipo(TipoDistributore tipo) {this.tipo = tipo; }

    public String getPosizione() { return posizione; }
    public void setPosizione(String posizione) { this.posizione = posizione; }

    public boolean isAccessibile() { return accessibile; }
    public void setAccessibile(boolean accessibile) { this.accessibile = accessibile; }

    public Piano getPiano() { return piano; }
    public void setPiano(Piano piano) { this.piano = piano; }
}