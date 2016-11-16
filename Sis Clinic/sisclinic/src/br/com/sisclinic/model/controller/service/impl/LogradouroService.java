package br.com.sisclinic.model.controller.service.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.ILogradouroService;
import br.com.sisclinic.model.entities.Logradouro;
import br.com.sisclinic.model.repository.impl.LogradouroRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;

@Named
@RequestScoped
public class LogradouroService implements ILogradouroService{

	@Inject
    private LogradouroRepository  logradouroRepository;
	
    private Logradouro logradouro;
    
    public LogradouroService() {
    	logradouro = new Logradouro();
    }
    
    @Transactional
    public void save() {
    	getLogradouroRepository().salvar(this.logradouro);
        this.logradouro = new Logradouro();
    }
     
    public void remove(Logradouro logradouro) {
    }

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public LogradouroRepository getLogradouroRepository() {
		return logradouroRepository;
	}
}
