package br.com.sisclinic.model.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sisclinic.model.controller.service.IMedicamentoService;
import br.com.sisclinic.model.entities.Medicamento;
import br.com.sisclinic.model.repository.impl.MedicamentoRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;

@Named
@RequestScoped
public class MedicamentoService implements IMedicamentoService {

	@Inject
	private MedicamentoRepository  medicamentoRepository;

	private Medicamento medicamento;

	public MedicamentoService() {
		medicamento = new Medicamento();
	}
	
	@Transactional
	public void salvarRegistro(Medicamento medicamento ) {
		if( medicamento.getId() == null) {
			save();
		} else {
			getMedicamentoRepository().alterar(medicamento);
		}
		listar();
	}
    

	@Transactional
	public void save() {
		getMedicamentoRepository().salvar(this.medicamento);
		this.medicamento = new Medicamento();
		listar();
	}

	@Transactional
	public void remove(Medicamento medicamento) {
		getMedicamentoRepository().excluir(medicamento);
		listar();
	}

	@Transactional
	public List<Medicamento> listar(){
		List<Medicamento> medicamentos = new ArrayList<Medicamento>();
		medicamentos = getMedicamentoRepository().listar();
		return medicamentos;
	}

	public MedicamentoRepository getMedicamentoRepository() {
		return medicamentoRepository;
	}

	public void setMedicamentoRepository(MedicamentoRepository medicamentoRepository) {
		this.medicamentoRepository = medicamentoRepository;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public void selecionarRegistro( Medicamento medicamento ){
		
	}
	
	public void novoRegistro( ){
		setMedicamento(null);
		this.getMedicamento();
	}
}
