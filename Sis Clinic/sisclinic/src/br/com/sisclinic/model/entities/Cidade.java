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
@Table(name="tb_cidade" )
public class Cidade extends AbstractEntityBean implements BaseEntity{

	@Id
	@Column(name = "cidade_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cidade_nome")
    private String nome;
	
	
    @ManyToOne
    @JoinColumn(name="unidade_federativa_id")
    private UnidadeFederativa unidadeFederativa;
    
    public Cidade(){ 	
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

	public UnidadeFederativa getUnidadeFederativa() {
		return unidadeFederativa;
	}

	public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
		this.unidadeFederativa = unidadeFederativa;
	}

	@Override
	public Long pegarId() {
		return new Long(id);
	}

}
