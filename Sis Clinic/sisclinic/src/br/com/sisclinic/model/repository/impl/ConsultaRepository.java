package br.com.sisclinic.model.repository.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.sisclinic.model.entities.Consulta;
import br.com.sisclinic.model.repository.IConsultaRepository;


@SuppressWarnings("serial")
public class ConsultaRepository  extends EntitiesRepository<Consulta> implements IConsultaRepository {
	
	public ConsultaRepository(){
	}
	
	public Consulta listarConsultaPorAatendimentoId(Integer idAtendimento ) throws Exception {
		try {
			String sql = "select c from Consulta c "
					+ " where c.atendimento.id = :idAtendimento";
			Query query = entityManager.createQuery(sql);
			 query.setParameter("idAtendimento", idAtendimento);
			return (Consulta)  query.getSingleResult();
		} catch( NoResultException e) {
			return new Consulta();
		}
	}
}