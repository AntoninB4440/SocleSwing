package fr.diginamic.dao;

import java.util.List;

public interface CrudDao<T> {

	T create(T t);

	T update(T t);

	T findById(Long id);

	List<T> findAll();

	void delete(T t);
}
