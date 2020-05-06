package fr.epita.quiz.service.dao;

import java.util.Map;

import fr.epita.dataModel.MCQAnswer;

public class MCQAnswerDAO extends GenericDAO<MCQAnswer, Long> {

	@Override
	public String getQuery() {
		return "from MCQ_ANSWER as choice where choice.mcq_choice = :PmcqChoice";
	}

	@Override
	public void setParameters(Map<String, Object> parameters, MCQAnswer criteria) {
		parameters.put("PmcqChoice", criteria.getMcqchoice());
		
	}

	@Override
	public Class<MCQAnswer> getEntityClass() {
		
		return MCQAnswer.class;
	}

	

}
