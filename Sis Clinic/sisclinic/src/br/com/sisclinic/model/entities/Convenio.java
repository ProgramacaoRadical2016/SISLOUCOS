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
@Table(name="tb_convenio" )
public class Convenio extends AbstractEntityBean implements BaseEntity {

	@Id
	@Column(name = "convenio_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "convenio_descricao")
	private String descricao;
	
	public Convenio(){
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	@Override
	public Long pegarId() {
		return new Long(id);
	}


}
