package fr.diginamic.service.client;

import java.util.List;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.dao.clientEntiteDao.ClientDao;
import fr.diginamic.entites.clientEntite.Adresse;
import fr.diginamic.entites.clientEntite.Client;
import fr.diginamic.service.client.form.ListeClientServiceFormValidator;

public class ListeClientService extends MenuService {

	private ClientDao clientDao = new ClientDao();

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
		form.addInput(new TextField("Date Obtention Permis : ", "champDateObtention"));

	}

}
