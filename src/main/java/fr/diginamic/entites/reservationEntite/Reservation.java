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
}
