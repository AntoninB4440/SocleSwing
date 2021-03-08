package fr.diginamic.dao.clientEntiteDao;

import java.util.List;

import javax.persistence.TypedQuery;

import fr.diginamic.dao.GenericDao;
import fr.diginamic.entites.clientEntite.Client;

public class ClientDao extends GenericDao<Client> {

	public List<Client> findByEmail(String mail) {
		TypedQuery<Client> query = super.em
				.createQuery("Select c FROM Client c where c.adresseClient.emailAdresse = ?1", Client.class);
		query.setParameter(1, mail);

		return query.getResultList();

	}
}
