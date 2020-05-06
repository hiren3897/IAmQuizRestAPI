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
@Table(name = "MCQChoice")
public class MCQChoice {

	@Id
	@Column(name = "MCQChoiceID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "CHOICE")
	private String choice;

	@Column(name = "Validation")
	private boolean valid;

	@ManyToOne
	@JoinColumn(name = "choice_question_fk")
	private Question question;



	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
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

	public MCQChoice() {

	}


}
