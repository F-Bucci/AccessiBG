package gestione_db;

import org.springframework.stereotype.Service;
import dao.*;
import struttura.*;

@Service
public class InsertInDB {
	static final String D002 = "/D002.webp";
	static final String BAGNI_E_DISTRIBUTORI_DX = "/DBagni_E_DistributoriDX.webp";
	static final String PERCORSO_DISTRIBUTORI_DX = "/percorso_DistributoriDX_BAGNO.webp";
	static final String ORARIO_730_2030 = "7.30-20.30";
	static final String LUNVEN_730_2030_SABATO_730_1330 = "Lun-Ven: 7.30-20.30  Sabato: 7.30-13.30";
	static final String EDIFICIO_D = "Edificio D";
	static final String URLMAPS = "urlMaps";
	static final String SEDE_DALMINE = "Sede di Dalmine";
	
	
    private final SedeDAO sedeDAO;
    private final EdificioDAO edificioDAO;
    private final ParcheggioDAO parcheggioDAO;
    private final PianoDAO pianoDAO;
    private final DistributoreDAO distributoreDAO;
    private final PuntoDiIngressoDAO puntoDiIngressoDAO;
    private final StanzaDAO stanzaDAO;
    private final OstacoloDAO ostacoloDAO;

    public InsertInDB(SedeDAO sedeDAO, EdificioDAO edificioDAO, ParcheggioDAO parcheggioDAO, PianoDAO pianoDAO, 
                      DistributoreDAO distributoreDAO, PuntoDiIngressoDAO puntoDiIngressoDAO, 
                      StanzaDAO stanzaDAO, OstacoloDAO ostacoloDAO) {
        this.sedeDAO = sedeDAO;
        this.edificioDAO = edificioDAO;
        this.parcheggioDAO = parcheggioDAO;
        this.pianoDAO = pianoDAO;
        this.distributoreDAO = distributoreDAO;
        this.puntoDiIngressoDAO = puntoDiIngressoDAO;
        this.stanzaDAO = stanzaDAO;
        this.ostacoloDAO = ostacoloDAO;
    }

    private <T> void insertAll(DAO<T> dao, T[] entities) {
        for (T entity : entities) {
            dao.insert(entity);
        }
    }

    public void insRecordSedi() {
        Sede[] listaSedi = {
            new Sede(SEDE_DALMINE, "Via A. Einstein 2", "/sedeDalmine.webp", LUNVEN_730_2030_SABATO_730_1330, "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1394.595860840313!2d9.595292955636975!3d45.64697147025653!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47814df37b8ef653%3A0x3eda30ac45ab6bed!2sUniversit%C3%A0%20Degli%20Studi%20Di%20Bergamo%20Ingegneria%20Ed%20B%2C%20Via%20Salvecchio%2C%2019%2C%2024129%20Bergamo%20BG!5e0!3m2!1sit!2sit!4v1769163707622!5m2!1sit!2sit"),
            new Sede("Sede di Sant'Agostino", "Piazzale Sant'Agostino, 2", "/sedeCittaAlta.webp", LUNVEN_730_2030_SABATO_730_1330, URLMAPS),
            new Sede("Sede di Caniana", "Via dei Caniana, 2", "/sedeCaniana.webp", "Lun-Ven: 7.30-20.30", URLMAPS),
            new Sede("Sede di Pignolo", "Via Pignolo, 123", "/sedePignolo.webp", "Lun-Ven: 7.30-20.30  Sabato:7.30-13.30", URLMAPS),
            new Sede("Sede Km Rosso", "Ingresso Est, via Stezzano, 87. Ingresso Ovest, viale Europa, 4", "/sedeKmrosso.webp", "Lun-Dom: 7.30-20.30", URLMAPS),
            new Sede("Sede Rosate", "Piazza Rosate, 2", "/sedeRosate.webp", LUNVEN_730_2030_SABATO_730_1330, URLMAPS)
        };
        insertAll(sedeDAO, listaSedi);
    }

    public void insRecordEdifici() {
        Edificio[] listaEdifici = {
            new Edificio("Edificio A", "Via Einstein 2", ORARIO_730_2030, "/dalmineA.webp", SEDE_DALMINE),
            new Edificio("Edificio B", "Viale Marconi 5", ORARIO_730_2030, "/dalmineB.webp", SEDE_DALMINE),
            new Edificio("Edificio C", "Viale Pasubio 7", ORARIO_730_2030, "/dalmineC.webp", SEDE_DALMINE),
            new Edificio(EDIFICIO_D, "Via Galvani 2", ORARIO_730_2030, "/dalmineD.webp", SEDE_DALMINE)    
        };
        insertAll(edificioDAO, listaEdifici);
    }

    public void insRecordParcheggio() {
        Parcheggio[] listaParcheggi = {
            new Parcheggio("Parcheggio sterrato C", TipoParcheggio.LIBERO, true , "Via Galvani 7", "/parcheggioSterrato.webp", SEDE_DALMINE),
            new Parcheggio("Parcheggio asfaltato C", TipoParcheggio.LIBERO, true , "Via Einstein 2", "/parcheggioTenaris.webp", SEDE_DALMINE),
            new Parcheggio("Parcheggio edificio A", TipoParcheggio.DISCO_ORARIO, true , "Via Cavour 2B", "/parcheggioEdA.webp", SEDE_DALMINE),
            new Parcheggio("Parcheggio edificio C", TipoParcheggio.DISCO_ORARIO, false , "Via Pasubio 2", "/parcheggioEdD.webp", SEDE_DALMINE)
        };
        insertAll(parcheggioDAO, listaParcheggi);
    }

