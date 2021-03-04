package fr.diginamic.entites.agenceEntite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agence")
public class Agence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "nom_Agence", nullable = false, length = 255)
	private String nomAgence;

	@Column(name = "tresorie_Agence", nullable = false)
	private Double tresorieAgence;

	/**
	 * 
	 */
	public Agence() {
		super();
	}

	/**
	 * @param nomAgence
	 * @param tresorieAgence
	 */
	public Agence(String nomAgence, Double tresorieAgence) {
		super();
		this.nomAgence = nomAgence;
		this.tresorieAgence = tresorieAgence;
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
	 * @return the nomAgence
	 */
	public String getNomAgence() {
		return nomAgence;
	}

	/**
	 * @param nomAgence the nomAgence to set
	 */
	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

	/**
	 * @return the tresorieAgence
	 */
	public Double getTresorieAgence() {
		return tresorieAgence;
	}

	/**
	 * @param tresorieAgence the tresorieAgence to set
	 */
	public void setTresorieAgence(Double tresorieAgence) {
		this.tresorieAgence = tresorieAgence;
	}

}
