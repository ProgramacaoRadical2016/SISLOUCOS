package br.com.sisclinic.model.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.IProcedimentoService;
import br.com.sisclinic.model.entities.Procedimento;
import br.com.sisclinic.model.repository.impl.ProcedimentoRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;


@Named
@RequestScoped
public class ProcedimentoService implements IProcedimentoService{

	@Inject
	private ProcedimentoRepository  procedimentoRepository;

	private Procedimento procedimento;

	public ProcedimentoService() {
		procedimento = new Procedimento();
	}
	
	@Transactional
	public void salvarRegistro(Procedimento procedimento ) {
		if( procedimento.getId() == null) {
			save();
		} else {
			getProcedimentoRepository().alterar(procedimento);
		}
		listar();
	}
    

	@Transactional
	public void save() {
		getProcedimentoRepository().salvar(this.procedimento);
		this.procedimento = new Procedimento();
		listar();
	}

	@Transactional
	public void remove(Procedimento procedimento) {
		getProcedimentoRepository().excluir(procedimento);
		listar();
	}

	@Transactional
	public List<Procedimento> listar(){
		List<Procedimento> procedimentos = new ArrayList<Procedimento>();
		procedimentos = getProcedimentoRepository().listar();
		return procedimentos;
	}

	public ProcedimentoRepository getProcedimentoRepository() {
		return procedimentoRepository;
	}

	public void setProcedimentoRepository(ProcedimentoRepository procedimentoRepository) {
		this.procedimentoRepository = procedimentoRepository;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	public void selecionarRegistro( Procedimento procedimento ){
		
	}
	
	public void novoRegistro( ){
		setProcedimento(null);
		this.getProcedimento();
	}
}
