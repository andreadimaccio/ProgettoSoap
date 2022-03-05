package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dispatcherricerca")
public class DispatcherRicerca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DispatcherRicerca() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("ricerca") != null && request.getParameter("ricerca").equals("cercatitolo")) {
			request.getServletContext().getNamedDispatcher("GestioneRicercaPostit").include(request, response);	
			request.getServletContext().getRequestDispatcher("/bachecaTitoli.jsp").forward(request, response); //da creare jsp bachecaTitoli
		}
		else if (request.getParameter("ricerca") != null && request.getParameter("ricerca").equals("cercadata")) {
			request.getServletContext().getNamedDispatcher("GestioneRicercaPostit").include(request, response);	
			request.getServletContext().getRequestDispatcher("/bachecaDate.jsp").forward(request, response); //da creare jsp bachecaDate
		}
	}

}
