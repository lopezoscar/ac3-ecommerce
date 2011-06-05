package controller;

import model.users.User;
import dataBaseAccess.users.LoginDB;
import exceptions.DBConnectException;
import exceptions.LoginException;

public class LoginController {
	
	
	public LoginController(){
		
	}
	
	public int login(String mail, String password){
		LoginDB loginDB = new LoginDB();
		LoginVO loginVo = null;
		try {
			loginVo = loginDB.getUser(mail,password);
		} catch (DBConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			boolean loginOk = false;
		if(mail.equals(loginVo.getMail()) && password.equals(loginVo.getPass())){
			
			User user = new User();
			user.setMail(loginVo.getMail());
			user.setPassword(loginVo.getPass());
			loginOk = true;
		}else{
			new LoginException();
			loginOk =  false;
			
		}
		
		return loginVo.getPkLogin();
		
	}

}
