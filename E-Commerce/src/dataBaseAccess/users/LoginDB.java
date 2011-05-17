package dataBaseAccess.users;

import interfaces.DBQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

import controller.LoginVO;
import dataBaseAccess.DBConnect;

public class LoginDB implements DBQuery {
	
	public static final String MAIL = "mail";
	
	public static final String PASS = "password";
	
	public static final String USERS = "users";
	
	
	public LoginDB(){
		
	}
	
	public LoginVO getUser(){
		ResultSet rs = DBConnect.getInstance().commandSelect(this);
		LoginVO loginVo = null;
		try {
			while(rs.next()){
				loginVo = new LoginVO();
				loginVo.setMail(rs.getString(MAIL));
				loginVo.setPass(rs.getString(PASS));
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

}
