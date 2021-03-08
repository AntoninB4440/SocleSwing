package fr.diginamic.service.vehicule;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.ComboBox;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.Selectable;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.dao.vehiculeEntiteDao.CamionDao;
import fr.diginamic.dao.vehiculeEntiteDao.TypeCamionDao;
import fr.diginamic.dao.vehiculeEntiteDao.TypeVoitureDao;
import fr.diginamic.dao.vehiculeEntiteDao.VehiculeDao;
import fr.diginamic.dao.vehiculeEntiteDao.VoitureDao;
import fr.diginamic.database.DatabaseAccess;
import fr.diginamic.entites.vehiculeEntite.Camion;
import fr.diginamic.entites.vehiculeEntite.TypeCamion;
import fr.diginamic.entites.vehiculeEntite.TypeVoiture;
import fr.diginamic.entites.vehiculeEntite.Vehicule;
import fr.diginamic.entites.vehiculeEntite.Voiture;
import fr.diginamic.service.utils.VehiculeUtils;
import fr.diginamic.service.vehicule.form.CamionFormValidator;
import fr.diginamic.service.vehicule.form.ListeVehiculeServiceFormValidator;
import fr.diginamic.service.vehicule.form.VoitureFormValidator;

public class ListeVehiculeService extends MenuService {

	private EntityManager em = DatabaseAccess.getEntityManager();

	private VehiculeDao vehiculeDao = new VehiculeDao();
	private VoitureDao voitureDao = new VoitureDao();
	private CamionDao camionDao = new CamionDao();
	private TypeVoitureDao typeVoitureDao = new TypeVoitureDao();
	private TypeCamionDao typeCamionDao = new TypeCamionDao();

	@Override
	public void traitement() {
		// TODO Auto-generated method stub

		TypedQuery<Vehicule> query = em.createQuery("SELECT v from Vehicule v", Vehicule.class);
		List<Vehicule> vehicules = query.getResultList();

		console.clear();
		console.print("<h1 class='bg-green'><center>Liste des véhicules</center></h1>");

		String html = "<table class='table' cellspacing=0>"
				+ "<tr class='bg-green'>"
				+ "		<td>&nbsp;</td>"
				+ "		<td>&nbsp;</td>"
				+ "		<td>Marque</td>"
				+ "		<td>Modele</td>"
				+ "		<td>Kilometrage</td>"
				+ "		<td>Immatriculation</td>"
				+ "		<td>Statut</td>"
				+ "		<td>Type</td>"
				+ "</tr>";

		for (Vehicule vehicule : vehicules) {
			if (vehicule instanceof Voiture) {
				Voiture v = (Voiture) vehicule;
				html += "<tr> "
						+ "	<td><a class='btn-blue' href='modifier(" + v.getId() + ")'<img width=25 src ='images/pencil-blue-xs.png'></a></td>"
						+ " <td><a class='btn-red' href='modifier(" + v.getId() + ")'<img width=25 src ='images/trash-red-xs.png'></a></td>"
						+ " <td width='150px'>" + v.getMarqueVehicule() + "</td>"
						+ " <td width='150px'>" + v.getModeleVehicule() + "</td>"
						+ " <td width='150px'>" + v.getKilometrageVehicule() + "</td>"
						+ " <td width='150px'>" + v.getImmatriculationVehicule() + "</td>"
						+ " <td width='150px'>" + v.getStatutVehicule()+ "</td>"
						+ " <td width='150px'>" + v.getTypeVoiture().getNomTypeVoiture()+ "</td>"
					+ "</tr>";
			} else if (vehicule instanceof Camion) {
				Camion c = (Camion) vehicule;
				html += "<tr> "
						+ "	<td><a class='btn-blue' href='modifier(" + c.getId() + ")'<img width=25 src ='images/pencil-blue-xs.png'></a></td>"
						+ " <td><a class='btn-red' href='modifier(" + c.getId() + ")'<img width=25 src ='images/trash-red-xs.png'></a></td>"
						+ " <td width='150px'>" + c.getMarqueVehicule() + "</td>"
						+ " <td width='150px'>" + c.getModeleVehicule() + "</td>"
						+ " <td width='150px'>" + c.getKilometrageVehicule() + "</td>"
						+ " <td width='150px'>" + c.getImmatriculationVehicule() + "</td>"
						+ " <td width='150px'>" + c.getStatutVehicule()+ "</td>"
						+ " <td width='150px'>" + c.getTypeCamion().getNomTypeCamion()+ "</td>"
					+ "</tr>";
			}
		}

		html += "</table>";
		html += "<a class='btn-blue' href='ajouter()'><img width=30 src='images/plus-blue.png'></a>";

		console.print(html);
	}

