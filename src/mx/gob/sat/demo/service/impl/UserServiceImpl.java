package mx.gob.sat.demo.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.gob.sat.demo.model.Usuario;
import mx.gob.sat.demo.repository.UserRepository;
import mx.gob.sat.demo.service.UserService;


@Service
public class UserServiceImpl implements UserService, Serializable {

 /**
	 * 
	 */
	private static final long serialVersionUID = 2731292864682617023L;
@Autowired
 UserRepository userRepository;
 
 public UserRepository getUserRepository() {
	return userRepository;
 }

 /**
  * Add User
  *
  * @param  User user
  */
 @Transactional(readOnly = false)
 @Override
 public void addUser(Usuario user) {
	 getUserRepository().addUser(user);
 }

 /**
  * Delete User
  *
  * @param  User user
  */
 @Transactional(readOnly = false)
 @Override
 public void deleteUser(Usuario user) {
	 getUserRepository().deleteUser(user);
 }

 /**
  * Update User
  *
  * @param  User user
  */
 @Transactional(readOnly = false)
 @Override
 public void updateUser(Usuario user) {
	 getUserRepository().updateUser(user);
 }

 /**
  * Get User
  *
  * @param  int User Id
  */
 @Override
 public Usuario getUserById(int id) {
  return getUserRepository().getUserById(id);
 }

 /**
  * Get User List
  *
  */
 @Override
 public List<Usuario> getUsers() {
  return getUserRepository().getUsers();
 }

}
