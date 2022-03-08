package controller;

import java.io.IOException;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Utenti;


@WebServlet(name= "GestioneLogin" , urlPatterns = "/GestioneLogin")

public class GestioneLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf;
	EntityManager em;

	public Utenti getUtenteLogin(String email, String password) {
		Utenti u = null;    	
		try {		    	
			if(!em.getTransaction().isActive())
				em.getTransaction().begin();		
			Query q = em.createQuery("SELECT u FROM Utenti u WHERE u.emailUtente = :param AND u.passwordUtente = :param1");
			q.setParameter("param", email);
			q.setParameter("param1", password);
			u = (Utenti) q.getSingleResult();
			em.getTransaction().commit();		
		}
		catch(Exception e){  		
		}
		return u;
	}

	public GestioneLogin() {   	
		super();  
	}

	@Override
	public void init() throws ServletException {
		super.init();
		emf = Persistence.createEntityManagerFactory("Soap");
		em = emf.createEntityManager();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email_utente");
		String password = request.getParameter("password_utente");
		if(request.getSession().getAttribute("utenteLogin") == null){
			if(!email.trim().equals("") && !password.trim().equals("")) {
				Utenti u = getUtenteLogin(email, password);
				HttpSession session = request.getSession();
				if(u != null && u.getAccettato()) {
					session.setAttribute("utenteLogin", u);	
				}
			}
		}						
	}
}


