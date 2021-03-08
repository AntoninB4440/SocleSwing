package fr.diginamic.service.vehicule.form;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;

public class VoitureFormValidator extends FormValidator {

	@Override
	public boolean validate(Form form) {
		String nbPlace = form.getValue("champNbPlace");

		if (nbPlace.trim().isEmpty()) {
			console.alert("Le nombre de place est obligatoire");
			return false;
		}
		// TODO Auto-generated method stub
		return true;
	}

}
