package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PublicacionController;

public class PublicacionServlet extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String titulo = request.getParameter("titulo");
		String producto = request.getParameter("producto");
		String imagen = request.getParameter("imagen");
		String precio = request.getParameter("precio");
		String categoria = request.getParameter("categoria");
		String medioPago = request.getParameter("medioPago");
		String descripcion = request.getParameter("descripcion");
		
		System.out.println();
		
		
		PublicacionController publicacionController = new PublicacionController();
		publicacionController.getPublicacion().setTitulo(titulo);
		publicacionController.getPublicacion().setNombreProducto(producto);
		publicacionController.getPublicacion().setImagen(imagen);
		publicacionController.getPublicacion().setPrecio(precio);
		publicacionController.getPublicacion().setCategoria(categoria);
		publicacionController.getPublicacion().setMedioDePago(medioPago);
		publicacionController.getPublicacion().setDescripcion(descripcion);
		
		publicacionController.publicar();
		
		
		
		
		
		
		
		
		
		
		
	}

}
