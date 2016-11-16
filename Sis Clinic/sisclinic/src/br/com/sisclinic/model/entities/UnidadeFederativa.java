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
@Table(name="tb_unidade_federativa" )
public class UnidadeFederativa extends AbstractEntityBean  implements BaseEntity{

	@Id
	@Column(name = "unidade_federativa_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "unidade_federativa_descricao")
    private String nome;
	
	@Column(name = "unidade_federativa_sigla")
    private String sigla;
	
	public UnidadeFederativa() {
		
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	@Override
	public Long pegarId() {
		return new Long(id);
	}

}
