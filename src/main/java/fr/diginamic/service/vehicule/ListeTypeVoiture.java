package fr.diginamic.service.vehicule;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.dao.vehiculeEntiteDao.TypeVoitureDao;
import fr.diginamic.database.DatabaseAccess;
import fr.diginamic.entites.vehiculeEntite.TypeVoiture;
import fr.diginamic.service.vehicule.form.ListeTypeVehiculeFormValidator;

public class ListeTypeVoiture extends MenuService {

	private EntityManager em = DatabaseAccess.getEntityManager();

	private TypeVoitureDao typeVoitureDao = new TypeVoitureDao();

	@Override
	public void traitement() {
		// TODO Auto-generated method stub

		TypedQuery<TypeVoiture> query = em.createQuery("SELECT tv from TypeVoiture tv", TypeVoiture.class);
		List<TypeVoiture> listTypeVoiture = query.getResultList();

		console.clear();
		console.print("<h1 class='bg-green'><center>Liste des véhicules</center></h1>");

		String html = "<table class='table' cellspacing=0>"
				+ "<tr class='bg-green'><td>&nbsp;</td><td>&nbsp;</td><td>Type Vehicule</td><td>Prix Journalier (€/J)</td><td>Prix Caution</td></tr>";

		for (TypeVoiture tv : listTypeVoiture) {
			html += "<tr>" + "  <td><a class='btn-blue' href='modifier(" + tv.getId()
					+ ")'><img width=25 src='images/pencil-blue-xs.png'></a></td>"
					+ " <td><a class='btn-red' href='supprimer(" + tv.getId()
					+ ")'><img width=25 src='images/trash-red-xs.png'></a></td>" + " <td width='150px'>"
					+ tv.getNomTypeVoiture() + "</td>" + " <td width='150px'>" + tv.getPrixJournalierTypeVoiture()
					+ "</td>" + " <td width='150px'>" + tv.getCautionTypeVoiture() + "</td>";
		}

		html += "</table>";
		html += "<a class='btn-blue' href='ajouter()'><img width=30 src='images/plus-blue.png'></a>";

		console.print(html);
	}

	public void ajouter() {
		Form form = new Form();

		form.addInput(new TextField("Type de Voiture : ", "champType"));
		form.addInput(new TextField("Prix journalier : ", "champPrix"));
		form.addInput(new TextField("Prix caution : ", "champCaution"));

		ListeTypeVehiculeFormValidator validator = new ListeTypeVehiculeFormValidator();

		boolean valide = console.input("Ajout d'un type de voiture", form, validator);

		if (valide) {
			String typeVoiture = form.getValue("champType");
			String prixJourna = form.getValue("champPrix");
			String prixCaution = form.getValue("champCaution");

			TypeVoiture typeVoitureCree = new TypeVoiture(typeVoiture, Double.parseDouble(prixJourna),
					Double.parseDouble(prixCaution));
			typeVoitureDao.create(typeVoitureCree);

			traitement();

		}
	}

	public void modifier(Long id) {

		TypeVoiture tv = em.find(TypeVoiture.class, id);

		// Création du formulaire vide
		Form form = new Form();

		// On ajoute au formulaire les champs nécessaire
		form.addInput(new TextField("Type camion : ", "champType", tv.getNomTypeVoiture(), false));
		form.addInput(
				new TextField("Marque vehicule : ", "champPrix", Double.toString(tv.getPrixJournalierTypeVoiture())));
		form.addInput(new TextField("Immatriculation : ", "champCaution", Double.toString(tv.getCautionTypeVoiture())));

		ListeTypeVehiculeFormValidator validator = new ListeTypeVehiculeFormValidator();

		boolean valide = console.input("Modification Type Camion : " + tv.getNomTypeVoiture(), form, validator);

		if (valide) {
			String prixJourna = form.getValue("champPrix");
			String prixCaution = form.getValue("champCaution");
			tv.setPrixJournalierTypeVoiture(Double.parseDouble(prixJourna));
			tv.setCautionTypeVoiture(Double.parseDouble(prixCaution));

			typeVoitureDao.update(tv);

			traitement();

		}

	}

	public void supprimer(Long id) {
		boolean result = console.confirm("Suppression de l'item " + id,
				"Confirmez-vous la suppression de l'item n°" + id);
		// console.println("" + result);
		if (result) {
			TypeVoiture typeCamionDelete = typeVoitureDao.findById(id);
			typeVoitureDao.delete(typeCamionDelete);

			traitement();
		}
	}

}
