package fr.diginamic.service.utils.VehiculeUtils;

import fr.diginamic.composants.ui.Selectable;

public class VehiculeUtils implements Selectable {

	private Long id;
	private String value;

	public VehiculeUtils(String string) {
		// TODO Auto-generated constructor stub
		this.value = string;
	}

	public VehiculeUtils(Long id, String string) {
		this.id = id;
		this.value = string;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String toString() {
		return value;
	}

}
