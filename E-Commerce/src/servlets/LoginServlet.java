package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.LoginController;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");

		String mail = request.getParameter("login");
		String pass = request.getParameter("pass");

		//PrintWriter pw = response.getWriter();
		//pw.println(mail+" "+pass);

		HttpSession session = request.getSession(false);
		
		LoginController loginControl = new LoginController();
		int idUser = loginControl.login(mail, pass);
		
		session.setAttribute("id_user", idUser);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("LoginOk.jsp");
		dispatcher.forward(request, response);
		
//			if(session == null){
//				session = request.getSession(true);
//				session.setAttribute("id_user", idUser);	
//			}else{
//				String user = (String)session.getAttribute("id_user");
//				RequestDispatcher dispatcherError = request.getRequestDispatcher("index.jsp");
//				dispatcherError.forward(request, response);
//				//pw.println(user);
//			}
//	




	}





}
