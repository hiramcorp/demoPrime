package mx.gob.sat.demo.service;

import java.util.List;

import mx.gob.sat.demo.model.Usuario;

/**
 *
 * User Service Interface
 *
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
public interface UserService {

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
  * @return List - User list
  */
 public List<Usuario> getUsers();
}
