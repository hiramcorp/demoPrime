package mx.gob.sat.demo.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import mx.gob.sat.demo.model.Usuario;
import mx.gob.sat.demo.repository.UserRepository;

import org.springframework.stereotype.Repository;

/**
 * 
 * User DAO
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
@Repository
public class UserRepositoryImpl implements UserRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2406423380449340836L;
	protected EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Add User
	 * 
	 * public class UserRepositoryImpl {
	 * 
	 * }
	 * 
	 * @param User
	 *            user
	 */
	@Override
	public void addUser(Usuario user) {
		getEntityManager().persist(user);
	}

	/**
	 * public class UserRepositoryImpl {
	 * 
	 * }
	 * 
	 * Delete User
	 * 
	 * @param User
	 *            user
	 */
	@Override
	public void deleteUser(Usuario user) {
		getEntityManager().remove(user);
	}

	/**
	 * Update User
	 * 
	 * @param User
	 *            user
	 */
	@Override
	public void updateUser(Usuario user) {
		getEntityManager().merge(user);
	}

	/**
	 * Get User
	 * 
	 * @param int User IdUser
	 * @return User
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Usuario getUserById(int id) {
		StringBuilder sb = new StringBuilder();
		sb.append("from Usuario where id=?");
		Query query = getEntityManager().createQuery(sb.toString());
		List list = query.getResultList();
		return (Usuario) list.get(0);
	}

	/**
	 * Get User List
	 * 
	 * @return List - User list
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Usuario> getUsers() {
		StringBuilder sb = new StringBuilder();
		sb.append("from Usuario");
		Query query = getEntityManager().createQuery(sb.toString());
		List list = query.getResultList();
		return list;
	}

}
