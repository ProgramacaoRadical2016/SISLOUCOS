package br.com.sisclinic.model.controller.service.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

import br.com.sisclinic.model.controller.service.IPessoaService;
import br.com.sisclinic.model.entities.AgendamentoConsulta;
import br.com.sisclinic.model.entities.Atendimento;
import br.com.sisclinic.model.entities.Convenio;
import br.com.sisclinic.model.entities.Empresa;
import br.com.sisclinic.model.entities.Especialidade;
import br.com.sisclinic.model.entities.Paciente;
import br.com.sisclinic.model.entities.Profissional;
import br.com.sisclinic.model.enums.TipoAtendimento;
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
public class AtendimentoService implements IPessoaService {
	
	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 250);
		opcoes.put("contentWidth", 500);
		
		RequestContext.getCurrentInstance().openDialog("NovoAtendimento", opcoes, null);
	}
	
	
	public void abrirTriagemDialogo(Integer atendimentoId) {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 550);
		opcoes.put("contentWidth", 750);
		
		 Map<String, List<String>> params = new HashMap<>();
		 params.put("atendimentoId", Arrays.asList(""+atendimentoId));
		RequestContext.getCurrentInstance().openDialog("Triagem", opcoes, params);
	}
		
	public void abrirConsultaDialogo(Integer id) {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 550);
		opcoes.put("contentWidth", 450);
		
		 Map<String, List<String>> params = new HashMap<>();
		 params.put("atendimentoConsultaId", Arrays.asList(""+id));
		RequestContext.getCurrentInstance().openDialog("Consulta", opcoes, params);
	}
	
	@Inject
	private AtendimentoRepository  atendimentoRepository;
	
	@Inject
	private AgendamentoConsultaRepository  agendamentoConsultaRepository;
	
	@Inject
	private EmpresaRepository empresaRepository;
	
	
	
	@Inject
    private ConvenioRepository convenioRepository;
	
	@Inject
	private ProfissionalRepository profissionalRepository;
	
	@Inject
    private PacienteRepository pacienteRepository;
	
	@Inject
    private EspecialidadeRepository especialidadeRepository;

	private Atendimento atendimento;

	public AtendimentoService() {
		atendimento = new Atendimento();
	}
	
	@Transactional
	public void salvarRegistro( Atendimento atendimento ) {
		if( atendimento.getId() == null) {
			atendimento.setTipoAtendimento(TipoAtendimento.ATENDIMENTO);
			save();
		} else {
			getAtendimentoRepository().alterar(atendimento);
		}
		listar();
	}
	
	
	@Transactional
	public void confirmarAtendimento( Atendimento atendimento ) {
		if( atendimento.getId() == null) {
			atendimento.setTipoAtendimento(TipoAtendimento.ATENDIMENTO);
			save();
		} else {
			getAtendimentoRepository().alterar(atendimento);
		}
		listar();
	}
    

	@Transactional
	public void save() {
		getAtendimentoRepository().salvar(this.atendimento);
		this.atendimento = new Atendimento();
		listar();
	}

	@Transactional
	public void remove(Atendimento atendimento) {
		getAtendimentoRepository().excluir(atendimento);
		listar();
	}

	@Transactional
	public List<Atendimento> listar(){
		List<Atendimento> atendimentos = new ArrayList<Atendimento>();
		atendimentos = getAtendimentoRepository().listar();
		return atendimentos;
	}
	
	@Transactional
	public List<Atendimento> listarAtendimentoTriagem() {
		return getAtendimentoRepository().listarAtendimentoTriagem();
	}
	
	@Transactional
	public List<Atendimento> listarAtendimentoConsulta() {
		return getAtendimentoRepository().listarAtendimentoConsulta();
	}
	
	
	@Transactional
	public List<Convenio> listarConvenios(){
		buscarAgendamentoPorId();
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
	
	
	@Transactional
	public List<Profissional> listarProfissionais(){
		List<Profissional> profissionais = new ArrayList<Profissional>();
		profissionais = getProfissionalRepository().listar();
		return profissionais;
	}

	public AtendimentoRepository getAtendimentoRepository() {
		return atendimentoRepository;
	}
	
	public ConvenioRepository getConvenioRepository() {
		return convenioRepository;
	}

	public void setAtendimentoRepository(AtendimentoRepository atendimentoRepository) {
		this.atendimentoRepository = atendimentoRepository;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public void selecionarRegistro( Atendimento atendimento ){
		
	}
	
	public void novoRegistro( ){
		setAtendimento(null);
		this.getAtendimento();
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
	
	public AgendamentoConsultaRepository getAgendamentoConsultaRepository() {
		return agendamentoConsultaRepository;
	}
	
	
	public void buscarAgendamentoPorId() {
		String paramResposta = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("agendamentoId");
		if(paramResposta != null && !paramResposta.isEmpty()){
			int codigo = Integer.parseInt(paramResposta);
//			try {
				
				AgendamentoConsulta agendamentoConsulta  = getAgendamentoConsultaRepository().buscarAtendimentoPorId(codigo);
				atendimento.setConvenio(agendamentoConsulta.getConvenio());
				atendimento.setEspecialidade(agendamentoConsulta.getEspecialidade());
				atendimento.setEmpresa(agendamentoConsulta.getEmpresa());
				atendimento.setPaciente(agendamentoConsulta.getPaciente());
				atendimento.setTipoAtendimento(TipoAtendimento.ATENDIMENTO);
				
//			} catch (Exception e) {
//
//			}
		}
	}

}
