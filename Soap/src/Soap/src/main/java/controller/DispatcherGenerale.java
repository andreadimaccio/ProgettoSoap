package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dispatchergenerale")
public class DispatcherGenerale extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public DispatcherGenerale() {
		super();

	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null && action.equals("registrazione")) {
			request.getServletContext().getRequestDispatcher("/registrazione.jsp").forward(request, response);
		} 
		else if(action != null && action.equals("login")){
			request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);			
		}
		else if(action != null && action.equals("homepageutente")) {
			request.getServletContext().getRequestDispatcher("/homepageutente.jsp").forward(request, response);
		}
		else {
			request.getServletContext().getRequestDispatcher("/infopage.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action") != null && request.getParameter("action").equals("registrazione")) {
			request.getServletContext().getNamedDispatcher("GestioneRegistrazione").include(request, response);					
		}
		else if(request.getParameter("action") != null && request.getParameter("action").equals("login")) {
			request.getServletContext().getNamedDispatcher("GestioneLogin").include(request, response);	
		}
		response.sendRedirect("DispatcherInfo");
	}

}
