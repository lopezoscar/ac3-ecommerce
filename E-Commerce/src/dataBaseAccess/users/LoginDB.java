package dataBaseAccess.users;

import interfaces.DBQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.LoginVO;
import dataBaseAccess.DBConnect;
import exceptions.DBConnectException;

public class LoginDB implements DBQuery {
	
	public static final String MAIL = "mail";
	
	public static final String PASS = "password";
	
	public static final String USERS = "users";
	
	
	public LoginDB(){
		
	}
	
	public LoginVO getUser() throws DBConnectException{
	
		//ResultSet rs = DBConnect.getInstance().commandSelect(getUserFromTable());
		Connection conexion = DBConnect.getInstance().connect();
		PreparedStatement preparedStatement = null;
		LoginVO loginVo = null;
		try {
			String query = "SELECT * FROM "+this.getTabla();
			if(conexion!=null){
				Statement stmt = conexion.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				//ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()){
					loginVo = new LoginVO();
					loginVo.setMail(rs.getString(MAIL));
					loginVo.setPass(rs.getString(PASS));
				}
			}else{
				throw new DBConnectException();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginVo;
		

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
	
	private String getUserFromTable(){
		String query = "SELECT "+this.getColumna()+" FROM "+this.getTabla();
		return query;
	}
	
	
	
	

}
