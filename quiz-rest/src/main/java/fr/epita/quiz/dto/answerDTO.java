package fr.epita.quiz.dto;

import fr.epita.dataModel.Exam;
import fr.epita.dataModel.Question;
import fr.epita.dataModel.Student;
import fr.epita.dataModel.questionAnswer;

public class answerDTO {

	private long id;
	private String answer;
	private Question question;
	private Exam examtitle;
	private Student username;

	public answerDTO() {

	}

	public answerDTO(questionAnswer answer) {
		this.id = answer.getId();
		this.answer = answer.getAnswer();
		this.question = answer.getQuestion();
		this.examtitle = answer.getExamtitle();
		this.username = answer.getUsername();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Exam getExamtitle() {
		return examtitle;
	}

	public void setExamtitle(Exam examtitle) {
		this.examtitle = examtitle;
	}

	public Student getUsername() {
		return username;
	}

	public void setUsername(Student username) {
		this.username = username;
	}

	

	

}
