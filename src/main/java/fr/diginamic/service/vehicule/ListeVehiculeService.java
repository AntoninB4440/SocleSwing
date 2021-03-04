package fr.diginamic.service.vehicule;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.composants.MenuService;
import fr.diginamic.database.DatabaseAccess;
import fr.diginamic.entites.vehiculeEntite.Vehicule;

public class ListeVehiculeService extends MenuService {

	private EntityManager em = DatabaseAccess.getEntityManager();

	@Override
	public void traitement() {
		// TODO Auto-generated method stub

		TypedQuery<Vehicule> query = em.createQuery("SELECT v from Vehicule v", Vehicule.class);
		List<Vehicule> vehicules = query.getResultList();

		console.clear();
		console.print("<h1 class='bg-green'><center>Liste des véhicules</center></h1>");

		String html = "<table cellspacing=0>"
				+ "<tr class='bg-green'><td>&nbsp;</td><td>&nbsp;</td><td>Marque</td><td>Model</td><td>Kilometrage</td><td>Immatriculation</td><td>Statut<td></tr>";

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

}
