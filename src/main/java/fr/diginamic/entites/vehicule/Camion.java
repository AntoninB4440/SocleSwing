package fr.diginamic.entites.vehicule;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "camion")
public class Camion extends Vehicule {

	@Column(name = "volume_camion", nullable = false, length = 3)
	private Short volumeCamion;

	private TypeCamion typeCamion;

	public Camion() {
		// TODO Auto-generated constructor stub
	}

	public Camion(String marqueVehicule, String modeleVehicule, String immatriculationVehicule, int kilometrageVehicule,
			TypeCamion typeCamion, Short volumeCamion) {
		super(marqueVehicule, modeleVehicule, immatriculationVehicule, kilometrageVehicule);
		// TODO Auto-generated constructor stub
		this.typeCamion = typeCamion;
		this.volumeCamion = volumeCamion;
	}

	/**
	 * @return the volumeCamion
	 */
	public short getVolumeCamion() {
		return volumeCamion;
	}

	/**
	 * @param volumeCamion the volumeCamion to set
	 */
	public void setVolumeCamion(short volumeCamion) {
		this.volumeCamion = volumeCamion;
	}

	/**
	 * @return the typeCamion
	 */
	public TypeCamion getTypeCamion() {
		return typeCamion;
	}

	/**
	 * @param typeCamion the typeCamion to set
	 */
	public void setTypeCamion(TypeCamion typeCamion) {
		this.typeCamion = typeCamion;
	}

}
