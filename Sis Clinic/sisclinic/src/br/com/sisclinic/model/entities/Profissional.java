package br.com.sisclinic.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.sisclinic.utilitarios.convert.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_profissional" )
public class Profissional extends AbstractEntityBean implements BaseEntity {

	@Id
	@Column(name = "profissional_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
    private Empresa empresa; 
		
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
    private Usuario usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
		
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public Long pegarId() {
		return new Long(id);
	}
}

