package br.com.sisclinic.model.repository.impl;

import java.util.List;

import javax.persistence.Query;

import br.com.sisclinic.model.entities.ProcedimentoValor;
import br.com.sisclinic.model.repository.IProcedimentoRepository;
	
@SuppressWarnings("serial")
public class ProcedimentoValorRepository  extends EntitiesRepository<ProcedimentoValor> implements IProcedimentoRepository{

	public ProcedimentoValorRepository(){
	}
		
	@SuppressWarnings("unchecked")
	public List<ProcedimentoValor> listarProcedimentoValor() {
		String sql = "select pv from ProcedimentoValor pv ";
		Query query = entityManager.createQuery(sql);
		
		return (List<ProcedimentoValor>) query.getResultList();
		
	}
}
