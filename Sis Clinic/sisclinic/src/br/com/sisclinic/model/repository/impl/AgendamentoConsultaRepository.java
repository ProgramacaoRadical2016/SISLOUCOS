package br.com.sisclinic.model.repository.impl;

import javax.persistence.Query;

import br.com.sisclinic.model.entities.AgendamentoConsulta;
import br.com.sisclinic.model.repository.IAgendamentoConsultaRepository;


@SuppressWarnings("serial")
public class AgendamentoConsultaRepository  extends EntitiesRepository<AgendamentoConsulta> implements IAgendamentoConsultaRepository {

	public AgendamentoConsultaRepository(){
	}
	
	
	public AgendamentoConsulta buscarAtendimentoPorId(Integer idAgendamento ) {
		String sql = "select ac from AgendamentoConsulta ac "
				+ " where ac.id = :idAgendamento";	
		Query query = entityManager.createQuery(sql);
		 query.setParameter("idAgendamento", idAgendamento);
		return (AgendamentoConsulta)  query.getSingleResult();
	}
}