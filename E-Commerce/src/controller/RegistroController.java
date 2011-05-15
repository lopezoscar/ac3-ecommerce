package controller;


import dataBaseAccess.users.RegistroDB;
import exceptions.MailNotFoundException;
import exceptions.PassNotFoundException;


public class RegistroController {

	private String mail;
	private String pass;



	public RegistroController(String mail,String pass){
		this.mail = mail;
		this.pass = pass;
		
	}

	public void registrar(String mail,String pass) throws MailNotFoundException,PassNotFoundException{
		if(mail == null){
			new MailNotFoundException();
		}
		if(pass == null){
			new PassNotFoundException();
		}else{
			String[] valores = {mail,pass};
			/**
			 * RegistroDB en su metodo registrar recibe los valores que insertara en la Base de Datos
			 */
			RegistroDB registroDB = new RegistroDB();
			registroDB.registrar(valores);
		}
		
		
	}






}
