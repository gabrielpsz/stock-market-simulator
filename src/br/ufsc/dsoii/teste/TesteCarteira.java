package br.ufsc.dsoii.teste;

import br.ufsc.dsoii.dao.CarteiraDao;
import br.ufsc.dsoii.dao.ClienteDao;
import br.ufsc.dsoii.dao._DaoFactory;
import br.ufsc.dsoii.model.Carteira;
import br.ufsc.dsoii.model.Cliente;

public class TesteCarteira {
	
	public static void main(String[] args) {
		
		CarteiraDao carteiraDao = _DaoFactory.getCarteiraDao();
		ClienteDao clienteDao =_DaoFactory.getClienteDao();
		Cliente c = clienteDao.findById(1L);
		System.out.println(c.getId());
		
		Carteira carteira = new Carteira();
		carteira.setSaldo(1000.0D);
		carteira.setCliente(c);
		
		carteiraDao.create(carteira);
		
	}

}
