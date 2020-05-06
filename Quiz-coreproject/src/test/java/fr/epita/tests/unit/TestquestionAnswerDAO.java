package fr.epita.tests.unit;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.dataModel.questionAnswer;
import fr.epita.quiz.service.dao.questionAnswerDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestquestionAnswerDAO {

	@Inject
	questionAnswerDAO dao;

	@Test
	@Named("QUESTIONANSWERDAOCLASS")
	public void TestCreateMethod() {
		questionAnswer answer = new questionAnswer();
		dao.create(answer);
	}

}
