package br.com.sisclinic.model.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.IPessoaService;
import br.com.sisclinic.model.entities.Bairro;
import br.com.sisclinic.model.entities.Cidade;
import br.com.sisclinic.model.entities.Pessoa;
import br.com.sisclinic.model.entities.Sexo;
import br.com.sisclinic.model.entities.TipoLogradouro;
import br.com.sisclinic.model.entities.UnidadeFederativa;
import br.com.sisclinic.model.repository.impl.BairroRepository;
import br.com.sisclinic.model.repository.impl.CidadeRepository;
import br.com.sisclinic.model.repository.impl.PessoaRepository;
import br.com.sisclinic.model.repository.impl.SexoRepository;
import br.com.sisclinic.model.repository.impl.TipoLogradouroRepository;
import br.com.sisclinic.model.repository.impl.UnidadeFederativaRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;

@Named
@RequestScoped
public class PessoaService implements IPessoaService {

	@Inject
    private PessoaRepository  pessoaRepository;
	
	@Inject
    private SexoRepository  sexoRepository;
	
	@Inject
    private UnidadeFederativaRepository unidadeFederativaRepository;
	
	@Inject
    private CidadeRepository cidadeRepository;
	
	@Inject
    private BairroRepository  bairroRepository;
	
	@Inject
    private TipoLogradouroRepository  tipoLogradouroRepository;
	
    private Pessoa pessoa;
    
	public PessoaService() {
		pessoa = new Pessoa();
	}
	
	@Transactional
	public void salvarRegistro( Pessoa pessoa ) {
		if( pessoa.getId() == null) {
			save();
			this.pessoa = new Pessoa();
		} else {
			getPessoaRepository().alterar(pessoa);
		}
		listar();
	}

	@Transactional
	public void save() {
		getPessoaRepository().salvar(this.pessoa);
		this.pessoa = new Pessoa();
		listar();
	}

	@Transactional
	public void remove(Pessoa pessoa) {
		getPessoaRepository().excluir(pessoa);
		listar();
	}

	@Transactional
	public List<Pessoa> listar(){
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas = getPessoaRepository().listar();
		return pessoas;
	}


	public void selecionarRegistro(Pessoa pessoa){
		setPessoa(pessoa);
		this.getPessoa();
	}
	
	public void novoRegistro( ){
		setPessoa(null);
		this.getPessoa();
	}
	
	@Transactional
	public List<Sexo> listarSexos(){
		List<Sexo> sexos = new ArrayList<Sexo>();
		sexos = getSexoRepository().listar();
		return sexos;
	}
	
	@Transactional
	public List<UnidadeFederativa> listarUnidades(){
		List<UnidadeFederativa> unidades = new ArrayList<UnidadeFederativa>();
		unidades = getUnidadeFederativaRepository().listar();
		return unidades;
	}
	
	@Transactional
	public List<Cidade> listarCidades(){
		List<Cidade> cidades = new ArrayList<Cidade>();
		cidades = getCidadeRepository().listar();
		return cidades;
	}
	
	@Transactional
	public List<Bairro> listarBairros(){
		List<Bairro> bairros = new ArrayList<Bairro>();
		bairros = getBairroRepository().listar();
		return bairros;
	}
	
	@Transactional
	public List<TipoLogradouro> listarTipoLogradouros(){
		List<TipoLogradouro> tipoLogradouros = new ArrayList<TipoLogradouro>();
		tipoLogradouros = getTipoLogradouroRepository().listar();
		return tipoLogradouros;
	}

	public PessoaRepository getPessoaRepository() {
		return pessoaRepository;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public SexoRepository getSexoRepository() {
		return sexoRepository;
	}

	public UnidadeFederativaRepository getUnidadeFederativaRepository() {
		return unidadeFederativaRepository;
	}

	public CidadeRepository getCidadeRepository() {
		return cidadeRepository;
	}

	public BairroRepository getBairroRepository() {
		return bairroRepository;
	}

	public TipoLogradouroRepository getTipoLogradouroRepository() {
		return tipoLogradouroRepository;
	}
	
	
	
	
	
}
