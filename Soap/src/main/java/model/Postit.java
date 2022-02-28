package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the postit database table.
 * 
 */
@Entity
@NamedQuery(name="Postit.findAll", query="SELECT p FROM Postit p")
public class Postit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_postit")
	private int idPostit;

	@Column(name="data_inserimento_postit")
	private String dataInserimentoPostit;

	@Column(name="data_promemoria_postit")
	private String dataPromemoriaPostit;

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

	public String getDataInserimentoPostit() {
		return this.dataInserimentoPostit;
	}

	public void setDataInserimentoPostit(String dataInserimentoPostit) {
		this.dataInserimentoPostit = dataInserimentoPostit;
	}

	public String getDataPromemoriaPostit() {
		return this.dataPromemoriaPostit;
	}

	public void setDataPromemoriaPostit(String dataPromemoriaPostit) {
		this.dataPromemoriaPostit = dataPromemoriaPostit;
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