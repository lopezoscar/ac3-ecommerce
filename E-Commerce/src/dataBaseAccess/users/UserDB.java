package dataBaseAccess.users;

import interfaces.DBQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.users.User;
import dataBaseAccess.DBConnect;

public class UserDB implements DBQuery {
	
	public static final String USER_ID = "id";
	
	public static final String NOMBRE = "nombre";
	
	public static final String APELLIDO = "apellido";
	
	public static final String MAIL = "mail";
	
	public static final String USERS = "users";
	
	public UserDB(){
		 
	}
	
	public User getData(){
		ResultSet rs = DBConnect.getInstance().commandSelect(this);
		
		User user = null;
		try {
			while(rs.next()){
				user = new User();
				user.setIdUser(rs.getInt(USER_ID));
				user.setNombre(rs.getString(NOMBRE));
				user.setApellido(rs.getString(APELLIDO));
				user.setMail(rs.getString(MAIL));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public void insertData(){
		String []values = {"",""};
		DBConnect.getInstance().commandInsert(this,values );
	}
	
	public String getColumna() {	
		return USER_ID +", "+ NOMBRE+", "+APELLIDO+","+MAIL;
	}

	public String getCondicion() {	
		return null;
	}
	
	public String getTabla() {
		return USERS;
	}

}
