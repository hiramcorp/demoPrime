package mx.gob.sat.demo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import mx.gob.sat.demo.model.Usuario;
import mx.gob.sat.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class UsuarioBeanController implements Serializable{

	

	 private static final long serialVersionUID = 1L;
	 private static final String SUCCESS = "success";
	 private static final String ERROR   = "error";

	 
	 @Autowired
	 @ManagedProperty(value="#{UserService}")
	 UserService userService;

	 List<Usuario> userList;

	 private Usuario usuario;

	 /**
	  * Add User
	  *
	  * @return String - Response Message
	  */
	 public String addUser() {
	  try {
		  getUserService().addUser(getUsuario());
	   return SUCCESS;
	  } catch (DataAccessException e) {
	   e.printStackTrace();
	  }  

	  return ERROR;
	 }

	 /**IUserService
	  * Reset Fields
	  *UsuarioSer
	  */
	 public void reset() {
	  this.getUsuario().setNombreUsuario("");
	  this.getUsuario().setApellidoMat("");
	  this.getUsuario().setApellidoPat("");
	 }

	 /**
	  * Get User List
	  *
	  * @return List - User List
	  */
	 
	 
	 public List<Usuario> getUserList() {
	  userList = new ArrayList<Usuario>();
	  userList.addAll(getUserService().getUsers());
	  return userList;
	 }

	 /**
	  * Get User Service
	  *
	  * @return IUserService - User Service
	  */
	 public UserService getUserService() {
	  return userService;
	 }

	 /**
	  * Set User Service
	  *
	  * @param IUserService - User Service
	  */
	 public void setUserService(UserService userService) {
	  this.userService = userService;
	 }

	 /**
	  * Set User List
	  *
	  * @param List - User List
	  */
	 public void setUserList(List<Usuario> userList) {
	  this.userList = userList;
	 }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
