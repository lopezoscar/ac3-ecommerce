package dataBaseAccess;

import interfaces.DBQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SuscripcionDB implements DBQuery {
	
	private static String TABLE = "suscripciones";
	
	private static String ID_MAIL = "id_mail";
	
	private static String MAIL = "mail";
	
	public boolean suscripcion(String mail){
		boolean isConnect = false;
		Connection conexion = DBConnect.getInstance().connect();
		PreparedStatement commandInsert = null;
		
		
		
//		String query = "INSERT INTO "+this.getTabla()+"("+this.getColumna()+") values ("+"2"+mail+");"; 
//		String queryTest = "INSERT INTO SUSCRIPCIONES (id_mail,mail)values(1,'lopezoscar.job@gmail.com');";
		
		String queryPreparedStatement = "INSERT INTO SUSCRIPCIONES VALUES (?)";
		
		try{
			if(conexion !=null){
				commandInsert = conexion.prepareStatement(queryPreparedStatement);
				commandInsert.setString(1, mail);
				
				commandInsert.executeUpdate();
				
				
				//Statement st = conexion.createStatement();
				//st.execute(queryTest);
				isConnect = true;
				//commandInsert = conexion.prepareStatement(query);
			}else{
				isConnect = false;
				System.out.println("Conexion Null");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		return isConnect;
	}

	@Override
	public String getColumna() {
		// TODO Auto-generated method stub
		return ID_MAIL+" , "+MAIL;
	}
	
	

	@Override
	public String getCondicion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTabla() {
		// TODO Auto-generated method stub
		return TABLE;
	}

}
