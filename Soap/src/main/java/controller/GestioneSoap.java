package controller;

import java.io.IOException;
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



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name= "GestioneSoap" , urlPatterns = "/GestioneSoap")
public class GestioneSoap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf;
	EntityManager em;

    public GestioneSoap() {
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
		System.out.println("Soap-it");
	}
	
	private void updateSoap(Postit soap) {
		em.getTransaction().begin();
		em.merge(soap);
		em.getTransaction().commit();
	}
	
	private void removeSoap(Postit soap) {
		em.getTransaction().begin();
		em.remove(soap);
		em.getTransaction().commit();
	}
}
