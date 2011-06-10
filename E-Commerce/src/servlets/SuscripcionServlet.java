package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SuscripcionController;

public class SuscripcionServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String mail = request.getParameter("mail");
		
		
		SuscripcionController suscripcionController = new SuscripcionController(mail);
		suscripcionController.suscripcion();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("SuscripcionOk.html");
		dispatcher.forward(request, response);
		
		//response.sendRedirect("SuscripcionOk.html");
		
		
		
		
		
		
		
	}

}
