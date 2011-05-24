package controller;

import dataBaseAccess.SuscripcionDB;

public class SuscripcionController {
	
	String mail;
	
	public SuscripcionController(String mail){
		this.mail = mail;
	}
	
	
	private boolean suscripcion(){
		boolean enLista = false;
		
		SuscripcionDB suscripcionDB = new SuscripcionDB();
		
		return enLista;
	}
	

}
