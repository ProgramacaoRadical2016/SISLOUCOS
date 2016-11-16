package br.com.sisclinic.model.repository.impl;

import javax.persistence.Query;

import br.com.sisclinic.model.entities.Pessoa;
import br.com.sisclinic.model.entities.Usuario;
import br.com.sisclinic.model.repository.IPessoaRepository;

@SuppressWarnings("serial")
public class PessoaRepository extends EntitiesRepository<Pessoa> implements IPessoaRepository {

	public PessoaRepository(){
	}
	

	public Pessoa buscarUltimaPessoaSalva() {
		String sql = "select p from Pessoa p order by p.id desc limit 1 ";
		Query query = entityManager.createQuery(sql);
		query.setMaxResults(1);
		return (Pessoa) query.getSingleResult();

	}
}
