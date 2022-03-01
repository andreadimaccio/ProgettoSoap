package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action") != null && request.getParameter("action").equals("aggiungi")) {
			em.getTransaction().begin();
			em.persist(utentiDaInserire.get(Integer.parseInt("aggiungi")));
			em.getTransaction().commit();
			utentiDaInserire.remove(Integer.parseInt("aggiungi"));
		}
		else if(request.getParameter("action") != null && request.getParameter("action").equals("rifiuta")) {
			utentiDaInserire.remove(Integer.parseInt("rifiuta"));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utenti u = (Utenti)request.getAttribute("nuovoutente");
		utentiDaInserire.add(u);
	}
}
