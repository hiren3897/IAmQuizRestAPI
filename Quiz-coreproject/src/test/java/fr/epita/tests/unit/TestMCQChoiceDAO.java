package fr.epita.tests.unit;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.dataModel.MCQChoice;
import fr.epita.quiz.service.dao.MCQChoiceDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestMCQChoiceDAO {

	@Inject
	MCQChoiceDAO dao;

	@Test
	@Named("MCQCHOICEDAOCLASS")
	public void TestCreateMethod() {
		MCQChoice choice = new MCQChoice();
		dao.create(choice);
	}

}
