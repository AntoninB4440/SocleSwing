package fr.diginamic.entites.vehiculeEntite;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.diginamic.dao.IDmodel;

@Entity
@Table(name = "maintenance")
public class Maintenance implements IDmodel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "date_debut_maintenance", nullable = false)
	private LocalDate dateDebutMaintenance;

	@Column(name = "date_fin_maintenance")
	private LocalDate dateFinMaintenance;

	@Column(name = "cout_maintenance")
	private Double coutMaintenance;

	@ManyToOne
	@JoinColumn(name = "ID_VEHICULE", nullable = false)
	private Vehicule vehiculeMaintenance;

	/**
	 * 
	 */
	public Maintenance() {
		super();
	}

	/**
	 * @param dateDebutMaintenance
	 */
	public Maintenance(LocalDate dateDebutMaintenance, Vehicule vehiculeMaintenance) {
		super();
		this.dateDebutMaintenance = dateDebutMaintenance;
		this.vehiculeMaintenance = vehiculeMaintenance;
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
	 * @return the dateDebutMaintenance
	 */
	public LocalDate getDateDebutMaintenance() {
		return dateDebutMaintenance;
	}

	/**
	 * @param dateDebutMaintenance the dateDebutMaintenance to set
	 */
	public void setDateDebutMaintenance(LocalDate dateDebutMaintenance) {
		this.dateDebutMaintenance = dateDebutMaintenance;
	}

	/**
	 * @return the dateFinMaintenance
	 */
	public LocalDate getDateFinMaintenance() {
		return dateFinMaintenance;
	}

	/**
	 * @param dateFinMaintenance the dateFinMaintenance to set
	 */
	public void setDateFinMaintenance(LocalDate dateFinMaintenance) {
		this.dateFinMaintenance = dateFinMaintenance;
	}

	/**
	 * @return the coutMaintenance
	 */
	public Double getCoutMaintenance() {
		return coutMaintenance;
	}

	/**
	 * @param coutMaintenance the coutMaintenance to set
	 */
	public void setCoutMaintenance(Double coutMaintenance) {
		this.coutMaintenance = coutMaintenance;
	}

	/**
	 * @return the vehiculeMaintenance
	 */
	public Vehicule getVehiculeMaintenance() {
		return vehiculeMaintenance;
	}

	/**
	 * @param vehiculeMaintenance the vehiculeMaintenance to set
	 */
	public void setVehiculeMaintenance(Vehicule vehiculeMaintenance) {
		this.vehiculeMaintenance = vehiculeMaintenance;
	}

}
