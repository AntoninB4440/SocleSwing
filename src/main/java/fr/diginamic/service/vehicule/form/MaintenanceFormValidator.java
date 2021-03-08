package fr.diginamic.service.vehicule.form;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;
import fr.diginamic.dao.vehiculeEntiteDao.VehiculeDao;
import fr.diginamic.entites.vehiculeEntite.StatutVehicule;
import fr.diginamic.entites.vehiculeEntite.Vehicule;

public class MaintenanceFormValidator extends FormValidator {

	private VehiculeDao vehiculeDao = new VehiculeDao();

	@Override
	public boolean validate(Form form) {
		// TODO Auto-generated method stub

		Vehicule vehiculeTrouve = vehiculeDao.findById(Long.parseLong(form.getValue("listeVehicules")));

		if (vehiculeTrouve.getStatutVehicule() != StatutVehicule.DISPONIBLE) {
			console.alert("Le véhicule est actuellement loué ou en maintenance");
			return false;
		}
		return true;
	}

}
