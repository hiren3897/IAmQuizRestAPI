package fr.epita.quiz.resources;

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
import fr.epita.dataModel.MCQChoice;
import fr.epita.dataModel.Question;
import fr.epita.quiz.ErrorManager.CommonError;
import fr.epita.quiz.dto.MCQChoiceDTO;
import fr.epita.quiz.service.business.ExamDataService;
import fr.epita.quiz.service.dao.MCQChoiceDAO;
import fr.epita.quiz.service.dao.QuestionDAO;

@Path("MCQ")
public class McqQuestionChoices {

	@Inject
	MCQChoiceDAO mcqChoiceDao;

	@Inject
	QuestionDAO questionDao;

	@Inject
	ExamDataService examDS;
	
	@Inject
	MCQChoiceDAO choiceDao;

	@POST
	@Path("/createMcqQuestion")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response createMcqQuestion(@RequestBody List<MCQChoiceDTO> listchoiceDTO) {

		for (MCQChoiceDTO mcqChoiceDTO : listchoiceDTO) {
			
			MCQChoice choice = new MCQChoice();
			choice.setChoice(mcqChoiceDTO.getChoice());
			
			Exam exam = new Exam();
			exam.setId(mcqChoiceDTO.getQuestion().getExamtitle().getId());
			exam.setExamtitle(mcqChoiceDTO.getQuestion().getExamtitle().getExamtitle());
			
			Question question = new Question();
			question.setId(mcqChoiceDTO.getQuestion().getId());
			question.setQuestion(mcqChoiceDTO.getQuestion().getQuestion());
			question.setType(mcqChoiceDTO.getQuestion().getType());
			question.setExamtitle(exam);
			
			choice.setQuestion(question);
			choice.setValid(mcqChoiceDTO.isValid());
			
			mcqChoiceDao.create(choice);
			
			mcqChoiceDTO.setId(choice.getId());
		}
		return Response.status(Status.OK).entity(listchoiceDTO).build();
	}

	@GET
	@Path("/getAllMCQ")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response findAllMCQ() {
		
		List<MCQChoice> resultList = choiceDao.getAll();
		return Response.status(Status.OK).entity(resultList).build();
		
	}
	
	@DELETE
	@Path("/deleteMCQ")
	public Response deleteQuesstion(@RequestBody MCQChoiceDTO mcqChoiceDTO) {
		
		if (mcqChoiceDTO == null) {
			return Response.ok(new CommonError("MCQ choices Cannnot Be Deleted")).build();
		}
		MCQChoice choice = mcqChoiceDao.getById(mcqChoiceDTO.getId());
		mcqChoiceDao.delete(choice);
		return Response.status(Status.OK).entity(mcqChoiceDTO).build();
	}
	
	@PUT
	@Path("/updateMCQChoice")
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response updateOneQuestion(@RequestBody MCQChoiceDTO mcqChoiceDTO) {

		if (mcqChoiceDTO == null) {
			return Response.ok(new CommonError("MCQ Cannot Be Updated")).build();
		}
		
		Question question =  new Question();
		question.setQuestion(mcqChoiceDTO.getQuestion().getQuestion());
		
		MCQChoice choice = new MCQChoice();
		choice.setId(mcqChoiceDTO.getId());
		choice.setQuestion(question);
		choice.setChoice(mcqChoiceDTO.getChoice());
		
		questionDao.update(question);
		mcqChoiceDao.update(choice);
		return Response.status(Status.OK).entity(mcqChoiceDTO).build();
	}
}
