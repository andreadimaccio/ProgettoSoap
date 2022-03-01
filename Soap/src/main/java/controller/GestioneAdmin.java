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


@WebServlet("/gestioneadmin")
public class GestioneAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf;
    EntityManager em;   
	public ArrayList<Utenti> utentiDaInserire;
	
    public GestioneAdmin() {
        super();
        emf = Persistence.createEntityManagerFactory("Soap");
        em = emf.createEntityManager();
    }
    
	@Override
	public void init() throws ServletException {
		super.init();
		utentiDaInserire = new ArrayList<Utenti>();
	}
	
	private List<Utenti> getAllUtentiInattivi() {
		Query q = em.createQuery("SELECT u FROM Utenti u where accettato = " + 0);
		return q.getResultList();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action") != null && request.getParameter("action").equals("aggiungi")) {
			utentiDaInserire.get(Integer.parseInt("aggiungi")).setAccettato((byte)1);
			utentiDaInserire.remove(Integer.parseInt("aggiungi"));
		}
		else if(request.getParameter("action") != null && request.getParameter("action").equals("rifiuta")) {
			utentiDaInserire.remove(Integer.parseInt("rifiuta"));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utenti u = (Utenti)request.getAttribute("nuovoutente");
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		utentiDaInserire = (ArrayList<Utenti>)getAllUtentiInattivi();
		request.setAttribute("nuoviutenti", utentiDaInserire);
	}
}
