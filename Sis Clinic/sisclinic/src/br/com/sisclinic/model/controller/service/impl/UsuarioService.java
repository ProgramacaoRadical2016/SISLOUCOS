package br.com.sisclinic.model.controller.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.IUsuarioService;
import br.com.sisclinic.model.entities.Usuario;
import br.com.sisclinic.model.repository.impl.UsuarioRepository;
import br.com.sisclinic.utilitarios.SecurityUtil;
import br.com.sisclinic.utilitarios.jpa.Transactional;


@Named
@RequestScoped
public class UsuarioService implements IUsuarioService{	
	
	@Inject
    private UsuarioRepository  repository;
	
    private Usuario usuario;
    
    public UsuarioService() {
    	usuario = new Usuario();
    }
    
	@Transactional
	public void salvarRegistro( Usuario usuario ) {
		if( usuario.getId() == null || usuario.getId() == 0) {
			usuario.setSenha(senha(usuario.getSenha()));
			save();
		} else {
			getRepository().alterar(usuario);
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
    	this.usuario.setId(null);
    	getRepository().salvar(this.usuario);
        this.usuario = new Usuario();
        listar();
    }
     
    @Transactional
    public void remove(Usuario usuario) {
    	getRepository().excluir(usuario);
    	listar();
    }
    
    @Transactional
    public void alterar( Usuario usuario ) {
    	getRepository().alterar(usuario);
    	listar();
    }
    
   @Transactional
    public List<Usuario> listar(){
    	return getRepository().listar();
    }
   
   public String logar() throws Exception {
	   String senha = SecurityUtil.toMD5( usuario.getSenha());
		usuario = getRepository().buscarUsuario(usuario.getLogin(), senha);
		if (usuario == null) {
//			usuario = new Usuario();
//			FacesContext.getCurrentInstance().addMessage(
//					null,
//					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
//							"Erro no Login!"));
			return "/login";
		} else {
			return "/home";
		}
	}

	public UsuarioRepository getRepository() {
		return repository;
	}
	
	public void selecionarRegistro( Usuario usuario ){
		setUsuario(usuario);
		this.getUsuario();
	}
	
	public void novoRegistro( ){
		setUsuario(null);
		this.getUsuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	public Usuario buscarUsuario(String login, String senha ){
		Usuario usuario = getRepository().buscarUsuario(login, senha);
		return usuario;
	}

}
