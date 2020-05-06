package fr.epita.tests.unit;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.dataModel.Exam;
import fr.epita.quiz.service.dao.ExamDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestExamDAO {
	
	@Inject
	ExamDAO dao;
	
	@Test
	@Named("DAOCLASS")
	public void TestCreateMethod() {
		Exam exam = new Exam();
		dao.create(exam);
	}

}
