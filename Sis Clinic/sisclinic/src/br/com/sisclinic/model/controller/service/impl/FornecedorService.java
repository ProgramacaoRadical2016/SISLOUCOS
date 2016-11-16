package br.com.sisclinic.model.controller.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.IFornecedorService;
import br.com.sisclinic.model.entities.Fornecedor;
import br.com.sisclinic.model.entities.Pessoa;
import br.com.sisclinic.model.entities.Usuario;
import br.com.sisclinic.model.repository.impl.FornecedorRepository;
import br.com.sisclinic.model.repository.impl.PessoaRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;

@Named
@RequestScoped
public class FornecedorService implements IFornecedorService{
	
	@Inject
	private FornecedorRepository repository;
	
	@Inject
	private PessoaRepository pessoaRepository;
	
	private Fornecedor fornecedor;
	
	public FornecedorService() {
		fornecedor = new Fornecedor();	
		fornecedor.setPessoa(new Pessoa());
	
	}
	
	
	@Transactional
	public void salvarRegistro( Fornecedor fornecedor ) {
		if( fornecedor.getId() == null || fornecedor.getId() == 0 ) {
			fornecedor.setId(null);
				fornecedor.setId(null);
				getPessoaRepository().salvar(fornecedor.getPessoa());
				fornecedor.setPessoa(getPessoaRepository().buscarUltimaPessoaSalva());
				save();
			} else {
				getRepository().alterar(fornecedor);
			}
			listar();
		}

	@Transactional
	public void save() {
		getRepository().salvar(this.fornecedor);
		this.fornecedor = new Fornecedor();
		listar();
	}

	@Transactional
	public void remove(Fornecedor fornecedor) {
		getRepository().excluir(fornecedor);
		listar();
	}

	@Transactional
	public void alterar(Fornecedor fornecedor) {
		getRepository().alterar(fornecedor);
		listar();
	}

	@Transactional
	public List<Fornecedor> listar(){
		 return getRepository().listar();
	}
	
	
	@Transactional
	public List<Pessoa> listarResponsavel(){
		return getPessoaRepository().listar();
	}
	

	public void selecionarRegistro( Fornecedor fornecedor ){
		setFornecedor(fornecedor);
		this.getFornecedor();
	}

	public FornecedorRepository getRepository() {
		return repository;
	}
	
	public PessoaRepository getPessoaRepository() {
		return pessoaRepository;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	
}
