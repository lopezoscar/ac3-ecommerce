package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.LoginController;
import controller.RegistroController;
import exceptions.MailNotFoundException;
import exceptions.PassNotFoundException;
import exceptions.RegisterExcetption;

public class RegisterServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		
//		PrintWriter pw = resp.getWriter();
//		pw.println("Ok");
//		
//	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("Entro al get del RegisterServlet");
		out.println(mail);
		out.println(pass);
		
		/**
		 * Paso Mail y Pass por el controller para que registre
		 * al usuario accediento internamente a RegistroDB
		 * 
		 * En caso de que algunos de los dos argumentos sea null
		 * arroja su Exception correspondiente
		 * 
		 * Luego de Registrar al usuario, si el registro es exitoso
		 * Se debe loguear al mismo
		 */
		RegistroController registroController = new RegistroController(mail,pass);
		try {
			Boolean registroOk = registroController.registrar(mail, pass);
			out.println(registroOk.booleanValue());
			if(registroOk == true){
				
				HttpSession session = request.getSession(false);
				
				LoginController login = new LoginController();
				int idUser = login.login(mail, pass);
				if( idUser>0){
					session = request.getSession(true);
					session.setAttribute("id_user", idUser);
					out.println(idUser);
					out.println("Login ok");
				}
			}else{
				out.println("Login Incorrect");
				throw new RegisterExcetption();
			}
			
		} catch (MailNotFoundException e) {
			e.printStackTrace();
		} catch (PassNotFoundException e) {
			e.printStackTrace();
		} catch (RegisterExcetption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
