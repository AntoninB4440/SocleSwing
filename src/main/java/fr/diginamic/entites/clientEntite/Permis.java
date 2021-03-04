package fr.diginamic.entites.clientEntite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permis")
public class Permis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "numero_permis", nullable = false)
	private int numeroPermis;

	@Column(name = "date_obtention_permis", nullable = false)
	private int dateObtentionPermis;

	@Column(name = "type_permis", nullable = false)
	@Enumerated(EnumType.STRING)
	private TypePermis typePermis;

	/**
	 * 
	 */
	public Permis() {
		super();
	}

	/**
	 * @param numeroPermis
	 * @param dateObtentionPermis
	 * @param typePermis
	 */
	public Permis(int numeroPermis, int dateObtentionPermis, String typePermis) {
		super();
		this.numeroPermis = numeroPermis;
		this.dateObtentionPermis = dateObtentionPermis;
		this.typePermis = TypePermis.find(typePermis);
	}

}
