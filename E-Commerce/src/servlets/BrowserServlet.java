package servlets;

import java.io.IOException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BrowserController;

public class BrowserServlet extends HttpServlet {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String busqueda = request.getParameter("busqueda");
		
		BrowserController browserControl = new BrowserController(busqueda);
		ResultSet rs = browserControl.buscarProducto();
		
		try {
			while(rs.next()){
				Array id = rs.getArray("id");
				
				System.out.println("ID: "+id.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