	public void ajouter() {
		Form form = new Form();

		form.addInput(new TextField("Marque vehicule : ", "champMarque"));
		form.addInput(new TextField("Modele vehicule : ", "champModele"));
		form.addInput(new TextField("Immatriculation : ", "champImma"));
		form.addInput(new TextField("kilometrage : ", "champKilo"));

		List<Selectable> typeVehicule = new ArrayList<>();
		typeVehicule.add(new VehiculeUtils(1L, "Voiture"));
		typeVehicule.add(new VehiculeUtils(2L, "Camion"));

		form.addInput(new ComboBox("Liste type vehicule:", "typeVehicule", typeVehicule, typeVehicule.get(0)));

		ListeVehiculeServiceFormValidator validator = new ListeVehiculeServiceFormValidator();

		boolean valide = console.input("Ajout d'un véhicule", form, validator);

		Form form2 = new Form();

		/// AJOUT D'UNE VOITURE
		if (valide && form.getValue("typeVehicule").equals("1")) {

			form2.addInput(new TextField("Nombre de place :", "champNbPlace"));

			TypedQuery<TypeVoiture> query = em.createQuery("SELECT tv from TypeVoiture tv", TypeVoiture.class);
			List<TypeVoiture> listTypeVoitures = query.getResultList();

			List<Selectable> typeVoiture = new ArrayList<>();
			for (TypeVoiture listTypeVoiture : listTypeVoitures) {
				typeVoiture.add(listTypeVoiture);
			}

			form2.addInput(new ComboBox("Liste type voiture: ", "typeVoiture", typeVoiture, typeVoiture.get(0)));

			VoitureFormValidator validator2 = new VoitureFormValidator();

			boolean valide2 = console.input("Ajout d'un type de voiture", form2, validator2);

			if (valide2) {
				String marqueVoiture = form.getValue("champMarque");
				String modeleVoiture = form.getValue("champModele");
				String immatriculation = form.getValue("champImma");
				int kilometrageVoiture = Integer.parseInt(form.getValue("champKilo"));
				Short nombrePlace = Short.parseShort(form2.getValue("champNbPlace"));
				TypeVoiture typeVoitureCree = typeVoitureDao.findById(Long.parseLong(form2.getValue("typeVoiture")));

				Voiture voitureCree = new Voiture(marqueVoiture, modeleVoiture, immatriculation, kilometrageVoiture,
						typeVoitureCree, nombrePlace);

				voitureDao.create(voitureCree);

				traitement();

			}

		}
		// AJOUT D'UN CAMION
		else if (valide && form.getValue("typeVehicule").equals("2")) {

			form2.addInput(new TextField("Volume du camion :", "champVolume"));

			TypedQuery<TypeCamion> query = em.createQuery("SELECT tc from TypeCamion tc", TypeCamion.class);
			List<TypeCamion> listTypeCamions = query.getResultList();

			List<Selectable> typeCamion = new ArrayList<>();
			for (TypeCamion listTypeCamion : listTypeCamions) {
				typeCamion.add(listTypeCamion);
			}

			form2.addInput(new ComboBox("Liste type camion: ", "typeCamion", typeCamion, typeCamion.get(0)));

			CamionFormValidator validator2 = new CamionFormValidator();

			boolean valide2 = console.input("Ajout d'un type de camion", form2, validator2);

			if (valide2) {
				String marqueVoiture = form.getValue("champMarque");
				String modeleVoiture = form.getValue("champModele");
				String immatriculation = form.getValue("champImma");
				int kilometrageVoiture = Integer.parseInt(form.getValue("champKilo"));
				Short volume = Short.parseShort(form2.getValue("champVolume"));
				TypeCamion typeCamionCree = typeCamionDao.findById(Long.parseLong(form2.getValue("typeCamion")));

				Camion camionCree = new Camion(marqueVoiture, modeleVoiture, immatriculation, kilometrageVoiture,
						typeCamionCree, volume);

				camionDao.create(camionCree);

				traitement();

			}
		}
	}

	public void modifier(Long id) {

		Vehicule v = em.find(Vehicule.class, id);

		// Création du formulaire vide
		Form form = new Form();

		// On ajoute au formulaire les champs nécessaire si la liste des réservation est vide
		if (v.getReservationVehicule().isEmpty()) {
			form.addInput(new TextField("Marque vehicule : ", "champMarque", v.getMarqueVehicule(), false));
			form.addInput(new TextField("Marque vehicule : ", "champModele", v.getModeleVehicule(), false));
			form.addInput(new TextField("Immatriculation : ", "champImma", v.getImmatriculationVehicule()));
			form.addInput(
					new TextField("kilometrage : ", "champKilo", Integer.toString(v.getKilometrageVehicule()), false));

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
