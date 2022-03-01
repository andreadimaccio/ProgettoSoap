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
    
	private Utenti getUtenteLogin(String email, String password) {
		Query q = em.createQuery("SELECT u FROM Utenti u where u.email_utente = email AND u.password = password ").setParameter("email", email).setParameter("password", password);
			return em.find(Utenti.class, q.executeUpdate());
		}
	
    public GestioneLogin() {   	
        super();  
        emf = Persistence.createEntityManagerFactory("Soap");
        em = emf.createEntityManager();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email_utente");
		String password = request.getParameter("password_utente");
		if(!email.trim().equals("") && !password.trim().equals("")) {
			Utenti u = getUtenteLogin(email, password);
			HttpSession session = request.getSession();
			session.setAttribute("utenteLogin", u);		
		}
	}

}
