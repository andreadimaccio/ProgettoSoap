package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name= "GestioneSoap" , urlPatterns = "/GestioneSoap")
public class GestioneAggiuntaSoap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf;
	EntityManager em;

    public GestioneAggiuntaSoap() {
        super();       
    }
    
    @Override
	public void init() throws ServletException {
		super.init();
		emf = Persistence.createEntityManagerFactory("WebProject_13_JPA_Login");
		em = emf.createEntityManager();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Postit soap = new Postit();		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titolo = request.getParameter("titolo_postit");
		String testo = request.getParameter("testo_postit");		
		LocalDate dataInserimento = LocalDate.now();
		String anno = request.getParameter("anno");
		String mese = request.getParameter("mese");
		String giorno = request.getParameter("giorno");
		long data = (long)Integer.parseInt(anno + mese + giorno);
		Date dataPromemoria = new Date(data);
	
		if(!titolo.trim().equals("") && 
				!testo.trim().equals("")  				
				) {
			Postit soap = new Postit();
			soap.setTitoloPostit(titolo);
			soap.setTestoPostit(testo);
			soap.setDataInserimento(dataInserimento);
			soap.setDataPromemoria(dataPromemoria);
			addSoapit(soap);
		}
	}
	
	private Postit getSoapit(int id) {
		em.getTransaction().begin();
		Postit p = em.find(Postit.class, id);
		em.getTransaction().commit();
		return p;
	}
	
	private void addSoapit(Postit soap) {
		em.getTransaction().begin();
		em.persist(soap);
		em.getTransaction().commit();		
	}
	
	private void removeSoap(Postit soap) {
		em.getTransaction().begin();
		em.remove(soap);
		em.getTransaction().commit();
	}
}
