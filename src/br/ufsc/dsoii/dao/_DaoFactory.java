package br.ufsc.dsoii.dao;

public abstract class _DaoFactory {
	/*
	
	private static EntityDao entityDao;
	
	public static EntityDao getEntityDao() {
		if (entityDao == null) {
			entityDao = new EntityDaoImp();
		}
		return entityDao;
	}*/
	
	private static ClienteDao clienteDao;
	
	public static ClienteDao getClienteDao() {
		if (clienteDao == null) {
			clienteDao = new ClienteDaoImp();
		}
		return clienteDao;
	}
	
	private static CarteiraDao carteiraDao;
	
	public static CarteiraDao getCarteiraDao() {
		if (carteiraDao == null) {
			carteiraDao = new CarteiraDaoImp();
		}
		return carteiraDao;
	}
	
	private static AcaoDao acaoDao;
	
	public static AcaoDao getAcaoDao() {
		if (acaoDao == null) {
			acaoDao = new AcaoDaoImp();
		}
		return acaoDao;
	}
	
}
