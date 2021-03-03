package fr.diginamic.entites.vehicule;

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

}
