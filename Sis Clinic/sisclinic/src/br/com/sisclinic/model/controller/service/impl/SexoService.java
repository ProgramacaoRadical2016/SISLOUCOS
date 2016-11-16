package br.com.sisclinic.model.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.ISexoService;
import br.com.sisclinic.model.entities.Sexo;
import br.com.sisclinic.model.repository.impl.SexoRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;

@Named
@RequestScoped
public class SexoService implements ISexoService  {

	@Inject
	private SexoRepository  sexoRepository;

	private Sexo sexo;

	public SexoService() {
		sexo = new Sexo();
	}
	
	@Transactional
	public void salvarRegistro( Sexo sexo ) {
		if( sexo.getId() == null) {
			save();
		} else {
			getSexoRepository().alterar(sexo);
		}
		listar();
	}
    

	@Transactional
	public void save() {
		getSexoRepository().salvar(this.sexo);
		this.sexo = new Sexo();
		listar();
	}

	@Transactional
	public void remove(Sexo sexo) {
		getSexoRepository().excluir(sexo);
		listar();
	}

	@Transactional
	public List<Sexo> listar(){
		List<Sexo> sexos = new ArrayList<Sexo>();
		sexos = getSexoRepository().listar();
		return sexos;
	}

	public SexoRepository getSexoRepository() {
		return sexoRepository;
	}

	public void setSexoRepository(SexoRepository sexoRepository) {
		this.sexoRepository = sexoRepository;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public void selecionarRegistro( Sexo sexo ){
		
	}
	
	public void novoRegistro( ){
		setSexo(null);
		this.getSexo();
	}
}
