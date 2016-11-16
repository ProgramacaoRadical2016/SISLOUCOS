package br.com.sisclinic.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.sisclinic.utilitarios.convert.BaseEntity;



@SuppressWarnings("serial")
@Entity
@Table(name="tb_usuario" )
public class Usuario extends AbstractEntityBean implements BaseEntity {
	
	@Id
	@Column(name = "usuario_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "usuario_nome")
	private String nome;
	
	@Column(name = "usuario_email")
	private String email;
	
	@Column(name = "usuario_login")
	private String login;

	@Column(name = "usuario_senha")
	private String senha;
	
	
	public Usuario(){
		
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	
	@Override
	public Long pegarId() {
		return new Long(id);
	}

	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
}
