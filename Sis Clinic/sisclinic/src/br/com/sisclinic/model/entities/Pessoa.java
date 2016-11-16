package br.com.sisclinic.model.entities;

import java.util.Date;

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
@Table(name="tb_pessoa" )
public class Pessoa extends AbstractEntityBean implements BaseEntity {

	@Id
	@Column(name = "pessoa_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "pessoa_nome")
    private String nome;
	
	@Column(name = "pessoa_data_dascimento")
    private Date dataNascimento;
	
	@Column(name = "pessoa_telefone")
    private String telefone;
	
	@Column(name = "pessoa_celular")
    private String celular;
	
	@Column(name = "pessoa_email")
    private String email;
	
	@ManyToOne
	@JoinColumn(name = "sexo_id")
	private Sexo sexo;
	
	@Column(name = "pessoa_cpf")
    private String cpf;
	
	@Column(name = "pessoa_cep")
    private String cep;

	@ManyToOne
	@JoinColumn(name = "tipo_logradouro_id")
	private TipoLogradouro tipoLogradouro;

	@Column(name = "pessoa_logradouro", length = 100)
    private String logradouro;
    
    @Column(name = "pessoa_numero", length = 100)
    private String numero;

    @ManyToOne
  	@JoinColumn(name = "unidade_federativa_id")
    private UnidadeFederativa unidadeFederativa;

    @ManyToOne
 	@JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @ManyToOne
 	@JoinColumn(name = "bairro_id")
    private Bairro bairro;

    @Column(name = "pessoa_complemento", length = 250)
    private String complemento;
    	
	public Pessoa(){
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public UnidadeFederativa getUnidadeFederativa() {
		return unidadeFederativa;
	}

	public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
		this.unidadeFederativa = unidadeFederativa;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public Long pegarId() {
		return new Long(id);
	}


}
