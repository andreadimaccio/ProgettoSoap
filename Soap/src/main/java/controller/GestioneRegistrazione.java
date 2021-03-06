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

@WebServlet(name= "GestioneRegistrazione" , urlPatterns = "/GestioneRegistrazione")
public class GestioneRegistrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf;
	EntityManager em;


	public GestioneRegistrazione() {
		super();       
	}

	@Override
	public void init() throws ServletException {
		super.init();
		emf = Persistence.createEntityManagerFactory("Soap");
		em = emf.createEntityManager();
	}

	public boolean checkEmail(String email) {
		Utenti u = null;    	
		try {		    			
			Query q = em.createQuery("SELECT u FROM Utenti u WHERE u.emailUtente = :param ");
			q.setParameter("param", email);
			u = (Utenti) q.getSingleResult();		
		}
		catch(Exception e){  		
		}
		return (u == null ? false : true);
	}

	public boolean checkTelefono(String telefono) {
		Utenti u = null;    	
		try {		    						
			Query q = em.createQuery("SELECT u FROM Utenti u WHERE u.telefonoUtente = :param ");
			q.setParameter("param", telefono);
			u = (Utenti) q.getSingleResult();		
		}
		catch(Exception e){  		
		}
		return (u == null ? false : true);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome_utente");
		String cognome = request.getParameter("cognome_utente");
		String email = request.getParameter("email_utente");
		String password = request.getParameter("password_utente");
		String telefono = request.getParameter("telefono_utente");	

		if(!checkEmail(email) && !checkTelefono(telefono)) {
			if(!nome.trim().equals("") && 
					!cognome.trim().equals("") &&  
					!email.trim().equals("") && 
					!password.trim().equals("") &&
					!telefono.trim().equals("")
					) {
				Utenti user = new Utenti();
				user.setNomeUtente(nome);
				user.setCognomeUtente(cognome);
				user.setEmailUtente(email);
				user.setPasswordUtente(password);
				user.setTelefonoUtente(telefono);
				em.getTransaction().begin();
				em.persist(user);
				em.getTransaction().commit();
			}
		}
	}
}