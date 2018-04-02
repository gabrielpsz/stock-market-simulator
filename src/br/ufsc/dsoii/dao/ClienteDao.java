package br.ufsc.dsoii.dao;

import br.ufsc.dsoii.dao.*;
import br.ufsc.dsoii.model.Cliente;

public interface ClienteDao extends _DaoCrud<Cliente> {
	
	Cliente findByCpf(String cpf);
	Cliente findById(Long id);

}
