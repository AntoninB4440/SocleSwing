package fr.diginamic.entites.vehiculeEntite;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.diginamic.entites.reservationEntite.Reservation;

@Entity
@Table(name = "vehicule")
@Inheritance(strategy = InheritanceType.JOINED)
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

	@OneToMany(mappedBy = "vehiculeMaintenance")
	private List<Maintenance> maintenanceVehicule = new ArrayList();

	@OneToMany(mappedBy = "vehiculeReservation")
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
	 * @return the statutVehicule
	 */
	public StatutVehicule getStatutVehicule() {
		return statutVehicule;
	}

	/**
	 * @param statutVehicule the statutVehicule to set
	 */
	public void setStatutVehicule(StatutVehicule statutVehicule) {
		this.statutVehicule = statutVehicule;
	}

	/**
	 * @return the marqueVehicule
	 */
	public String getMarqueVehicule() {
		return marqueVehicule;
	}

	/**
	 * @param marqueVehicule the marqueVehicule to set
	 */
	public void setMarqueVehicule(String marqueVehicule) {
		this.marqueVehicule = marqueVehicule;
	}

	/**
	 * @return the modeleVehicule
	 */
	public String getModeleVehicule() {
		return modeleVehicule;
	}

	/**
	 * @param modeleVehicule the modeleVehicule to set
	 */
	public void setModeleVehicule(String modeleVehicule) {
		this.modeleVehicule = modeleVehicule;
	}

	/**
	 * @return the immatriculationVehicule
	 */
	public String getImmatriculationVehicule() {
		return immatriculationVehicule;
	}

	/**
	 * @param immatriculationVehicule the immatriculationVehicule to set
	 */
	public void setImmatriculationVehicule(String immatriculationVehicule) {
		this.immatriculationVehicule = immatriculationVehicule;
	}

	/**
	 * @return the kilometrageVehicule
	 */
	public int getKilometrageVehicule() {
		return kilometrageVehicule;
	}

	/**
	 * @param kilometrageVehicule the kilometrageVehicule to set
	 */
	public void setKilometrageVehicule(int kilometrageVehicule) {
		this.kilometrageVehicule = kilometrageVehicule;
	}

	/**
	 * @return the maintenanceVehicule
	 */
	public List<Maintenance> getMaintenanceVehicule() {
		return maintenanceVehicule;
	}

	/**
	 * @param maintenanceVehicule the maintenanceVehicule to set
	 */
	public void setMaintenanceVehicule(List<Maintenance> maintenanceVehicule) {
		this.maintenanceVehicule = maintenanceVehicule;
	}

	/**
	 * @return the reservationVehicule
	 */
	public List<Reservation> getReservationVehicule() {
		return reservationVehicule;
	}

	/**
	 * @param reservationVehicule the reservationVehicule to set
	 */
	public void setReservationVehicule(List<Reservation> reservationVehicule) {
		this.reservationVehicule = reservationVehicule;
	}

}
