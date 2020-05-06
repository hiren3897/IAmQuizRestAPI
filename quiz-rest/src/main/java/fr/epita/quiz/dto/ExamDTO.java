package fr.epita.quiz.dto;

import fr.epita.dataModel.Exam;
import fr.epita.quiz.ErrorManager.CommonError;

public class ExamDTO extends CommonError{
	
	private long id;
	private String examtitle;
	
	public ExamDTO() {
		
	}
	public ExamDTO(Exam exam) {
		this.id = exam.getId();
		this.examtitle = exam.getExamtitle();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getExamtitle() {
		return examtitle;
	}
	public void setExamtitle(String examtitle) {
		this.examtitle = examtitle;
	}
	
	

}
