package controller;

import java.sql.ResultSet;

import dataBaseAccess.BrowserDB;

public class BrowserController {
	
	String busqueda;
	
	public BrowserController(String busqueda){
		this.busqueda = busqueda;
	}
	
	public ResultSet buscarProducto(){
		BrowserDB browserDB = new BrowserDB();
		ResultSet rs = browserDB.buscar(busqueda);

		return rs;
	}

}
