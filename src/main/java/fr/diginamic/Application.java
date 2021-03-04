package fr.diginamic;

import fr.diginamic.composants.AbstractApplication;
import fr.diginamic.service.vehicule.ListeVehiculeService;
import fr.diginamic.services.exemples.AideService;

/**
 * Fenêtre principale qui porte les principaux composants graphiques de
 * l'application:<br>
 * - les boutons du menu,<br>
 * - le panneau d'affichage des résultats<br>
 * 
 * @author RichardBONNAMY
 *
 */
public class Application extends AbstractApplication {

	/** serialVersionUID */
	private static final long serialVersionUID = 6755835482616236832L;

	/**
	 * Constructeur
	 * 
	 * @param title titre
	 */
	public Application(String title) {
		super(title);
	}

	/**
	 * Code principal
	 * 
	 */
	public void main() {
		addMenu(1, "File");
		addMenu(2, "Gestion clients");
		addMenu(3, "Gestion vehicule");
		// addMenu(4, "Exemples");

		addMenuOption(1, "Aide", new AideService());
		addMenuOption(3, "Liste des véhicules", new ListeVehiculeService());

		// addMenuOption(2, "Liste des clients", new AideService());

		/*
		 * addMenuOption(3, "Exemple 1 - Titres", new Exemple1Service());
		 * addMenuOption(3, "Exemple 2 - Textes de couleur", new Exemple2Service());
		 * addMenuOption(3, "Exemple 3 - Table", new Exemple3Service());
		 * addMenuOption(3, "Exemple 4 - Table avec liens vers méthodes", new
		 * Exemple4Service()); addMenuOption(3, "Exemple 5 - Table dynamique", new
		 * Exemple5Service()); addMenuOption(3, "Exemple 6 - Formulaire", new
		 * Exemple6Service());
		 */
	}
}