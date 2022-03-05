package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Postit;
import model.Utenti;

@WebServlet(name= "GestioneEditSoap" , urlPatterns = "/GestioneEditSoap")
public class GestioneEditSoap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf;
	EntityManager em;
	
    public GestioneEditSoap() {
        super();
       
    }
    
    @Override
   	public void init() throws ServletException {
   		super.init();
   		emf = Persistence.createEntityManagerFactory("Soap");
   		em = emf.createEntityManager();
   	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("remove") != null) {
			Query q = em.createQuery("SELECT p FROM Postit p WHERE p.idPostit = :param");
			q.setParameter("param", Integer.parseInt(request.getParameter("remove")));
			Postit soap = (Postit) q.getSingleResult();
			em.getTransaction().begin();
			em.remove(soap);
			em.getTransaction().commit();
			
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("editpostit") != null) {
		
		String titolo = request.getParameter("titolo_postit");
		String testo = request.getParameter("testo_postit");
		String data = request.getParameter("data_promemoria");
		Date dataInserimento = Date.valueOf(LocalDate.now());		
		Date dataPromemoria = Date.valueOf(data);

	
		if(!titolo.trim().equals("") && 
				!testo.trim().equals("")  				
				) {
			Query q = em.createQuery("SELECT p FROM Postit p WHERE p.idPostit = :param");
			q.setParameter("param", Integer.parseInt(request.getParameter("editpostit")));
			Postit soap = (Postit) q.getSingleResult();
			soap.setTitoloPostit(titolo);
			soap.setTestoPostit(testo);
			soap.setDataInserimento(dataInserimento);
			soap.setDataPromemoria(dataPromemoria);
			em.getTransaction().begin();
			em.persist(soap);
			em.getTransaction().commit();
			}
		}
		
	}
		private void updateSoap(Postit soap) {
			em.getTransaction().begin();
			em.merge(soap);
			em.getTransaction().commit();
		}
		
		 private Postit getPostit(String email, String password) {
		    	Postit p = null;    	
		    	try {		    	
				if(!em.getTransaction().isActive())
				    em.getTransaction().begin();		
				Query q = em.createQuery("SELECT u FROM Utenti u WHERE u.emailUtente = :param AND u.passwordUtente = :param1");
				q.setParameter("param", email);
				q.setParameter("param1", password);
				p = (Postit) q.getSingleResult();
				em.getTransaction().commit();		
		    	}
		    	catch(Exception e){  		
		    	}
		    	return p;
			}
}
