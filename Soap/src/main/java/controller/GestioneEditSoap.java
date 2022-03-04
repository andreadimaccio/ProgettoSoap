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
   		emf = Persistence.createEntityManagerFactory("WebProject_13_JPA_Login");
   		em = emf.createEntityManager();
   	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titolo = request.getParameter("titolo_postit");
		String testo = request.getParameter("testo_postit");
		String data = request.getParameter("data");
		Date dataInserimento = Date.valueOf(LocalDate.now());		
		Date dataPromemoria = Date.valueOf(data);
	
		if(!titolo.trim().equals("") && 
				!testo.trim().equals("")  				
				) {
//			Postit soap = getPostit();
//			soap.setTitoloPostit(titolo);
//			soap.setTestoPostit(testo);
//			soap.setDataInserimento(dataInserimento);
//			soap.setDataPromemoria(dataPromemoria);
//			updateSoap(soap);
		}
	}
		private void updateSoap(Postit soap) {
			em.getTransaction().begin();
			em.merge(soap);
			em.getTransaction().commit();
		}
		
		 private Postit getPostit(String email, String password) {
		    	Postit u = null;    	
		    	try {		    	
				if(!em.getTransaction().isActive())
				    em.getTransaction().begin();		
				Query q = em.createQuery("SELECT u FROM Utenti u WHERE u.emailUtente = :param AND u.passwordUtente = :param1");
				q.setParameter("param", email);
				q.setParameter("param1", password);
				u = (Postit) q.getSingleResult();
				em.getTransaction().commit();		
		    	}
		    	catch(Exception e){  		
		    	}
		    	return u;
			}
}
