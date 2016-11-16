package br.com.sisclinic.model.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.IBairroService;
import br.com.sisclinic.model.entities.Bairro;
import br.com.sisclinic.model.entities.Cidade;
import br.com.sisclinic.model.entities.TipoLogradouro;
import br.com.sisclinic.model.repository.impl.BairroRepository;
import br.com.sisclinic.model.repository.impl.CidadeRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;

@Named
@RequestScoped
public class BairroService implements IBairroService{ 

	@Inject
	private BairroRepository  bairroRepository;
	
	@Inject
	private CidadeRepository  cidadeRepository;

	private Bairro bairro;
	
	private Cidade cidade;

	public BairroService() {
		bairro = new Bairro();
	}
	
	
	  @Transactional
	    public void salvarRegistro( Bairro bairro ) {
	    	if( bairro.getId() == null) {
	    		save();
	    	} else {
	    		getBairroRepository().alterar(bairro);
	    	}
	    	listar();
	    }

	@Transactional
	public void save() {
		getBairroRepository().salvar(this.bairro);
		this.bairro = new Bairro();
		listar();
	}

	@Transactional
	public void remove(Bairro bairro) {
		getBairroRepository().excluir(bairro);
		listar();
	}

	@Transactional
	public List<Bairro> listar(){
		List<Bairro> bairros = new ArrayList<Bairro>();
		bairros = getBairroRepository().listar();
		return bairros;
	}
	
	public void novoRegistro(){
		setBairro(null);
		this.getBairro();
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public BairroRepository getBairroRepository() {
		return bairroRepository;
	}

	public void selecionarRegistro( Bairro bairro ){
		setBairro(bairro);
		this.getBairro();
	}
	
	@Transactional
	public List<Cidade> listarCidades(){
		List<Cidade> cidades = new ArrayList<Cidade>();
		cidades = getCidadeRepository().listar();
		return cidades;
	}

	public CidadeRepository getCidadeRepository() {
		return cidadeRepository;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	
	
	

}
