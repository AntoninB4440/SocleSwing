package fr.diginamic.entites.reservationEntite;

public enum TypePaiement {

	CB(new String[] { "cb", "carte banacaire" }), LIQUIDE(new String[] { "liquide", "espece", "espèce" }),
	CHEQUE(new String[] { "cheque", "chèque" });

	private String[] reglement;

	TypePaiement(String[] strings) {
		// TODO Auto-generated constructor stub
		this.reglement = strings;
	}

	public static TypePaiement find(String string) {
		// TODO Auto-generated method stub
		TypePaiement[] listReglements = TypePaiement.values();
		for (TypePaiement reglement : listReglements) {
			for (String typePaiement : reglement.getReglement()) {
				if (typePaiement.equals(string.toLowerCase())) {
					return reglement;
				}
			}
		}
		return null;
	}

	/**
	 * @return the statut
	 */
	public String[] getReglement() {
		return reglement;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setReglement(String[] reglement) {
		this.reglement = reglement;
	}
}
