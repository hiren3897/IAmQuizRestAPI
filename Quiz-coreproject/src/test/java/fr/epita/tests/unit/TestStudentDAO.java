package fr.epita.tests.unit;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.dataModel.Student;
import fr.epita.quiz.service.dao.StudentDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestStudentDAO {

	@Inject
	StudentDAO dao;

	@Test
	@Named("STUDENTDAOCLASS")
	public void TestCreateMethod() {
		Student student = new Student();
		dao.create(student);
	}

}
