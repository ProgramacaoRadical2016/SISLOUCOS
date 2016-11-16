package br.com.sisclinic.model.controller.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

import br.com.sisclinic.model.controller.service.ITriagemMedicamentoService;
import br.com.sisclinic.model.entities.Profissional;
import br.com.sisclinic.model.entities.Triagem;
import br.com.sisclinic.model.entities.TriagemMedicamento;
import br.com.sisclinic.model.repository.impl.ProfissionalRepository;
import br.com.sisclinic.model.repository.impl.TriagemMedicamentoRepository;
import br.com.sisclinic.model.repository.impl.TriagemRepositoy;
import br.com.sisclinic.utilitarios.jpa.Transactional;


@Named
@RequestScoped
public class TriagemMedicamentoService implements ITriagemMedicamentoService {
	
	
	
	
	public void abrirTriagemMedicamentoDialogo(Integer id) {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 250);
		opcoes.put("contentWidth", 500);
		
		Map<String, List<String>> params = new HashMap<>();
		 params.put("triagemId", Arrays.asList(""+id));
		RequestContext.getCurrentInstance().openDialog("TriagemMedicamento", opcoes, params);
		
	}
	
	@Inject
	private TriagemMedicamentoRepository  triagemMedicamentoRepository;
	
	
	@Inject
	private TriagemRepositoy  triagemRepositoy;

	@Inject
	private ProfissionalRepository profissionalRepository;

	private TriagemMedicamento triagemMedicamento;

	public TriagemMedicamentoService() {
		triagemMedicamento = new TriagemMedicamento();
		String paramResposta = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("triagemId");
		if(paramResposta != null && !paramResposta.isEmpty()){
			int codigo = Integer.parseInt(paramResposta);
			triagemMedicamento.setTriagem(new Triagem(codigo));
		}			
	}

	@Transactional
	public void salvarRegistro( TriagemMedicamento triagemMedicamento ) {
		if( triagemMedicamento.getId() == null) {
			save();
		} else {
			getTriagemMedicamentoRepository().alterar(triagemMedicamento);
		}
		listar();
	}


	@Transactional
	public void save() {
		getTriagemMedicamentoRepository().salvar(this.triagemMedicamento);
		this.triagemMedicamento = new TriagemMedicamento();
		listar();
	}

	@Transactional
	public void remove(TriagemMedicamento triagemMedicamento) {
		getTriagemMedicamentoRepository().excluir(triagemMedicamento);
		listar();
	}

	@Transactional
	public List<TriagemMedicamento> listar(){
		List<TriagemMedicamento> triagemMedicamentos = new ArrayList<TriagemMedicamento>();
		triagemMedicamentos = getTriagemMedicamentoRepository().listar();
		return triagemMedicamentos;
	}


	@Transactional
	public List<Profissional> listarProfissionais(){
		List<Profissional> profissionais = new ArrayList<Profissional>();
		profissionais = getProfissionalRepository().listar();
		return profissionais;
	}
	
	@Transactional
	public List<Triagem> listarTriagens(){
		List<Triagem> triagens = new ArrayList<Triagem>();
		triagens = getTriagemRepositoy().listar();
		return triagens;
	}

	public TriagemMedicamentoRepository getTriagemMedicamentoRepository() {
		return triagemMedicamentoRepository;
	}

	public ProfissionalRepository getProfissionalRepository() {
		return profissionalRepository;
	}
	
	public TriagemMedicamento getTriagemMedicamento() {
		return triagemMedicamento;
	}

	public void setTriagemMedicamento(TriagemMedicamento triagemMedicamento) {
		this.triagemMedicamento = triagemMedicamento;
	}

	public void selecionarRegistro( Triagem triagem ){

	}

	public void novoRegistro( ){
		setTriagemMedicamento(null);
		this.getTriagemMedicamento();
	}
	
	public List<TriagemMedicamento> medicamentosGridTriagem( Triagem triagem ){
		if(triagem != null){
			return  getTriagemMedicamentoRepository().listarTriagemMedicamento(triagem);
		} else {
			 return null;
		}
	}
	
	
	public List<TriagemMedicamento> medicamentosTriagem(){
		return  getTriagemMedicamentoRepository().listar();

	}
	
	public TriagemRepositoy getTriagemRepositoy() {
		return triagemRepositoy;
	}
}
