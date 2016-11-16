package br.com.sisclinic.model.repository.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.sisclinic.model.entities.Triagem;
import br.com.sisclinic.model.entities.TriagemMedicamento;
import br.com.sisclinic.model.repository.ITriagemMedicamentoRepository;


@SuppressWarnings("serial")
public class TriagemMedicamentoRepository extends EntitiesRepository<TriagemMedicamento> implements ITriagemMedicamentoRepository {

	public TriagemMedicamentoRepository(){
	}
	
	@SuppressWarnings("unchecked")
	public List<TriagemMedicamento> listarTriagemMedicamento(){
		String sql = "select tp from TriagemMedicamento tp ";
		Query query = entityManager.createQuery(sql);
		return (List<TriagemMedicamento>) query.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<TriagemMedicamento> listarTriagemMedicamento( Triagem triagem ){
		try {
			String sql = "select tp from TriagemMedicamento tp"
					+ " where  tp.triagem.id = :idTriagem";
			Query query = entityManager.createQuery(sql);
			query.setParameter("idTriagem", triagem.getId());
			return (List<TriagemMedicamento>) query.getResultList();
		} catch (NoResultException e ) {
			return null;
		}
	}
}
