
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Utenti;


@WebServlet(name= "GestioneAdmin" , urlPatterns = "/GestioneAdmin")
public class GestioneAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf;
    EntityManager em;   
	public ArrayList<Utenti> utentiDaInserire;
	
    public GestioneAdmin() {
        super();
    }
    
	@Override
	public void init() throws ServletException {
		super.init();		
		utentiDaInserire = new ArrayList<Utenti>();
		  emf = Persistence.createEntityManagerFactory("Soap");
	      em = emf.createEntityManager();
	}
	
	private ArrayList<Utenti> getAllUtentiInattivi() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Soap");
	    EntityManager em= emf.createEntityManager();
		Query q = em.createQuery("SELECT u FROM Utenti u WHERE u.accettato = " + false);
		ArrayList<Utenti> lista = new ArrayList<Utenti>();
		for (Object o : q.getResultList()) {
			Utenti u = (Utenti)o;
			lista.add(u);
		}
		return lista;
	}
	
	public void setAccettatoAdmin(int id) {
		Utenti u = null;    	
		try {		    						
			Query q = em.createQuery("SELECT u FROM Utenti u WHERE u.idUtente = :param ");
			q.setParameter("param", id);
			u = (Utenti) q.getSingleResult();
			u.setAccettato(true);
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		}
		catch(Exception e){  		
		}
	}
	
	public void removeUtente(int id) {
		Utenti u = null;    	
		try {		    						
			Query q = em.createQuery("SELECT u FROM Utenti u WHERE u.idUtente = :param ");
			q.setParameter("param", id);
			u = (Utenti) q.getSingleResult();
			em.getTransaction().begin();
			em.remove(u);
			em.getTransaction().commit();
		}
		catch(Exception e){  		
		}
	}
	
	public Utenti getUtente(int id) {
		Utenti u = null;    	
		try {		    			
			Query q = em.createQuery("SELECT u FROM Utenti u WHERE u.idUtente = :param ");
			q.setParameter("param", id);
			u = (Utenti) q.getSingleResult();		
		}
		catch(Exception e){  		
		}
		return u;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		utentiDaInserire = getAllUtentiInattivi();
		if(request.getParameter("aggiungi") != null) {
			int aggiungi = Integer.parseInt(request.getParameter("aggiungi"));		
			setAccettatoAdmin(aggiungi);			
			utentiDaInserire = getAllUtentiInattivi();
		}
		else if(request.getParameter("rifiuta") != null) {
			int rifiuta = Integer.parseInt(request.getParameter("rifiuta"));
			removeUtente(rifiuta);
			utentiDaInserire = getAllUtentiInattivi();
		}
		utentiDaInserire = getAllUtentiInattivi();
		request.setAttribute("nuoviutenti", utentiDaInserire);
		System.out.println(utentiDaInserire.size());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		
	}
}
