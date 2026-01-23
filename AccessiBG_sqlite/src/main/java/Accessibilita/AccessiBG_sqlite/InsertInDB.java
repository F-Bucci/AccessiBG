package Accessibilita.AccessiBG_sqlite;

import org.springframework.stereotype.Service;

import Accessibilita.AccessiBG_Backend.*;

@Service
public class InsertInDB{
	private final SedeDAO sedeDAO;
	private final EdificioDAO edificioDAO;

	public InsertInDB(SedeDAO sedeDAO, EdificioDAO edificioDAO) {
		this.sedeDAO = sedeDAO;
		this.edificioDAO=edificioDAO;
	}

	public void insRecordSedi() {
		Sede dalmine = new Sede("Sede di Dalmine", "via A. Einstein 2", "/sedeDalmine.webp", "lun-ven:7.30-20.30 sabato:7.30-13.30", "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1394.595860840313!2d9.595292955636975!3d45.64697147025653!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47814df37b8ef653%3A0x3eda30ac45ab6bed!2sUniversit%C3%A0%20Degli%20Studi%20Di%20Bergamo%20Ingegneria%20Ed%20B%2C%20Via%20Salvecchio%2C%2019%2C%2024129%20Bergamo%20BG!5e0!3m2!1sit!2sit!4v1769163707622!5m2!1sit!2sit");
		sedeDAO.insert(dalmine); 
		Sede santAgostino = new Sede("Sede di Sant'Agostino", "piazzale Sant'Agostino, 2", "/sedeCittaAlta.webp", "lun-ven:7.30-20.30 sabato:7.30-13.30", "urlMaps");
    	sedeDAO.insert(santAgostino);
    	Sede caniana = new Sede("Sede di Caniana", "via dei Caniana, 2", "/sedeCaniana.webp", "lun-ven:7.30-20.30", "urlMaps");
    	sedeDAO.insert(caniana);
    	Sede pignolo = new Sede("Sede di Pignolo", "via Pignolo, 123", "/sedePignolo.webp", "lun-ven:7.30-20.30 sabato:7.30-13.30", "urlMaps");
    	sedeDAO.insert(pignolo);
    	Sede kmrosso = new Sede("Sede Km Rosso", "Ingresso Est, via Stezzano, 87. Ingresso Ovest, viale Europa, 4", "/sedeKmrosso.webp", "lun-dom:7.30-20.30", "urlMaps");
    	sedeDAO.insert(kmrosso);
	}
	
	public void insRecordEdifici() {
		Edificio a = new Edificio("Edificio A", "Via Einstein 2", "DA LUNEDÍ A VENERDÍ \n" + "7.30-20.30 \n" + "SABATO \n"+ "7.30-13.30", "/dalmineA.webp", "Sede di Dalmine");
		edificioDAO.insert(a); 
		Edificio b = new Edificio("Edificio B", "viale Marconi 5", "DA LUNEDÍ A VENERDÍ \n" + "7.30-20.30 \n" + "SABATO \n"+ "7.30-13.30", "/dalmineB.webp", "Sede di Dalmine");
		edificioDAO.insert(b);
		Edificio c = new Edificio("Edifcio C", "viale Pasubio 7", "DA LUNEDÍ A VENERDÍ \n" + "7.30-20.30 \n" + "SABATO \n"+ "7.30-13.30", "/dalmineC.webp", "Sede di Dalmine");
		edificioDAO.insert(c);
		Edificio d = new Edificio("Edificio D", "via Galvani 2", "DA LUNEDÍ A VENERDÍ \n" + "7.30-20.30 \n" + "SABATO \n"+ "7.30-13.30", "/dalmineD.webp", "Sede di Dalmine");
		edificioDAO.insert(d);
	}
	
}