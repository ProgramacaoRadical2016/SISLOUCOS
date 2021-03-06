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
@Table(name="tb_fornecedor" )
public class Fornecedor extends AbstractEntityBean implements BaseEntity {

	@Id
	@Column(name = "fornecedor_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
	
	public Fornecedor(){
		
	}

	@Override
	public Long pegarId() {
		return new Long(id);
	}

	public Integer getId() {
		return id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
