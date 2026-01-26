package Accessibilita.AccessiBG_sqlite;
import org.jooq.DSLContext;

import static org.jooq.impl.DSL.*;

import org.springframework.stereotype.Repository;

import Accessibilita.AccessiBG_Backend.*;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SedeDAO {
	
	private final DSLContext dsl;
	
	public SedeDAO(DSLContext dsl) {
		this.dsl = dsl;}

	public void insert(Sede s) {
		dsl.insertInto(table("sede"), field("facolta"), field("indirizzo"), field("pathFoto"), field("orarioApertura"), field("pathMaps"))
        .values(s.getFacolta(), s.getIndirizzo(), s.getPathFoto(), s.getOrarioApertura(), s.getPathMaps())
        .onConflict(field("facolta"))
        .doNothing()
        .execute();}

	public Sede findByFacolta(String facolta) {
		var record = dsl.select(field("facolta"),field("indirizzo"),field("pathFoto"), field("orarioApertura"), field("pathMaps"))
            .from(table("sede"))
            .where(field("facolta").eq(facolta))
            .fetchOne();
        if (record != null) {
           return new Sede(
               record.get("facolta", String.class),
               record.get("indirizzo", String.class),
               record.get("pathFoto", String.class),
               record.get("orarioApertura", String.class),
               record.get("pathMaps", String.class)
               );}
       return null;}
	
	public List<Sede> findAll(){
		try {return dsl.selectFrom(table("sede"))
					.fetch(record ->
					new Sede(
			                 record.get("facolta", String.class),
			                 record.get("indirizzo", String.class),
			                 record.get("pathFoto", String.class),
			                 record.get("orarioApertura", String.class),
			                 record.get("pathMaps", String.class))
			          );
		}catch (Exception e) {e.printStackTrace();
			return new ArrayList<>();}}
	
//	restituisce tutti gli edifici di una sede (sempre un array)
	public List<Edificio> findEdificiBySede(String facolta) {
	    return dsl
	        .selectFrom(table("edificio"))
	        .where(field("facolta").eq(facolta))
	        .fetchInto(Edificio.class);}
	
//	restituisce tutti i parcheggi di una sede (sempre un array)
	public List<Parcheggio> findParcheggioBySede(String facolta) {
	    return dsl
	        .selectFrom(table("parcheggio"))
	        .where(field("facolta").eq(facolta))
	        .fetchInto(Parcheggio.class);}
}