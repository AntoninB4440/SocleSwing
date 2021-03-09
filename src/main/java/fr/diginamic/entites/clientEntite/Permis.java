package fr.diginamic.entites.clientEntite;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.diginamic.dao.IDmodel;

@Entity
@Table(name = "permis")
public class Permis implements IDmodel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "numero_permis", nullable = false)
	private String numeroPermis;

	@Column(name = "date_obtention_permis", nullable = false)
	private LocalDate dateObtentionPermis;

	@Column(name = "type_permis", nullable = false)
	@Enumerated(EnumType.STRING)
	private TypePermis typePermis;

	@OneToOne(mappedBy = "permisClient")
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
	public Permis(String numeroPermis, LocalDate dateObtentionPermis, TypePermis typePermis, Client client) {
		super();
		this.numeroPermis = numeroPermis;
		this.dateObtentionPermis = dateObtentionPermis;
		this.typePermis = typePermis;
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
	public String getNumeroPermis() {
		return numeroPermis;
	}

	/**
	 * @param numeroPermis the numeroPermis to set
	 */
	public void setNumeroPermis(String numeroPermis) {
		this.numeroPermis = numeroPermis;
	}

	/**
	 * @return the dateObtentionPermis
	 */
	public LocalDate getDateObtentionPermis() {
		return dateObtentionPermis;
	}

	/**
	 * @param dateObtentionPermis the dateObtentionPermis to set
	 */
	public void setDateObtentionPermis(LocalDate dateObtentionPermis) {
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
