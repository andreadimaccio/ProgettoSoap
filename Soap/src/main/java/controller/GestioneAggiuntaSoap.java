package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
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
import model.Categorie;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name= "GestioneAggiuntaSoap" , urlPatterns = "/GestioneAggiuntaSoap")
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
		emf = Persistence.createEntityManagerFactory("Soap");
		em = emf.createEntityManager();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titolo = request.getParameter("titolo_postit");
		String testo = request.getParameter("testo_postit");	
		String data = request.getParameter("data");
		int categoria = Integer.parseInt(request.getParameter("categoria_postit"));
		Utenti utente = (Utenti)request.getSession().getAttribute("utenteLogin");
		Date dataInserimento = Date.valueOf(LocalDate.now());
		Date dataPromemoria = Date.valueOf(data);	
		if(!titolo.trim().equals("") && 
				!testo.trim().equals("")  				
				) {
			Postit soap = new Postit();
			soap.setTitoloPostit(titolo);
			soap.setTestoPostit(testo);
			soap.setCategorie(getCategoria(categoria));
			soap.setDataInserimento(dataInserimento);
			soap.setDataPromemoria(dataPromemoria);
			soap.setUtenti(utente);
			addSoapit(soap);
			
			request.getSession().removeAttribute("allPostit");
			ArrayList<Postit> allPostitUtente = new ArrayList<Postit>();
			allPostitUtente.addAll(getAllPostitUtente(utente.getEmailUtente(), utente.getPasswordUtente()));
			request.getSession().setAttribute("allPostit", allPostitUtente);
			
		}
	}	
	private void addSoapit(Postit soap) {
		try {
			init();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.getTransaction().begin();
		em.persist(soap);
		em.getTransaction().commit();		
	}
	private Categorie getCategoria(int id) {
		try {
			init();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Query q = em.createQuery("SELECT c FROM Categorie c WHERE c.idCategoria = :param");
		q.setParameter("param", id);		
		Categorie c = (Categorie) q.getSingleResult();
    	return c;
	}
	
	private List<Postit> getAllPostitUtente(String email, String password) {
		try {
			init();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Query q = em.createQuery("SELECT p From Utenti u JOIN u.postits p WHERE u.emailUtente = :param AND u.passwordUtente = :param1 ");
		q.setParameter("param", email);
		q.setParameter("param1", password);
		return q.getResultList();
	}
}
