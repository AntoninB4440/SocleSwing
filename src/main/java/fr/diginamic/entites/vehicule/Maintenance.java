package fr.diginamic.entites.vehicule;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "maintenance")
public class Maintenance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "date_debut_maintenance", nullable = false)
	private LocalDate dateDebutMaintenance;

	@Column(name = "date_fin_maintenance", nullable = false)
	private LocalDate dateFinMaintenance;

	@Column(name = "cout_maintenance", nullable = false)
	private Double coutMaintenance;

}
