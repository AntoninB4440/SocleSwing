package fr.diginamic.service.vehicule;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;

public class ListeVehiculeServiceFormValidator extends FormValidator {

	@Override
	public boolean validate(Form form) {
		// TODO Auto-generated method stub
		String nvImmatriculation = form.getValue("champImma");

		if (nvImmatriculation.trim().isEmpty()) {
			console.alert("L'immatriculation est obligatoire");
			return false;
		} else if (!nvImmatriculation.toUpperCase().matches("[A-Z]{2}[-][0-9]{3}[-][A-Z]{2}")) {
			console.alert("L'immatriculation du vehicule doit être au format AA-111-AA");
			return false;
		}
		return true;
	}

}
