package fr.diginamic.service.client;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.ComboBox;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.Selectable;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.dao.clientEntiteDao.ClientDao;
import fr.diginamic.entites.clientEntite.Client;
import fr.diginamic.entites.vehiculeEntite.Camion;
import fr.diginamic.entites.vehiculeEntite.TypeCamion;
import fr.diginamic.entites.vehiculeEntite.TypeVoiture;
import fr.diginamic.entites.vehiculeEntite.Vehicule;
import fr.diginamic.entites.vehiculeEntite.Voiture;
import fr.diginamic.service.utils.VehiculeUtils;
import fr.diginamic.service.vehicule.form.CamionFormValidator;
import fr.diginamic.service.vehicule.form.ListeVehiculeServiceFormValidator;
import fr.diginamic.service.vehicule.form.VoitureFormValidator;

public class ListeClientService extends MenuService {

	private ClientDao clientDao = new ClientDao();

	@Override
	public void traitement() {
		// TODO Auto-generated method stub

		List<Client> listeClients = clientDao.findAll();
		
		console.clear();
		console.print("<h1 class='bg-yellow'><center>Liste des clients</center></h1>");

		String html = "<table class='table' cellspacing=0>"
				+ "<tr class='bg-green'>"
				+ "		<td>&nbsp;</td>"
				+ "		<td>&nbsp;</td>"
				+ "		<td>Nom</td>"
				+ "		<td>Prenom</td>"
				+ "		<td>Adresse</td>"
				+ "		<td>Permis</td>"
				+ "</tr>";

		for (Client client : listeClients) {
				html += "<tr> "
						+ "	<td><a class='btn-blue' href='modifier(" + client.getId() + ")'<img width=25 src ='images/pencil-blue-xs.png'></a></td>"
						+ " <td><a class='btn-red' href='supprimer(" + client.getId() + ")'<img width=25 src ='images/trash-red-xs.png'></a></td>"
						+ " <td width='150px'>" + client.getNomClient() + "</td>"
						+ " <td width='150px'>" + client.getPrenomClient() + "</td>"
						+ " <td width='150px'>" + client.getAdresseClient() + "</td>"
						+ " <td width='150px'>" + client.getPermisClient().getTypePermis() + "</td>"
					+ "</tr>";
		}

		html += "</table>";
		html += "<a class='btn-blue' href='ajouter()'><img width=30 src='images/plus-blue.png'></a>";

		console.print(html);
	}
	
	public void ajouter() {
		Form form = new Form();

		form.addInput(new TextField("Nom : ", "champNom"));
		form.addInput(new TextField("Prenom : ", "champModele"));
		form.addInput(new TextField("N° rue : ", "champNumeroRue"));
		form.addInput(new TextField("rue : ", "champRue"));
		form.addInput(new TextField("Code Postal : ", "champCodePostal"));
		form.addInput(new TextField("Ville : ", "champVille"));
		form.addInput(new TextField("Téléphone : ", "champTelephone"));
		form.addInput(new TextField("Email : ", "champEmail"));


		
	}

}
