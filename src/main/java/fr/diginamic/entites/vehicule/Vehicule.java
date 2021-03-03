package fr.diginamic.entites.vehicule;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicule")
public class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "statut_vehicule", length = 255)
	@Enumerated(EnumType.STRING)
	private StatutVehicule statutVehicule = StatutVehicule.DISPONIBLE;

	@Column(name = "marque_vehicule", nullable = false, length = 255)
	private String marqueVehicule;

	@Column(name = "modele_vehicule", nullable = false, length = 255)
	private String modeleVehicule;

	@Column(name = "immatriculation_vehicule", nullable = false, length = 11)
	private String immatriculationVehicule;

	@Column(name = "kilometrage_vehicule", nullable = false, length = 11)
	private int kilometrageVehicule;

	private List<Maintenance> maintenanceVehicule = new ArrayList();

	private List<Reservation> reservationVehicule = new ArrayList();

	/**
	 * 
	 */
	public Vehicule() {
		super();
	}

	/**
	 * @param marqueVehicule
	 * @param modeleVehicule
	 * @param immatriculationVehicule
	 * @param kilometrageVehicule
	 */
	public Vehicule(String marqueVehicule, String modeleVehicule, String immatriculationVehicule,
			int kilometrageVehicule) {
		super();
		this.marqueVehicule = marqueVehicule;
		this.modeleVehicule = modeleVehicule;
		this.immatriculationVehicule = immatriculationVehicule;
		this.kilometrageVehicule = kilometrageVehicule;
	}

}
