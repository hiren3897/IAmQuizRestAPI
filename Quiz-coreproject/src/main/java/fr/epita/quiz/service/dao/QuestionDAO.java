package fr.epita.quiz.service.dao;

import java.util.Map;

import fr.epita.dataModel.Question;

public class QuestionDAO extends GenericDAO<Question, Long> {

	@Override
	public String getQuery() {
		return "from Question where question = :pTitle";
	}

	@Override
	public void setParameters(Map<String, Object> parameters, Question criteria) {
		parameters.put("pTitle", criteria.getQuestion());
		
	}

	@Override
	public Class<Question> getEntityClass() {
		return Question.class;
	}


}
