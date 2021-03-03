package fr.diginamic.entites.vehicule;

public enum StatutVehicule {

	DISPONIBLE("displonible"), LOUE("loue"), MAINTENANCE("maintenance");

	private String statut;

	StatutVehicule(String statut) {
		// TODO Auto-generated constructor stub
		this.statut = statut;
	}

	public static StatutVehicule find(String string) {
		// TODO Auto-generated method stub
		StatutVehicule[] listStatuts = StatutVehicule.values();
		for (StatutVehicule statut : listStatuts) {
			if (statut.getStatut().equals(statut)) {
				return statut;
			}
		}
		return null;
	}

	/**
	 * @return the statut
	 */
	public String getStatut() {
		return statut;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}

}
