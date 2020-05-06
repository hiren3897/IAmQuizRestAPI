package fr.epita.quiz.service.dao;

import java.util.Map;

import fr.epita.dataModel.Student;

public class StudentDAO extends GenericDAO<Student, String> {

	@Override
	public String getQuery() {
		return "from USERS where email = :pEmail";
	}

	@Override
	public void setParameters(Map<String, Object> parameters, Student criteria) {
		parameters.put("pEmail", criteria.getEmail());	
	}

	@Override
	public Class<Student> getEntityClass() {
		return Student.class;
	}

}
