package fr.diginamic.service.vehicule;

import java.util.List;

import javax.persistence.EntityManager;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.dao.vehiculeEntiteDao.TypeCamionDao;
import fr.diginamic.database.DatabaseAccess;
import fr.diginamic.entites.vehiculeEntite.TypeCamion;
import fr.diginamic.service.vehicule.form.ListeTypeVehiculeFormValidator;

public class ListeTypeCamion extends MenuService {

	private EntityManager em = DatabaseAccess.getEntityManager();

	private TypeCamionDao typeCamionDao = new TypeCamionDao();

	@Override
	public void traitement() {
		// TODO Auto-generated method stub

		List<TypeCamion> listTypeCamion = typeCamionDao.findAll();

		console.clear();
		console.print("<h1 class='bg-green'><center>Liste des véhicules</center></h1>");

		String html = "<table class='table' cellspacing=0>"
				+ "<tr class='bg-green'><td>&nbsp;</td><td>&nbsp;</td><td>Type Vehicule</td><td>Prix Journalier (€/J)</td><td>Prix Caution</td></tr>";

		for (TypeCamion tc : listTypeCamion) {
			html += "<tr>" + "  <td><a class='btn-blue' href='modifier(" + tc.getId()
					+ ")'><img width=25 src='images/pencil-blue-xs.png'></a></td>"
					+ " <td><a class='btn-red' href='supprimer(" + tc.getId()
					+ ")'><img width=25 src='images/trash-red-xs.png'></a></td>" + " <td width='150px'>"
					+ tc.getNomTypeCamion() + "</td>" + " <td width='150px'>" + tc.getPrixJournalierTypeCamion()
					+ "</td>" + " <td width='150px'>" + tc.getCautionTypeCamion() + "</td>";
		}

		html += "</table>";
		html += "<a class='btn-blue' href='ajouter()'><img width=30 src='images/plus-blue.png'></a>";

		console.print(html);
	}

	public void ajouter() {
		Form form = new Form();

		form.addInput(new TextField("Type de Camion : ", "champType"));
		form.addInput(new TextField("Prix journalier : ", "champPrix"));
		form.addInput(new TextField("Prix caution : ", "champCaution"));

		ListeTypeVehiculeFormValidator validator = new ListeTypeVehiculeFormValidator();

		boolean valide = console.input("Ajout d'un type de camion", form, validator);

		if (valide) {
			String typeCamion = form.getValue("champType");
			String prixJourna = form.getValue("champPrix");
			String prixCaution = form.getValue("champCaution");

			TypeCamion typeCamionCree = new TypeCamion(typeCamion, Double.parseDouble(prixJourna),
					Double.parseDouble(prixCaution));
			typeCamionDao.create(typeCamionCree);

			traitement();

		}
	}

	public void modifier(Long id) {

		TypeCamion tc = typeCamionDao.findById(id);

		// Création du formulaire vide
		Form form = new Form();

		// On ajoute au formulaire les champs nécessaire
		form.addInput(new TextField("Type camion : ", "champType", tc.getNomTypeCamion(), false));
		form.addInput(
				new TextField("Marque vehicule : ", "champPrix", Double.toString(tc.getPrixJournalierTypeCamion())));
		form.addInput(new TextField("Immatriculation : ", "champCaution", Double.toString(tc.getCautionTypeCamion())));

		ListeTypeVehiculeFormValidator validator = new ListeTypeVehiculeFormValidator();

		boolean valide = console.input("Modification Type Camion : " + tc.getNomTypeCamion(), form, validator);

		if (valide) {
			String prixJourna = form.getValue("champPrix");
			String prixCaution = form.getValue("champCaution");
			tc.setPrixJournalierTypeCamion(Double.parseDouble(prixJourna));
			tc.setCautionTypeCamion(Double.parseDouble(prixCaution));

			typeCamionDao.update(tc);

			traitement();

		}

	}

	public void supprimer(Long id) {
		boolean result = console.confirm("Suppression de l'item " + id,
				"Confirmez-vous la suppression de l'item n°" + id);
		// console.println("" + result);
		if (result) {
			TypeCamion typeCamionDelete = typeCamionDao.findById(id);
			typeCamionDao.delete(typeCamionDelete);

			traitement();
		}
	}

}
