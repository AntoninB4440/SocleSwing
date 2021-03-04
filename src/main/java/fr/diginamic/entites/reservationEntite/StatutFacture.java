package fr.diginamic.entites.reservationEntite;

public enum StatutFacture {

	NONPAYE("non paye"), PAYE("paye");

	private String statut;

	StatutFacture(String statut) {
		// TODO Auto-generated constructor stub
		this.statut = statut;
	}

	public static StatutFacture find(String string) {
		// TODO Auto-generated method stub
		StatutFacture[] listStatuts = StatutFacture.values();
		for (StatutFacture statut : listStatuts) {
			if (statut.getStatut().equals(string.toLowerCase())) {
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
