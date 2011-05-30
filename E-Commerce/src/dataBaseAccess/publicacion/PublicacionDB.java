package dataBaseAccess.publicacion;

import interfaces.DBQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.publicacion.Publicacion;
import dataBaseAccess.DBConnect;

public class PublicacionDB implements DBQuery {
	
	
	
	public static final String TABLA = "publicaciones";
	
	
	
	public void publicar(Publicacion publicacion){
		
		
		
		
		Connection conexion = DBConnect.getInstance().connect();
		
		
		String insert = "INSERT INTO publicaciones VALUES(?,?,?,?,?,?,?)";
		
		
		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(insert,PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, publicacion.getTitulo());
			preparedStatement.setString(2, publicacion.getNombreProducto());
			preparedStatement.setString(3, publicacion.getImagen());
			preparedStatement.setFloat(4, publicacion.getPrecio());
			preparedStatement.setString(5, publicacion.getCategoria());
			preparedStatement.setString(6, publicacion.getMedioDePago());
			preparedStatement.setString(7, publicacion.getDescripcion());
			
			preparedStatement.executeUpdate();
			
			ResultSet rs = preparedStatement.getGeneratedKeys(); 
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String getColumna() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCondicion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTabla() {
		// TODO Auto-generated method stub
		return null;
	}

}
