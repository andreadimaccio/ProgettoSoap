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
		Query q = em.createQuery("SELECT u FROM Utenti u WHERE u.accettato = " + false);
		ArrayList<Utenti> lista = new ArrayList<Utenti>();
		for (Object o : q.getResultList()) {
			Utenti u = (Utenti)o;
			lista.add(u);
		}
		return lista;
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		if(request.getParameter("action") != null && request.getParameter("action").equals("aggiungi")) {
			utentiDaInserire.get(Integer.parseInt("aggiungi")).setAccettato(true);
			utentiDaInserire.remove(Integer.parseInt("aggiungi"));
		}
		else if(request.getParameter("action") != null && request.getParameter("action").equals("rifiuta")) {
			utentiDaInserire.remove(Integer.parseInt("rifiuta"));
		}
		utentiDaInserire = getAllUtentiInattivi();
		request.setAttribute("nuoviutenti", utentiDaInserire);
		System.out.println(utentiDaInserire.size());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		
	}
}