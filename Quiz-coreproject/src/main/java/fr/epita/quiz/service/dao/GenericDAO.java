package fr.epita.quiz.service.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epita.quiz.service.business.ExamDataService;

public abstract class GenericDAO<T, I> {
	private static final Logger LOGGER = LogManager.getLogger(ExamDataService.class);

	@PersistenceContext
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public void create(T entity) {
		em.persist(entity);
	}

	@Transactional(value = TxType.REQUIRED)
	public void update(T entity) {
		em.merge(entity);
	}

	@Transactional(value = TxType.REQUIRED)
	public void delete(T entity) {
		em.refresh(entity);
		em.remove(entity);
	}

	public abstract String getQuery();

	public abstract void setParameters(Map<String, Object> map, T criteria);

	public List<T> search(T criteria) {
		LOGGER.info(getQuery());
		Query searchQuery = em.createQuery(getQuery());

		Map<String, Object> parameters = new LinkedHashMap<String, Object>();
		setParameters(parameters, criteria);
		for (Map.Entry<String, Object> entry : parameters.entrySet()) {
			searchQuery.setParameter(entry.getKey(), entry.getValue());
		}
		return searchQuery.getResultList();

	}

	public T getById(I id) {
		return em.find(getEntityClass(), id);
	}

	public abstract Class<T> getEntityClass();

	public List<T> getAll() {

		String test = getEntityClass().getSimpleName();
		test = test.substring(test.lastIndexOf('.') + 1);
		String query = "from " + test;
		Query searchQuery = em.createQuery(query);

		return searchQuery.getResultList();

	}
}
