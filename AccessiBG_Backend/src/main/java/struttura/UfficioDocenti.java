

package struttura;

public class UfficioDocenti extends Stanza
 {
	private String docente;
	
	public UfficioDocenti(int id, String descrizione, boolean accessibile, String docente, double x, double y) {
		super(descrizione, accessibile, y, x, id);
		this.docente = docente;
	}
	
	public UfficioDocenti() {super();}
	
	public String getDocente() { return docente; }
    //public void setDocente(String docente) { this.docente = docente; }
}
