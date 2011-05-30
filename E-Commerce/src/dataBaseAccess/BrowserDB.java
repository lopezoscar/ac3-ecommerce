package dataBaseAccess;

import interfaces.DBQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BrowserDB implements DBQuery {
	
	public static final String TAG = "TAG";
	
	public static final String TAGTABLE = "TAGS";
	
	
	public ResultSet buscar(String busqueda){
		ResultSet rs = null;
		Connection conexion = DBConnect.getInstance().connect();
		
		String query = "SELECT * FROM publicaciones WHERE categoria = ?";
		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, busqueda);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}
	

	@Override
	public String getColumna() {
		// TODO Auto-generated method stub
		return TAG;
	}

	@Override
	public String getCondicion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTabla() {
		// TODO Auto-generated method stub
		return TAGTABLE;
	}

}
