package fr.epita.quiz.service.dao;

import java.util.Map;

import fr.epita.dataModel.Exam;

public class ExamDAO extends GenericDAO<Exam, Long> {

	@Override
	public String getQuery() {
		return "from Exam where title = :pTitle";
	}

	@Override
	public void setParameters(Map<String, Object> parameters, Exam criteria) {
		parameters.put("pTitle", criteria.getExamtitle());
		
	}

	@Override
	public Class<Exam> getEntityClass() {
		return Exam.class;
	}

	/*
	 * @Override public List<Exam> search(Exam criteria) { List<questionAnswer>
	 * answerParam = criteria.getAnswer(); javax.persistence.Query createQuery =
	 * em.createQuery("from Exam where answer = :pAnswer");
	 * createQuery.setParameter("pAnswer", answerParam); List<Exam> resultList =
	 * createQuery.getResultList(); return resultList; }
	 * 
	 * @Override public Exam getById(Long id) {
	 * 
	 * return em.find(Exam.class, id); }
	 */
}
