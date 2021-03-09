package fr.diginamic.entites.vehiculeEntite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voiture")
public class Voiture extends Vehicule {

	@Column(name = "nombre_place_voiture", nullable = false, length = 1)
	private Short nombrePlaceVoiture;

	@ManyToOne
	@JoinColumn(name = "ID_TYPE_VOITURE")
	private TypeVoiture typeVoiture;

	public Voiture() {
		// TODO Auto-generated constructor stub
	}

	public Voiture(String marqueVehicule, String modeleVehicule, String immatriculationVehicule,
			int kilometrageVehicule, TypeVoiture typeVoiture, Short nombrePlaceVoiture) {
		super(marqueVehicule, modeleVehicule, immatriculationVehicule, kilometrageVehicule);
		// TODO Auto-generated constructor stub
		this.typeVoiture = typeVoiture;
		this.nombrePlaceVoiture = nombrePlaceVoiture;
	}

	@Override
	public String toCSV() {
		// TODO Auto-generated method stub
		return this.typeVoiture.getNomTypeVoiture();
	}

	/**
	 * @return the nombrePlaceVoiture
	 */
	public Short getNombrePlaceVoiture() {
		return nombrePlaceVoiture;
	}

	/**
	 * @param nombrePlaceVoiture the nombrePlaceVoiture to set
	 */
	public void setNombrePlaceVoiture(Short nombrePlaceVoiture) {
		this.nombrePlaceVoiture = nombrePlaceVoiture;
	}

	/**
	 * @return the typeVoiture
	 */
	public TypeVoiture getTypeVoiture() {
		return typeVoiture;
	}

	/**
	 * @param typeVoiture the typeVoiture to set
	 */
	public void setTypeVoiture(TypeVoiture typeVoiture) {
		this.typeVoiture = typeVoiture;
	}

}
