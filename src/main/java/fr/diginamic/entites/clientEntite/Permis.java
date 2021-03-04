package fr.diginamic.entites.clientEntite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "permis")
public class Permis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "numero_permis", nullable = false)
	private int numeroPermis;

	@Column(name = "date_obtention_permis", nullable = false)
	private int dateObtentionPermis;

	@Column(name = "type_permis", nullable = false)
	@Enumerated(EnumType.STRING)
	private TypePermis typePermis;

	@OneToOne
	@JoinColumn(name = "ID_CLIENT")
	private Client client;

	/**
	 * 
	 */
	public Permis() {
		super();
	}

	/**
	 * @param numeroPermis
	 * @param dateObtentionPermis
	 * @param typePermis
	 */
	public Permis(int numeroPermis, int dateObtentionPermis, String typePermis, Client client) {
		super();
		this.numeroPermis = numeroPermis;
		this.dateObtentionPermis = dateObtentionPermis;
		this.typePermis = TypePermis.find(typePermis);
		this.client = client;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the numeroPermis
	 */
	public int getNumeroPermis() {
		return numeroPermis;
	}

	/**
	 * @param numeroPermis the numeroPermis to set
	 */
	public void setNumeroPermis(int numeroPermis) {
		this.numeroPermis = numeroPermis;
	}

	/**
	 * @return the dateObtentionPermis
	 */
	public int getDateObtentionPermis() {
		return dateObtentionPermis;
	}

	/**
	 * @param dateObtentionPermis the dateObtentionPermis to set
	 */
	public void setDateObtentionPermis(int dateObtentionPermis) {
		this.dateObtentionPermis = dateObtentionPermis;
	}

	/**
	 * @return the typePermis
	 */
	public TypePermis getTypePermis() {
		return typePermis;
	}

	/**
	 * @param typePermis the typePermis to set
	 */
	public void setTypePermis(TypePermis typePermis) {
		this.typePermis = typePermis;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

}
