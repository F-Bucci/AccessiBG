package gestione_db;

import org.springframework.stereotype.Service;

import dao.*;
import struttura.*;

@Service
public class InsertInDB{
	private final SedeDAO sedeDAO;
	private final EdificioDAO edificioDAO;
	private final ParcheggioDAO parcheggioDAO;
	private final PianoDAO pianoDAO;
	private final DistributoreDAO distributoreDAO;
	private final PuntiDiIngressoDAO puntoDiIngressoDAO;
	private final StanzaDAO stanzaDAO;
	private final OstacoloDAO ostacoloDAO;

	public InsertInDB(SedeDAO sedeDAO, EdificioDAO edificioDAO, ParcheggioDAO parcheggioDAO, PianoDAO pianoDAO, DistributoreDAO distributoreDAO, 
			PuntiDiIngressoDAO puntoDiIngressoDAO, StanzaDAO stanzaDAO, OstacoloDAO ostacoloDAO) {
		this.sedeDAO = sedeDAO;
		this.edificioDAO=edificioDAO;
		this.parcheggioDAO=parcheggioDAO;
		this.pianoDAO=pianoDAO;
		this.distributoreDAO=distributoreDAO;
		this.puntoDiIngressoDAO=puntoDiIngressoDAO;
		this.stanzaDAO=stanzaDAO;
		this.ostacoloDAO=ostacoloDAO;
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
	
	public void insRecordParcheggio() {
		Parcheggio sterrato = new Parcheggio("Parcheggio sterrato C", TipoParcheggio.LIBERO, true , "Via Galvani 7", "/parcheggioSterrato.webp", "Sede di Dalmine");
		parcheggioDAO.insert(sterrato);
		Parcheggio tenaris = new Parcheggio("Parcheggio asfaltato C", TipoParcheggio.LIBERO, true , "Via Einstein 2", "/parcheggioTenaris.webp", "Sede di Dalmine");
		parcheggioDAO.insert(tenaris);
		Parcheggio edA = new Parcheggio("Parcheggio edificio A", TipoParcheggio.DISCO_ORARIO, true , "Via Cavour 2B", "/parcheggioEdA.webp", "Sede di Dalmine");
		parcheggioDAO.insert(edA);
		Parcheggio edD = new Parcheggio("Parcheggio edificio C", TipoParcheggio.DISCO_ORARIO, false , "Via Pasubio 2", "/parcheggioEdD.webp", "Sede di Dalmine");
		parcheggioDAO.insert(edD);
	}
//	int id, boolean scale, boolean rampe, boolean portaTagliafuoco, boolean percorsoStrisceIpov, String edificio)
	public void insRecordPuntoIngresso() {
		PuntoDiIngresso p = new PuntoDiIngresso (1, false, true, false, false, "Edificio D");
		puntoDiIngressoDAO.insert(p);
	}
	
	public void insRecordPiano() {
		Piano terra = new Piano (0,"piano terra","url dellafoto", "Edificio D");
		pianoDAO.insert(terra);
	}
	
	public void insRecordDistributore() {
		Distributore dx = new Distributore (1, TipoDistributore.BEVANDE_CALDE, true, 56.64, 45, "foto","percorso" ,0 );
		distributoreDAO.insert(dx);
		Distributore dxA = new Distributore (2, TipoDistributore.ACQUA, false,52.54, 45.50, "foto","percorso", 0 );
		distributoreDAO.insert(dxA);
		Distributore sx = new Distributore (3, TipoDistributore.SNACK_E_BEVANDE, true, 7.13, 73.13, "foto","percorso", 0 );
		distributoreDAO.insert(sx);
	}
		
	public void insRecordStanza() {
		Stanza d01 = new Stanza (1, "D001", 275, "Aula magna, dispone del banco per disabili", true, 33.24, 39.88, TipoStanza.AULA, "foto","percorso", 0);
		stanzaDAO.insert(d01);
		Stanza d02 = new Stanza (2, "D002", 265, "Dispone del banco per disabili", true, 61.10, 68.75, TipoStanza.AULA, "foto","percorso", 0);
		stanzaDAO.insert(d02);
		Stanza stud1 = new Stanza (3, "Aula studio", 275, "Aula studio con banchi grandi e sedie rimovibili", true, 8.30, 52.13, TipoStanza.AULA_STUDIO, "foto","percorso", 0);
		stanzaDAO.insert(stud1);
		Stanza bagnoU = new Stanza (4,"Bagno", 8 ,"Bagno uomini a sinistra", true, 49.90, 36.88, TipoStanza.BAGNO, "foto","percorso", 0);
		stanzaDAO.insert(bagnoU);
		Stanza bagnoD = new Stanza (5,"Bagno", 8 ,"Bagno donne a destra", true, 60.35, 34.62, TipoStanza.BAGNO, "foto","percorso", 0);
		stanzaDAO.insert(bagnoD);
	}
	
//	int id, TipoOstacolo tipo, String descrizione, int piano
	public void insRecordOstacolo() {
		Ostacolo o1 = new Ostacolo (1, TipoOstacolo.OGGETTO_INGROMBRANTE, "sedie laterali fisse", 52.13, 70.38, "foto","percorso", 0);
		ostacoloDAO.insert(o1);
		Ostacolo o2 = new Ostacolo (2, TipoOstacolo.OGGETTO_INGROMBRANTE, "macchinario vicino ingresso D002", 59.96, 61.88, "foto","percorso", 0);
		ostacoloDAO.insert(o2);
		}
}