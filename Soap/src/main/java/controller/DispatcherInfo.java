package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Utenti;


@WebServlet(name= "DispatcherInfo" , urlPatterns = "/DispatcherInfo")
public class DispatcherInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DispatcherInfo() {
        super();   
    }
    
    @Override
	public void init() throws ServletException {
		super.init();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		if(request.getSession().getAttribute("utenteLogin") != null) {
			Utenti u = (Utenti)request.getSession().getAttribute("utenteLogin");
			
			if(u.getEmailUtente().equals("admin@admin.com") && u.getPasswordUtente().equals("admin")) {
				request.getServletContext().getNamedDispatcher("GestioneAdmin").include(request, response);
				request.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);				
			}
			else {
				request.getServletContext().getRequestDispatcher("/homepageutente.jsp").forward(request, response);
			}		
		}
		else {
			request.getServletContext().getRequestDispatcher("/infopage.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
	}

}
