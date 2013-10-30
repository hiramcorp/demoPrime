package mx.gob.sat.demo.repository;

import java.util.List;

import mx.gob.sat.demo.model.Usuario;

/**
 *
 * User DAO Interface
 *
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
public interface UserRepository {

 /**
  * Add User
  *
  * @param  User user
  */
 public void addUser(Usuario user);

 /**
  * Update User
  *
  * @param  User user
  */
 public void updateUser(Usuario user);

 /**
  * Delete User
  *
  * @param  User user
  */
 public void deleteUser(Usuario user);

 /**
  * Get User
  *
  * @param  int User Id
  */
 public Usuario getUserById(int id);

 /**
  * Get User List
  *
  */
 public List<Usuario> getUsers();
}
