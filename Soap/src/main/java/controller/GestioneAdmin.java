package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Utenti;


@WebServlet("/gestioneadmin")
public class GestioneAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public ArrayList<Utenti> utentiDaInserire;
    public GestioneAdmin() {
        super();
    }
    
	@Override
	public void init() throws ServletException {
		super.init();
		utentiDaInserire = new ArrayList<Utenti>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utenti u = (Utenti)request.getAttribute("nuovoutente");
		utentiDaInserire.add(u);
	}
}
