package fr.epita.quiz.dto;

import fr.epita.dataModel.Exam;
import fr.epita.dataModel.MCQAnswer;
import fr.epita.dataModel.MCQChoice;
import fr.epita.dataModel.Student;

public class MCQAnswerDTO {
	
	long id;
	String mcqanswertitle;
	Student user;
	Exam examtitle;
	MCQChoice mcqchoice;
	
	
	
	public MCQAnswerDTO() {
		
	}
	
	public MCQAnswerDTO(MCQAnswer mcqanswer) {
		this.id = mcqanswer.getId();
		this.mcqanswertitle = mcqanswer.getMcqanswertitle();
		this.user = mcqanswer.getUser();
		this.examtitle = mcqanswer.getExamtitle();
		this.mcqchoice = mcqanswer.getMcqchoice();
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMcqanswertitle() {
		return mcqanswertitle;
	}
	public void setMcqanswertitle(String mcqanswertitle) {
		this.mcqanswertitle = mcqanswertitle;
	}
	public Student getUser() {
		return user;
	}
	public void setUser(Student user) {
		this.user = user;
	}
	public Exam getExamtitle() {
		return examtitle;
	}
	public void setExamtitle(Exam examtitle) {
		this.examtitle = examtitle;
	}
	public MCQChoice getMcqchoice() {
		return mcqchoice;
	}
	public void setMcqchoice(MCQChoice mcqchoice) {
		this.mcqchoice = mcqchoice;
	}
	
	

}
