package fr.epita.quiz.service.dao;

import java.util.Map;

import fr.epita.dataModel.questionAnswer;

public class questionAnswerDAO extends GenericDAO<questionAnswer, Long> {

	@Override
	public String getQuery() {
		return "from questionAnswer as answer where answer.question = :pQuestion";
	}

	@Override
	public void setParameters(Map<String, Object> parameters, questionAnswer criteria) {
		parameters.put("pQuestion", criteria.getQuestion());
	}

	@Override
	public Class<questionAnswer> getEntityClass() {
		return questionAnswer.class;
	}

//	@Override
//	public List<questionAnswer> search(questionAnswer criteria) {
//		Question questionParam = criteria.getQuestion();
//		Query createQuery = em.createQuery("from questionAnswer as answer where answer.question = :pQuestion");
//		createQuery.setParameter("pQuestion", questionParam);
//		List<questionAnswer> resultList = createQuery.getResultList();
//		return resultList;
//	}
//
//	@Override
//	public questionAnswer getById(Long id) {
//		return em.find(questionAnswer.class, id);
//	}

}
