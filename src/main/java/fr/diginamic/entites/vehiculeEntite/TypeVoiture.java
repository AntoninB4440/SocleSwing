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
@Table(name = "type_voiture")
public class TypeVoiture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "nom_type_voiture", length = 255, nullable = false, unique = true)
	private String nomTypeVoiture;

	@Column(name = "prix_journalier_type_voiture", nullable = false)
	private Double prixJournalierTypeVoiture;

	@Column(name = "nom_type_voiture", nullable = false)
	private Double cautionTypeVoiture;

	private List<Voiture> voitures = new ArrayList<>();

	/**
	 * 
	 */
	public TypeVoiture() {
		super();
	}

	/**
	 * @param nomTypeVoiture
	 * @param prixJournalierTypeVoiture
	 * @param cautionTpeVoiture
	 */
	public TypeVoiture(String nomTypeVoiture, Double prixJournalierTypeVoiture, Double cautionTypeVoiture) {
		super();
		this.nomTypeVoiture = nomTypeVoiture;
		this.prixJournalierTypeVoiture = prixJournalierTypeVoiture;
		this.cautionTypeVoiture = cautionTypeVoiture;
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
	 * @return the nomTypeVoiture
	 */
	public String getNomTypeVoiture() {
		return nomTypeVoiture;
	}

	/**
	 * @param nomTypeVoiture the nomTypeVoiture to set
	 */
	public void setNomTypeVoiture(String nomTypeVoiture) {
		this.nomTypeVoiture = nomTypeVoiture;
	}

	/**
	 * @return the prixJournalierTypeVoiture
	 */
	public Double getPrixJournalierTypeVoiture() {
		return prixJournalierTypeVoiture;
	}

	/**
	 * @param prixJournalierTypeVoiture the prixJournalierTypeVoiture to set
	 */
	public void setPrixJournalierTypeVoiture(Double prixJournalierTypeVoiture) {
		this.prixJournalierTypeVoiture = prixJournalierTypeVoiture;
	}

	/**
	 * @return the cautionTypeVoiture
	 */
	public Double getCautionTypeVoiture() {
		return cautionTypeVoiture;
	}

	/**
	 * @param cautionTypeVoiture the cautionTypeVoiture to set
	 */
	public void setCautionTypeVoiture(Double cautionTypeVoiture) {
		this.cautionTypeVoiture = cautionTypeVoiture;
	}

	/**
	 * @return the voitures
	 */
	public List<Voiture> getVoitures() {
		return voitures;
	}

	/**
	 * @param voitures the voitures to set
	 */
	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}

}
