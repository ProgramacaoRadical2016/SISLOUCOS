package br.com.sisclinic.model.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.ITipoLogradouroService;
import br.com.sisclinic.model.entities.TipoLogradouro;
import br.com.sisclinic.model.repository.impl.TipoLogradouroRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;

@Named
@RequestScoped
public class TipoLogradouroService implements ITipoLogradouroService {

	@Inject
    private TipoLogradouroRepository  tipoLogradouroRepository;
	
    private TipoLogradouro tipoLogradouro;
    
    public TipoLogradouroService() {
    	tipoLogradouro = new TipoLogradouro();
    }
    
    @Transactional
    public void salvarRegistro( TipoLogradouro tipoLogradouro ) {
    	if( tipoLogradouro.getId() == null) {
    		save();
    	} else {
    		getTipoLogradouroRepository().alterar(tipoLogradouro);
    	}
    	listar();
    }
    
	@Transactional
	public void save() {
		getTipoLogradouroRepository().salvar(this.tipoLogradouro);
		this.tipoLogradouro = new TipoLogradouro();
	}
	
	public void novoRegistro(){
		setTipoLogradouro(null);
		this.getTipoLogradouro();
	}
	

	@Transactional
	public void remove(TipoLogradouro tipoLogradouro) {
		getTipoLogradouroRepository().excluir(tipoLogradouro);
		listar();
	}

	@Transactional
	public List<TipoLogradouro> listar(){
		List<TipoLogradouro> tipoLogradouros = new ArrayList<TipoLogradouro>();
		tipoLogradouros = getTipoLogradouroRepository().listar();
		return tipoLogradouros;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public TipoLogradouroRepository getTipoLogradouroRepository() {
		return tipoLogradouroRepository;
	}

	public void selecionarRegistro( TipoLogradouro tipoLogradouro ){
		setTipoLogradouro(tipoLogradouro);
		this.getTipoLogradouro();
	}
    
}
