package br.com.sisclinic.model.entities;

import java.sql.Timestamp;

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
@Table(name="tb_consulta_procedimento" )
public class ConsultaProcedimento extends AbstractEntityBean implements BaseEntity {

	@Id
	@Column(name = "consulta_procedimento_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "consulta_id")
	private Consulta consulta;
	
	@ManyToOne
	@JoinColumn(name = "procedimento_id")
    private Procedimento procedimento;
	
	@Column(name = "consulta_procedimento_quantidade")
    private Double quantidade;
	
	
	public ConsultaProcedimento(){
		
	}

	@Override
	public Long pegarId() {
		return new Long(id);
	}

	public Integer getId() {
		return id;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}