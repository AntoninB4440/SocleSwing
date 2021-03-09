package fr.diginamic;

import fr.diginamic.dao.vehiculeEntiteDao.VehiculeDao;
import fr.diginamic.database.DatabaseAccess;

public class TestConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DatabaseAccess.getEntityManager();

		VehiculeDao vehiculeDao = new VehiculeDao();

		// Vehicule vehicule1 = new Vehicule("mercedeces", "Classe A", "AGC-654-ZHD",
		// 0);
		// Vehicule vehicule2 = new Vehicule("BMW", "AMG564", "AGC-844-ZHD", 0);

//		vehiculeDao.create(vehicule1);
//		vehiculeDao.create(vehicule2);
//		vehiculeDao.findAll().forEach(vehicule -> System.out.println(vehicule.getMarqueVehicule()));
	}

}
