package br.ufsc.dsoii.control;

import br.ufsc.dsoii.dao.ClienteDao;
import br.ufsc.dsoii.dao._DaoFactory;

public class ClienteControl {
	
	private ClienteDao clienteDao = _DaoFactory.getClienteDao();
	
	public ClienteControl() {

	}

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
}
