package fr.diginamic.service.vehicule;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;

public class CamionFormValidator extends FormValidator {

	@Override
	public boolean validate(Form form) {
		String volumeCamion = form.getValue("typeCamion");

		if (volumeCamion.trim().isEmpty()) {
			console.alert("Le nombre de place est obligatoire");
			return false;
		}
		if (Short.parseShort(volumeCamion) <= 0) {
			console.alert("Le volume doit être strictement positif");
			return false;
		}
		// TODO Auto-generated method stub
		return true;
	}

}
