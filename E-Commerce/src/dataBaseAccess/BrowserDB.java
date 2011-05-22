package dataBaseAccess;

import interfaces.DBQuery;

import java.sql.ResultSet;

public class BrowserDB implements DBQuery {
	
	public static final String TAG = "TAG";
	
	public static final String TAGTABLE = "TAGS";
	
	
	public ResultSet buscar(String busqueda){
		ResultSet result = DBConnect.getInstance().commandSelect(this);
		//String fin = "busqueda exitosa";
		return result;
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
