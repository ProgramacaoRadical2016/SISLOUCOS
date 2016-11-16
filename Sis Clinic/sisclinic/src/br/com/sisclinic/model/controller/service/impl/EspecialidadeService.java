package br.com.sisclinic.model.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.IEspecialidadeService;
import br.com.sisclinic.model.entities.Especialidade;
import br.com.sisclinic.model.repository.impl.EspecialidadeRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;

@Named
@RequestScoped
public class EspecialidadeService  implements IEspecialidadeService{ 

	

	@Inject
	private EspecialidadeRepository  especialidadeRepository;
	
	private Especialidade especialidade;


	public EspecialidadeService() {
		especialidade = new Especialidade();
	}
	
	
	@Transactional
	public void salvarRegistro(Especialidade especialidade ) {
		if( especialidade.getId() == null) {
			save();
		} else {
			getEspecialidadeRepository().alterar(especialidade);
		}
		listar();
	}

	@Transactional
	public void save() {
		getEspecialidadeRepository().salvar(this.especialidade);
		this.especialidade = new Especialidade();
		listar();
	}

	@Transactional
	public void remove(Especialidade especialidade) {
		getEspecialidadeRepository().excluir(especialidade);
		listar();
	}

	@Transactional
	public List<Especialidade> listar(){
		List<Especialidade> especialidades = new ArrayList<Especialidade>();
		especialidades = getEspecialidadeRepository().listar();
		return especialidades;
	}
	
	public void novoRegistro(){
		setEspecialidade(null);
		this.getEspecialidade();
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}


	public void selecionarRegistro( Especialidade especialidade ){
		setEspecialidade(especialidade);
		this.getEspecialidade();
	}
		
	public EspecialidadeRepository getEspecialidadeRepository() {
		return especialidadeRepository;
	}


}