    public void insRecordPuntoIngresso() {
        PuntoDiIngresso[] listaIngressi = {
        						//id, nome, descrizione, scale, rampa, porta tagliafuoco, percorsoStrisceIpo, x, y, pathFoto, pathPercorso(null), edificio)
            new PuntoDiIngresso(1, "Ingresso principale", "descrizione", false, true, false, false, 33.10, 85.38, "/ingressoD.webp", null, EDIFICIO_D),
            new PuntoDiIngresso(2, "Ingresso principale","descrizione", true, true, false, false, 0, 0, "/ingressoPrincipaleB.webp", null, "Edificio B"),
            new PuntoDiIngresso(3, "Ingresso viale G.Marconi, 5","descrizione", true, false, false, false, 0, 0, "/Ingresso-B-via-Marconi.webp", null, "Edificio B"),
            new PuntoDiIngresso(4, "Ingresso via Cavour","descrizione", true, false, false, false, 0, 0, "/ingressoLateraleB.webp",null, "Edificio B" ),
            new PuntoDiIngresso(5, "Ingresso passaggio sotterraneo tra Edificio A e B", "descrizione",false, false, true, false, 0, 0, "pathFoto", null, "Edificio B")
        };
        insertAll(puntoDiIngressoDAO, listaIngressi);
    }

    public void insRecordPiano() {
    						//numero, nome, mappa, edificio
        Piano terra = new Piano(0, "piano terra", "/Mappa_PianoTerra_D.webp", EDIFICIO_D);
        pianoDAO.insert(terra);
    }

    public void insRecordDistributore() {
        Distributore[] listaDistributori = {
        					//id, nome, descrizione, tipo, accessibile, coordinate x, coordinate y, , pathfoto, pathpercorso, pianp
            new Distributore(1, "Macchinetta caffe", null, TipoDistributore.BEVANDE_CALDE, true, 56.64, 45, BAGNI_E_DISTRIBUTORI_DX, PERCORSO_DISTRIBUTORI_DX, 0),
            new Distributore(2, "Distributore acqua", "Potrebbbe essere necessario aiuto esterno per le persone in sedia a rotelle vista l'altezza del distributore",TipoDistributore.ACQUA, false, 52.54, 45.50, BAGNI_E_DISTRIBUTORI_DX, PERCORSO_DISTRIBUTORI_DX, 0),
            new Distributore(3, "Macchinetta merendine", null, TipoDistributore.SNACK_E_BEVANDE, true, 7.13, 73.13, "/D_DistributoreSX.webp", "/percorso_DistributoriSX.webp", 0)
        };
        insertAll(distributoreDAO, listaDistributori);
    }

    public void insRecordStanza() {
        Stanza[] listaStanze = {
        				//id, nome, capacita', descrizione, accessibile, coordinate x, coordinate y, tipo, pathfoto, pathpercorso, piano
            new Stanza(1, "Aula D001", 275, "È disponibile, se fosse necessario, dei banchi adattati per persone disabili. Per maggiori infomazioni chiedere in segreteria.", true, 33.24, 39.88, TipoStanza.AULA, "/D001.webp", "/percorso_D001.webp", 0),
            new Stanza(2, "Aula D002", 265, "È disponibile, se fosse necessario, dei banchi adattati per persone disabili. Per maggiori infomazioni chiedere in segreteria.", true, 78.13, 22.50, TipoStanza.AULA, D002, "/percorso_D002.webp", 0),
            new Stanza(3, "Aula studio", 275, "È disponibile, se fosse necessario, dei banchi adattati per persone disabili. Per maggiori infomazioni chiedere in segreteria.", true, 11.52, 36, TipoStanza.AULA_STUDIO, "/aulaStudioD.webp", "/percorso_DAulaStudio.webp", 0),
            new Stanza(4, "Bagno degli uomini", 4, "Il bagno degli uomini è situato sulla sinistra", true, 49.90, 36.88, TipoStanza.BAGNO_UOMO, BAGNI_E_DISTRIBUTORI_DX, PERCORSO_DISTRIBUTORI_DX, 0),
            new Stanza(5, "Bagno delle donne", 4, "Il bagno delle donne è situato sulla destra", true, 60.35, 34.62, TipoStanza.BAGNO_DONNA, BAGNI_E_DISTRIBUTORI_DX, PERCORSO_DISTRIBUTORI_DX, 0)
        };
        insertAll(stanzaDAO, listaStanze);
    }

    public void insRecordOstacolo() {
        Ostacolo[] listaOstacoli = {
        				//id, nome, tipo, descrizione, coordinate x, coordinate y, null, numero piano
            new Ostacolo(1, "Sedie", TipoOstacolo.OGGETTO_INGROMBRANTE, "sedie laterali fisse, che potrebbero rendere il passaggio difficoltoso in alcuni casi.", 52.13, 70.38, D002, null, 0),
            new Ostacolo(2, "Macchinario", TipoOstacolo.OGGETTO_INGROMBRANTE, "macchinario vicino ingresso D002", 59.96, 61.88, "/macchinario.webp", null, 0),
            new Ostacolo(3, "Gradino", TipoOstacolo.DISLIVELLI, "Gradino all'entrantata dell'aula D002",64.75, 70.25, D002,null, 0  )
        };
        insertAll(ostacoloDAO, listaOstacoli);
    }
}