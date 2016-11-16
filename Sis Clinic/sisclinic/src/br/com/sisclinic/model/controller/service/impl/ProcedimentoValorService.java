package br.com.sisclinic.model.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.IProcedimentoValorService;
import br.com.sisclinic.model.entities.ProcedimentoValor;
import br.com.sisclinic.model.repository.impl.ProcedimentoValorRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;


@Named
@RequestScoped
public class ProcedimentoValorService implements IProcedimentoValorService  {

	@Inject
	private ProcedimentoValorRepository  procedimentoValorRepository;

	private ProcedimentoValor procedimentoValor;

	public ProcedimentoValorService() {
		procedimentoValor = new ProcedimentoValor();
	}
	
	@Transactional
	public void salvarRegistro( ProcedimentoValor procedimentoValor ) {
		if( procedimentoValor.getId() == null || procedimentoValor.getId() == 0  ) {
			save();
		} else {
			getProcedimentoValorRepository().alterar(procedimentoValor);
		}
		listar();
	}
    

	@Transactional
	public void save() {
		getProcedimentoValorRepository().salvar(this.procedimentoValor);
		this.procedimentoValor = new ProcedimentoValor();
		listar();
	}

	@Transactional
	public void remove(ProcedimentoValor procedimentoValor) {
		getProcedimentoValorRepository().excluir(procedimentoValor);
		listar();
	}

	@Transactional
	public List<ProcedimentoValor> listar(){
		List<ProcedimentoValor> procedimentoValors = new ArrayList<ProcedimentoValor>();
		procedimentoValors = getProcedimentoValorRepository().listar();
		return procedimentoValors;
	}

	public ProcedimentoValorRepository getProcedimentoValorRepository() {
		return procedimentoValorRepository;
	}

	public void setProcedimentoValorRepository(ProcedimentoValorRepository procedimentoValorRepository) {
		this.procedimentoValorRepository = procedimentoValorRepository;
	}

	public ProcedimentoValor getProcedimentoValor() {
		return procedimentoValor;
	}

	public void setProcedimentoValor(ProcedimentoValor procedimentoValor) {
		this.procedimentoValor = procedimentoValor;
	}

	public void selecionarRegistro( ProcedimentoValor procedimentoValor ){
		
	}
	
	public void novoRegistro( ){
		setProcedimentoValor(null);
		this.getProcedimentoValor();
	}
}
