package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dispatchereditremove")
public class DispatcherEditRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DispatcherEditRemove() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("remove") != null ) {
			request.getServletContext().getNamedDispatcher("GestioneEditSoap").include(request, response);
			request.getServletContext().getNamedDispatcher("GestioneSoap").include(request, response);
			request.getServletContext().getRequestDispatcher("/bacheca.jsp").forward(request, response);
		}
		else if(request.getParameter("edit") != null) {
			request.getServletContext().getRequestDispatcher("/modificasoap.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("editpostit") != null) {
			request.getServletContext().getNamedDispatcher("GestioneEditSoap").include(request, response);
			request.getServletContext().getNamedDispatcher("GestioneSoap").include(request, response);
			request.getServletContext().getRequestDispatcher("/bacheca.jsp").forward(request, response);
		}
	}

}
