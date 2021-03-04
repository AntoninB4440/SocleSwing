package fr.diginamic.entites.clientEntite;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	@Column(name = "numero_adresse")
	private Short numeroAdresse;

	@Column(name = "rue_adresse", length = 255)
	private String rueAdresse;

	@Column(name = "code_postal_adresse")
	private Integer codePostalAdresse;

	@Column(name = "ville_adresse", length = 255)
	private String villeAdresse;

	@Column(name = "telephone_adresse", length = 10)
	private int telephoneAdresse;

	@Column(name = "email_adresse", length = 255)
	private String emailAdresse;

	/**
	 * 
	 */
	public Adresse() {
		super();
	}

	/**
	 * @param numeroAdresse
	 * @param rueAdresse
	 * @param codePostalAdresse
	 * @param villeAdresse
	 * @param telephoneAdresse
	 * @param emailAdresse
	 */
	public Adresse(Short numeroAdresse, String rueAdresse, Integer codePostalAdresse, String villeAdresse,
			int telephoneAdresse, String emailAdresse) {
		super();
		this.numeroAdresse = numeroAdresse;
		this.rueAdresse = rueAdresse;
		this.codePostalAdresse = codePostalAdresse;
		this.villeAdresse = villeAdresse;
		this.telephoneAdresse = telephoneAdresse;
		this.emailAdresse = emailAdresse;
	}

	/**
	 * @return the numeroAdresse
	 */
	public Short getNumeroAdresse() {
		return numeroAdresse;
	}

	/**
	 * @param numeroAdresse the numeroAdresse to set
	 */
	public void setNumeroAdresse(Short numeroAdresse) {
		this.numeroAdresse = numeroAdresse;
	}

	/**
	 * @return the rueAdresse
	 */
	public String getRueAdresse() {
		return rueAdresse;
	}

	/**
	 * @param rueAdresse the rueAdresse to set
	 */
	public void setRueAdresse(String rueAdresse) {
		this.rueAdresse = rueAdresse;
	}

	/**
	 * @return the codePostalAdresse
	 */
	public Integer getCodePostalAdresse() {
		return codePostalAdresse;
	}

	/**
	 * @param codePostalAdresse the codePostalAdresse to set
	 */
	public void setCodePostalAdresse(Integer codePostalAdresse) {
		this.codePostalAdresse = codePostalAdresse;
	}

	/**
	 * @return the villeAdresse
	 */
	public String getVilleAdresse() {
		return villeAdresse;
	}

	/**
	 * @param villeAdresse the villeAdresse to set
	 */
	public void setVilleAdresse(String villeAdresse) {
		this.villeAdresse = villeAdresse;
	}

	/**
	 * @return the telephoneAdresse
	 */
	public int getTelephoneAdresse() {
		return telephoneAdresse;
	}

	/**
	 * @param telephoneAdresse the telephoneAdresse to set
	 */
	public void setTelephoneAdresse(int telephoneAdresse) {
		this.telephoneAdresse = telephoneAdresse;
	}

	/**
	 * @return the emailAdresse
	 */
	public String getEmailAdresse() {
		return emailAdresse;
	}

	/**
	 * @param emailAdresse the emailAdresse to set
	 */
	public void setEmailAdresse(String emailAdresse) {
		this.emailAdresse = emailAdresse;
	}

}
