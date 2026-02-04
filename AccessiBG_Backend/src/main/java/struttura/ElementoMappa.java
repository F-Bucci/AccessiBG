package struttura;

/**
 * Interfaccia per la logica della mappa.
 * <p>
 * Interfaccia che ci aiuta a costruire la logica della mappa sul frontend
 * </p>
 */
public interface ElementoMappa {
	double getX();
	double getY();
	int getId();
	String getPathPercorso();
	String getPathFoto();
	String getNome();
	String getDescrizione();
}
