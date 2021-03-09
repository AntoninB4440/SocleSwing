package fr.diginamic.service.client;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.ComboBox;
import fr.diginamic.composants.ui.DateField;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.Selectable;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.dao.clientEntiteDao.ClientDao;
import fr.diginamic.dao.clientEntiteDao.PermisDao;
import fr.diginamic.entites.clientEntite.Adresse;
import fr.diginamic.entites.clientEntite.Client;
import fr.diginamic.entites.clientEntite.Permis;
import fr.diginamic.entites.clientEntite.TypePermis;
import fr.diginamic.service.client.form.ListeClientServiceFormValidator;
import fr.diginamic.service.client.form.PermisFormValidator;
import fr.diginamic.service.utils.DateUtils;

public class ListeClientService extends MenuService {

	private ClientDao clientDao = new ClientDao();
	private PermisDao permisDao = new PermisDao();

	@Override
	public void traitement() {
		// TODO Auto-generated method stub

		List<Client> listeClients = clientDao.findAll();

		console.clear();
		console.print("<h1 class='bg-yellow'><center>Liste des clients</center></h1>");

		String html = "<table class='table' cellspacing=0>" + "<tr class='bg-yellow'>" + "		<td>&nbsp;</td>"
				+ "		<td>&nbsp;</td>" + "		<td>Nom</td>" + "		<td>Prenom</td>"
				+ "		<td>Adresse</td>" + "		<td>Téléphone</td>" + "		<td>Email</td>" + "		<td>Permis</td>"
				+ "</tr>";

		for (Client client : listeClients) {
			if (client.getPermisClient() == null) {
				html += "<tr> " + "	<td><a class='btn-blue' href='modifier(" + client.getId()
						+ ")'<img width=25 src ='images/pencil-blue-xs.png'></a></td>"
						+ " <td><a class='btn-red' href='supprimer(" + client.getId()
						+ ")'<img width=25 src ='images/trash-red-xs.png'></a></td>" + " <td width='150px'>"
						+ client.getNomClient() + "</td>" + " <td width='150px'>" + client.getPrenomClient() + "</td>"
						+ " <td width='150px'>" + client.getAdresseClient() + "</td>" + " <td width='150px'>"
						+ client.getAdresseClient().getTelephoneAdresse() + "</td>" + " <td width='150px'>"
						+ client.getAdresseClient().getEmailAdresse() + "</td>"
						+ " <td><a class='btn-grey' href='ajouterPermis(" + client.getId()
						+ ")'<img width=25 src ='images/plus-dark.png'></a></td>" + "</tr>";
			} else {
				html += "<tr> " + "	<td><a class='btn-blue' href='modifier(" + client.getId()
						+ ")'<img width=25 src ='images/pencil-blue-xs.png'></a></td>"
						+ " <td><a class='btn-red' href='supprimer(" + client.getId()
						+ ")'<img width=25 src ='images/trash-red-xs.png'></a></td>" + " <td width='150px'>"
						+ client.getNomClient() + "</td>" + " <td width='150px'>" + client.getPrenomClient() + "</td>"
						+ " <td width='150px'>" + client.getAdresseClient() + "</td>" + " <td width='150px'>"
						+ client.getAdresseClient().getTelephoneAdresse() + "</td>" + " <td width='150px'>"
						+ client.getAdresseClient().getEmailAdresse() + "</td>" + " <td width='150px'>"
						+ client.getPermisClient().getTypePermis() + " "
						+ client.getPermisClient().getDateObtentionPermis() + "</td>" + "</tr>";
			}

		}

		html += "</table>";
		html += "<a class='btn-blue' href='ajouter()'><img width=30 src='images/plus-blue.png'></a>";
		html += "<a class='btn-green' href='exportCSV()'><img width=30 src='images/file-green.png'></a>";

		console.print(html);
	}

	public void ajouter() {
		Form form = new Form();

		form.addInput(new TextField("Nom : ", "champNom"));
		form.addInput(new TextField("Prenom : ", "champPrenom"));
		form.addInput(new TextField("N° rue : ", "champNumeroRue"));
		form.addInput(new TextField("rue : ", "champRue"));
		form.addInput(new TextField("Code Postal : ", "champCodePostal"));
		form.addInput(new TextField("Ville : ", "champVille"));
		form.addInput(new TextField("Téléphone : ", "champTelephone"));
		form.addInput(new TextField("Email : ", "champEmail"));

		ListeClientServiceFormValidator validator = new ListeClientServiceFormValidator();

		boolean valide = console.input("Ajout d'un client", form, validator);

		if (valide) {
			String nomClient = form.getValue("champNom");
			String prenomClient = form.getValue("champPrenom");
			String numeroRueClient = form.getValue("champNumeroRue");
			String rueClient = form.getValue("champRue");
			String codePostalClient = form.getValue("champCodePostal");
			String villeClient = form.getValue("champVille");
			String telephoneClient = form.getValue("champTelephone");
			String emailClient = form.getValue("champEmail");

			Adresse adresseClient = new Adresse(numeroRueClient, rueClient, codePostalClient, villeClient,
					telephoneClient, emailClient);

			Client clientCree = new Client(nomClient, prenomClient, adresseClient);

			clientDao.create(clientCree);

			traitement();

		}

	}

