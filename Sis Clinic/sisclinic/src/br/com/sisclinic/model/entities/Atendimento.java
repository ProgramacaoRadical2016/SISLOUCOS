package br.com.sisclinic.model.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.sisclinic.model.enums.TipoAtendimento;
import br.com.sisclinic.utilitarios.convert.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_atendimento" )
public class Atendimento extends AbstractEntityBean implements BaseEntity {

	@Id
	@Column(name = "atendimento_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "atendimento_tipo")
	private TipoAtendimento tipoAtendimento;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
    private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name = "convenio_id")
    private Convenio convenio;
	

	@ManyToOne
	@JoinColumn(name = "especialidade_id")
    private Especialidade especialidade;
	
	@Column(name = "atendimento_data")
    private Timestamp dataAtendimento;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id")
    private Paciente paciente;

	
	public Atendimento(){
		
	}
	
	public Atendimento(Integer id ){
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




	public Timestamp getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Timestamp dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public TipoAtendimento getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
	
}