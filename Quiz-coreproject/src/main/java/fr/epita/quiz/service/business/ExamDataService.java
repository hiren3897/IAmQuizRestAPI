package fr.epita.quiz.service.business;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epita.dataModel.Exam;
import fr.epita.dataModel.MCQAnswer;
import fr.epita.dataModel.MCQChoice;
import fr.epita.dataModel.Question;
import fr.epita.dataModel.Student;
import fr.epita.dataModel.questionAnswer;
import fr.epita.quiz.service.dao.MCQAnswerDAO;
import fr.epita.quiz.service.dao.MCQChoiceDAO;
import fr.epita.quiz.service.dao.QuestionDAO;
import fr.epita.quiz.service.dao.questionAnswerDAO;

public class ExamDataService {

	private static final Logger LOGGER = LogManager.getLogger(ExamDataService.class);


	@Inject
	QuestionDAO questionDAO;

	@Inject
	MCQChoiceDAO choiceDAO;

	@Inject
	questionAnswerDAO answerDAO;
	
	@Inject
	MCQAnswerDAO mcqAnswerDAO;

	@PersistenceContext
	EntityManager em;

	@Transactional(Transactional.TxType.REQUIRED)
	public void createQuestionAndMCQChoices(Question question, MCQChoice... choices) {

		LOGGER.info("entering the createQuestionAndMCQChoices method");
		for (MCQChoice choice : choices) {
			choice.setQuestion(question);
			choiceDAO.create(choice);
		}

	}
	
	
	public void createQuestionAndAnswerTransaction(Student user, Question question, questionAnswer answer,Exam exam) {

		LOGGER.info("entering the createQuestionAndAnswerTransaction method");

		
		answerDAO.create(answer);	

	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void AnswerToMCQ(Student user,MCQAnswer mcqAnswer, MCQChoice choices, Exam exam) {

		mcqAnswer.setExamtitle(exam);
		mcqAnswer.setUser(user);
		mcqAnswer.setMcqchoice(choices);
		mcqAnswerDAO.create(mcqAnswer);
		
	}

}
