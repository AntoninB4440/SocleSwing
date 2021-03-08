package fr.diginamic.service.client.form;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;

public class ListeClientServiceFormValidator extends FormValidator {

	@Override
	public boolean validate(Form form) {
		String nomClient = form.getValue("champNom");
		String prenomClient = form.getValue("champPrenom");
		String numeroRueClient = form.getValue("champNumeroRue");
		String rueClient = form.getValue("champRue");
		String codePostalClient = form.getValue("champCodePostal");
		String villeClient = form.getValue("champVille");
		String telephoneClient = form.getValue("champTelephone");
		String emailClient = form.getValue("champEmail");

		if (nomClient.isEmpty()) {
			console.alert("Le nom du client est obligatoire");
			return false;
		}
		if (prenomClient.isEmpty()) {
			console.alert("Le prenom du client est obligatoire");
			return false;
		}
		if (numeroRueClient.isEmpty()) {
			console.alert("Le numéro de la rue est obligatoire");
			return false;
		}
		if (rueClient.isEmpty()) {
			console.alert("Le nom de la rue est obligatoire");
			return false;
		}
		if (codePostalClient.isEmpty()) {
			console.alert("Le code postal est obligatoire");
			return false;
		}
		if (villeClient.isEmpty()) {
			console.alert("La ville est obligatoire");
			return false;
		}
		if (!telephoneClient.matches("^0[1-9](-\\d{2}){4}$")) {
			console.alert("Le numéro de téléphone doit être au format XX-XX-XX-XX-XX");
			return false;
		}
		if (!emailClient.toLowerCase().matches("^[\\w]+(?:.[\\w]+)*@(?:[a-zA-Z0-9-]+.)+[a-zA-Z]{2,6}$")) {
			console.alert("Le numéro de téléphone doit être au format xxxxxxx@xxxx.xxx");
			return false;
		}

		return true;
	}

}
