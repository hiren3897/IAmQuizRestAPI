package fr.epita.tests.unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.dataModel.Question;
import fr.epita.quiz.service.dao.QuestionDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestQuestionDAO {

	private static final Logger LOGGER = LogManager.getLogger(TestQuestionDAO.class);

	@Inject
	QuestionDAO dao;

	@Inject
	DataSource ds;

	@Test
	@Named("QuestionDAOCLASS")
	public void TestCreateMethod() {
		Question question = new Question();
		dao.create(question);

		LOGGER.info("Question id {}", question.getId());

		try (Connection connection = ds.getConnection();
				PreparedStatement stmt = connection.prepareStatement("select count(1) from QUESTIONS");
				ResultSet rs = stmt.executeQuery();) {
			rs.next();
			int count = rs.getInt(1);
			Assert.assertEquals(4, count);

		} catch (Exception e) {
			LOGGER.info("Exception Occoured while performing verifivation", e);
		}

	}

	@Test
	@Named("QuestionDAOCLASS")
	public void TestUpdateMethod() {
		Question question = new Question();
		dao.update(question);

		LOGGER.info("Question id {}", question.getId());

		try (Connection connection = ds.getConnection();
				PreparedStatement stmt = connection
						.prepareStatement("UPDATE QUESTIONS SET QtsAnswer = 'Hiren' WHERE id = 1");
				ResultSet rs = stmt.executeQuery();) {
			// rs.next();
			int count = rs.getInt(1);
			Assert.assertEquals(1, count);

		} catch (Exception e) {
			LOGGER.info("Exception Occoured while performing verifivation", e);
		}

	}

	@Test
	@Named("QuestionDAOCLASS")
	public void TestDeleteMethod() {
		Question question = new Question();
		dao.delete(question);

		LOGGER.info("Question id {}", question.getId());

		try (Connection connection = ds.getConnection();
				PreparedStatement stmt = connection.prepareStatement("DELETE FROM QUESTIONS WHERE id = 1");
				ResultSet rs = stmt.executeQuery();) {
			// rs.next();
			int count = rs.getInt(1);
			Assert.assertEquals(1, count);

		} catch (Exception e) {
			LOGGER.info("Exception Occoured while performing verifivation", e);
		}

	}

}
