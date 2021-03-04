package fr.diginamic.entites.clientEntite;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.diginamic.entites.reservationEntite.Reservation;

@Entity
@Table(name = "permis")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "nom_client", nullable = false, length = 255)
	private String nomClient;

	@Column(name = "prenom_client", nullable = false, length = 255)
	private String prenomClient;

	@Embedded
	private Adresse adresseClient;

	@OneToOne
	@JoinColumn(name = "ID_PERMIS")
	private Permis permisClient;

	@OneToMany(mappedBy = "clientReservation")
	private List<Reservation> reservationsClient = new ArrayList<Reservation>();

	/**
	 * 
	 */
	public Client() {
		super();
	}

	/**
	 * @param nomClient
	 * @param prenomClient
	 * @param adresseClient
	 * @param permisClient
	 */
	public Client(String nomClient, String prenomClient, Adresse adresseClient, Permis permisClient) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresseClient = adresseClient;
		this.permisClient = permisClient;
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
	 * @return the prenomClient
	 */
	public String getPrenomClient() {
		return prenomClient;
	}

	/**
	 * @param prenomClient the prenomClient to set
	 */
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	/**
	 * @return the adresseClient
	 */
	public Adresse getAdresseClient() {
		return adresseClient;
	}

	/**
	 * @param adresseClient the adresseClient to set
	 */
	public void setAdresseClient(Adresse adresseClient) {
		this.adresseClient = adresseClient;
	}

	/**
	 * @return the permisClient
	 */
	public Permis getPermisClient() {
		return permisClient;
	}

	/**
	 * @param permisClient the permisClient to set
	 */
	public void setPermisClient(Permis permisClient) {
		this.permisClient = permisClient;
	}

	/**
	 * @return the reservationsClient
	 */
	public List<Reservation> getReservationsClient() {
		return reservationsClient;
	}

	/**
	 * @param reservationsClient the reservationsClient to set
	 */
	public void setReservationsClient(List<Reservation> reservationsClient) {
		this.reservationsClient = reservationsClient;
	}

}
