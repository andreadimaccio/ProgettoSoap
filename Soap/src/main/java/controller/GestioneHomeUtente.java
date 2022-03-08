package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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

import model.Postit;
import model.Utenti;


@WebServlet(name= "GestioneHomeUtente" , urlPatterns = "/GestioneHomeUtente")
public class GestioneHomeUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf;
	EntityManager em;
    ArrayList<Postit> postitDataOggi;
  
    public GestioneHomeUtente() {
        super();
      
    }
    
    @Override
   	public void init() throws ServletException {
   		super.init();
   		emf = Persistence.createEntityManagerFactory("Soap");
   		em = emf.createEntityManager();
   		postitDataOggi = new ArrayList<Postit>();
   	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utenti u = (Utenti)request.getSession().getAttribute("utenteLogin");				
		postitDataOggi = cercaPerDataOdierna(u.getEmailUtente(), u.getPasswordUtente()) ;
		request.getSession().setAttribute("postitOggi", postitDataOggi);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private ArrayList<Postit> cercaPerDataOdierna(String email, String password) {
		
		ArrayList<Postit> listaData = new ArrayList<Postit>();
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Soap");
	    EntityManager em= emf.createEntityManager();
		
		Query q = em.createQuery("SELECT u From Utenti u WHERE u.emailUtente = :param AND u.passwordUtente = :param1 ");
		q.setParameter("param", email);
		q.setParameter("param1", password);
		Utenti u = (Utenti)q.getSingleResult();
		ArrayList<Postit> lista = new ArrayList<>() ;
		lista.addAll(u.getPostits());
		if (lista != null && lista.size() > 0) {
		for (Postit p : lista) {
				if (p.getDataPromemoria().compareTo(Date.valueOf(LocalDate.now())) == 0) {
					listaData.add(p);
				}
			}	
		}
		
		return listaData;
	}
	
}
