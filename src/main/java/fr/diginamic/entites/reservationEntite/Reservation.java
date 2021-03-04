package fr.diginamic.entites.reservationEntite;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.diginamic.entites.vehiculeEntite.Vehicule;

@Entity
@Table(name = "reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "date_debut_reservation", nullable = false)
	private LocalDate dateDebutReservation;

	@Column(name = "date_fin_prevu_reservation", nullable = false)
	private LocalDate dateFinPrevuReservation;

	@Column(name = "kilometrage_fin_reservation")
	private int kilometrageFinVehicule;

	@Column(name = "date_fin_reel_reservation")
	private LocalDate dateFinReelReservation;

	private Facture reservationFacture;

	private Client clientReservation;

	private Vehicule vehiculeReservation;

	@Column(name = "kilometrage_debut_reservation", nullable = false)
	private int kilometrageDebutVehicule = vehiculeReservation.getKilometrageVehicule();

	@Column(name = "commentaire_vehicule_reservation", length = 255)
	private String commentaireVehiculeReservation;

	/**
	 * 
	 */
	public Reservation() {
		super();
	}

	/**
	 * @param dateDebutReservation
	 * @param dateFinPrevuReservation
	 * @param clientReservation
	 * @param vehiculeReservation
	 * @param kilometrageDebutVehicule
	 */
	public Reservation(LocalDate dateDebutReservation, LocalDate dateFinPrevuReservation, Client clientReservation,
			Vehicule vehiculeReservation, int kilometrageDebutVehicule) {
		super();
		this.dateDebutReservation = dateDebutReservation;
		this.dateFinPrevuReservation = dateFinPrevuReservation;
		this.clientReservation = clientReservation;
		this.vehiculeReservation = vehiculeReservation;
		this.kilometrageDebutVehicule = kilometrageDebutVehicule;
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
	 * @return the dateDebutReservation
	 */
	public LocalDate getDateDebutReservation() {
		return dateDebutReservation;
	}

	/**
	 * @param dateDebutReservation the dateDebutReservation to set
	 */
	public void setDateDebutReservation(LocalDate dateDebutReservation) {
		this.dateDebutReservation = dateDebutReservation;
	}

	/**
	 * @return the dateFinPrevuReservation
	 */
	public LocalDate getDateFinPrevuReservation() {
		return dateFinPrevuReservation;
	}

	/**
	 * @param dateFinPrevuReservation the dateFinPrevuReservation to set
	 */
	public void setDateFinPrevuReservation(LocalDate dateFinPrevuReservation) {
		this.dateFinPrevuReservation = dateFinPrevuReservation;
	}

	/**
	 * @return the kilometrageFinVehicule
	 */
	public int getKilometrageFinVehicule() {
		return kilometrageFinVehicule;
	}

	/**
	 * @param kilometrageFinVehicule the kilometrageFinVehicule to set
	 */
	public void setKilometrageFinVehicule(int kilometrageFinVehicule) {
		this.kilometrageFinVehicule = kilometrageFinVehicule;
	}

	/**
	 * @return the dateFinReelReservation
	 */
	public LocalDate getDateFinReelReservation() {
		return dateFinReelReservation;
	}

	/**
	 * @param dateFinReelReservation the dateFinReelReservation to set
	 */
	public void setDateFinReelReservation(LocalDate dateFinReelReservation) {
		this.dateFinReelReservation = dateFinReelReservation;
	}

	/**
	 * @return the reservationFacture
	 */
	public Facture getReservationFacture() {
		return reservationFacture;
	}

	/**
	 * @param reservationFacture the reservationFacture to set
	 */
	public void setReservationFacture(Facture reservationFacture) {
		this.reservationFacture = reservationFacture;
	}

	/**
	 * @return the clientReservation
	 */
	public Client getClientReservation() {
		return clientReservation;
	}

	/**
	 * @param clientReservation the clientReservation to set
	 */
	public void setClientReservation(Client clientReservation) {
		this.clientReservation = clientReservation;
	}

	/**
	 * @return the vehiculeReservation
	 */
	public Vehicule getVehiculeReservation() {
		return vehiculeReservation;
	}

	/**
	 * @param vehiculeReservation the vehiculeReservation to set
	 */
	public void setVehiculeReservation(Vehicule vehiculeReservation) {
		this.vehiculeReservation = vehiculeReservation;
	}

	/**
	 * @return the kilometrageDebutVehicule
	 */
	public int getKilometrageDebutVehicule() {
		return kilometrageDebutVehicule;
	}

	/**
	 * @param kilometrageDebutVehicule the kilometrageDebutVehicule to set
	 */
	public void setKilometrageDebutVehicule(int kilometrageDebutVehicule) {
		this.kilometrageDebutVehicule = kilometrageDebutVehicule;
	}

	/**
	 * @return the commentaireVehiculeReservation
	 */
	public String getCommentaireVehiculeReservation() {
		return commentaireVehiculeReservation;
	}

	/**
	 * @param commentaireVehiculeReservation the commentaireVehiculeReservation to
	 *                                       set
	 */
	public void setCommentaireVehiculeReservation(String commentaireVehiculeReservation) {
		this.commentaireVehiculeReservation = commentaireVehiculeReservation;
	}

}
