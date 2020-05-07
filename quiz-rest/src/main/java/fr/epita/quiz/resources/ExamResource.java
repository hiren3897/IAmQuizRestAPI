package fr.epita.quiz.resources;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.dataModel.Exam;
import fr.epita.dataModel.Question;
import fr.epita.dataModel.Student;
import fr.epita.dataModel.questionAnswer;
import fr.epita.quiz.ErrorManager.CommonError;
import fr.epita.quiz.dto.ExamDTO;
import fr.epita.quiz.dto.answerDTO;
import fr.epita.quiz.service.business.ExamDataService;
import fr.epita.quiz.service.dao.ExamDAO;
import fr.epita.quiz.service.dao.QuestionDAO;
import fr.epita.quiz.service.dao.StudentDAO;
import fr.epita.quiz.service.dao.questionAnswerDAO;

@Path("/exam")
public class ExamResource {

	@Inject
	ExamDataService examDS;

	@Inject
	StudentDAO studentDAO;

	@Inject
	QuestionDAO questionDAO;

	@Inject
	questionAnswerDAO answerDAO;
	
	@Inject
	ExamDAO examDAO;
	
	@POST
	@Path("/answer")
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response addAnswerToQuestion(@RequestBody answerDTO answerDto) {
		
		Student user = new Student();
		user.setUsername(answerDto.getUsername().getUsername()); 
		
		
		Question question = new Question();
		question.setQuestion(answerDto.getQuestion().getQuestion());
		questionDAO.create(question);

		Exam exam = new Exam();
		exam.setExamtitle(answerDto.getExamtitle().getExamtitle());
		examDAO.create(exam);
		
		questionAnswer answer= new questionAnswer();
		answer.setQuestion(question);
		answer.setAnswer(answerDto.getAnswer());
		answer.setUsername(answerDto.getUsername());
		answer.setExamtitle(exam);
		
		examDS.createQuestionAndAnswerTransaction(user, question, answer, exam);
		return Response.ok(answer).build();

	}

	@GET
	@Path("/answer/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAnswer(@PathParam("id") long answerId) {
		questionAnswer answer = answerDAO.getById(answerId);
		return Response.ok(answer).build();
	}

	@GET
	@Path("/answer")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAnswers(@RequestBody answerDTO answerDTO) {

		// beginning dummy implementation
		questionAnswer answer = new questionAnswer();
		answer.setAnswer(answerDTO.getAnswer());

		return Response.ok(Arrays.asList(answer)).build();
	}

	@PUT
	@Path("/answer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAnswerById(@RequestBody answerDTO answerdto) {
		
		questionAnswer answer= new questionAnswer();
		answer.setAnswer(answerdto.getAnswer());
		answer.setId(answerdto.getId());
		answerDAO.update(answer);

		return Response.ok().entity(answer).build();
	}

	@DELETE
	@Path("/answer")
	public Response deleteAnswerById(@RequestBody questionAnswer answer) {
		questionAnswer ans = answerDAO.getById(answer.getId());
		answerDAO.delete(ans);
		return Response.status(202).entity("Employee deleted successfully !!").build();
	}
	
	@POST
	@Path("/createExam")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response createExam(@RequestBody ExamDTO examDTO) {
		
		Exam exam = new Exam();
		exam.setExamtitle(examDTO.getExamtitle());
		if(examDAO.getById(examDTO.getId()) == null) {
			try {
				examDAO.create(exam);
				examDTO.setId(exam.getId());
				return Response.status(Status.OK).entity(examDTO).build();
			} catch (Exception e) {
				return Response.ok(new CommonError(e.getLocalizedMessage())).build();
			}
		}else {
			return Response.ok(new CommonError("Exam Already Created OR Exists.")).build();
		}
		
	}
	
	@GET
	@Path("/getallExam")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response findAllExam() {
		
		List<Exam> resultList = examDAO.getAll();
		return Response.status(Status.OK).entity(resultList).build();
		
	}
	
	@PUT
	@Path("/updateExam")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response updateOneExam(@RequestBody ExamDTO examDTO) {

		if (examDTO == null) {
			return Response.ok(new CommonError("Exam Cannot Be Updated")).build();
		}
		
		Exam exam = new Exam();
		//exam.setId(examDTO.getId());
		exam.setExamtitle(examDTO.getExamtitle());
		
		examDAO.update(exam);
		return Response.ok(examDTO).build();
	}
	
	@DELETE
	@Path("/deleteExam")
	public Response deleteExam(@RequestBody ExamDTO examDTO) {
		
		if (examDTO == null) {
			return Response.ok(new CommonError("Exam Cannot Be Deleted")).build();
		}
		Exam exam = examDAO.getById(examDTO.getId());
		examDAO.delete(exam);
		return Response.status(Status.OK).entity(examDTO).build();
	}

}
