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
	
	private void suscripcion(String mail){
		Connection conexion = DBConnect.getInstance().connect();
		PreparedStatement commandInsert = null;
		String query = "INSERT INTO "+this.getTabla()+"("+this.getColumna()+");"; 
		try{
			if(conexion !=null){
				Statement st = conexion.createStatement();
				st.execute(query);
				//commandInsert = conexion.prepareStatement(query);
			}else{
				System.out.println("Conexion Null");
			}
		}catch(SQLException e){
			
		}
		
		
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