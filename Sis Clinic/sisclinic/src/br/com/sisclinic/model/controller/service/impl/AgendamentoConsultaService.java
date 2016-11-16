package br.com.sisclinic.model.controller.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.sisclinic.model.controller.service.IAgendamentoConsultaService;
import br.com.sisclinic.model.entities.AgendamentoConsulta;
import br.com.sisclinic.model.entities.Convenio;
import br.com.sisclinic.model.entities.Empresa;
import br.com.sisclinic.model.entities.Especialidade;
import br.com.sisclinic.model.entities.Paciente;
import br.com.sisclinic.model.entities.Profissional;
import br.com.sisclinic.model.repository.impl.AgendamentoConsultaRepository;
import br.com.sisclinic.model.repository.impl.AtendimentoRepository;
import br.com.sisclinic.model.repository.impl.ConvenioRepository;
import br.com.sisclinic.model.repository.impl.EmpresaRepository;
import br.com.sisclinic.model.repository.impl.EspecialidadeRepository;
import br.com.sisclinic.model.repository.impl.PacienteRepository;
import br.com.sisclinic.model.repository.impl.ProfissionalRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;


@Named
@RequestScoped
public class AgendamentoConsultaService implements IAgendamentoConsultaService {
	
	
	public void abrirAgendamentoConsultaDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 250);
		opcoes.put("contentWidth", 500);
		
		RequestContext.getCurrentInstance().openDialog("NovaAgendamentoConsulta", opcoes, null);
	}
		
	
	public void abrirConfirmacaoAtendimentoDialogo(Integer agendamentoId) {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 250);
		opcoes.put("contentWidth", 450);
		
		 Map<String, List<String>> params = new HashMap<>();
		 params.put("agendamentoId", Arrays.asList(""+agendamentoId));
		RequestContext.getCurrentInstance().openDialog("ConfirmarAgendamento",opcoes, params);
	}
	
	
	
	@Inject
	private AgendamentoConsultaRepository  agendamentoConsultaRepository;
	
	
	@Inject
    private ConvenioRepository convenioRepository;
	
	@Inject
    private PacienteRepository pacienteRepository;
	
	@Inject
    private EspecialidadeRepository especialidadeRepository;
	
	@Inject
	private ProfissionalRepository profissionalRepository;

	private AgendamentoConsulta agendamentoConsulta;
	
	@Inject
	private EmpresaRepository empresaRepository;

	public AgendamentoConsultaService() {
		agendamentoConsulta = new AgendamentoConsulta();
	}
	
	@Transactional
	public void salvarRegistro( AgendamentoConsulta agendamentoConsulta ) {
		if( agendamentoConsulta.getId() == null) {
			save();
		} else {
			getAgendamentoConsultaRepository().alterar(agendamentoConsulta);
		}
		listar();
	}
    

	@Transactional
	public void save() {
		getAgendamentoConsultaRepository().salvar(this.agendamentoConsulta);
		this.agendamentoConsulta = new AgendamentoConsulta();
		listar();
	}

	@Transactional
	public void remove(AgendamentoConsulta agendamentoConsulta) {
		getAgendamentoConsultaRepository().excluir(agendamentoConsulta);
		listar();
	}

	@Transactional
	public List<AgendamentoConsulta> listar(){
		List<AgendamentoConsulta> agendamentoConsultas = new ArrayList<AgendamentoConsulta>();
		agendamentoConsultas = getAgendamentoConsultaRepository().listar();
		return agendamentoConsultas;
	}
	
	
	@Transactional
	public List<Convenio> listarConvenios(){
		List<Convenio> convenios = new ArrayList<Convenio>();
		convenios = getConvenioRepository().listar();
		return convenios;
	}
	
	
	@Transactional
	public List<Especialidade> listarEspecialidades(){
		List<Especialidade> especialidades = new ArrayList<Especialidade>();
		especialidades = getEspecialidadeRepository().listar();
		return especialidades;
	}
	
	@Transactional
	public List<Paciente> listarPacientes(){
		List<Paciente> pacientes = new ArrayList<Paciente>();
		pacientes = getPacienteRepository().listar();
		return pacientes;
	}

	public AgendamentoConsultaRepository getAgendamentoConsultaRepository() {
		return agendamentoConsultaRepository;
	}
	
	public ConvenioRepository getConvenioRepository() {
		return convenioRepository;
	}



	public AgendamentoConsulta getAgendamentoConsulta() {
		return agendamentoConsulta;
	}

	public void setAgendamentoConsulta(AgendamentoConsulta agendamentoConsulta) {
		this.agendamentoConsulta = agendamentoConsulta;
	}

	public void selecionarRegistro( AgendamentoConsulta agendamentoConsulta ){
		
	}
	
	public void novoRegistro( ){
		setAgendamentoConsulta(null);
		this.getAgendamentoConsulta();
	}
	
	public EspecialidadeRepository getEspecialidadeRepository() {
		return especialidadeRepository;
	}
	
	public PacienteRepository getPacienteRepository() {
		return pacienteRepository;
	}
	
	
	public ProfissionalRepository getProfissionalRepository() {
		return profissionalRepository;
	}
	
	public EmpresaRepository getEmpresaRepository() {
		return empresaRepository;
	}
	
	@Transactional
	public List<Empresa> listarEmpresa(){
		return getEmpresaRepository().listar();
	}

}
