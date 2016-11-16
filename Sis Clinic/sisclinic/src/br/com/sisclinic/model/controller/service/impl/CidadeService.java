package br.com.sisclinic.model.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.ICidadeService;
import br.com.sisclinic.model.entities.Bairro;
import br.com.sisclinic.model.entities.Cidade;
import br.com.sisclinic.model.entities.UnidadeFederativa;
import br.com.sisclinic.model.repository.impl.CidadeRepository;
import br.com.sisclinic.model.repository.impl.UnidadeFederativaRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;

@Named
@RequestScoped
public class CidadeService implements ICidadeService {


	@Inject
	private CidadeRepository  cidadeRepository;
	
	@Inject
	private UnidadeFederativaRepository  unidadeFederativaRepository;

	private Cidade cidade;
	

	public CidadeService() {
		cidade = new Cidade();
	}
	
	@Transactional
	public void salvarRegistro( Cidade cidade ) {
		if( cidade.getId() == null) {
			save();
		} else {
			getCidadeRepository().alterar(cidade);
		}
		listar();
	}

	@Transactional
	public void save() {
		getCidadeRepository().salvar(this.cidade);
		this.cidade = new Cidade();
		listar();
	}

	@Transactional
	public void remove(Cidade cidade) {
		getCidadeRepository().excluir(cidade);
		listar();
	}

	@Transactional
	public List<Cidade> listar(){
		List<Cidade> cidades = new ArrayList<Cidade>();
		cidades = getCidadeRepository().listar();
		return cidades;
	}

	public void selecionarRegistro( Cidade cidade){
		setCidade(cidade);
		this.getCidade();
	}
	
	public void novoRegistro(){
		setCidade(cidade);
		this.getCidade();
	}
	
	@Transactional
	public List<UnidadeFederativa> listarUnidades(){
		List<UnidadeFederativa> unidades = new ArrayList<UnidadeFederativa>();
		unidades = getUnidadeFederativaRepository().listar();
		return unidades;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	
	public CidadeRepository getCidadeRepository() {
		return cidadeRepository;
	}

	public UnidadeFederativaRepository getUnidadeFederativaRepository() {
		return unidadeFederativaRepository;
	}
	



}
