package fr.epita.quiz.dto;

import fr.epita.dataModel.Exam;
import fr.epita.dataModel.Question;
import fr.epita.quiz.ErrorManager.CommonError;

public class questionDTO extends CommonError {

	private long id;
	private String question;
	private Exam examtitle;
	private String type;

	public questionDTO() {

	}

	public questionDTO(long id, String question, Exam examtitle, String type) {
		this.id = id;
		this.question = question;
		this.examtitle= examtitle;
		this.type = type;
	}

	
	public Exam getExamtitle() {
		return examtitle;
	}

	public void setExamtitle(Exam examtitle) {
		this.examtitle = examtitle;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
