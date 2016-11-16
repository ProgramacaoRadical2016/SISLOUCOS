package br.com.sisclinic.model.repository.impl;

import java.util.List;

import br.com.sisclinic.model.entities.Bairro;
import br.com.sisclinic.model.repository.IBairroRepository;

@SuppressWarnings("serial")
public class BairroRepository  extends EntitiesRepository<Bairro> implements IBairroRepository{

	public BairroRepository(){
	}
	
	
	@SuppressWarnings("unused")
	public List<String> listarNomeContrato() {
		String queryString = "SELECT pessoa_nome from tb_pessoa";
		
	//List<String> nomes = listar();
		
		return null;
	}
}
