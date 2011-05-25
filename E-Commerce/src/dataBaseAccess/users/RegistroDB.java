package dataBaseAccess.users;

import interfaces.DBQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dataBaseAccess.DBConnect;
import exceptions.DBConnectException;


public class RegistroDB implements DBQuery {


	public static final String MAIL = "mail";
	
	public static final String PASS = "password";

	public static final String USERS = "DBO.users";
	



	public RegistroDB(){
	}
	
	public Boolean registrar(String mail, String pass){
		/**
		 * Se accede a la base de datos mediante una UNICA CONEXION
		 * Esta esta implementada mediante el patron de diseño SINGLETON
		 * 
		 */
		
		//DBConnect.getInstance().commandInsert(getUserFromTable(mail, pass));
		int clavePrimaria = 0;
		try {
			clavePrimaria = statementInsert(mail, pass);
		} catch (DBConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(clavePrimaria);
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

	
	public int statementInsert(String mail, String pass) throws DBConnectException{
		Connection conexion = DBConnect.getInstance().connect();
		//INSERT INTO users (id_user,mail,pass) values (1,'lopezoscar.job@gmail.com','36175080');
		//String query = "INSERT INTO users (id_user,mail,pass) values (2,"+"'"+mail+"',"+"'"+pass+"'"+")";
		
		int pk = 0;
		try {
//			Statement prueba = conexion.createStatement();
//			prueba.execute(query);
			
			if(conexion !=null){
				PreparedStatement preparedStatement = conexion.prepareStatement("INSERT INTO users(mail,pass) values (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, mail);
				preparedStatement.setString(2, pass);
				
				preparedStatement.executeUpdate();
				
				ResultSet rs = preparedStatement.getGeneratedKeys();
				
				while(rs.next()){
					pk = rs.getInt(1);
					System.out.println(rs.getInt(1));
				}
			}else{
				throw new DBConnectException();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pk;
		
	}


}
