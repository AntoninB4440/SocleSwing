package fr.diginamic.entites.clientEntite;

public enum TypePermis {

	A1("a1"), A("a"), B1("b1"), B("b"), C("c"), D("d"), EB("eb"), EC("ec"), ED("ed");

	private String type;

	TypePermis(String type) {
		// TODO Auto-generated constructor stub
		this.type = type;
	}

	public static TypePermis find(String string) {
		// TODO Auto-generated method stub
		TypePermis[] listPermis = TypePermis.values();
		for (TypePermis permis : listPermis) {
			if (permis.getType().equals(string.toLowerCase())) {
				return permis;
			}

		}
		return null;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
