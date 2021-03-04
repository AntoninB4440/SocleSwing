package fr.diginamic.entites.reservationEntite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "facture")
public class Facture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "numero_facture", nullable = false, unique = true)
	private int numeroFacture;

	@Column(name = "cout_facture", nullable = false)
	private Double coutFacture;

	@Column(name = "nom_client_facture", nullable = false)
	private String nomClient;

	@OneToOne
	@JoinColumn(name = "ID_reservation")
	private Reservation reservationFacture;

	@Column(name = "statut_facture", length = 255, nullable = false)
	@Enumerated(EnumType.STRING)
	private StatutFacture statutFacture = StatutFacture.NONPAYE;

	@Column(name = "type_paiement_facture", length = 255)
	@Enumerated(EnumType.STRING)
	private TypePaiement typePaiementFacture;

	/**
	 * 
	 */
	public Facture() {
		super();
	}

	/**
	 * @param numeroFacture
	 * @param coutFacture
	 * @param nomClient
	 * @param reservationFacture
	 */
	public Facture(int numeroFacture, Double coutFacture, String nomClient, Reservation reservationFacture) {
		super();
		this.numeroFacture = numeroFacture;
		this.coutFacture = coutFacture;
		this.nomClient = nomClient;
		this.reservationFacture = reservationFacture;
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
	 * @return the numeroFacture
	 */
	public int getNumeroFacture() {
		return numeroFacture;
	}

	/**
	 * @param numeroFacture the numeroFacture to set
	 */
	public void setNumeroFacture(int numeroFacture) {
		this.numeroFacture = numeroFacture;
	}

	/**
	 * @return the coutFacture
	 */
	public Double getCoutFacture() {
		return coutFacture;
	}

	/**
	 * @param coutFacture the coutFacture to set
	 */
	public void setCoutFacture(Double coutFacture) {
		this.coutFacture = coutFacture;
	}

	/**
	 * @return the nomClient
	 */
	public String getNomClient() {
		return nomClient;
	}

	/**
	 * @param nomClient the nomClient to set
	 */
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	/**
	 * @return the reservationFacture
	 */
	public Reservation getReservationFacture() {
		return reservationFacture;
	}

	/**
	 * @param reservationFacture the reservationFacture to set
	 */
	public void setReservationFacture(Reservation reservationFacture) {
		this.reservationFacture = reservationFacture;
	}

	/**
	 * @return the statutFacture
	 */
	public StatutFacture getStatutFacture() {
		return statutFacture;
	}

	/**
	 * @param statutFacture the statutFacture to set
	 */
	public void setStatutFacture(StatutFacture statutFacture) {
		this.statutFacture = statutFacture;
	}

	/**
	 * @return the typePaiementFacture
	 */
	public TypePaiement getTypePaiementFacture() {
		return typePaiementFacture;
	}

	/**
	 * @param typePaiementFacture the typePaiementFacture to set
	 */
	public void setTypePaiementFacture(TypePaiement typePaiementFacture) {
		this.typePaiementFacture = typePaiementFacture;
	}

}
