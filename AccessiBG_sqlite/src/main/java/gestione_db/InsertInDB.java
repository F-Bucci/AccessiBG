package gestione_db;

import org.springframework.stereotype.Service;

import dao.*;
import struttura.*;
import servizi.*;

@Service
public class InsertInDB{
	private final SedeDAO sedeDAO;
	private final EdificioDAO edificioDAO;
	private final ParcheggioDAO parcheggioDAO;
	private final PianoDAO pianoDAO;
	private final DistributoreDAO distributoreDAO;

	public InsertInDB(SedeDAO sedeDAO, EdificioDAO edificioDAO, ParcheggioDAO parcheggioDAO, PianoDAO pianoDAO, DistributoreDAO distributoreDAO) {
		this.sedeDAO = sedeDAO;
		this.edificioDAO = edificioDAO;
		this.parcheggioDAO = parcheggioDAO;
		this.pianoDAO = pianoDAO;
		this.distributoreDAO = distributoreDAO;
	}

	
	// INSERIMENTO DELLE SEDI NEL DATABASE
	public void insRecordSedi() {
		Sede[] listaSedi = {
				new Sede("Sede di Dalmine", "Via A. Einstein 2", "/sedeDalmine.webp", "Lun-Ven: 7.30-20.30  Sabato: 7.30-13.30", "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1394.595860840313!2d9.595292955636975!3d45.64697147025653!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47814df37b8ef653%3A0x3eda30ac45ab6bed!2sUniversit%C3%A0%20Degli%20Studi%20Di%20Bergamo%20Ingegneria%20Ed%20B%2C%20Via%20Salvecchio%2C%2019%2C%2024129%20Bergamo%20BG!5e0!3m2!1sit!2sit!4v1769163707622!5m2!1sit!2sit"),
				new Sede("Sede di Sant'Agostino", "Piazzale Sant'Agostino, 2", "/sedeCittaAlta.webp", "Lun-Ven: 7.30-20.30  Sabato: 7.30-13.30", "urlMaps"),
				new Sede("Sede di Caniana", "Via dei Caniana, 2", "/sedeCaniana.webp", "Lun-Ven: 7.30-20.30", "urlMaps"),
				new Sede("Sede di Pignolo", "Via Pignolo, 123", "/sedePignolo.webp", "Lun-Ven: 7.30-20.30  Sabato:7.30-13.30", "urlMaps"),
				new Sede("Sede Km Rosso", "Ingresso Est, via Stezzano, 87. Ingresso Ovest, viale Europa, 4", "/sedeKmrosso.webp", "Lun-Dom: 7.30-20.30", "urlMaps"),
				new Sede("Sede Rosate", "Piazza Rosate, 2", "/sedeRosate.webp", "Lun-Ven: 7.30-20.30  Sabato: 7.30-13.30", "urlMaps")
		};
		
		inserimentoSedi(listaSedi);
	}
	
	private void inserimentoSedi(Sede[] listaSedi) {
		for(Sede s : listaSedi)
			sedeDAO.insert(s);
	}
	
	
	// INSERIMENTO DEGLI EDIFICI NEL DATABASE
	public void insRecordEdifici() {
		Edificio[] listaEdifici = {
				new Edificio("Edificio A", "Via Einstein 2", "DA LUNEDÍ A VENERDÍ: \n" + "7.30-20.30 \n" + "SABATO: \n"+ "7.30-13.30", "/dalmineA.webp", "Sede di Dalmine"),
				new Edificio("Edificio B", "Viale Marconi 5", "DA LUNEDÍ A VENERDÍ: \n" + "7.30-20.30 \n" + "SABATO: \n"+ "7.30-13.30", "/dalmineB.webp", "Sede di Dalmine"),
				new Edificio("Edificio C", "Viale Pasubio 7", "DA LUNEDÍ A VENERDÍ: \n" + "7.30-20.30 \n" + "SABATO: \n"+ "7.30-13.30", "/dalmineC.webp", "Sede di Dalmine"),
				new Edificio("Edificio D", "Via Galvani 2", "DA LUNEDÍ A VENERDÍ: \n" + "7.30-20.30 \n" + "SABATO: \n"+ "7.30-13.30", "/dalmineD.webp", "Sede di Dalmine")	
		};
		
		inserimentoEdifici(listaEdifici);
	}
	
	private void inserimentoEdifici(Edificio[] listaEdifici) {
		for(Edificio e : listaEdifici)
			edificioDAO.insert(e);
	}
	
	
	// INSERIMENTO DEI PARCHEGGI NEL DATABASE
	public void insRecordParcheggio() {
		Parcheggio[] listaParcheggi = {
				new Parcheggio("Parcheggio sterrato C", TipoParcheggio.LIBERO, true , "Via Galvani 7", "/parcheggioSterrato.webp", "Sede di Dalmine"),
				new Parcheggio("Parcheggio asfaltato C", TipoParcheggio.LIBERO, true , "Via Einstein 2", "/parcheggioTenaris.webp", "Sede di Dalmine"),
				new Parcheggio("Parcheggio edificio A", TipoParcheggio.DISCO_ORARIO, true , "Via Cavour 2B", "/parcheggioEdA.webp", "Sede di Dalmine"),
				new Parcheggio("Parcheggio edificio C", TipoParcheggio.DISCO_ORARIO, false , "Via Pasubio 2", "/parcheggioEdD.webp", "Sede di Dalmine")
		};
		
		inserimentoParcheggi(listaParcheggi);
	}
	
	private void inserimentoParcheggi(Parcheggio[] listaParcheggi) {
		for(Parcheggio p : listaParcheggi)
			parcheggioDAO.insert(p);
	}
	
	
	// INSERIMENTO DEI PIANI NEL DATABASE
	public void insRecordPiano() {
		Piano[] listaPiani = {
				new Piano (0, "Piano terra", "Edificio D")	
		};
		
		inserimentoPiani(listaPiani);
	}
	
	private void inserimentoPiani(Piano[] listaPiani) {
		for(Piano p : listaPiani)
			pianoDAO.insert(p);
	}
	
	
	// INSERIMENTO DEI DISTRIBUTORI NEL DATABASE
    // (int id, TipoDistributore tipo, String posizione, boolean accessibile, int piano)
	public void insRecordDistributore() {
		Distributore[] listaDistributori = {
				new Distributore (1, TipoDistributore.BEVANDE_CALDE,"a destra dell'ingresso", true, 0 ),
				new Distributore (2, TipoDistributore.ACQUA,"a destra dell'ingresso", false, 0 ),
				new Distributore (3, TipoDistributore.SNACK_E_BEVANDE,"a sinistra dell'ingresso", true, 0 )
		};
		
		inserimentoDistributori(listaDistributori);
	}
	
	private void inserimentoDistributori(Distributore[] listaDistributori) {
		for(Distributore d : listaDistributori)
			distributoreDAO.insert(d);
	}
	
}