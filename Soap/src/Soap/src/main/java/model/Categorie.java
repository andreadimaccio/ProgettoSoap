package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="Categorie.findAll", query="SELECT c FROM Categorie c")
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_categoria")
	private int idCategoria;

	@Column(name="colore_categoria")
	private String coloreCategoria;

	@Column(name="nome_categoria")
	private String nomeCategoria;

	//bi-directional many-to-one association to Postit
	@OneToMany(mappedBy="categorie")
	private List<Postit> postits;

	public Categorie() {
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getColoreCategoria() {
		return this.coloreCategoria;
	}

	public void setColoreCategoria(String coloreCategoria) {
		this.coloreCategoria = coloreCategoria;
	}

	public String getNomeCategoria() {
		return this.nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public List<Postit> getPostits() {
		return this.postits;
	}

	public void setPostits(List<Postit> postits) {
		this.postits = postits;
	}

	public Postit addPostit(Postit postit) {
		getPostits().add(postit);
		postit.setCategorie(this);

		return postit;
	}

	public Postit removePostit(Postit postit) {
		getPostits().remove(postit);
		postit.setCategorie(null);

		return postit;
	}

}
