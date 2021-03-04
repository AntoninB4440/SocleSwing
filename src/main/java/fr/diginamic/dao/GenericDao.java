package fr.diginamic.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.diginamic.database.DatabaseAccess;

public abstract class GenericDao<T extends IDmodel> implements CrudDao<T> {

	protected EntityManager em = DatabaseAccess.getEntityManager();

	protected EntityTransaction transaction = this.em.getTransaction();

	private Class<T> type;

	public GenericDao() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public T create(final T t) {
		this.transaction.begin();
		this.em.persist(t);
		this.transaction.commit();
		return t;
	}

	@Override
	public void delete(final T t) {
		this.transaction.begin();
		this.em.remove(findById(t.getId()));
		this.transaction.commit();
	}

	@Override
	public T findById(final Long id) {
		return (T) this.em.find(type, id);
	}

	@Override
	public T update(final T t) {
		this.transaction.begin();
		this.em.persist(t);
		this.transaction.commit();
		return t;
	}

	@Override
	public List<T> findAll() {
		return this.em.createQuery("Select t from " + type.getSimpleName() + " t").getResultList();
	}

}
