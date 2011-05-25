package controller;

import model.users.User;
import dataBaseAccess.users.LoginDB;
import exceptions.DBConnectException;
import exceptions.LoginException;

public class LoginController {
	
	
	public LoginController(){
		
	}
	
	public boolean login(String mail, String password){
		LoginDB loginDB = new LoginDB();
		LoginVO loginVo = null;
		try {
			loginVo = loginDB.getUser(mail,password);
		} catch (DBConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(mail.equals(loginVo.getMail()) && password.equals(loginVo.getPass())){
			User user = new User();
			user.setMail(loginVo.getMail());
			user.setPassword(loginVo.getPass());
			return true;
		}else{
			new LoginException();
			return false;
			
		}
	}

}
