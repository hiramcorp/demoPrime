package mx.gob.sat.demo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import mx.gob.sat.demo.model.Usuario;
import mx.gob.sat.demo.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@ManagedBean(name="usuarioBeanController")

@Scope("request")
public class UsuarioBeanController implements Serializable {
	
	Logger log = Logger.getLogger(UsuarioBeanController.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	@ManagedProperty(value = "#{UserService}")
	UserService userService;

	List<Usuario> userList;

	private Usuario usuario;

	
	public void addUser(ActionEvent actionEvent) {
		log.debug("mandando a llamar el actionEvent");
			getUserService().addUser(getUsuario());
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage("agregado "
							+ getUsuario().getNombreUsuario() + " "
							+ getUsuario().getApellidoPat() + "!"));
			setUsuario(new Usuario());

	}

	/**
	 * IUserService Reset Fields UsuarioSer
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
	 * @param IUserService
	 *            - User Service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Set User List
	 * 
	 * @param List
	 *            - User List
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
	
	@PostConstruct
    public void cargar() {
		log.debug("Cargando usuarios");
		userList = new ArrayList<Usuario>();
		userList.addAll(getUserService().getUsers());
		setUsuario(new Usuario());
    }   
}
