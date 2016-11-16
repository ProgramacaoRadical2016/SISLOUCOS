package br.com.sisclinic.model.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.IEnderecoService;
import br.com.sisclinic.model.entities.Bairro;
import br.com.sisclinic.model.entities.Cidade;
import br.com.sisclinic.model.entities.Endereco;
import br.com.sisclinic.model.entities.TipoLogradouro;
import br.com.sisclinic.model.entities.UnidadeFederativa;
import br.com.sisclinic.model.repository.impl.BairroRepository;
import br.com.sisclinic.model.repository.impl.CidadeRepository;
import br.com.sisclinic.model.repository.impl.EnderecoRepository;
import br.com.sisclinic.model.repository.impl.TipoLogradouroRepository;
import br.com.sisclinic.model.repository.impl.UnidadeFederativaRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;

@Named
@RequestScoped
public class EnderecoService implements IEnderecoService{

	@Inject
    private EnderecoRepository repository;
	
    private Endereco endereco;
    	
	
	@Inject
    private UnidadeFederativaRepository unidadeFederativaRepository;
	
	@Inject
    private CidadeRepository cidadeRepository;
	
	@Inject
    private BairroRepository  bairroRepository;
	
	@Inject
    private TipoLogradouroRepository  tipoLogradouroRepository;
	
      
	public EnderecoService() {
		endereco = new Endereco();
	}

	@Transactional
	public void save() {
		getRepository().salvar(this.endereco);
		this.endereco = new Endereco();
		listar();
	}

	@Transactional
	public void remove(Endereco endereco) {
		getRepository().excluir(endereco);
		listar();
	}

	@Transactional
	public void alterar(Endereco endereco) {
		getRepository().alterar(endereco);
		listar();
	}

	@Transactional
	public List<Endereco> listar(){
		return getRepository().listar();
	}


	public void selecionarRegistro(Endereco endereco){
		setEndereco(endereco);
		this.getEndereco();
	}
	

	
	@Transactional
	public List<UnidadeFederativa> listarUnidades(){
		List<UnidadeFederativa> unidades = new ArrayList<UnidadeFederativa>();
		unidades = getUnidadeFederativaRepository().listar();
		return unidades;
	}
	
	@Transactional
	public List<Cidade> listarCidades(){
		List<Cidade> cidades = new ArrayList<Cidade>();
		cidades = getCidadeRepository().listar();
		return cidades;
	}
	
	@Transactional
	public List<Bairro> listarBairros(){
		List<Bairro> bairros = new ArrayList<Bairro>();
		bairros = getBairroRepository().listar();
		return bairros;
	}
	
	@Transactional
	public List<TipoLogradouro> listarTipoLogradouros(){
		List<TipoLogradouro> tipoLogradouros = new ArrayList<TipoLogradouro>();
		tipoLogradouros = getTipoLogradouroRepository().listar();
		return tipoLogradouros;
	}

	public UnidadeFederativaRepository getUnidadeFederativaRepository() {
		return unidadeFederativaRepository;
	}

	public CidadeRepository getCidadeRepository() {
		return cidadeRepository;
	}

	public BairroRepository getBairroRepository() {
		return bairroRepository;
	}

	public TipoLogradouroRepository getTipoLogradouroRepository() {
		return tipoLogradouroRepository;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public EnderecoRepository getRepository() {
		return repository;
	}
	
	

}
