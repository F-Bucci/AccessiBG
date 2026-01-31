package struttura;

public class Distributore {
	private int id;
	private TipoDistributore tipo;
	private boolean accessibile;
	private double x;
	private double y;
	private int piano;
	
	public Distributore(int id, TipoDistributore tipo, boolean accessibile, double x, double y, int piano) {
		this.id=id;
		this.tipo = tipo;
		this.accessibile = accessibile;
		this.x=x;
		this.y=y;
		this.piano=piano;
	}
	public TipoDistributore getTipo() { return tipo; }
//    public void setTipo(TipoDistributore tipo) {this.tipo = tipo; }

    public boolean getAccessibile() { return accessibile; }
//    public void setAccessibile(boolean accessibile) { this.accessibile = accessibile; }
    
	public int getPiano() {return piano;}
	
	public int getId() {return id;}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
}