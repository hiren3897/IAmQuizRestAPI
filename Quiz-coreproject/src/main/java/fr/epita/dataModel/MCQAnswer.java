package fr.epita.dataModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MCQ_ANSWER")
public class MCQAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MCQAnswerID")
	private Long id;
	
	@Column(name = "MCQAnswer")
	private String mcqanswertitle;

	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MCQAnswer_Student_fk")
	private Student user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MCQAnswer_Title_fk")
	private Exam examtitle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MCQChoice_MCQAnswer_fk")
	private MCQChoice mcqchoice;

	public MCQAnswer() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
