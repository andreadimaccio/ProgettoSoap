package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dispatcherutente")
public class DispatcherUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DispatcherUtente() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null && action.equals("logout")) {			
			request.getSession().setAttribute("utentelogin", null);
			response.sendRedirect("dispatchergenerale");
		} 
		else if(action != null && action.equals("edit")) {
			request.getServletContext().getRequestDispatcher("/modificaprofilo.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getNamedDispatcher("GestioneEditUtente").include(request, response);
		response.sendRedirect("dispatchergenerale");
	}

}
