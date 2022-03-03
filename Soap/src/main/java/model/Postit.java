package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;

@Entity
@NamedQuery(name="Postit.findAll", query="SELECT p FROM Postit p")
public class Postit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_postit")
	private int idPostit;
	
	@Column(name="data_inserimento_postit")
	private Date dataInserimento;
	
	@Column(name="data_promemoria_postit")
	private Date dataPromemoria;

	@Lob
	@Column(name="testo_postit")
	private String testoPostit;

	@Column(name="titolo_postit")
	private String titoloPostit;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="categoria_postit")
	private Categorie categorie;

	//bi-directional many-to-one association to Utenti
	@ManyToOne
	@JoinColumn(name="utente_postit")
	private Utenti utente;

	public Postit() {
	}

	public int getIdPostit() {
		return this.idPostit;
	}

	public void setIdPostit(int idPostit) {
		this.idPostit = idPostit;
	}

	public Date getDataInserimento() {
		return this.dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Date getDataPromemoria() {
		return this.dataPromemoria;
	}

	public void setDataPromemoria(Date dataPromemoria) {
		this.dataPromemoria = dataPromemoria;
	}

	public String getTestoPostit() {
		return this.testoPostit;
	}

	public void setTestoPostit(String testoPostit) {
		this.testoPostit = testoPostit;
	}

	public String getTitoloPostit() {
		return this.titoloPostit;
	}

	public void setTitoloPostit(String titoloPostit) {
		this.titoloPostit = titoloPostit;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Utenti getUtenti() {
		return this.utente;
	}

	public void setUtenti(Utenti utente) {
		this.utente = utente;
	}

}
