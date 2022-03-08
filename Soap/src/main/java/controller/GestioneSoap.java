package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Postit;
import model.Utenti;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GestioneSoap", urlPatterns = "/GestioneSoap")
public class GestioneSoap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf;
	EntityManager em;
	ArrayList<Postit> allPostitUtente;

	@Override
	public void init() throws ServletException {
		super.init();
		emf = Persistence.createEntityManagerFactory("Soap");
		em = emf.createEntityManager();
		allPostitUtente = new ArrayList<Postit>();
	}

	public GestioneSoap() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utenti u = (Utenti) request.getSession().getAttribute("utenteLogin");

		if (request.getParameter("remove") != null) {
			init();
			Query q = em.createQuery("SELECT p FROM Postit p WHERE p.idPostit = :param");
			q.setParameter("param", Integer.parseInt(request.getParameter("remove")));
			Postit soap = (Postit) q.getSingleResult();
			em.getTransaction().begin();
			em.remove(soap);
			em.getTransaction().commit();

		}
		request.getSession().removeAttribute("allPostit");
		ArrayList<Postit> allPostitUtente = new ArrayList<Postit>();
		allPostitUtente.addAll(getAllPostitUtente(u.getEmailUtente(), u.getPasswordUtente()));
		request.getSession().setAttribute("allPostit", allPostitUtente);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utenti u = (Utenti) request.getSession().getAttribute("utenteLogin");

		if (request.getParameter("editpostit") != null) {

			String titolo = request.getParameter("titolo_postit");
			String testo = request.getParameter("testo_postit");
			
			String data;
			if(request.getParameter("data").equals("") || request.getParameter("data") == null) {
				data = "2000-01-01";
			}
			else {
				data = request.getParameter("data");
			}
			
			Date dataInserimento = Date.valueOf(LocalDate.now());
			Date dataPromemoria = Date.valueOf(data);

			if (!titolo.trim().equals("") && !testo.trim().equals("")) {
				init();
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
		allPostitUtente.addAll(getAllPostitUtente(u.getEmailUtente(), u.getPasswordUtente()));

		request.getSession().setAttribute("allPostit", allPostitUtente);
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
		return (List<Postit>) q.getResultList();
	}

	private void updateSoap(Postit soap) {
		em.getTransaction().begin();
		em.merge(soap);
		em.getTransaction().commit();
	}

	private Postit getPostit(String email, String password) {
		Postit p = null;
		try {
			if (!em.getTransaction().isActive())
				em.getTransaction().begin();
			Query q = em
					.createQuery("SELECT u FROM Utenti u WHERE u.emailUtente = :param AND u.passwordUtente = :param1");
			q.setParameter("param", email);
			q.setParameter("param1", password);
			p = (Postit) q.getSingleResult();
			em.getTransaction().commit();
		} catch (Exception e) {
		}
		return p;
	}

}
