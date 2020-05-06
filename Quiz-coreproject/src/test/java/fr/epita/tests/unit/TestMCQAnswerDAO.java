package fr.epita.tests.unit;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.dataModel.MCQAnswer;
import fr.epita.quiz.service.dao.MCQAnswerDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestMCQAnswerDAO {

	@Inject
	MCQAnswerDAO dao;

	@Test
	@Named("MCQANSWERDAOCLASS")
	public void TestCreateMethod() {
		MCQAnswer ans = new MCQAnswer();
		dao.create(ans);
	}

}
