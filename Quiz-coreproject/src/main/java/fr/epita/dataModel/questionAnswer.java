package fr.epita.dataModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Qts_Answer")
public class questionAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AnswerID")
	private Long id;

	@Column(name = "T_answer")
	private String answer;

	@ManyToOne
	@JoinColumn(name = "A_AnswerToQts_fk")
	private Question question;

	@ManyToOne
	@JoinColumn(name = "A_Exam_Ans_Fk")
	private Exam examtitle;
	
	@ManyToOne
	@JoinColumn(name = "User_answer_fk")
	private Student username;

	

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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	

	public questionAnswer() {

	}

	public questionAnswer(Long id, String answer, Question question, Exam examtitle, Student username) {
		
		this.id = id;
		this.answer = answer;
		this.question = question;
		this.examtitle = examtitle;
		this.username = username;
	}
	
	

}
