package br.com.sisclinic.model.controller.service.bens;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.sisclinic.model.entities.Usuario;
import br.com.sisclinic.model.repository.impl.UsuarioRepository;


@ManagedBean
@ViewScoped
public class LoginManagedBean {

//	@ManagedProperty(value="#{entityManager}")
//	 private EntityManager entityManager;

	private UsuarioRepository repository = new UsuarioRepository();
	
	private Usuario usuario = new Usuario();
	
	public String logar() {

		usuario = getRepository().buscarUsuario(usuario.getLogin(), usuario.getSenha());
		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
							"Erro no Login!"));
			return null;
		} else {
			return "/home";
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public UsuarioRepository getRepository() {
		return repository;
	}
}