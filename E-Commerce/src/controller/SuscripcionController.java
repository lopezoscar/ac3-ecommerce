package controller;

import dataBaseAccess.SuscripcionDB;

public class SuscripcionController {
	
	String mail;
	
	public SuscripcionController(String mail){
		this.mail = mail;
	}
	
	
	public boolean suscripcion(){
		
		SuscripcionDB suscripcionDB = new SuscripcionDB();
		boolean suscriptoOk = suscripcionDB.suscripcion(mail);
		
		return suscriptoOk;
	}
	

}
