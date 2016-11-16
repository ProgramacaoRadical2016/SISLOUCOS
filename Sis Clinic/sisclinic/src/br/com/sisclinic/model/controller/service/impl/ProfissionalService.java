package br.com.sisclinic.model.controller.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.IProfissionalService;
import br.com.sisclinic.model.entities.Empresa;
import br.com.sisclinic.model.entities.Pessoa;
import br.com.sisclinic.model.entities.Profissional;
import br.com.sisclinic.model.entities.Usuario;
import br.com.sisclinic.model.repository.impl.EmpresaRepository;
import br.com.sisclinic.model.repository.impl.PessoaRepository;
import br.com.sisclinic.model.repository.impl.ProfissionalRepository;
import br.com.sisclinic.model.repository.impl.UsuarioRepository;
import br.com.sisclinic.utilitarios.SecurityUtil;
import br.com.sisclinic.utilitarios.jpa.Transactional;

@Named
@RequestScoped
public class ProfissionalService implements IProfissionalService{
	
	@Inject
	private ProfissionalRepository repository;
	
	@Inject
	private PessoaRepository pessoaRepository;
	
	
	@Inject
	private EmpresaRepository empresaRepository;
	
	private Profissional profissional;
	

	@Inject
	private UsuarioRepository usuarioRepository;


	private Usuario usuario;

	public ProfissionalService() {
		profissional = new Profissional();
		profissional.setPessoa(new Pessoa());
		profissional.setUsuario(new Usuario());
	}
	
	
	@Transactional
	public void salvarRegistro( Profissional profissional ) {
		if( profissional.getId() == null || profissional.getId() == 0 ) {
			profissional.setId(null);
			getPessoaRepository().salvar(profissional.getPessoa());
			profissional.setPessoa(getPessoaRepository().buscarUltimaPessoaSalva());
			profissional.getUsuario().setNome(profissional.getPessoa().getNome());
			profissional.getUsuario().setEmail(profissional.getPessoa().getEmail());
			profissional.getUsuario().setSenha(senha(profissional.getUsuario().getSenha()));
			getUsuarioRepository().salvar(profissional.getUsuario());
			profissional.setUsuario(getUsuarioRepository().buscarUltimoUsuarioSalvo());
			save();
		} else {
			getRepository().alterar(profissional);
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
		getRepository().salvar(this.profissional);
		this.profissional = new Profissional();
		listar();
	}
	
	
	

	@Transactional
	public void remove(Profissional profissional) {
		getRepository().excluir(profissional);
		listar();
	}

	@Transactional
	public void alterar(Profissional profissional) {
		getRepository().alterar(profissional);
		listar();
	}

	@Transactional
	public List<Profissional> listar(){
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
	

	@Transactional
	public List<Empresa> listarEmpresa(){
		return getEmpresaRepository().listar();
	}

	public void selecionarRegistro( Profissional profissional ){
		setProfissional(profissional);
		this.getProfissional();
	}

	public ProfissionalRepository getRepository() {
		return repository;
	}
	
	public EmpresaRepository getEmpresaRepository() {
		return empresaRepository;
	}

	public PessoaRepository getPessoaRepository() {
		return pessoaRepository;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Profissional getProfissional() {
		return profissional;
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
		setProfissional(null);
		this.getProfissional();
	}
}

