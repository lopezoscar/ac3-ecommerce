package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.RegistroController;
import exceptions.MailNotFoundException;
import exceptions.PassNotFoundException;

public class RegisterServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		response.setContentType("text/html");
		
		/**
		 * Paso Mail y Pass por el controller para que registre
		 * al usuario accediento internamente a RegistroDB
		 * 
		 * En caso de que algunos de los dos argumentos sea null
		 * arroja su Exception correspondiente
		 */
		RegistroController registroController = new RegistroController(mail,pass);
		try {
			registroController.registrar(mail, pass);
			
		} catch (MailNotFoundException e) {
			e.printStackTrace();
		} catch (PassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
