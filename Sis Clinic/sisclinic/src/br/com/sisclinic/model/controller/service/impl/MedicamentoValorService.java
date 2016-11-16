package br.com.sisclinic.model.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.IMedicamentoValorService;
import br.com.sisclinic.model.entities.MedicamentoValor;
import br.com.sisclinic.model.repository.impl.MedicamentoValorRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;


@Named
@RequestScoped
public class MedicamentoValorService implements IMedicamentoValorService {

	@Inject
	private MedicamentoValorRepository  medicamentoValorRepository;

	private MedicamentoValor medicamentoValor;

	public MedicamentoValorService() {
		medicamentoValor = new MedicamentoValor();
	}
	
	@Transactional
	public void salvarRegistro( MedicamentoValor medicamentoValor ) {
		if( medicamentoValor.getId() == null || medicamentoValor.getId() == 0  ) {
			save();
		} else {
			getMedicamentoValorRepository().alterar(medicamentoValor);
		}
		listar();
	}
    

	@Transactional
	public void save() {
		getMedicamentoValorRepository().salvar(this.medicamentoValor);
		this.medicamentoValor = new MedicamentoValor();
		listar();
	}

	@Transactional
	public void remove(MedicamentoValor medicamentoValor) {
		getMedicamentoValorRepository().excluir(medicamentoValor);
		listar();
	}

	@Transactional
	public List<MedicamentoValor> listar(){
		List<MedicamentoValor> medicamentoValors = new ArrayList<MedicamentoValor>();
		medicamentoValors = getMedicamentoValorRepository().listar();
		return medicamentoValors;
	}

	public MedicamentoValorRepository getMedicamentoValorRepository() {
		return medicamentoValorRepository;
	}

	public void setMedicamentoValorRepository(MedicamentoValorRepository medicamentoValorRepository) {
		this.medicamentoValorRepository = medicamentoValorRepository;
	}

	public MedicamentoValor getMedicamentoValor() {
		return medicamentoValor;
	}

	public void setMedicamentoValor(MedicamentoValor medicamentoValor) {
		this.medicamentoValor = medicamentoValor;
	}

	public void selecionarRegistro( MedicamentoValor medicamentoValor ){
		
	}
	
	public void novoRegistro( ){
		setMedicamentoValor(null);
		this.getMedicamentoValor();
	}
}
