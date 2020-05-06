package fr.epita.quiz.dto;

import fr.epita.quiz.ErrorManager.CommonError;

public class MCQChoiceDTO extends CommonError{
	
	private long id;
	private String choice;
	private boolean valid;
	private questionDTO question;
	
	
	
	public MCQChoiceDTO() {
		
	}
	
	
	
	public MCQChoiceDTO(long id, String choice, boolean valid, questionDTO question) {
		this.id = id;
		this.choice = choice;
		this.valid = valid;
		this.question = question;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}



	public questionDTO getQuestion() {
		return question;
	}



	public void setQuestion(questionDTO question) {
		this.question = question;
	}
	
	
	
	

}
