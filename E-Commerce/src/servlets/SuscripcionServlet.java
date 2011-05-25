package servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		
		PrintWriter out = response.getWriter();
		
		out.println(mail);
		
		
		
		
		
		
		
		
	}

}
