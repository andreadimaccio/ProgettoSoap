package controller;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Utenti;


@WebServlet(name= "GestioneEditUtente" , urlPatterns = "/GestioneEditUtente")
public class GestioneEditUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf;
	EntityManager em;

	public GestioneEditUtente() {
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
		String nome = request.getParameter("nome_utente");
		String cognome = request.getParameter("cognome_utente");
		String email = request.getParameter("email_utente");
		String password = request.getParameter("password_utente");
		String telefono = request.getParameter("telefono_utente");

		if(!nome.trim().equals("") && 
				!cognome.trim().equals("") &&  
				!email.trim().equals("") && 
				!password.trim().equals("") &&
				!telefono.trim().equals("")
				) {
			Utenti user = (Utenti)request.getSession().getAttribute("utenteLogin");
			user = getUtenteLogin(user.getEmailUtente(),user.getPasswordUtente());
			user.setNomeUtente(nome);
			user.setCognomeUtente(cognome);
			user.setEmailUtente(email);
			user.setPasswordUtente(password);
			user.setTelefonoUtente(telefono);
			updateUser(user);
			request.getSession().setAttribute("utenteLogin", user);
		}
	}
	private void updateUser(Utenti user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
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
			e.printStackTrace();
		}
		return u;
	}
}


