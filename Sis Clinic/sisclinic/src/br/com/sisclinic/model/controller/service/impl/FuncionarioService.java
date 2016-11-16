package br.com.sisclinic.model.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.sisclinic.model.controller.service.IFuncionarioService;
import br.com.sisclinic.model.entities.Funcionario;
import br.com.sisclinic.model.repository.impl.FuncionarioRepository;
import br.com.sisclinic.utilitarios.jpa.Transactional;

public class FuncionarioService  implements IFuncionarioService {

	@Inject
	private FuncionarioRepository  funcionarioRepository;

	private Funcionario funcionario;

	public FuncionarioService() {
		funcionario = new Funcionario();
	}
	
	@Transactional
	public void salvarRegistro( Funcionario funcionario ) {
		if( funcionario.getId() == null) {
			save();
		} else {
			getFuncionarioRepository().alterar(funcionario);
		}
		listar();
	}
    

	@Transactional
	public void save() {
		getFuncionarioRepository().salvar(this.funcionario);
		this.funcionario = new Funcionario();
		listar();
	}

	@Transactional
	public void remove(Funcionario funcionario) {
		getFuncionarioRepository().excluir(funcionario);
		listar();
	}

	@Transactional
	public List<Funcionario> listar(){
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		funcionarios = getFuncionarioRepository().listar();
		return funcionarios;
	}


	public void selecionarRegistro( Funcionario funcionario  ){
		
	}
	
	public FuncionarioRepository getFuncionarioRepository() {
		return funcionarioRepository;
	}

	public void setFuncionarioRepository(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void novoRegistro( ){
		setFuncionario(null);
		this.getFuncionario();
	}
}