	public void modifier(Long id) {

		Client c = clientDao.findById(id);

		Form form = new Form();

		form.addInput(new TextField("Nom : ", "champNom", c.getNomClient()));
		form.addInput(new TextField("Prenom : ", "champPrenom", c.getPrenomClient()));
		form.addInput(new TextField("N° rue : ", "champNumeroRue", c.getAdresseClient().getNumeroAdresse()));
		form.addInput(new TextField("rue : ", "champRue", c.getAdresseClient().getRueAdresse()));
		form.addInput(new TextField("Code Postal : ", "champCodePostal", c.getAdresseClient().getCodePostalAdresse()));
		form.addInput(new TextField("Ville : ", "champVille", c.getAdresseClient().getVilleAdresse()));
		form.addInput(new TextField("Téléphone : ", "champTelephone", c.getAdresseClient().getTelephoneAdresse()));
		form.addInput(new TextField("Email : ", "champEmail", c.getAdresseClient().getEmailAdresse()));

		ListeClientServiceFormValidator validator = new ListeClientServiceFormValidator();

		boolean valide = console.input("Modification du client : " + c.getNomClient() + " " + c.getPrenomClient(), form,
				validator);

		if (valide) {
			String nomClient = form.getValue("champNom");
			String prenomClient = form.getValue("champPrenom");
			String numeroRueClient = form.getValue("champNumeroRue");
			String rueClient = form.getValue("champRue");
			String codePostalClient = form.getValue("champCodePostal");
			String villeClient = form.getValue("champVille");
			String telephoneClient = form.getValue("champTelephone");
			String emailClient = form.getValue("champEmail");

			c.setNomClient(nomClient);
			c.setPrenomClient(prenomClient);

			Adresse adressUpdate = new Adresse(numeroRueClient, rueClient, codePostalClient, villeClient,
					telephoneClient, emailClient);
			c.setAdresseClient(adressUpdate);

			clientDao.update(c);

			traitement();

		}

	}

	public void supprimer(Long id) {
		boolean result = console.confirm("Suppression de l'item " + id,
				"Confirmez-vous la suppression de l'item n°" + id);
		// console.println("" + result);
		if (result) {
			Client clientDelete = clientDao.findById(id);
			clientDao.delete(clientDelete);

			traitement();
		}
	}

	public void ajouterPermis(Long id) {

		Client c = clientDao.findById(id);

		Form form = new Form();

		form.addInput(new TextField("Numéro du permis : ", "champNumeroPermis"));
		form.addInput(new DateField("Date d'obtention : ", "champDateObtention"));

		List<Selectable> ListTypePermis = new ArrayList<>();
		TypePermis[] listePermis = TypePermis.values();
		for (TypePermis typePermis : listePermis) {
			ListTypePermis.add(typePermis);
		}

		form.addInput(
				new ComboBox("Liste des types de permis :", "listePermis", ListTypePermis, ListTypePermis.get(0)));

		PermisFormValidator validator = new PermisFormValidator();

		boolean valide = console.input("Ajout d'un permis ", form, validator);

		if (valide) {
			String numeroPermis = form.getValue("champNumeroPermis");
			String dateObtentionPermis = form.getValue("champDateObtention");
			LocalDate dateObtention = DateUtils.parseLocal(dateObtentionPermis);

			TypePermis typePermisObtenu = TypePermis.findById(Long.parseLong(form.getValue("listePermis")));

			Permis permisClient = new Permis(numeroPermis, dateObtention, typePermisObtenu, c);

			permisDao.create(permisClient);

			c.setPermisClient(permisClient);

			clientDao.update(c);

			traitement();

		}
	}

	public void exportCSV() {

		List<Client> listeClient = clientDao.findAll();
		List<String[]> stringCSV = new ArrayList<>();

		try {
			CSVWriter writer = new CSVWriter(new FileWriter(
					"C:\\SpringProject\\SocleSwing\\src\\main\\resources\\EXPORT\\EXCEL\\exportClient.csv"));
			String[] header = { "id", "Nom", "Prenom", "Adresse", "Telephone", "Email", "TypePermis",
					"Date Obtention" };
			stringCSV.add(header);

			for (Client client : listeClient) {
				String[] clientLu = { Long.toString(client.getId()), client.getNomClient(), client.getPrenomClient(),
						client.getAdresseClient().getNumeroAdresse() + " " + client.getAdresseClient().getRueAdresse()
								+ " " + client.getAdresseClient().getCodePostalAdresse() + " "
								+ client.getAdresseClient().getVilleAdresse(),
						client.getAdresseClient().getTelephoneAdresse(), client.getAdresseClient().getEmailAdresse(),
						client.getPermisClient().getTypePermis().getType(),
						client.getPermisClient().getDateObtentionPermis().toString() };

				stringCSV.add(clientLu);
			}
			writer.writeAll(stringCSV);
			// NE PAS OUBLIER LE FLUSH (vidage de la mémoire tampon)
			writer.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

	}

}
