package controller;

import model.publicacion.Publicacion;
import dataBaseAccess.publicacion.PublicacionDB;

public class PublicacionController {
	
	Publicacion publicacion;
	
	
	
	
	public PublicacionController(){
		publicacion = new Publicacion();
		
	}
	
	
	public void publicar(){
		PublicacionDB publicacionDB = new PublicacionDB();
		publicacionDB.publicar(publicacion);
		
		
		
	}
	
	
	public Publicacion getPublicacion(){
		return publicacion;
	}

}
