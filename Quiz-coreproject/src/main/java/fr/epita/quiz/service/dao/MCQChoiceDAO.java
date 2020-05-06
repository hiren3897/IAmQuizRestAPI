package fr.epita.quiz.service.dao;

import java.util.Map;

import fr.epita.dataModel.MCQChoice;

public class MCQChoiceDAO extends GenericDAO<MCQChoice, Long> {

	@Override
	public String getQuery() {
		return "from MCQChoice as choice where choice.question = :Pquestion";
	}

	@Override
	public void setParameters(Map<String, Object> parameters, MCQChoice criteria) {
		parameters.put("Pquestion", criteria.getQuestion());
		
	}

	@Override
	public Class<MCQChoice> getEntityClass() {
		return MCQChoice.class;
	}

//	@Override
//	public List<MCQChoice> search(MCQChoice criteria) {
//		Question questionParam = criteria.getQuestion();
//		Query createQuery = em.createQuery("from MCQChoice as choice where choice.question = :Pquestion");
//		createQuery.setParameter("Pquestion", questionParam);
//		List<MCQChoice> resultList = createQuery.getResultList();
//		return resultList;
//	}
//
//	@Override
//	public MCQChoice getById(Long id) {
//		// TODO Auto-generated method stub
//		return em.find(MCQChoice.class, id);
//	}

}
