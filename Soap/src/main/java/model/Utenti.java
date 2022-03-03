package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the utenti database table.
 * 
 */
@Entity
@NamedQuery(name="Utenti.findAll", query="SELECT u FROM Utenti u")
public class Utenti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_utente")
	private int idUtente;


	@Column(name="accettato")
	private boolean accettato;

	@Column(name="cognome_utente")
	private String cognomeUtente;

	@Column(name="email_utente")
	private String emailUtente;

	@Column(name="nome_utente")
	private String nomeUtente;

	@Column(name="password_utente")
	private String passwordUtente;

	@Column(name="telefono_utente")
	private String telefonoUtente;

	//bi-directional many-to-one association to Postit
	@OneToMany(mappedBy="utente")
	private List<Postit> postits;

	public Utenti() {
	}

	public int getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public boolean getAccettato() {
		return this.accettato;
	}

	public void setAccettato(boolean accettato) {
		this.accettato = accettato;
	}

	public String getCognomeUtente() {
		return this.cognomeUtente;
	}

	public void setCognomeUtente(String cognomeUtente) {
		this.cognomeUtente = cognomeUtente;
	}

	public String getEmailUtente() {
		return this.emailUtente;
	}

	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}

	public String getNomeUtente() {
		return this.nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getPasswordUtente() {
		return this.passwordUtente;
	}

	public void setPasswordUtente(String passwordUtente) {
		this.passwordUtente = passwordUtente;
	}

	public String getTelefonoUtente() {
		return this.telefonoUtente;
	}

	public void setTelefonoUtente(String telefonoUtente) {
		this.telefonoUtente = telefonoUtente;
	}

	public List<Postit> getPostits() {
		return this.postits;
	}

	public void setPostits(List<Postit> postits) {
		this.postits = postits;
	}

	public Postit addPostit(Postit postit) {
		getPostits().add(postit);
		postit.setUtenti(this);

		return postit;
	}

	public Postit removePostit(Postit postit) {
		getPostits().remove(postit);
		postit.setUtenti(null);

		return postit;
	}

}
