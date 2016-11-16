package br.com.sisclinic.model.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.IConvenioService;
import br.com.sisclinic.model.entities.Convenio;
import br.com.sisclinic.model.repository.impl.ConvenioRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;

@Named
@RequestScoped
public class ConvenioService implements IConvenioService{


	@Inject
    private ConvenioRepository repository;
	
    private Convenio convenio;
    
    public ConvenioService() {
		convenio = new Convenio();
	}
    
    @Transactional
  	public void salvarRegistro( Convenio convenio ) {
  		if( convenio.getId() == null) {
  			save();
  		} else {
  			getRepository().alterar(convenio);
  		}
  		listar();
  	}

    
    @Transactional
    public void save() {
    	getRepository().salvar(this.convenio);
        this.convenio = new Convenio();
        listar();
    }
     
    @Transactional
    public void remove(Convenio convenio) {
    	getRepository().excluir(convenio);
    	listar();
    }
        
   @Transactional
    public List<Convenio> listar(){
    	List<Convenio> convenios = new ArrayList<Convenio>();
    	convenios = getRepository().listar();
    	return convenios;
    }
    	
	public ConvenioRepository getRepository() {
		return repository;
	}

	public void selecionarRegistro( Convenio convenio){
		setConvenio(convenio);
		this.getConvenio();
	}
	
	public void novoRegistro( ){
		setConvenio(null);
		this.getConvenio();
	}
	
	public Convenio getConvenio() {
		return convenio;
	}
	
	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
}
