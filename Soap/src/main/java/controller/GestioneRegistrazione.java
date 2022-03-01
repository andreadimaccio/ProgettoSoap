package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Utenti;

@WebServlet("/gestioneregistrazione")
public class GestioneRegistrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GestioneRegistrazione() {
        super();       
    }
    
	@Override
	public void init() throws ServletException {
		super.init();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome_utente");
		String cognome = request.getParameter("cognome_utente");
		String email = request.getParameter("email_utente");
		String password = request.getParameter("password_utente");
		
		if(!nome.trim().equals("") && 
				!cognome.trim().equals("") &&  
				!email.trim().equals("") && 
				!password.trim().equals("")
				) {
			Utenti user = new Utenti();
			user.setNomeUtente(nome);
			user.setCognomeUtente(cognome);
			user.setEmailUtente(email);
			user.setPasswordUtente(password);
			String nuovoutente = "nuovoutente";
			request.setAttribute(nuovoutente, user);
		}
	}

}
