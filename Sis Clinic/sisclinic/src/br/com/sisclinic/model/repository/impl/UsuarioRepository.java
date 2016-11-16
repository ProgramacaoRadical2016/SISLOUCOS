package br.com.sisclinic.model.repository.impl;

import javax.persistence.Query;

import br.com.sisclinic.model.entities.Pessoa;
import br.com.sisclinic.model.entities.Usuario;
import br.com.sisclinic.model.repository.IUsuarioRepository;

@SuppressWarnings("serial")
public class UsuarioRepository extends EntitiesRepository<Usuario> implements IUsuarioRepository {
		
	public UsuarioRepository(){
		
	}
	
	public Usuario buscarUsuario( String login, String senha ) {
		String sql = "select u from Usuario u "
				+ " where u.login = :login AND u.senha = :senha ";
		Query query = entityManager.createQuery(sql);
		 query.setParameter("login", login);
		 query.setParameter("senha", senha);
		return (Usuario) query.getSingleResult();
		
	}
	
	public Usuario buscarUltimoUsuarioSalvo() {
		String sql = "select u from Usuario u order by u.id desc limit 1 ";
		Query query = entityManager.createQuery(sql);
		query.setMaxResults(1);
		return (Usuario) query.getSingleResult();

	}

}
