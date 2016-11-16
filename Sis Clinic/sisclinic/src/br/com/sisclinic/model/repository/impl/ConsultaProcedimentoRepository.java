package br.com.sisclinic.model.repository.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.sisclinic.model.entities.Consulta;
import br.com.sisclinic.model.entities.ConsultaProcedimento;
import br.com.sisclinic.model.entities.Triagem;
import br.com.sisclinic.model.entities.TriagemMedicamento;
import br.com.sisclinic.model.repository.IConsultaProcedimentoRepository;


@SuppressWarnings("serial")
public class ConsultaProcedimentoRepository extends EntitiesRepository<ConsultaProcedimento> implements IConsultaProcedimentoRepository {

	public ConsultaProcedimentoRepository(){
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ConsultaProcedimento> listarConsultaProcedimento(){
		String sql = "select cp from ConsultaProcedimento cp ";
		Query query = entityManager.createQuery(sql);
		return (List<ConsultaProcedimento>) query.getResultList();
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<ConsultaProcedimento> listarConsultaProcedimento( Consulta consulta ){
		try {
			String sql = "select cp from ConsultaProcedimento cp "
					+ " where  cp.consulta.id = :idConsulta";
			Query query = entityManager.createQuery(sql);
			query.setParameter("idConsulta", consulta.getId());
			return (List<ConsultaProcedimento>) query.getResultList();
		} catch (NoResultException e ) {
			return null;
		}
	}
}