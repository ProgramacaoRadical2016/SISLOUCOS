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
@Table(name="tb_consulta" )
public class Consulta extends AbstractEntityBean implements BaseEntity {

	@Id
	@Column(name = "consulta_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;


	@ManyToOne
	@JoinColumn(name = "atendimento_id")
	private Atendimento atendimento;

	@ManyToOne
	@JoinColumn(name = "profissional_id")
	private Profissional profissional;


	@Column(name = "consulta_data")
	private Timestamp dataConsulta;

	@Column(name = "consulta_informacao")
	private String informacao;


	@Column(name = "consulta_exame")
	private String exame;


	public Consulta(){

	}

	public Consulta(Integer id){
      this.id = id;
	}

	@Override
	public Long pegarId() {
		return new Long(id);
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public Timestamp getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Timestamp dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public String getInformacao() {
		return informacao;
	}

	public void setInformacao(String informacao) {
		this.informacao = informacao;
	}

	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

}
