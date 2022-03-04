package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import model.Postit;
import model.Utenti;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name= "GestioneSoap" , urlPatterns = "/GestioneSoap")
public class GestioneSoap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf;
	EntityManager em;
	ArrayList<Postit> allPostitUtente;
    
    @Override
	public void init() throws ServletException {
		super.init();
		emf = Persistence.createEntityManagerFactory("Soap");
		em = emf.createEntityManager();
		allPostitUtente = new ArrayList<Postit>();
	}


	public GestioneSoap() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utenti u = (Utenti) request.getSession().getAttribute("utenteLogin");
		
		allPostitUtente = getAllPostitUtente(u.getEmailUtente(), u.getPasswordUtente());
		System.out.println(allPostitUtente.size());
		
		request.setAttribute("allPostit", allPostitUtente);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
	
	public Postit getPostitUtente(String email, String password) {
		Postit p = null;    	
		try {		    	
			if(!em.getTransaction().isActive())
				em.getTransaction().begin();		
			Query q = em.createQuery("SELECT p FROM Postit p INNER JOIN Utenti u ON p.utente.getIdUtente() = u.idUtente  WHERE u.emailUtente = :param AND u.passwordUtente = :param1 ");
			q.setParameter("param", email);
			q.setParameter("param1", password);
			p = (Postit) q.getSingleResult();
			em.getTransaction().commit();		
		}
		catch(Exception e){  		
		}
		return p;
	}
	
	
	public ArrayList<Postit> getAllPostitUtente(String email, String password) {
		Query q = em.createQuery("SELECT u From Utenti u WHERE u.emailUtente = :param AND u.passwordUtente = :param1 ");
		q.setParameter("param", email);
		q.setParameter("param1", password);
		Utenti u = (Utenti)q.getSingleResult();
		ArrayList<Postit> lista = new ArrayList<>() ;
		lista.addAll(u.getPostits());
		return lista;
	}
}