package br.com.sisclinic.model.repository.impl;

import java.util.List;

import javax.persistence.Query;






import br.com.sisclinic.model.entities.Atendimento;
import br.com.sisclinic.model.entities.Triagem;
import br.com.sisclinic.model.entities.Usuario;
import br.com.sisclinic.model.enums.TipoAtendimento;
import br.com.sisclinic.model.repository.ISexoRepository;


@SuppressWarnings("serial")
public class AtendimentoRepository  extends EntitiesRepository<Atendimento> implements ISexoRepository {

	public AtendimentoRepository(){
	}
	
	
	public Atendimento buscarAtendimentoPorId(Integer idAtendimento ) {
		String sql = "select a from Atendimento a "
				+ " where a.id = :idAtendimento";
		Query query = entityManager.createQuery(sql);
		 query.setParameter("idAtendimento", idAtendimento);
		return (Atendimento)  query.getSingleResult();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Atendimento> listarAtendimentoTriagem() {
		String sql = "select a from Atendimento a "
				+ " where a.tipoAtendimento = :tipoAtendimento "
				+ " OR a.tipoAtendimento = :tipoTriagem";
	
		Query query = entityManager.createQuery(sql);
		 query.setParameter("tipoAtendimento", TipoAtendimento.ATENDIMENTO);
		 query.setParameter("tipoTriagem", TipoAtendimento.TRIAGEM);
		return (List<Atendimento>)  query.getResultList();

	}
	
	
	@SuppressWarnings("unchecked")
	public List<Atendimento> listarAtendimentoConsulta() {
		String sql = "select a from Atendimento a "
				+ " where a.tipoAtendimento = :tipoConsulta ";	
		Query query = entityManager.createQuery(sql);
		 query.setParameter("tipoConsulta", TipoAtendimento.ATENDIMENTO);
		return (List<Atendimento>)  query.getResultList();

	}
}
