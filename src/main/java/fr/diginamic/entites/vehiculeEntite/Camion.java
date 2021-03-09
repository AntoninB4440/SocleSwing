package fr.diginamic.entites.vehiculeEntite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "camion")
public class Camion extends Vehicule {

	@Column(name = "volume_camion", nullable = false, length = 3)
	private Short volumeCamion;

	@ManyToOne
	@JoinColumn(name = "ID_TYPE_CAMION", nullable = false)
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

	@Override
	public String toCSV() {
		// TODO Auto-generated method stub
		return this.typeCamion.getNomTypeCamion();
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
