package dataBaseAccess.users;

import interfaces.DBQuery;
import dataBaseAccess.DBConnect;

public class RegistroDB implements DBQuery {


	public static final String MAIL = "mail";
	
	public static final String PASS = "password";

	public static final String USERS = "users";
	



	public RegistroDB(){
	}
	
	public Boolean registrar(String mail, String pass){
		/**
		 * Se accede a la base de datos mediante una UNICA CONEXION
		 * Esta esta implementada mediante el patron de diseño SINGLETON
		 * 
		 */
		
		DBConnect.getInstance().commandInsert(getUserFromTable(mail, pass));
		Boolean registroOk = true;
		return registroOk;
	}

	@Override
	public String getColumna() {
		// TODO Auto-generated method stub
		return MAIL+" , "+PASS;
	}

	@Override
	public String getCondicion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTabla() {
		// TODO Auto-generated method stub
		return USERS;
	}
	
	/**
	 * Se definen en esta clase todos los comandos que intervengan en el registro de usuarios.
	 * @param mail a insertar
	 * @param pass a insertar
	 * @return
	 */
	private String getUserFromTable(String mail, String pass){
		String query = "INSERT INTO "+this.getTabla()+"(mail,pass)" + " VALUES " +mail+pass;
		return query;
	}

	
	


}
