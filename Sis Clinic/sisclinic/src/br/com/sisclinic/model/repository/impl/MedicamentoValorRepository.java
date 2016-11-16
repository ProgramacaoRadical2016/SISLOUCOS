package br.com.sisclinic.model.repository.impl;

import java.util.List;

import javax.persistence.Query;

import br.com.sisclinic.model.entities.MedicamentoValor;
import br.com.sisclinic.model.entities.Usuario;
import br.com.sisclinic.model.repository.IMedicamentoValorRepository;
import br.com.sisclinic.model.repository.IProcedimentoRepository;


@SuppressWarnings("serial")
public class MedicamentoValorRepository  extends EntitiesRepository<MedicamentoValor> implements IMedicamentoValorRepository{

	public MedicamentoValorRepository(){
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<MedicamentoValor> listarMedicamentoValor() {
		String sql = "select med from MedicamentoValor med ";
		Query query = entityManager.createQuery(sql);
		
		return (List<MedicamentoValor>) query.getResultList();
		
	}
}
