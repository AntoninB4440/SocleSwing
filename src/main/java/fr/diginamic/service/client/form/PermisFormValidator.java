package fr.diginamic.service.client.form;

import java.time.LocalDate;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;
import fr.diginamic.service.utils.DateUtils;

public class PermisFormValidator extends FormValidator {

	@Override
	public boolean validate(Form form) {
		// TODO Auto-generated method stub

		String numeroPermis = form.getValue("champNumeroPermis");
		LocalDate dateObtention = DateUtils.parseLocal(form.getValue("champDateObtention"));

		if (numeroPermis.isEmpty()) {
			console.alert("Le numéro du permis est obligatoire");
			return false;
		}

		if (dateObtention.isAfter(LocalDate.now())) {
			console.alert("La date d'obtention ne peut pas être supérieur à la date d'aujourd'hui");
			return false;
		}
		return true;
	}

}
