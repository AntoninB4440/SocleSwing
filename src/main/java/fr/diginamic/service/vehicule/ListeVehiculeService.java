package fr.diginamic.service.vehicule;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.dao.vehiculeEntiteDao.VehiculeDao;
import fr.diginamic.database.DatabaseAccess;
import fr.diginamic.entites.vehiculeEntite.Vehicule;

public class ListeVehiculeService extends MenuService {

	private EntityManager em = DatabaseAccess.getEntityManager();

	private VehiculeDao vehiculeDao = new VehiculeDao();

	@Override
	public void traitement() {
		// TODO Auto-generated method stub

		TypedQuery<Vehicule> query = em.createQuery("SELECT v from Vehicule v", Vehicule.class);
		List<Vehicule> vehicules = query.getResultList();

		console.clear();
		console.print("<h1 class='bg-green'><center>Liste des véhicules</center></h1>");

		String html = "<table cellspacing=0>"
				+ "<tr class='bg-green'><td>&nbsp;</td><td>&nbsp;</td><td>Marque</td><td>Model</td><td>Kilometrage</td><td>Immatriculation</td><td>Statut</td></tr>";

		for (Vehicule v : vehicules) {
			html += "<tr>" + "  <td><a class='btn-blue' href='modifier(" + v.getId()
					+ ")'><img width=25 src='images/pencil-blue-xs.png'></a></td>"
					+ "  <td><a class='btn-red' href='supprimer(" + v.getId()
					+ ")'><img width=25 src='images/trash-red-xs.png'></a></td>" + "  <td width='150px'>"
					+ v.getMarqueVehicule() + "</td>" + "  <td width='150px'>" + v.getModeleVehicule() + "</td>"
					+ "  <td width='150px'>" + v.getKilometrageVehicule() + "</td>" + "  <td width='150px'>"
					+ v.getImmatriculationVehicule() + "</td>" + "  <td width='150px'>" + v.getStatutVehicule()
					+ "</td>" + "</tr>";
		}

		html += "</table>";

		console.print(html);
	}

	public void modifier(Long id) {

		Vehicule v = em.find(Vehicule.class, id);

		// Création du formulaire vide
		Form form = new Form();

		// On ajoute au formulaire les champs nécessaire
		if (v.getReservationVehicule().isEmpty()) {
			form.addInput(new TextField("Marque vehicule : ", "champMarque", v.getMarqueVehicule(), false));
			form.addInput(new TextField("Marque vehicule : ", "champModele", v.getModeleVehicule(), false));
			form.addInput(new TextField("Immatriculation : ", "champImma", v.getImmatriculationVehicule()));

		}

		ListeVehiculeServiceFormValidator validator = new ListeVehiculeServiceFormValidator();
		boolean valide = console.input("Modification du véhicule : " + v.getMarqueVehicule() + " "
				+ v.getModeleVehicule() + " " + v.getImmatriculationVehicule(), form, validator);

		if (valide) {
			String nvImma = form.getValue("champImma").toUpperCase();
			v.setImmatriculationVehicule(nvImma);
			vehiculeDao.update(v);

			traitement();

		}

	}

	public void supprimer(Long id) {
		boolean result = console.confirm("Suppression de l'item " + id,
				"Confirmez-vous la suppression de l'item n°" + id);
		// console.println("" + result);
		if (result) {
			Vehicule vehiculeDelete = vehiculeDao.findById(id);
			vehiculeDao.delete(vehiculeDelete);

			traitement();
		}
	}

}
