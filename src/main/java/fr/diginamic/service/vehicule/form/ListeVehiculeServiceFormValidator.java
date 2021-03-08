package fr.diginamic.service.vehicule.form;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;

public class ListeVehiculeServiceFormValidator extends FormValidator {

	@Override
	public boolean validate(Form form) {
		// TODO Auto-generated method stub
		String marque = form.getValue("champMarque");
		String modele = form.getValue("champModele");
		String immatriculation = form.getValue("champImma");
		String kilometrage = form.getValue("champKilo");

		if (marque.trim().isEmpty()) {
			console.alert("La marque est obligatoire");
			return false;
		}
		if (modele.trim().isEmpty()) {
			console.alert("Le model est obligatoire");
			return false;
		}
		if (kilometrage.trim().isEmpty()) {
			console.alert("Le kilometrage est obligatoire");
			return false;
		}

		if (Double.parseDouble(kilometrage) < 0) {
			console.alert("Le kilometrage doit être positif");
			return false;
		}

		if (immatriculation.trim().isEmpty()) {
			console.alert("L'immatriculation est obligatoire");
			return false;
		}
		if (!immatriculation.toUpperCase().matches("[A-Z]{2}[-][0-9]{3}[-][A-Z]{2}")) {
			console.alert("L'immatriculation du vehicule doit être au format AA-111-AA");
			return false;
		}
		return true;
	}

}
