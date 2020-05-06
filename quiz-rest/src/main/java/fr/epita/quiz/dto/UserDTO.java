package fr.epita.quiz.dto;

import fr.epita.dataModel.Student;
import fr.epita.quiz.ErrorManager.CommonError;

public class UserDTO extends CommonError{
	
	private String username;
	private String email;
	private String type;
	
	
	public UserDTO() {
		
	}

	public UserDTO(Student entity) {
		this.username = entity.getUsername();
		this.email = entity.getEmail();
		this.type = entity.getType();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

}
