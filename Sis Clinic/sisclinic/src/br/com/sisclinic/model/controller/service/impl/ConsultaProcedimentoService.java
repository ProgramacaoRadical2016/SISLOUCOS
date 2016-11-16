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

import br.com.sisclinic.model.controller.service.IConsultaProcedimentoService;
import br.com.sisclinic.model.entities.Consulta;
import br.com.sisclinic.model.entities.ConsultaProcedimento;
import br.com.sisclinic.model.entities.Profissional;
import br.com.sisclinic.model.entities.Triagem;
import br.com.sisclinic.model.entities.TriagemMedicamento;
import br.com.sisclinic.model.repository.impl.ConsultaProcedimentoRepository;
import br.com.sisclinic.model.repository.impl.ProfissionalRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;

@Named
@RequestScoped
public class ConsultaProcedimentoService implements IConsultaProcedimentoService {

	
	public void abrirConsultaProcedimenotDialogo(Integer id) {
		
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 250);
		opcoes.put("contentWidth", 500);
				
		Map<String, List<String>> params = new HashMap<>();
		 params.put("consultaId", Arrays.asList(""+id));
		RequestContext.getCurrentInstance().openDialog("ConsultaProcedimento", opcoes, params);
	}
		

	@Inject
	private ConsultaProcedimentoRepository  consultaProcedimentoRepository;

	@Inject
	private ProfissionalRepository profissionalRepository;

	private ConsultaProcedimento consultaProcedimento;

	public ConsultaProcedimentoService() {
		consultaProcedimento = new ConsultaProcedimento();
		String paramResposta = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("consultaId");
		if(paramResposta != null && !paramResposta.isEmpty()){
			int codigo = Integer.parseInt(paramResposta);
			consultaProcedimento.setConsulta(new Consulta(codigo));
		}
	}

	@Transactional
	public void salvarRegistro( ConsultaProcedimento consultaProcedimento ) {
		if( consultaProcedimento.getId() == null) {
			
			save();
		} else {
			getConsultaProcedimentoRepository().alterar(consultaProcedimento);
		}
		listar();
	}


	@Transactional
	public void save() {
		getConsultaProcedimentoRepository().salvar(this.consultaProcedimento);
		this.consultaProcedimento = new ConsultaProcedimento();
		listar();
	}

	@Transactional
	public void remove(ConsultaProcedimento consultaProcedimento) {
		getConsultaProcedimentoRepository().excluir(consultaProcedimento);
		listar();
	}

	@Transactional
	public List<ConsultaProcedimento> listar(){
		List<ConsultaProcedimento> consultaProcedimentos = new ArrayList<ConsultaProcedimento>();
		consultaProcedimentos = getConsultaProcedimentoRepository().listar();
		return consultaProcedimentos;
	}


	@Transactional
	public List<Profissional> listarProfissionais(){
		List<Profissional> profissionais = new ArrayList<Profissional>();
		profissionais = getProfissionalRepository().listar();
		return profissionais;
	}

	public ProfissionalRepository getProfissionalRepository() {
		return profissionalRepository;
	}

	public void selecionarRegistro( ConsultaProcedimento consultaProcedimento ){

	}

	public void novoRegistro( ){
		setConsultaProcedimento(null);
		this.getConsultaProcedimento();
	}
	
	
	public List<ConsultaProcedimento> listarProcedimentoConsulta(){
		return  getConsultaProcedimentoRepository().listar();

	}


	public ConsultaProcedimento getConsultaProcedimento() {
		return consultaProcedimento;
	}

	public void setConsultaProcedimento(ConsultaProcedimento consultaProcedimento) {
		this.consultaProcedimento = consultaProcedimento;
	}
	
	public ConsultaProcedimentoRepository getConsultaProcedimentoRepository() {
		return consultaProcedimentoRepository;
	}
	
	
	public List<ConsultaProcedimento> procedimentoGridCosulta( Consulta consulta ){
		if(consulta != null){
			return  getConsultaProcedimentoRepository().listarConsultaProcedimento(consulta);
		} else {
			 return null;
		}
	}


}
