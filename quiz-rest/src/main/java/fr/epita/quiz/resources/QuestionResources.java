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
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.dataModel.Exam;
import fr.epita.dataModel.Question;
import fr.epita.quiz.ErrorManager.CommonError;
import fr.epita.quiz.dto.questionDTO;
import fr.epita.quiz.service.dao.QuestionDAO;

@Path("/question")
public class QuestionResources {
	
	@Inject
	QuestionDAO questionDao;
	
	@POST
	@Path("/createQuestion")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response createQuestion(@RequestBody questionDTO questionDto) {
		
		Exam exam = new Exam();
		exam.setId(questionDto.getExamtitle().getId());
		exam.setExamtitle(questionDto.getExamtitle().getExamtitle());
		
		Question question = new Question();
		question.setQuestion(questionDto.getQuestion());
		question.setExamtitle(exam);
		question.setType(questionDto.getType());
		
		if(questionDao.getById(questionDto.getId()) == null) {
			try {
				questionDao.create(question);
				questionDto.setId(question.getId());
				return Response.status(Status.OK).entity(questionDto).build();
			} catch (Exception e) {
				return Response.ok(new CommonError(e.getLocalizedMessage())).build();
			}
		}else {
			return Response.ok(new CommonError("Question Already Created.")).build();
		}
		
		
		
	}
	
	@GET
	@Path("/getallquestion")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response findAllQuestions() {
		
		List<Question> resultList = questionDao.getAll();
		return Response.status(Status.OK).entity(resultList).build();
		
	}
	
	@PUT
	@Path("/updateQuestion")
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response updateOneQuestion(@RequestBody questionDTO questionDTO) {

		if (questionDTO == null) {
			return Response.ok(new CommonError("Question Cannot Be Updated")).build();
		}
		
		Question question = new Question();
		question.setId(questionDTO.getId());
		question.setQuestion(questionDTO.getQuestion());
		
		questionDao.update(question);
		return Response.ok(questionDTO).build();
	}
	
	
	
	@DELETE
	@Path("/deleteQuestion")
	public Response deleteQuesstion(@RequestBody questionDTO questionDTO) {
		
		if (questionDTO == null) {
			return Response.ok(new CommonError("Question Cannot Be Deleted")).build();
		}
		Question question = questionDao.getById(questionDTO.getId());
		questionDao.delete(question);
		return Response.status(202).entity("Question deleted successfully !!").build();
	}

}
