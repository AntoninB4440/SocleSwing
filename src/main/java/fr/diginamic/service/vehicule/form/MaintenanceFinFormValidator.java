package fr.diginamic.service.vehicule.form;

import java.time.LocalDate;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;
import fr.diginamic.dao.vehiculeEntiteDao.VehiculeDao;
import fr.diginamic.service.utils.DateUtils;

public class MaintenanceFinFormValidator extends FormValidator {

	private VehiculeDao vehiculeDao = new VehiculeDao();

	@Override
	public boolean validate(Form form) {
		// TODO Auto-generated method stub

		Double coutMaintenance = Double.parseDouble(form.getValue("coutMaintenance"));
		LocalDate debutMaintenance = LocalDate.parse(form.getValue("dateDebutMaintenance"));
		LocalDate finMaintenance = DateUtils.parseLocal(form.getValue("dateFinMaintenance"));

		if (coutMaintenance <= 0) {
			console.alert("Le cout de la maintenance doit être strictement positif");
			return false;
		}

		if (finMaintenance.isBefore(debutMaintenance)) {
			console.alert("La date de fin de maintenance doit être supérieur à celle du début");
			return false;
		}

		if (finMaintenance.isAfter(LocalDate.now())) {
			console.alert("La date de fin de maintenance ne peut pas être supérieur à la date d'aujourd'hui");
			return false;
		}

		return true;
	}

}
