package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatchersoap")
public class DispatcherSoap extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DispatcherSoap() {
        super();
      
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action") != null && request.getParameter("action").equals("aggiungisoap")) {
			request.getServletContext().getRequestDispatcher("/creasoap.jsp").forward(request, response);
		}
		
		else {			
			response.sendRedirect("dispatchergenerale");
		}				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getNamedDispatcher("GestioneAggiuntaSoap").include(request, response);
		
		
		request.getServletContext().getRequestDispatcher("/bacheca.jsp").forward(request, response);		
	}

}
