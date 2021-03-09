package fr.diginamic.entites.clientEntite;

import fr.diginamic.composants.ui.Selectable;

public enum TypePermis implements Selectable {

	A1("a1", 1L), A("a", 2L), B1("b1", 3L), B("b", 4L), C("c", 5L), D("d", 6L), EB("eb", 7L), EC("ec", 8L),
	ED("ed", 9L);

	private String type;
	private Long id;

	TypePermis(String type, Long id) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.id = id;
	}

	public static TypePermis findLibelle(String string) {
		// TODO Auto-generated method stub
		TypePermis[] listPermis = TypePermis.values();
		for (TypePermis permis : listPermis) {
			if (permis.getType().equals(string.toLowerCase())) {
				return permis;
			}

		}
		return null;
	}

	public static TypePermis findById(Long id) {
		// TODO Auto-generated method stub
		TypePermis[] listPermis = TypePermis.values();
		for (TypePermis permis : listPermis) {
			if (permis.getId() == id) {
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

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
