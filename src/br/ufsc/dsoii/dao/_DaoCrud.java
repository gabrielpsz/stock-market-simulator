package br.ufsc.dsoii.dao;

public interface _DaoCrud<ENTITY_TYPE> {
	
	public abstract void create(ENTITY_TYPE object);	
	public abstract void read(ENTITY_TYPE object);
	public abstract void update(ENTITY_TYPE object);
	public abstract void delete(ENTITY_TYPE object);
	
}