package fr.diginamic.service.vehicule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.ComboBox;
import fr.diginamic.composants.ui.DateField;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.Selectable;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.dao.vehiculeEntiteDao.MaintenanceDao;
import fr.diginamic.dao.vehiculeEntiteDao.VehiculeDao;
import fr.diginamic.database.DatabaseAccess;
import fr.diginamic.entites.vehiculeEntite.Maintenance;
import fr.diginamic.entites.vehiculeEntite.StatutVehicule;
import fr.diginamic.entites.vehiculeEntite.Vehicule;
import fr.diginamic.service.utils.DateUtils;
import fr.diginamic.service.vehicule.form.MaintenanceFinFormValidator;
import fr.diginamic.service.vehicule.form.MaintenanceFormValidator;

public class ListeMaintenanceService extends MenuService {

	private VehiculeDao vehiculeDao = new VehiculeDao();
	private MaintenanceDao maintenanceDao = new MaintenanceDao();

	@Override
	public void traitement() {
		// TODO Auto-generated method stub

		List<Maintenance> maintenances = maintenanceDao.findAll();

		console.clear();
		console.print("<h1 class='bg-red'><center>Liste des maintenances</center></h1>");
		
		String html = "<table class='table' cellspacing=0>"
				+ "<tr class='bg-red'>"
				+ "		<td>Date de début</td>"
				+ "		<td>Date de fin</td>"
				+ "		<td>Marque</td>"
				+ "		<td>Modele</td>"
				+ "		<td>Immatriculation</td>"
				+ "		<td>Coût</td>"
				+ "		<td>&nbsp;</td>"
				+ "</tr>";
		
		for (Maintenance m : maintenances) {
			
			if (m.getDateFinMaintenance() == null)
			{
				html += "<tr> "
						+ " <td width='150px'>" + m.getDateDebutMaintenance() + "</td>"
						+ " <td width='150px'>" + m.getDateFinMaintenance() + "</td>"
						+ " <td width='150px'>" + m.getVehiculeMaintenance().getMarqueVehicule() + "</td>"
						+ " <td width='150px'>" + m.getVehiculeMaintenance().getModeleVehicule() + "</td>"
						+ " <td width='150px'>" + m.getVehiculeMaintenance().getImmatriculationVehicule() + "</td>"
						+ " <td width='150px'>" + m.getCoutMaintenance()+ "</td>"
						+ " <td><a class='btn-green' href='valider(" + m.getId() + ")'<img width=25 src ='images/check-square-green.png'></a></td>"
					+ "</tr>";
			} else {
				html += "<tr> "
						+ " <td width='150px'>" + m.getDateDebutMaintenance() + "</td>"
						+ " <td width='150px'>" + m.getDateFinMaintenance() + "</td>"
						+ " <td width='150px'>" + m.getVehiculeMaintenance().getMarqueVehicule() + "</td>"
						+ " <td width='150px'>" + m.getVehiculeMaintenance().getModeleVehicule() + "</td>"
						+ " <td width='150px'>" + m.getVehiculeMaintenance().getImmatriculationVehicule() + "</td>"
						+ " <td width='150px'>" + m.getCoutMaintenance()+ "</td>"
						+ "		<td>&nbsp;</td>"
					+ "</tr>";
			}
			
		}
		
		html += "</table>";
		html += "<a class='btn-blue' href='ajouter()'><img width=30 src='images/plus-blue.png'></a>";

		console.print(html);
	}
	
	public void ajouter() {
		Form form = new Form();
		
		form.addInput(new DateField("Date de début de la maintenance : ","dateDebutMaintenance" ));
		
		List<Selectable> listeVehicules = new ArrayList<>();
		
		List<Vehicule> resultatVehicules = vehiculeDao.findAll();
		
		for (Vehicule vehicule : resultatVehicules) {
			listeVehicules.add(vehicule);
		}
		
		form.addInput(new ComboBox("Liste immatriculation vehicule :", "listeVehicules", listeVehicules, listeVehicules.get(0)));
		
		MaintenanceFormValidator validator = new MaintenanceFormValidator();
		
		boolean valide = console.input("Ajout d'une maintenance", form, validator);
		
		if(valide) {
			String debutMaintenance = form.getValue("dateDebutMaintenance");
			LocalDate dateDebutMaintenance = DateUtils.parseLocal(debutMaintenance);
			
			Vehicule vehiculeTrouve = vehiculeDao.findById(Long.parseLong(form.getValue("listeVehicules")));
			
			Maintenance maintenanceCree = new Maintenance(dateDebutMaintenance, vehiculeTrouve);
		
			maintenanceDao.create(maintenanceCree);
				
			vehiculeTrouve.getMaintenanceVehicule().add(maintenanceCree);
			vehiculeTrouve.setStatutVehicule(StatutVehicule.MAINTENANCE);
			
			vehiculeDao.update(vehiculeTrouve);
			
			traitement();
		}
	}
	
	public void valider(Long id ) {
		
		Maintenance m = maintenanceDao.findById(id);
		
		Form form = new Form();
		
		form.addInput(new TextField("Date de début de la maintenance : ","dateDebutMaintenance" , m.getDateDebutMaintenance().toString() ,false));
		form.addInput(new DateField("Date de fin de la maintenance : ","dateFinMaintenance" ));
		form.addInput(new TextField("Immatriculation du vehicule : ", "immaVehicule", m.getVehiculeMaintenance().getImmatriculationVehicule(), false));
		form.addInput(new TextField("Cout de la maintenance : ", "coutMaintenance"));
		
		MaintenanceFinFormValidator validator = new MaintenanceFinFormValidator();
		
		boolean valide = console.input("Validation de la maintenance", form, validator);
		
		if(valide) {
			String finMaintenance = form.getValue("dateFinMaintenance");
			LocalDate dateFinMaintenance = DateUtils.parseLocal(finMaintenance);
			Double coutMaintenance = Double.parseDouble(form.getValue("coutMaintenance"));
			
			m.setCoutMaintenance(coutMaintenance);
			m.setDateFinMaintenance(dateFinMaintenance);
			
			Vehicule vehiculeTrouve = vehiculeDao.findById(m.getVehiculeMaintenance().getId());
			vehiculeTrouve.setStatutVehicule(StatutVehicule.DISPONIBLE);
			
			maintenanceDao.update(m);
			vehiculeDao.update(vehiculeTrouve);
			
			traitement();
		}
	}

}
