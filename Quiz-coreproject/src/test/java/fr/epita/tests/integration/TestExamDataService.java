package fr.epita.tests.integration;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.dataModel.Exam;
import fr.epita.dataModel.MCQAnswer;
import fr.epita.dataModel.MCQChoice;
import fr.epita.dataModel.Question;
import fr.epita.dataModel.Student;
import fr.epita.dataModel.questionAnswer;
import fr.epita.quiz.service.business.ExamDataService;
import fr.epita.quiz.service.dao.ExamDAO;
import fr.epita.quiz.service.dao.MCQAnswerDAO;
import fr.epita.quiz.service.dao.MCQChoiceDAO;
import fr.epita.quiz.service.dao.QuestionDAO;
import fr.epita.quiz.service.dao.StudentDAO;
import fr.epita.quiz.service.dao.questionAnswerDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestExamDataService {

//	private static final Logger LOGGER = LogManager.getLogger(TestExamDataService.class);

	@Inject
	ExamDataService examDS;

	@Inject
	QuestionDAO questionDAO;

	@Inject
	MCQChoiceDAO choiceDAO;

	@Inject
	questionAnswerDAO answerDAO;

	@Inject
	StudentDAO userDao;

	@Inject
	MCQAnswerDAO mcqAnswerDAO;
	ExamDAO examDAO;

//	@Test
//	@Named("EXAMDATASERVICEDAO")
//	public void testQuestionWithMCQChoicesInsertion() {
//
//		Question question = new Question();
//		question.setQuestion("What is maven ?");
//		MCQChoice choice1 = new MCQChoice();
//		String firstChoiceText = ;
//		choice1.setChoice(firstChoiceText);
//		choice1.setValid(false);
//		MCQChoice choice2 = new MCQChoice();
//		choice2.setChoice("it is a dependency injection framework","it is including a dependency management tool");
//		choice2.setValid(true);
//
//		examDS.createQuestionAndMCQChoices(question, choice1, choice2);
//
//		MCQChoice criteria = new MCQChoice();
//		criteria.setQuestion(question);
//		List<MCQChoice> searchResults = choiceDAO.search(criteria);
//		Assert.assertTrue(!searchResults.isEmpty());
//
//		List<MCQChoice> subList = searchResults.stream().filter(c -> c.getChoice().equals(firstChoiceText))
//				.collect(Collectors.toList());
//
//		Assert.assertEquals(1, subList.size());
//
//	}

	@Test
	@Named("EXAMDATASERVICEDAO")
	public void testcreateQuestionAndAnswerTransaction() {

		Student user = new Student();
		user.setUsername("hiren");
		user.setEmail("hiren.rathod@gmail.com");
		userDao.create(user);

		Question question = new Question();
		question.setQuestion("What is maven ?");
		questionDAO.create(question);
		
		Exam exam = new Exam();
		exam.setExamtitle("Java Exam");

		questionAnswer answer = new questionAnswer();
		String validAnswer = "it is including a dependency management tool";
		answer.setAnswer(validAnswer);
		
		

		examDS.createQuestionAndAnswerTransaction(user, question, answer,exam);

		questionAnswer criteria = answerDAO.getById(answer.getId());
		criteria.setQuestion(question);
		criteria.setUsername(user);

		Assert.assertEquals(criteria.getUsername().getUsername(), user.getUsername());

		List<questionAnswer> searchResults = answerDAO.search(criteria);
		Assert.assertTrue(!searchResults.isEmpty());

	}

	@Test
	public void TestAnswerToMCQ() {
		Student user = new Student();
		user.setUsername("vishal");
		user.setEmail("vishal.rathod@gmail.com");
		userDao.create(user);

		MCQChoice choice = new MCQChoice();
		choice.setChoice("Valid Choice");
		choiceDAO.create(choice);

		Exam exam = new Exam();
		exam.setExamtitle("Java Exam");
		examDAO.create(exam);

		MCQAnswer mcqAnswer = new MCQAnswer();
		mcqAnswer.setMcqanswertitle("Valid Choice");

		examDS.AnswerToMCQ(user, mcqAnswer, choice, exam);

		MCQAnswer criteria = new MCQAnswer();
		criteria.setExamtitle(exam);
		criteria.setMcqchoice(choice);
		criteria.setUser(user);
		
		Assert.assertEquals(criteria.getMcqchoice(), choice.getChoice());
		List<MCQAnswer> searchResults = mcqAnswerDAO.search(criteria);
		Assert.assertTrue(!searchResults.isEmpty());

	}
}
