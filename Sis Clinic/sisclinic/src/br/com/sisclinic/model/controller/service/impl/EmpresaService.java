package br.com.sisclinic.model.controller.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.IEmpresaService;
import br.com.sisclinic.model.entities.Empresa;
import br.com.sisclinic.model.entities.Pessoa;
import br.com.sisclinic.model.repository.impl.EmpresaRepository;
import br.com.sisclinic.model.repository.impl.PessoaRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;

@Named
@RequestScoped
public class EmpresaService implements IEmpresaService{
	
	@Inject
	private EmpresaRepository repository;
	
	@Inject
	private PessoaRepository pessoaRepository;
	
	private Empresa empresa;
	
	public EmpresaService() {
		empresa = new Empresa();
		empresa.setPessoa(new Pessoa());
	}
	
	
	@Transactional
	public void salvarRegistro( Empresa empresa ) {
		if( empresa.getId() == null || empresa.getId() == 0 ) {
			empresa.setId(null);
			getPessoaRepository().salvar(empresa.getPessoa());
			empresa.setPessoa(getPessoaRepository().buscarUltimaPessoaSalva());
			save();
		} else {
			getRepository().alterar(empresa);
		}
		listar();
	}

	@Transactional
	public void save() {
		getRepository().salvar(this.empresa);
		this.empresa = new Empresa();
		listar();
	}

	@Transactional
	public void remove(Empresa empresa) {
		getRepository().excluir(empresa);
		listar();
	}

	@Transactional
	public void alterar(Empresa empresa) {
		getRepository().alterar(empresa);
		listar();
	}

	@Transactional
	public List<Empresa> listar(){
		 return getRepository().listar();
	}
	
	
	@Transactional
	public List<Pessoa> listarResponsavel(){
		return getPessoaRepository().listar();
	}
	

	public void selecionarRegistro( Empresa empresa ){
		setEmpresa(empresa);
		this.getEmpresa();
	}

	public EmpresaRepository getRepository() {
		return repository;
	}
	
	public PessoaRepository getPessoaRepository() {
		return pessoaRepository;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	
}
