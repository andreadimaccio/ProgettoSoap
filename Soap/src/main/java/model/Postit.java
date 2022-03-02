package model;

import java.io.Serializable;
import javax.persistence.*;

import com.mysql.cj.xdevapi.Type;

import java.util.Date;
import java.time.LocalDate;


/**
 * The persistent class for the postit database table.
 * 
 */
@Entity
@NamedQuery(name="Postit.findAll", query="SELECT p FROM Postit p")
public class Postit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_postit")
	private int idPostit;


	@Column(name="data_inserimento")
	private LocalDate dataInserimento;

	@Temporal(TemporalType.DATE)
	@Column(name="data_promemoria")
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
	private Utenti utenti;

	public Postit() {
	}

	public int getIdPostit() {
		return this.idPostit;
	}

	public void setIdPostit(int idPostit) {
		this.idPostit = idPostit;
	}

	public LocalDate getDataInserimento() {
		return this.dataInserimento;
	}

	public void setDataInserimento(LocalDate dataInserimento) {
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
		return this.utenti;
	}

	public void setUtenti(Utenti utenti) {
		this.utenti = utenti;
	}

}