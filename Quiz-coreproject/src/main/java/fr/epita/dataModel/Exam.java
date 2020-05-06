package fr.epita.dataModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Exam")
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ExamID")
	private Long id;

	@Column(name = "TITLE")
	private String examtitle;

//	@OneToMany
//	@JoinTable(name = "Exam_Answer_fk")
//	private List<questionAnswer> answer;
//
//	@OneToMany
//	@JoinTable(name = "Exam_McqAnswer_fk")
//	private List<MCQAnswer> MCQ_Answer;

	public Exam() {

	}

	

	public String getExamtitle() {
		return examtitle;
	}



	public void setExamtitle(String examtitle) {
		this.examtitle = examtitle;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public List<questionAnswer> getAnswer() {
//		return answer;
//	}
//
//	public void setAnswer(List<questionAnswer> answer) {
//		this.answer = answer;
//	}
//
//	public List<MCQAnswer> getMCQ_Answer() {
//		return MCQ_Answer;
//	}
//
//	public void setMCQ_Answer(List<MCQAnswer> mCQ_Answer) {
//		MCQ_Answer = mCQ_Answer;
//	}

}
