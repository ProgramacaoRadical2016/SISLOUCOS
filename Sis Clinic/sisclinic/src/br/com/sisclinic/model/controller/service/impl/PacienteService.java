package br.com.sisclinic.model.controller.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.IPacienteService;
import br.com.sisclinic.model.entities.Paciente;
import br.com.sisclinic.model.entities.Pessoa;
import br.com.sisclinic.model.entities.Usuario;
import br.com.sisclinic.model.repository.impl.PacienteRepository;
import br.com.sisclinic.model.repository.impl.PessoaRepository;
import br.com.sisclinic.model.repository.impl.UsuarioRepository;
import br.com.sisclinic.utilitarios.SecurityUtil;
import br.com.sisclinic.utilitarios.jpa.Transactional;

@Named
@RequestScoped
public class PacienteService implements IPacienteService{

	@Inject
	private PacienteRepository repository;

	@Inject
	private PessoaRepository pessoaRepository;

	@Inject
	private UsuarioRepository usuarioRepository;


	private Paciente paciente;


	private Usuario usuario;

	public PacienteService() {
		paciente = new Paciente();
		paciente.setPessoa(new Pessoa());
		paciente.setUsuario(new Usuario());
	}
	
	
	@Transactional
	public void salvarRegistro( Paciente paciente ) {
		if( paciente.getId() == null || paciente.getId() == 0 ) {
			paciente.setId(null);
			getPessoaRepository().salvar(paciente.getPessoa());
			paciente.setPessoa(getPessoaRepository().buscarUltimaPessoaSalva());
			paciente.getUsuario().setNome(paciente.getPessoa().getNome());
			paciente.getUsuario().setEmail(paciente.getPessoa().getEmail());
			paciente.getUsuario().setSenha(senha(paciente.getUsuario().getSenha()));
			getUsuarioRepository().salvar(paciente.getUsuario());
			paciente.setUsuario(getUsuarioRepository().buscarUltimoUsuarioSalvo());
			save();
		} else {
			getRepository().alterar(paciente);
		}
		listar();
	}
	
	
	
	public String senha(String senhaNormal){
		try {
			String senha = SecurityUtil.toMD5(senhaNormal);
			return senha;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return senhaNormal;
	}
    

	@Transactional
	public void save() {
		getRepository().salvar(this.paciente);
		this.paciente = new Paciente();
		listar();
	}
	
	
	

	@Transactional
	public void remove(Paciente paciente) {
		getRepository().excluir(paciente);
		listar();
	}

	@Transactional
	public void alterar(Paciente paciente) {
		getRepository().alterar(paciente);
		listar();
	}

	@Transactional
	public List<Paciente> listar(){
		return getRepository().listar();
	}


	@Transactional
	public List<Pessoa> listarResponsavel(){
		return getPessoaRepository().listar();
	}


	@Transactional
	public List<Usuario> listarUsuario(){
		return getUsuarioRepository().listar();
	}

	public void selecionarRegistro( Paciente paciente ){
		setPaciente(paciente);
		this.getPaciente();
	}

	public PacienteRepository getRepository() {
		return repository;
	}

	public PessoaRepository getPessoaRepository() {
		return pessoaRepository;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public void novoRegistro( ){
		setPaciente(null);
		this.getPaciente();
	}

}

