package br.com.sisclinic.model.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.com.sisclinic.model.controller.service.IConsultaService;
import br.com.sisclinic.model.entities.Atendimento;
import br.com.sisclinic.model.entities.Consulta;
import br.com.sisclinic.model.entities.Profissional;
import br.com.sisclinic.model.repository.impl.AtendimentoRepository;
import br.com.sisclinic.model.repository.impl.ConsultaRepository;
import br.com.sisclinic.model.repository.impl.ProfissionalRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;


@Named
@RequestScoped
public class ConsultaService implements IConsultaService {


	@Inject
	private ConsultaRepository  consultaRepository;
	
	@Inject
	private AtendimentoRepository  atendimentoRepository;

	@Inject
	private ProfissionalRepository profissionalRepository;

	private Consulta consulta;

	public ConsultaService() {
		consulta = new Consulta();
	}
	
	
	public void buscarIdAtendimento() {
		String paramResposta = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest()).getParameter("atendimentoConsultaId");
		if(paramResposta != null && !paramResposta.isEmpty()){
			int codigo = Integer.parseInt(paramResposta);
			try {
				consulta  = getConsultaRepository().listarConsultaPorAatendimentoId(codigo);
			} catch (Exception e) {

			}
		}
	}

	@Transactional
	public void salvarRegistro( Consulta consulta ) {
		if( consulta.getId() == null) {
			save();
		} else {
			getConsultaRepository().alterar(consulta);
		}
		listar();
	}


	@Transactional
	public void save() {
		getConsultaRepository().salvar(this.consulta);
		this.consulta = new Consulta();
		listar();
	}

	@Transactional
	public void remove(Consulta consulta) {
		getConsultaRepository().excluir(consulta);
		listar();
	}

	@Transactional
	public List<Consulta> listar(){
		List<Consulta> consultas = new ArrayList<Consulta>();
		consultas = getConsultaRepository().listar();
		return consultas;
	}


	@Transactional
	public List<Profissional> listarProfissionais(){
		List<Profissional> profissionais = new ArrayList<Profissional>();
		profissionais = getProfissionalRepository().listar();
		return profissionais;
	}
	
	@Transactional
	public List<Atendimento> listarAtendimentos(){
		buscarIdAtendimento();
		List<Atendimento> atendimentos = new ArrayList<Atendimento>();
		atendimentos = getAtendimentoRepository().listar();
	
		return atendimentos;
	}

	public ConsultaRepository getConsultaRepository() {
		return consultaRepository;
	}

	public ProfissionalRepository getProfissionalRepository() {
		return profissionalRepository;
	}


	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public void selecionarRegistro( Consulta consulta ){

	}

	public void novoRegistro( ){
		setConsulta(null);
		this.getConsulta();
	}

	
	public AtendimentoRepository getAtendimentoRepository() {
		return atendimentoRepository;
	}

}
