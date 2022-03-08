package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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

import model.Categorie;
import model.Postit;
import model.Utenti;


@WebServlet(name= "GestioneRicercaPostit" , urlPatterns = "/GestioneRicercaPostit")
public class GestioneRicercaPostit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf;
	EntityManager em;
	public ArrayList<Postit> postitRicercaTitolo;
	public ArrayList<Postit> postitRicercaData;
    public GestioneRicercaPostit() {
        super();
        
    }

    @Override
   	public void init() throws ServletException {
   		super.init();
   		emf = Persistence.createEntityManagerFactory("Soap");
   		em = emf.createEntityManager();
   		postitRicercaTitolo = new ArrayList<Postit>();
   		ArrayList<Postit> postitRicercaData = new ArrayList<Postit>();
   	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(request.getParameter("ricerca").equals("cercatitolo")) {
			Utenti u = (Utenti)request.getSession().getAttribute("utenteLogin");
			String titolo = request.getParameter("titolo_cercato");
			request.getSession().removeAttribute("postitTitoli"); //nuovo
			ArrayList<Postit> postitRicercaTitolo = new ArrayList<Postit>(); //nuovo
			postitRicercaTitolo.addAll((cercaPerTitolo(u.getEmailUtente(), u.getPasswordUtente(), titolo))); //nuovo
			
			
//			postitRicercaTitolo = cercaPerTitolo(u.getEmailUtente(), u.getPasswordUtente(), titolo);
			request.getSession().setAttribute("postitTitoli", postitRicercaTitolo);
			
			
		}
		else if(request.getParameter("ricerca").equals("cercadata")) {			
				Utenti u = (Utenti)request.getSession().getAttribute("utenteLogin");
				String data = request.getParameter("data_cercata");
				Date dataPromemoria = Date.valueOf(data);
		
				request.getSession().removeAttribute("postitDate"); //nuovo
				ArrayList<Postit> postitRicercaData = new ArrayList<Postit>(); //nuovo
				postitRicercaData.addAll((cercaPerData(u.getEmailUtente(), u.getPasswordUtente(), dataPromemoria))); //nuovo
				//postitRicercaData = cercaPerData(u.getEmailUtente(), u.getPasswordUtente(), dataPromemoria);
				request.getSession().setAttribute("postitDate", postitRicercaData);

		}
	}
	
	public List<Postit> cercaPerTitolo(String email, String password, String titolo) {
		ArrayList<Postit> listaTitoli = new ArrayList<Postit>();
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Soap");
	    EntityManager em= emf.createEntityManager();
	    
//		Query q = em.createQuery("SELECT u From Utenti u WHERE u.emailUtente = :param AND u.passwordUtente = :param1 ");
//		q.setParameter("param", email);
//		q.setParameter("param1", password);
//		Utenti u = (Utenti)q.getSingleResult();
//		ArrayList<Postit> lista = new ArrayList<>() ;
//		lista.addAll(u.getPostits());
//		if (lista != null && lista.size() > 0) {
//		for (Postit p : lista) {
//				if (p.getTitoloPostit().equals(titolo)) {
//					listaTitoli.add(p);
//				}
//			}	
//		}
//		
//		return listaTitoli;
	    
	    Query q = em.createQuery("SELECT p From Utenti u JOIN u.postits p WHERE u.emailUtente = :param AND u.passwordUtente = :param1 AND p.titoloPostit =:param2 ");
		q.setParameter("param", email);
		q.setParameter("param1", password);
		q.setParameter("param2", titolo);
		
		return q.getResultList();
	}
	
	public List<Postit> cercaPerData(String email, String password, Date data) {
		ArrayList<Postit> listaData = new ArrayList<Postit>();
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Soap");
	    EntityManager em= emf.createEntityManager();
		
//		Query q = em.createQuery("SELECT u From Utenti u WHERE u.emailUtente = :param AND u.passwordUtente = :param1 ");
//		q.setParameter("param", email);
//		q.setParameter("param1", password);
//		Utenti u = (Utenti)q.getSingleResult();
//		ArrayList<Postit> lista = new ArrayList<>() ;
//		lista.addAll(u.getPostits());
//		if (lista != null && lista.size() > 0) {
//		for (Postit p : lista) {
//				if (p.getDataInserimento().compareTo(data) == 0) {
//					listaData.add(p);
//				}
//			}	
//		}		
//		return listaData;
	    
	    Query q = em.createQuery("SELECT p From Utenti u JOIN u.postits p WHERE u.emailUtente = :param AND u.passwordUtente = :param1 AND p.dataInserimento =:param2 ");
	  		q.setParameter("param", email);
	  		q.setParameter("param1", password);
	  		q.setParameter("param2", data);
	  		
	  		return q.getResultList();
	}
}
