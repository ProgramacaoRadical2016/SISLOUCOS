package br.com.sisclinic.model.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.com.sisclinic.model.controller.service.ITriagemService;
import br.com.sisclinic.model.entities.Atendimento;
import br.com.sisclinic.model.entities.Profissional;
import br.com.sisclinic.model.entities.Triagem;
import br.com.sisclinic.model.repository.impl.AtendimentoRepository;
import br.com.sisclinic.model.repository.impl.ProfissionalRepository;
import br.com.sisclinic.model.repository.impl.TriagemRepositoy;
import br.com.sisclinic.utilitarios.jpa.Transactional;


@Named
@RequestScoped
public class TriagemService implements ITriagemService {

	@Inject
	private TriagemRepositoy  triagemRepository;
	
	@Inject
	private AtendimentoRepository  atendimentoRepository;

	@Inject
	private ProfissionalRepository profissionalRepository;

	private Triagem triagem;
	
	
	public TriagemService() {
		triagem = new Triagem();
	}
	
	public void buscarIdAtendimento() {
		String paramResposta = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest()).getParameter("atendimentoId");
		if(paramResposta != null && !paramResposta.isEmpty()){
			int codigo = Integer.parseInt(paramResposta);
			try {
				triagem  = getTriagemRepository().listarTriagemPorIdAatendimento(codigo);
			} catch (Exception e) {

			}
		}
	}
	
		
	@Transactional
	public Atendimento buscarAtendimento(Integer id ){
		return getAtendimentoRepository().buscarAtendimentoPorId(id);
	}

	
	public AtendimentoRepository getAtendimentoRepository() {
		return atendimentoRepository;
	}

	@Transactional
	public void salvarRegistro( Triagem triagem ) {
		if( triagem.getId() == null) {
			save();
		} else {
			getTriagemRepository().alterar(triagem);
		}
		listar();
	}


	@Transactional
	public void save() {
		getTriagemRepository().salvar(this.triagem);
		this.triagem = new Triagem();
		listar();
	}

	@Transactional
	public void remove(Triagem triagem) {
		getTriagemRepository().excluir(triagem);
		listar();
	}

	@Transactional
	public List<Triagem> listar(){
		List<Triagem> triagems = new ArrayList<Triagem>();
		triagems = getTriagemRepository().listar();
		return triagems;
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
	
	
	@Transactional
	public Atendimento selecionarAtendimento(){
		String paramResposta = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("atendimentoId");
		if(paramResposta != null && !paramResposta.isEmpty()){
			int codigo = Integer.parseInt(paramResposta);
			return getAtendimentoRepository().buscarAtendimentoPorId(codigo);
		}
		return null;
	}

	public TriagemRepositoy getTriagemRepository() {
		return triagemRepository;
	}

	public ProfissionalRepository getProfissionalRepository() {
		return profissionalRepository;
	}


	public Triagem getTriagem() {
		return triagem;
	}

	public void setTriagem(Triagem triagem) {
		this.triagem = triagem;
	}

	public void selecionarRegistro( Triagem triagem ){

	}

	public void novoRegistro( ){
		setTriagem(null);
		this.getTriagem();
	}


}
