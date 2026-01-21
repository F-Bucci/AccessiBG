package Accessibilita.AccessiBG_sqlite;

import org.springframework.stereotype.Service;

import Accessibilita.AccessiBG_Backend.Sede;

@Service
public class InsertInDB{
	private final SedeDAO sedeDAO;
	
	public InsertInDB(SedeDAO sedeDAO) {
		this.sedeDAO = sedeDAO;
	}

	public void insRecordSedi() {
		Sede dalmine = new Sede("Sede di Dalmine", "via A. Einstein 2", "/sedeDalmine.webp");
		sedeDAO.insert(dalmine); 
		Sede santAgostino = new Sede("Sede di Sant'Agostino", "piazzale Sant'Agostino, 2", "/sedeCittaAlta.webp");
    	sedeDAO.insert(santAgostino);
    	Sede caniana = new Sede("Sede di Caniana", "via dei Caniana, 2", "/sedeCaniana.webp");
    	sedeDAO.insert(caniana);
    	Sede pignolo = new Sede("Sede di Pignolo", "via Pignolo, 123", "/sedePignolo.webp");
    	sedeDAO.insert(pignolo);
    	Sede kmrosso = new Sede("Sede Km Rosso", "Ingresso Est, via Stezzano, 87. Ingresso Ovest, viale Europa, 4", "/sedeKmrosso.webp");
    	sedeDAO.insert(kmrosso);
	}
	
}