package br.ufsc.dsoii.teste;

import br.ufsc.dsoii.dao.AcaoDao;
import br.ufsc.dsoii.dao.CarteiraDao;
import br.ufsc.dsoii.dao.ClienteDao;
import br.ufsc.dsoii.dao._DaoFactory;
import br.ufsc.dsoii.model.Acao;
import br.ufsc.dsoii.model.Carteira;
import br.ufsc.dsoii.model.Cliente;
import br.ufsc.dsoii.model.Compra;


public class Teste {
	
	public static void main(String[] args) {
		
		ClienteDao clienteDao = _DaoFactory.getClienteDao();
		CarteiraDao carteiraDao = _DaoFactory.getCarteiraDao();
		AcaoDao acaoDao = _DaoFactory.getAcaoDao();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Gabriel Pereira de Souza");
		cliente.setCpf("067.072.339-80");
		clienteDao.create(cliente);
		
		Carteira carteira = new Carteira();
		carteira.setSaldo(10000.0D);
		carteira.setCliente(cliente);
		carteiraDao.create(carteira);
		
		Acao acao = new Acao();
		acao.setNome("PETR4");
		acao.setNomeEmpresa("Petrobrás");
		acao.setValor(40.0D);
		acaoDao.create(acao);

		
	}

}
