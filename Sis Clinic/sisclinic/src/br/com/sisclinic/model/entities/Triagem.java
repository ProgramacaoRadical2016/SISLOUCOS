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
@Table(name="tb_triagem" )
public class Triagem extends AbstractEntityBean implements BaseEntity {

	@Id
	@Column(name = "triagem_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
		
	@ManyToOne
	@JoinColumn(name = "atendimento_id")
	private Atendimento atendimento;
	

	@ManyToOne
	@JoinColumn(name = "profissional_id")
    private Profissional profissional;
	
	@Column(name = "triagem_data")
    private Timestamp dataTriagem;
	
	@Column(name = "triagem_pressao")
    private String pressao;
	
	@Column(name = "triagem_temperatura")
    private String temperatura;
	
	@Column(name = "triagem_peso")
    private String peso;
	
	@Column(name = "triagem_altura")
    private String altura;
	
	@Column(name = "triagem_queixa")
    private String queixa;

	
	public Triagem(){
		
	}
	
	public Triagem(Integer id){
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

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Timestamp getDataTriagem() {
		return dataTriagem;
	}

	public void setDataTriagem(Timestamp dataTriagem) {
		this.dataTriagem = dataTriagem;
	}

	public String getPressao() {
		return pressao;
	}

	public void setPressao(String pressao) {
		this.pressao = pressao;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getQueixa() {
		return queixa;
	}

	public void setQueixa(String queixa) {
		this.queixa = queixa;
	}
	
	
		
}