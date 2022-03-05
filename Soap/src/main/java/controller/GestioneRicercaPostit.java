package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

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
			postitRicercaTitolo = cercaPerTitolo(u.getEmailUtente(), u.getPasswordUtente(), titolo);
			request.setAttribute("postitTitoli", postitRicercaTitolo);
			
			
		}
		else if(request.getParameter("ricerca").equals("cercadata")) {
			
				Utenti u = (Utenti)request.getSession().getAttribute("utenteLogin");
				String data = request.getParameter("data_cercata");
				Date dataPromemoria = Date.valueOf(data);
				postitRicercaData = cercaPerData(u.getEmailUtente(), u.getPasswordUtente(), dataPromemoria);
				request.setAttribute("postitDate", postitRicercaData);

		}
	}
	
	public ArrayList<Postit> cercaPerTitolo(String email, String password, String titolo) {
		ArrayList<Postit> listaTitoli = new ArrayList<Postit>();
		
		Query q = em.createQuery("SELECT u From Utenti u WHERE u.emailUtente = :param AND u.passwordUtente = :param1 ");
		q.setParameter("param", email);
		q.setParameter("param1", password);
		Utenti u = (Utenti)q.getSingleResult();
		ArrayList<Postit> lista = new ArrayList<>() ;
		lista.addAll(u.getPostits());
		if (lista != null && lista.size() > 0) {
		for (Postit p : lista) {
				if (p.getTitoloPostit().equals(titolo)) {
					listaTitoli.add(p);
				}
			}	
		}
		
		return listaTitoli;
	}
	
	public ArrayList<Postit> cercaPerData(String email, String password, Date data) {
		ArrayList<Postit> listaData = new ArrayList<Postit>();
		
		Query q = em.createQuery("SELECT u From Utenti u WHERE u.emailUtente = :param AND u.passwordUtente = :param1 ");
		q.setParameter("param", email);
		q.setParameter("param1", password);
		Utenti u = (Utenti)q.getSingleResult();
		ArrayList<Postit> lista = new ArrayList<>() ;
		lista.addAll(u.getPostits());
		if (lista != null && lista.size() > 0) {
		for (Postit p : lista) {
				if (p.getDataPromemoria().compareTo(data) == 0) {
					listaData.add(p);
				}
			}	
		}
		
		return listaData;
	}
	

}
