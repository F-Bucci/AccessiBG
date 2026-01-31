package dao;

import org.jooq.DSLContext;


public abstract class DAO<T> {
	
	protected final DSLContext dsl;

	protected DAO(DSLContext dsl) {
		this.dsl = dsl;
	}
	
	public abstract void insert(T o);
}
