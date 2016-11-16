package br.com.sisclinic.model.repository.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import sun.security.util.PropertyExpander.ExpandException;
import br.com.sisclinic.model.entities.Triagem;
import br.com.sisclinic.model.repository.IPessoaRepository;


@SuppressWarnings("serial")
public class TriagemRepositoy extends EntitiesRepository<Triagem> implements IPessoaRepository {

	public TriagemRepositoy(){
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Triagem listarTriagemPorIdAatendimento(Integer idAtendimento ) throws Exception {
		try {
			String sql = "select t from Triagem t "
					+ " where t.atendimento.id = :idAtendimento";
		
			Query query = entityManager.createQuery(sql);
			 query.setParameter("idAtendimento", idAtendimento);
			return (Triagem)  query.getSingleResult();
		} catch( NoResultException e) {
			return new Triagem();
		}
	}
}
