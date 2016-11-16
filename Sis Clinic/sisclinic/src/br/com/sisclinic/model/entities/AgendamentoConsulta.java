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
@Table(name="tb_agendamento_consulta" )
public class AgendamentoConsulta extends AbstractEntityBean implements BaseEntity {

	@Id
	@Column(name = "agendamento_consulta_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
    private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name = "convenio_id")
    private Convenio convenio;
	
	@ManyToOne
	@JoinColumn(name = "especialidade_id")
    private Especialidade especialidade;
	
	@Column(name = "agendamento_consulta_data")
    private Timestamp dataConsulta;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id")
    private Paciente paciente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Timestamp getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Timestamp dataConsulta) {
		this.dataConsulta = dataConsulta;
	}


	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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
