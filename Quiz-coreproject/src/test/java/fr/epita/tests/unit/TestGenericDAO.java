package fr.epita.tests.unit;

import fr.epita.dataModel.Question;
import fr.epita.quiz.service.dao.QuestionDAO;

public class TestGenericDAO {

	public void testGenericDAO() {
		QuestionDAO dao = new QuestionDAO();
		dao.create(new Question());

	}

}
