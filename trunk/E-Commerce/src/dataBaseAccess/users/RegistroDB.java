package dataBaseAccess.users;

import interfaces.DBQuery;
import dataBaseAccess.DBConnect;

public class RegistroDB implements DBQuery {

//	public static final String NOMBRE = "nombre";
//
//	public static final String APELLIDO = "apellido";

	public static final String MAIL = "mail";
	
	public static final String PASS = "password";

	public static final String USERS = "users";
	



	public RegistroDB(){
	}
	
	public String registrar(String[] valores){
		/**
		 * Se accede a la base de datos mediante una UNICA CONEXION
		 * Esta esta implementada mediante el patron de diseño SINGLETON
		 * 
		 * El paramatro this, se refiere a esta clase dado que al realizar 
		 * la ejecucion del comando, el metodo commandInsert debe conocer
		 * la Tabla y los campos al cual debe insertar los datos.
		 * 
		 * Valores es el array con los datos a insertar
		 * en este caso son Mail y Pass
		 */
		DBConnect.getInstance().commandInsert(this, valores);
		String fin = "Registro Exitoso";
		return fin;
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

	
	


}
