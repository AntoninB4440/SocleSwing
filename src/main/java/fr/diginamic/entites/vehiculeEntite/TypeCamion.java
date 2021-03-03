package fr.diginamic.entites.vehiculeEntite;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type_camion")
public class TypeCamion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "nom_type_camion", length = 255, nullable = false, unique = true)
	private String nomTypeCamion;

	@Column(name = "prix_journalier_type_camion", nullable = false)
	private Double prixJournalierTypeCamion;

	@Column(name = "nom_type_camion", nullable = false)
	private Double cautionTypeCamion;

	private List<Camion> camions = new ArrayList<>();

	/**
	 * 
	 */
	public TypeCamion() {
		super();
	}

	/**
	 * @param nomTypeCamion
	 * @param prixJournalierTypeCamion
	 * @param cautionTypeCamion
	 */
	public TypeCamion(String nomTypeCamion, Double prixJournalierTypeCamion, Double cautionTypeCamion) {
		super();
		this.nomTypeCamion = nomTypeCamion;
		this.prixJournalierTypeCamion = prixJournalierTypeCamion;
		this.cautionTypeCamion = cautionTypeCamion;
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
	 * @return the nomTypeCamion
	 */
	public String getNomTypeCamion() {
		return nomTypeCamion;
	}

	/**
	 * @param nomTypeCamion the nomTypeCamion to set
	 */
	public void setNomTypeCamion(String nomTypeCamion) {
		this.nomTypeCamion = nomTypeCamion;
	}

	/**
	 * @return the prixJournalierTypeCamion
	 */
	public Double getPrixJournalierTypeCamion() {
		return prixJournalierTypeCamion;
	}

	/**
	 * @param prixJournalierTypeCamion the prixJournalierTypeCamion to set
	 */
	public void setPrixJournalierTypeCamion(Double prixJournalierTypeCamion) {
		this.prixJournalierTypeCamion = prixJournalierTypeCamion;
	}

	/**
	 * @return the cautionTypeCamion
	 */
	public Double getCautionTypeCamion() {
		return cautionTypeCamion;
	}

	/**
	 * @param cautionTypeCamion the cautionTypeCamion to set
	 */
	public void setCautionTypeCamion(Double cautionTypeCamion) {
		this.cautionTypeCamion = cautionTypeCamion;
	}

	/**
	 * @return the camions
	 */
	public List<Camion> getCamions() {
		return camions;
	}

	/**
	 * @param camions the camions to set
	 */
	public void setCamions(List<Camion> camions) {
		this.camions = camions;
	}

}
