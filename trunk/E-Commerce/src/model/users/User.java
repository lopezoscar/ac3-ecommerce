package model.users;

import java.util.ArrayList;

import model.publicacion.Publicacion;
import controller.UserController;

public class User {
	
	UserController userController;
	
	int idUser;
	
	String nombre;
	
	String apellido;
	
	String mail;
	
	String password;
	
	ArrayList<Permiso> permisos;
	
	ArrayList<Publicacion> publicaciones;
	
	
	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(ArrayList<Permiso> permisos) {
		this.permisos = permisos;
	}

	public ArrayList<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	
	
	
	
}

