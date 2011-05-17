package dataBaseAccess;

import interfaces.DBQuery;

public class BrowserDB implements DBQuery {
	
	public static final String TAG = "TAG";
	
	public static final String TAGTABLE = "TAGS";
	
	
	public String buscar(String busqueda){
		DBConnect.getInstance().commandSelect(this);
		String fin = "busqueda exitosa";
		return fin;
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
