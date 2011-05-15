package controller;

import dataBaseAccess.BrowserDB;

public class BrowserController {
	
	String busqueda;
	
	public BrowserController(String busqueda){
		this.busqueda = busqueda;
	}
	
	public void buscarProducto(){
		BrowserDB browserDB = new BrowserDB();
		browserDB.buscar(busqueda);
		
	}

}
