package fr.diginamic.service.vehicule;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;

public class ListeTypeVehiculeFormValidator extends FormValidator {

	@Override
	public boolean validate(Form form) {
		// TODO Auto-generated method stub
		String typeVehicule = form.getValue("champType");
		String prixJourna = form.getValue("champPrix");
		String prixCaution = form.getValue("champCaution");

		if (typeVehicule.trim().isEmpty()) {
			console.alert("Le type du camion est obligatoire");
			return false;
		}
		if (prixJourna.trim().isEmpty()) {
			console.alert("Le prix journalier est obligatoire");
			return false;
		}
		if (prixCaution.trim().isEmpty()) {
			console.alert("Le prix de la caution est obligatoire");
			return false;
		}
		if (Double.parseDouble(prixCaution) <= 0) {
			console.alert("Le prix de la caution doit être strictement positif");
			return false;
		}
		if (Double.parseDouble(prixJourna) <= 0) {
			console.alert("Le prix journalier doit être strictement positif");
			return false;
		}
		return true;
	}

}
