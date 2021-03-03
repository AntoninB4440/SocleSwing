package fr.diginamic.entites.vehicule;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "voiture")
public class Voiture extends Vehicule {

	@Column(name = "nombre_place_voiture", nullable = false, length = 1)
	private Short nombrePlaceVoiture;

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
